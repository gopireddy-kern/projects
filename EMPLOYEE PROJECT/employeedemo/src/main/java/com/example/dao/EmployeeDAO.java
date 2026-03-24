package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.EmployeeJavaBean;
import com.example.util.DBConnection;

public class EmployeeDAO {

    @SuppressWarnings("CallToPrintStackTrace")
    public void insert(EmployeeJavaBean e) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO employees(emp_name, department, salary) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getEmpName());
            ps.setString(2, e.getDepartment());
            ps.setDouble(3, e.getSalary());
            ps.executeUpdate();
        } catch (Exception ex) {
             ex.printStackTrace();
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void update(EmployeeJavaBean emp) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE employees SET emp_name=?, department=?, salary=? WHERE emp_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emp.getEmpName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.setInt(4, emp.getEmpId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void delete(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM employees WHERE emp_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public List<EmployeeJavaBean> getAll() {
        List<EmployeeJavaBean> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employees";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmployeeJavaBean e = new EmployeeJavaBean();
                e.setEmpId(rs.getInt("emp_id"));
                e.setEmpName(rs.getString("emp_name"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getDouble("salary"));
                list.add(e);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public EmployeeJavaBean getById(int id) {
        EmployeeJavaBean e = null;
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employees WHERE emp_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                e = new EmployeeJavaBean();
                e.setEmpId(rs.getInt("emp_id"));
                e.setEmpName(rs.getString("emp_name"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getDouble("salary"));
            }
        } catch (Exception ex) { ex.printStackTrace(); }
        return e;
    }
}

