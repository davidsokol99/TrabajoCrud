/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg8.aplicacion.crud;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class SalidaDep {
    /**
     * Scanner para leer por teclado.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Listado.
     * Formateo de salida del listado de departamentos, incluye la salida de un departamento por codigo
     * y la salida de todos los registros de la tabla de empleados.
     * @throws SQLException 
     */
    public void listado() throws SQLException {
        Departamentos deps = new Departamentos();   //Creamos los objetos
        Departamento dep = new Departamento();
        System.out.println("╔====================================================╗");   //Menu grafico
        System.out.println("║    • Selecciona la accion que quieres realizar •   ║");
        System.out.println("║                                                    ║");
        System.out.println("║                                                    ║");
        System.out.println("║ 1. Listar un departamento por codigo               ║");
        System.out.println("║ 2. Listar todos los departamentos                  ║");
        System.out.println("║                                                    ║");
        System.out.println("╚====================================================╝");
        switch (Integer.parseInt(sc.nextLine())) {      //Switch para escoger la opcion a relizar
            case 1:     //listar un departamento por codigo
                System.out.println("╔====================================================╗");
                System.out.println("║     • Introducir el codigo del departamento •      ║");
                System.out.println("╚====================================================╝");
                dep = deps.Readuno(Integer.parseInt(sc.nextLine()));
                System.out.println("");
                System.out.println("    Consulta:");
                System.out.println("");
                System.out.println("|Cod   |     Nombre     |     Localizacion    |");
                System.out.println("");
                System.out.printf("|%-5d |%15s |%20s | %n",
                        dep.getDept_no(), dep.getDnombre(), dep.getLoc());
                System.out.println("");
                System.out.println("");
                System.out.println("");

                break;
            case 2:     //listar todos los registros de la tabla de departamentos
                deps.Readtodos();
                System.out.println("");
                System.out.println("    Consulta:");
                System.out.println("");
                System.out.println("|Cod   |     Nombre     |     Localizacion    |");
                System.out.println("");
                for (int i = 0; i < deps.departamentos.size(); i++) {
                    dep = deps.departamentos.get(i);
                    System.out.printf("|%-5d |%15s |%20s | %n",
                            dep.getDept_no(), dep.getDnombre(), dep.getLoc());

                }
                System.out.println("");
                System.out.println("");
                System.out.println("");
        }
    }
    /***
     * Listar departamentos por nombre.
     * @throws SQLException 
     */
    public void buscarpornombre() throws SQLException {
        Departamentos deps = new Departamentos();       //crear objetos
        Departamento dep = new Departamento();
        System.out.println("╔====================================================╗"); 
        System.out.println("║     • Introducir el nombre del departamento •      ║");
        System.out.println("╚====================================================╝");
        dep = deps.ReadunoNombre(sc.nextLine());
        System.out.printf("|%-5d |%15s |%20s | %n",
                dep.getDept_no(), dep.getDnombre(), dep.getLoc());
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    /***
     * Crear departamento.
     * @throws SQLException 
     */
    public void creardepartamento() throws SQLException {
        Departamento credep = new Departamento();   //objetos
        Departamentos deps = new Departamentos();
        System.out.println("Introduce los siguientes datos del nuevo departamento: ");  //Pide los datos para la creacion del departamento
        System.out.printf("    » Codigo del departamento \n");
        credep.setDept_no(Integer.parseInt((sc.nextLine())));
        System.out.printf("    » Nombre del departamento \n");
        credep.setDnombre(sc.nextLine());
        System.out.printf("    » Localizacion del departamento \n");
        credep.setLoc(sc.nextLine());
        System.out.println("Se ha creado: " + deps.Create(credep) + " empleado correctamente");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    /***
     * Borrar departamento.
     * @throws SQLException 
     */
    public void borrardep() throws SQLException {
        Departamentos deps = new Departamentos();
        System.out.println("╔====================================================╗");
        System.out.println("║ • Introducir el numero del departamento a borrar • ║");
        System.out.println("╚====================================================╝");
        System.out.println("Se ha borrado: " + deps.Delete(sc.nextInt()) + " departamento correctamente.");

        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}
