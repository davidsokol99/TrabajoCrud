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
    
/***
 * Creamos el arrays list para almacenar los registros cuando haya que devolver mas de uno
 */
    private Connection conexion;
    ArrayList<Departamento> departamentos; 
    
/***
 * Aqui realizamos la conexion a la base de datos
 */
    public Departamentos() {

        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
/***
 * Crear departamento.
 * @param dep
 * @return
 * @throws SQLException 
 */
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
    
    /***
     * Update.
     * Aqui tenemos el metodo que nos hara las actualizaciones de los datos
     * para realizar el update en los registros, necesitaremos el num del departamento.
     * @param dept_no
     * @param dep
     * @throws SQLException 
     */
    public void Update(int dept_no, Departamento dep) throws SQLException {
        String sql = "UPDATE SET ? FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, ("loc = Madrid"));
        sentencia.setString(2, ("1"));
        sentencia.executeUpdate();
    }

    /***
     * Leer un departamento.
     * Aqui tenemos el metodo que realiza la salida de un solo departamento
     * a traves de el codigo del departamento
     * @param CodigoDep
     * @return
     * @throws SQLException 
     */
    public Departamento Readuno(int CodigoDep) throws SQLException {
        String sql = "SELECT * FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, CodigoDep);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        Departamento dep = new Departamento(rs.getInt(1), rs.getString(2), rs.getString(3));
        return dep;
    }

    /***
     * Leer un departamento (pero por nombres).
     * Con este constructor conseguimos que nos devuelva todos los departamentos que tengan el mismo numero
     * @param NombreDep
     * @return
     * @throws SQLException 
     */
    public Departamento ReadunoNombre(String NombreDep) throws SQLException {
        String sql = "SELECT * FROM departamentos WHERE dnombre = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, NombreDep);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        Departamento dep = new Departamento(rs.getInt(1), rs.getString(2), rs.getString(3));
        return dep;
    }

    /***
     * Borrado.
     * Aqui podremos borrar un departamento a traves de su codigo
     * @param codDep
     * @return
     * @throws SQLException 
     */
    public int Delete(int codDep) throws SQLException {
        int filas;
        String sql = "DELETE FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, (codDep));
        filas = sentencia.executeUpdate();
        return filas;
    }

    /***
     * Leer todos los departamentos.
     * Nos devuelve todos los registros de la tabla de departamentos
     * @return
     * @throws SQLException 
     */
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
/***
 * Cerrar programa.
 * @throws SQLException 
 */
    public void Close() throws SQLException {
        conexion.close();
    }
}
