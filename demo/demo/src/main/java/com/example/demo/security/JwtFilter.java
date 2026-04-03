package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter implements jakarta.servlet.Filter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();

        // ✅ Allow public APIs (Swagger + Login)
        if (path.startsWith("/auth") ||
            path.startsWith("/swagger-ui") ||
            path.startsWith("/v3/api-docs")) {

            chain.doFilter(request, response);
            return;
        }

        String header = req.getHeader("Authorization");

        // 🔍 Debug (optional)
        System.out.println("PATH: " + path);
        System.out.println("HEADER: " + header);

        // ❌ Missing or invalid header
        if (header == null || !header.startsWith("Bearer ")) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Missing or invalid Authorization header");
            return;
        }

        String token = header.substring(7);

        try {
            // ❌ Invalid token
            if (!jwtUtil.validateToken(token)) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write("Invalid JWT Token");
                return;
            }

            // ✅ Extract username
            String username = jwtUtil.extractUsername(token);

            // ✅ Set authentication (IMPORTANT)
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            Collections.emptyList() // 👈 important
                    );

            SecurityContextHolder.getContext().setAuthentication(auth);

        } catch (Exception e) {
            e.printStackTrace(); // 🔥 debug
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Token error");
            return;
        }

        // ✅ Continue request
        chain.doFilter(request, response);
    }
}