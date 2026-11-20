package Excepciones;

/**
 * Excepcion comprobada utilizada cuando no es posible calcular
 * correctamente el pago de un empleado.
 */
public class NominaException extends Exception {

    /** Crea la excepcion con el motivo del error de nomina. */
    public NominaException(String mensaje) {
        super(mensaje);
    }
}
