package ejercicio.pkg8.aplicacion.crud;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Empleados {

    /*Creamos conexion y un array para almacenar los datos de salida*/
    private Connection conexion;
    ArrayList<Empleado> empleados;

    /***
     * Realizamos el intento de conexion
     */
    public Empleados() {

        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /***
     * Crear empleado.
     * @param emp
     * @return
     * @throws SQLException 
     */
    public int Create(Empleado emp) throws SQLException {
        int filas;
        String sql = "INSERT INTO empleados VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp.getEmp_no());
        sentencia.setString(2, emp.getApellido());
        sentencia.setString(3, emp.getOficio());
        sentencia.setInt(4, emp.getDir());
        sentencia.setDate(5, emp.getFecha_alt());
        sentencia.setFloat(6, emp.getSalario());
        sentencia.setFloat(7, emp.getComision());
        sentencia.setInt(8, emp.getDept_no());
        filas = sentencia.executeUpdate();
        return filas;
    }

    /***
     * Update.
     * Con este metodo actualizaremos los datos de los empleados a traves de su codigo de empleado
     * @param emp_no
     * @param emp
     * @throws SQLException 
     */
    public void Update(int emp_no, Empleado emp) throws SQLException {
        String sql = "UPDATE SET ? FROM Empleados WHERE emp_no";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, ("apellido = Sokol Zelazko"));
        sentencia.executeUpdate();
    }

    /***
     * Devolver un dato.
     *  Devuelve solamente un registro de empleado a traves de el numero del empleado
     * @param CodigoEmp
     * @return
     * @throws SQLException 
     */
    public Empleado Readuno(int CodigoEmp) throws SQLException {
        String sql = "SELECT * FROM empleados WHERE emp_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, CodigoEmp);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        Empleado emp = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6), rs.getFloat(7), rs.getInt(8));
        return emp;
    }

    /***
     * Devolver todos los registros.
     * Devuelve todos los registros de la tabla de empleados.
     * @return
     * @throws SQLException 
     */
    public ArrayList<Empleado> Readtodos() throws SQLException {
        empleados = new ArrayList<Empleado>();
        String sql = "SELECT * FROM empleados";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            Empleado emp = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6), rs.getFloat(7), rs.getInt(8));
            empleados.add(emp);
        }
        return empleados;
    }

    /***
     * Devuelve un dato por nombre.
     * Devuelve todos los datos que tengan el nombre introducido.
     * @param NombreEmp
     * @return
     * @throws SQLException 
     */
    public Empleado ReadunoNombre(String NombreEmp) throws SQLException {
        String sql = "SELECT * FROM empleados WHERE apellido = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, NombreEmp);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        Empleado emp = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6), rs.getFloat(7), rs.getInt(8));
        return emp;
    }
    /***
     * Borrado.
     * Borra empleados a traves del numero del empleado
     * @param emp_no
     * @return
     * @throws SQLException 
     */
    public int Delete(int emp_no) throws SQLException {
        int filas;
        String sql = "DELETE FROM empleados WHERE emp_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, (emp_no));
        filas = sentencia.executeUpdate();
        return filas;
    }
    
    /***
     * Cierre.
     * @throws SQLException 
     */
    public void Close() throws SQLException {
        conexion.close();
    }
}
