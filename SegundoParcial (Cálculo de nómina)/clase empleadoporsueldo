package Modelo;

import Excepciones.DatoInvalidoException;

/**
 * Empleado que recibe una cantidad fija como sueldo mensual.
 */
public class EmpleadoPorSueldo extends Empleado {
    private double sueldoMensual;

    /**
     * @param nombre nombre del empleado
     * @param id identificador
     * @param sueldoMensual sueldo mensual fijo
     */
    public EmpleadoPorSueldo(String nombre, int id, double sueldoMensual) {
        super(nombre, id);
        if (sueldoMensual < 0) {
            throw new DatoInvalidoException("El sueldo no puede ser negativo: " + sueldoMensual);
        }
        this.sueldoMensual = sueldoMensual;
    }

    /** @return sueldo mensual */
    @Override
    public double calcularPago() {
        return sueldoMensual;
    }

    /** @return tipo de empleado */
    @Override
    public String getTipo() {
        return "Por sueldo";
    }
}
