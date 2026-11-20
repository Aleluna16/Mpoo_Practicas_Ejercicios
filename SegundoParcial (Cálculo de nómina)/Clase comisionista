package Modelo;

import Excepciones.DatoInvalidoException;

/**
 * Empleado que recibe un sueldo base mas una comision del 8 por ciento
 * sobre las ventas realizadas.
 */
public class Comisionista extends Empleado {
    private static final double COMISION = 0.08;

    private double sueldoBase;
    private double ventas;

    /**
     * @param nombre nombre del empleado
     * @param id identificador
     * @param sueldoBase sueldo base
     * @param ventas monto de ventas
     */
    public Comisionista(String nombre, int id, double sueldoBase, double ventas) {
        super(nombre, id);
        if (sueldoBase < 0) {
            throw new DatoInvalidoException("El sueldo base no puede ser negativo: " + sueldoBase);
        }
        if (ventas < 0) {
            throw new DatoInvalidoException("Las ventas no pueden ser negativas: " + ventas);
        }
        this.sueldoBase = sueldoBase;
        this.ventas = ventas;
    }

    /** @return sueldo base mas la comision correspondiente */
    @Override
    public double calcularPago() {
        return sueldoBase + ventas * COMISION;
    }

    /** @return tipo de empleado */
    @Override
    public String getTipo() {
        return "Comisionista";
    }
}
