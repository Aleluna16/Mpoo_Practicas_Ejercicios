package Principal;

import Excepciones.DatoInvalidoException;
import Excepciones.NominaException;
import Modelo.Comisionista;
import Modelo.Empleado;
import Modelo.EmpleadoPorHoras;
import Modelo.EmpleadoPorSueldo;

/**
 * Punto de entrada del programa. Ejecuta los casos de prueba solicitados
 * y despues muestra un ejemplo de calculo general de nomina.
 */
public class Main {

    /** Ejecuta las pruebas de validacion y el calculo de la nomina. */
    public static void main(String[] args) {
        System.out.println("========== CASOS DE PRUEBA ==========");

        // CP-01: empleado con sueldo fijo.
        try {
            Empleado ana = new EmpleadoPorSueldo("Ana", 1, 12000);
            System.out.printf("CP-01: %.2f%n", ana.calcularPago());
        } catch (DatoInvalidoException | NominaException e) {
            System.out.println("CP-01: Error - " + e.getMessage());
        }

        // CP-02: 170 horas; 160 normales y 10 al doble.
        try {
            EmpleadoPorHoras empleado = new EmpleadoPorHoras("Luis", 2, 100);
            empleado.setHoras(170);
            System.out.printf("CP-02: %.2f%n", empleado.calcularPago());
        } catch (DatoInvalidoException | NominaException e) {
            System.out.println("CP-02: Error - " + e.getMessage());
        }

        // CP-03: 350 horas exceden el limite y deben lanzar NominaException.
        try {
            EmpleadoPorHoras empleado = new EmpleadoPorHoras("Jorge", 3, 100);
            empleado.setHoras(350);
            System.out.printf("CP-03: %.2f%n", empleado.calcularPago());
        } catch (NominaException e) {
            System.out.println("CP-03: Excepcion verificada - " + e.getMessage());
        }

        System.out.println();
        System.out.println("----- Alta de empleados con datos invalidos -----");
        try {
            new EmpleadoPorSueldo("", 10, 12000);
        } catch (DatoInvalidoException e) {
            System.out.println("  No se registro: " + e.getMessage());
        }
        try {
            new EmpleadoPorHoras("Pedro", 11, -50);
        } catch (DatoInvalidoException e) {
            System.out.println("  No se registro: " + e.getMessage());
        }
        try {
            new Comisionista("Rosa", 12, 7000, -2000);
        } catch (DatoInvalidoException e) {
            System.out.println("  No se registro: " + e.getMessage());
        }

        // Los objetos se almacenan como Empleado para aplicar polimorfismo.
        EmpleadoPorHoras luis = new EmpleadoPorHoras("Luis", 2, 100);
        EmpleadoPorHoras marta = new EmpleadoPorHoras("Marta", 3, 100);
        EmpleadoPorHoras jorge = new EmpleadoPorHoras("Jorge", 4, 100);
        luis.setHoras(150);
        marta.setHoras(180);
        jorge.setHoras(320);

        Empleado[] nomina = {
            new EmpleadoPorSueldo("Ana", 1, 18000),
            luis,
            marta,
            jorge,
            new Comisionista("Sara", 5, 7000, 50000)
        };

        System.out.println("----- Calculo de la nomina -----");
        double total = 0;
        int conError = 0;
        for (Empleado e : nomina) {
            try {
                double pago = e.calcularPago();
                total += pago;
                System.out.printf("  %-26s $%,10.2f%n", e, pago);
            } catch (NominaException ex) {
                conError++;
                System.out.println("  [Error] " + ex.getMessage());
            }
        }
        System.out.printf("Total de la nomina: $%,.2f%n", total);
        System.out.println("Empleados pendientes por error: " + conError);
    }
}
