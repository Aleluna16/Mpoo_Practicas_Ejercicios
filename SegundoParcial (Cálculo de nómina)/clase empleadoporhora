package Modelo;

import Excepciones.DatoInvalidoException;
import Excepciones.NominaException;

/**
 * Empleado cuyo pago depende de las horas trabajadas.
 * Las primeras 160 horas se pagan a tarifa normal y las siguientes
 * hasta 300 horas se pagan al doble.
 */
public class EmpleadoPorHoras extends Empleado {
    private static final double HORAS_NORMALES = 160;
    private static final double HORAS_MAXIMAS = 300;

    private double tarifaHora;
    private double horas;

    /**
     * @param nombre nombre del empleado
     * @param id identificador
     * @param tarifaHora pago por hora normal
     */
    public EmpleadoPorHoras(String nombre, int id, double tarifaHora) {
        super(nombre, id);
        if (tarifaHora < 0) {
            throw new DatoInvalidoException("La tarifa no puede ser negativa: " + tarifaHora);
        }
        this.tarifaHora = tarifaHora;
        this.horas = 0;
    }

    /**
     * Registra las horas trabajadas. El rango se comprueba al calcular el pago
     * para poder reportar el error mediante NominaException en ese momento.
     *
     * @param horas horas trabajadas
     */
    public void setHoras(double horas) {
        this.horas = horas;
    }

    /** @return horas registradas */
    public double getHoras() {
        return horas;
    }

    /**
     * Calcula el pago y verifica que las horas esten entre 0 y 300.
     *
     * @return pago total
     * @throws NominaException si las horas estan fuera del rango permitido
     */
    @Override
    public double calcularPago() throws NominaException {
        if (horas < 0 || horas > HORAS_MAXIMAS) {
            throw new NominaException("Horas fuera de rango (0 a 300) para "
                + getNombre() + ": " + horas);
        }
        if (horas <= HORAS_NORMALES) {
            return horas * tarifaHora;
        }
        double extra = horas - HORAS_NORMALES;
        return HORAS_NORMALES * tarifaHora + extra * tarifaHora * 2;
    }

    /** @return tipo de empleado */
    @Override
    public String getTipo() {
        return "Por horas";
    }
}
