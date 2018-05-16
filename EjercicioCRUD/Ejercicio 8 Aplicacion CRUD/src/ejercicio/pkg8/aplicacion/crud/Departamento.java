/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg8.aplicacion.crud;

/**
 *
 * @author David
 */
public class Departamento {
    /**
     * Creamos las variables del departamento.
     */
    private int dept_no;        //Codigo del departamento, es la primary key.
    private String dnombre;     //Nombre del departamento.
    private String loc;         //Locaclizacion del departamento.

    /**
     * Creamos constructor vacio y mas tarde uno con sus variables.
     */
    public Departamento() {
    }

    public Departamento(int dept_no, String dnombre, String loc) {
        this.dept_no = dept_no; 
        this.dnombre = dnombre; 
        this.loc = loc;
    }
    
    /**
     * Getters y setters.
     */
    
    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

}
