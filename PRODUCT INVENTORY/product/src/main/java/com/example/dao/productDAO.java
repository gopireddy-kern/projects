package com.example.dao;

import java.sql.*;
import java.util.*;
import com.example.model.Product;
import com.example.util.DBConnection;

public class productDAO {

     public void addProduct(Product p) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO products(product_name,price,quantity,category) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getQuantity());
            ps.setString(4, p.getCategory());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM products");
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setProductName(rs.getString("product_name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCategory(rs.getString("category"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteProduct(int id) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE product_id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Product getProductById(int id) {
        Product p = new Product();
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE product_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setId(id);
                p.setProductName(rs.getString("product_name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCategory(rs.getString("category"));
            }
        } catch (Exception e) {

        }
        return p;
    }

    public void updateProduct(Product p) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE products SET product_name=?, price=?, quantity=?, category=? WHERE product_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getQuantity());
            ps.setString(4, p.getCategory());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insert(Product p) {
    
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    public void delete(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Object getAll() {

        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public void update(Product p) {

        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}

   
    