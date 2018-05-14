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
public class SalidaEmp {

    Scanner sc = new Scanner(System.in);
    Empleados emps = new Empleados();
    Empleado emp = new Empleado();

    public void listado() throws SQLException {

        System.out.println("╔====================================================╗");
        System.out.println("║    • Selecciona la accion que quieres realizar •   ║");
        System.out.println("║                                                    ║");
        System.out.println("║                                                    ║");
        System.out.println("║ 1. Listar un empleado por codigo                   ║");
        System.out.println("║ 2. Listar todos los empleados                      ║");
        System.out.println("║                                                    ║");
        System.out.println("╚====================================================╝");
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                System.out.println("╔====================================================╗");
                System.out.println("║     • Introducir el codigo del empleado     •      ║");
                System.out.println("╚====================================================╝");

                emp = emps.Readuno(Integer.parseInt(sc.nextLine()));
                System.out.println("");
                System.out.println("    Consulta:");
                System.out.println("");
                System.out.println("|Cod   |    Apellido    |     Oficio     | Direccion |   Fecha Alta   |  Salario  | Comision  |  Cod Dep  |");
                System.out.println("");
                System.out.printf("|%-5d |%15s |%15s |%10s |%15s |%10s |%10s |%10s |%n",
                        emp.getEmp_no(), emp.getApellido(), emp.getOficio(), emp.getDir(), emp.getFecha_alt(), emp.getSalario(), emp.getComision(), emp.getDept_no());
                System.out.println("");
                System.out.println("");
                System.out.println("");

                break;
            case 2:
                emps.Readtodos();
                System.out.println("");
                System.out.println("    Consulta:");
                System.out.println("");
                System.out.println("|Cod   |    Apellido    |     Oficio     | Direccion |   Fecha Alta   |  Salario  | Comision  |  Cod Dep  |");
                System.out.println("");

                for (int i = 0; i < emps.empleados.size(); i++) {
                    emp = emps.empleados.get(i);

                    System.out.printf("|%-5d |%15s |%15s |%10s |%15s |%10s |%10s |%10s |%n",
                            emp.getEmp_no(), emp.getApellido(), emp.getOficio(), emp.getDir(), emp.getFecha_alt(), emp.getSalario(), emp.getComision(), emp.getDept_no());

                }

                System.out.println("");
                System.out.println("");
                System.out.println("");
        }
    }

    public void buscarpornombre() throws SQLException {
        System.out.println("╔====================================================╗");
        System.out.println("║       • Introducir el nombre del empleado •        ║");
        System.out.println("╚====================================================╝");
        emp = emps.ReadunoNombre(sc.nextLine());
        System.out.println("");
        System.out.println("    Consulta:");
        System.out.println("");
        System.out.println("|Cod   |    Apellido    |     Oficio     | Direccion |   Fecha Alta   |  Salario  | Comision  |  Cod Dep  |");
        System.out.println("");
        System.out.printf("|%-5d |%15s |%15s |%10s |%15s |%10s |%10s |%10s |%n",
                emp.getEmp_no(), emp.getApellido(), emp.getOficio(), emp.getDir(), emp.getFecha_alt(), emp.getSalario(), emp.getComision(), emp.getDept_no());
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }

    public void crearemp() throws SQLException {
        Empleado creemp = new Empleado();
        System.out.println("Introduce los siguientes datos del nuevo empleado: ");
        System.out.printf("    » Codigo del empleado: \n");
        creemp.setEmp_no(Integer.parseInt((sc.nextLine())));
        System.out.printf("    » Nombre del empleado: \n");
        creemp.setApellido(sc.nextLine());
        System.out.printf("    » Oficio del empleado: \n");
        creemp.setOficio(sc.nextLine());
        System.out.printf("    » Direccion (numerica) del empleado: \n");
        creemp.setDir(Integer.parseInt((sc.nextLine())));
        System.out.printf("    » Fecha de alta del empleado (AAAA-MM-DD): \n");
        java.sql.Date jsqlD = java.sql.Date.valueOf(sc.nextLine());
        creemp.setFecha_alt(jsqlD);
        System.out.printf("    » Salario del empleado: \n");
        creemp.setSalario(Integer.parseInt((sc.nextLine())));
        System.out.printf("    » Comision del empleado: \n");
        creemp.setComision(Integer.parseInt((sc.nextLine())));
        System.out.printf("    » Codigo del Departamento donde trabaja: \n");
        creemp.setDept_no(Integer.parseInt((sc.nextLine())));
        System.out.println("Se ha creado: " + emps.Create(creemp) + " empleado correctamente");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public void borraremp() throws SQLException {
        System.out.println("╔====================================================╗");
        System.out.println("║   • Introducir el numero del empleado a borrar •   ║");
        System.out.println("╚====================================================╝");
        System.out.println("Se ha borrado: " + emps.Delete(sc.nextInt()) + " departamento correctamente.");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}
