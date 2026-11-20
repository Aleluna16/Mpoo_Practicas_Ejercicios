package Modelo;

import Excepciones.DatoInvalidoException;
import Excepciones.NominaException;

/**
 * Clase base abstracta para los distintos tipos de empleados.
 * Define los datos y operaciones que comparten todos los empleados.
 */
public abstract class Empleado {
    private String nombre;
    private int id;

    /**
     * Construye un empleado y valida que su nombre no este vacio.
     *
     * @param nombre nombre del empleado
     * @param id identificador del empleado
     */
    public Empleado(String nombre, int id) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
        this.id = id;
    }

    /** @return nombre del empleado */
    public String getNombre() {
        return nombre;
    }

    /** @return identificador del empleado */
    public int getId() {
        return id;
    }

    /**
     * Calcula el pago segun el tipo concreto de empleado.
     *
     * @return pago calculado
     * @throws NominaException cuando los datos impiden calcular la nomina
     */
    public abstract double calcularPago() throws NominaException;

    /** @return descripcion del esquema de pago */
    public abstract String getTipo();

    /** @return identificador, nombre y tipo de empleado */
    @Override
    public String toString() {
        return id + " " + nombre + " (" + getTipo() + ")";
    }
}
