/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg8.aplicacion.crud;

import java.sql.Date;

/**
 *
 * @author David
 */
public class Empleado {

    /**
     * Creamos todas las variables del empleado.
     */
    private int emp_no;         //Codigo del empleado, es la primary key.
    private String apellido;    //Nombre/apellido del empleado.
    private String oficio;      //Oficio o tarea del empleado
    private int dir;            //Direccion  del empleado
    private Date fecha_alt;     //Fecha de alta (fecha cuando empezo a trabajar)
    private float salario;      //Salario mensual del empleado
    private float comision;     //Comision del empleado
    private int dept_no;        //Codigo del departamento en el que trabaja

    /***
     * Constructor vacio y otro con todas las variables.
     */
    public Empleado() {
    }

    public Empleado(int emp_no, String apellido, String oficio, int dir, Date fecha_alt, float salario, float comision, int dept_no) {
        this.emp_no = emp_no;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        this.fecha_alt = fecha_alt;
        this.salario = salario;
        this.comision = comision;
        this.dept_no = dept_no;
    }

    /**
     * Getters y Setters.
     */
    
    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public Date getFecha_alt() {
        return fecha_alt;
    }

    public void setFecha_alt(Date fecha_alt) {
        this.fecha_alt = fecha_alt;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

}
