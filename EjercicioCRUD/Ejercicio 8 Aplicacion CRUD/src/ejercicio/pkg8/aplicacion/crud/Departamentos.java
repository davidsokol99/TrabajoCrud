/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg8.aplicacion.crud;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Departamentos {

    private Connection conexion;
    ArrayList<Departamento> departamentos;

    public Departamentos() {

        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int Create(Departamento dep) throws SQLException {
        int filas;
        String sql = "INSERT INTO departamentos VALUES (?, ?, ?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dep.getDept_no());
        sentencia.setString(2, dep.getDnombre());
        sentencia.setString(3, dep.getLoc());
        filas = sentencia.executeUpdate();
        return filas;
    }

    public void Update(int dept_no, Departamento dep) throws SQLException {
        String sql = "UPDATE SET ? FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, ("loc = Madrid"));
        sentencia.setString(2, ("1"));
        sentencia.executeUpdate();
    }

    public Departamento Readuno(int CodigoDep) throws SQLException {
        String sql = "SELECT * FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, CodigoDep);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        Departamento dep = new Departamento(rs.getInt(1), rs.getString(2), rs.getString(3));
        return dep;
    }

    public Departamento ReadunoNombre(String NombreDep) throws SQLException {
        String sql = "SELECT * FROM departamentos WHERE dnombre = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, NombreDep);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        Departamento dep = new Departamento(rs.getInt(1), rs.getString(2), rs.getString(3));
        return dep;
    }

    public int Delete(int codDep) throws SQLException {
        int filas;
        String sql = "DELETE FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, (codDep));
        filas = sentencia.executeUpdate();
        return filas;
    }

    public ArrayList<Departamento> Readtodos() throws SQLException {
        departamentos = new ArrayList<Departamento>();
        String sql = "SELECT * FROM departamentos";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            Departamento dep = new Departamento(rs.getInt(1), rs.getString(2), rs.getString(3));
            departamentos.add(dep);
        }
        return departamentos;
    }

    public void Close() throws SQLException {
        conexion.close();
    }
}
