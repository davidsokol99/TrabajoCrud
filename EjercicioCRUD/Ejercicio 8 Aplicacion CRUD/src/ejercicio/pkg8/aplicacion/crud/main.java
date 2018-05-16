package ejercicio.pkg8.aplicacion.crud;

import java.sql.SQLException;
import java.util.Scanner;

public class main {

    /**
     * 
     * @param args
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {
        
        /**
         * Creacion de objetos.
         */
        SalidaDep salidadep = new SalidaDep();
        SalidaEmp salidaemp = new SalidaEmp();
        int salida = 1;
        
        while (salida == 1) {
            /**
             * MEnu grafico para escoger la opcion que queremos realizar
             */
            System.out.println("╔====================================================╗");
            System.out.println("║    • Selecciona la accion que quieres realizar •   ║");
            System.out.println("║                                                    ║");
            System.out.println("║                                                    ║");
            System.out.println("║ 1. Listar Departamentos                            ║");
            System.out.println("║ 2. Listar Empleados                                ║");
            System.out.println("║ 3. Buscar empleado por nombre                      ║");
            System.out.println("║ 4. Buscar departamento por nombre                  ║");
            System.out.println("║ 5. Crear empleado                                  ║");
            System.out.println("║ 6. Crear departamento                              ║");
            System.out.println("║ 7. Borrar empleado                                 ║");
            System.out.println("║ 8. Borrar departamento                             ║");
            System.out.println("║                                                    ║");
            System.out.println("║ 9. Salir del programa                              ║");
            System.out.println("║                                                    ║");
            System.out.println("╚====================================================╝");
            
            /**
             * Switch con todos los casos que llama a los metodos
             */
            Scanner sc = new Scanner(System.in);
            switch (Integer.parseInt(sc.nextLine())) {
                case 1:
                    salidadep.listado();
                    break;
                case 2:
                    salidaemp.listado();
                    break;
                case 3:
                    salidaemp.buscarpornombre();
                    break;
                case 4:
                    salidadep.buscarpornombre();
                    break;
                case 5:
                    salidaemp.crearemp();
                    break;
                case 6:
                    salidadep.creardepartamento();
                    break;
                case 7:
                    salidaemp.borraremp();
                    break;
                case 8:
                    salidadep.borrardep();
                    break;
                case 9:
                    salida = salida + 1;
                    break;
                default:
                    System.out.println("No has introducido una accion correcta");
                    break;
            }

        }
    }
}
