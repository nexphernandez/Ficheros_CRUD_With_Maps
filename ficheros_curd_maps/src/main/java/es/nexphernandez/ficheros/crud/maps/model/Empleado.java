package es.nexphernandez.ficheros.crud.maps.model;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Empleado extends Persona{
    private String puesto;
    private double salario;
    
    /**
     * Constructor vacio
     */
    public Empleado (){}

    /**
     * Constructor con el atributo clave de la clase
     * @param identificador identiifcador del empleado
     */
    public Empleado(String identificador) {
        super(identificador);
    }

    /**
     * Constructor de loa atributos de la clase empleado
     * @param identificador identificador del empleado
     * @param nombre nombre del empleado
     * @param puesto puesto del empleado
     * @param salario salario del empleado
     * @param fechaNacimento fecha de nacimiento del empleado
     */
    public Empleado(String identificador, String nombre, String puesto, 
    double salario, String fechaNacimento) {
        super(identificador, nombre, fechaNacimento);
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Funcion que calcula la edad usando una fecha de nacimiento
     * @param fechaNacimiento fecha de nacimineto de la persona
     * @return edad de la persona
     */
    public int getEdad (String fechaNacimiento){
        LocalDate fechaActual = LocalDate.now();
        String[] arrayFecha = fechaNacimiento.split("/");
        LocalDate nacimiento = LocalDate.of(Integer.parseInt(arrayFecha[0]), 
        Integer.parseInt(arrayFecha[1]), Integer.parseInt(arrayFecha[0]));
        Period periodo = Period.between(nacimiento, fechaActual);
        return periodo.getYears();
    }

    /**
     * Funcion toString de la clase empleado
     */
    @Override
    public String toString() {
        return getIdentificador() + ", " + getNombre() + ", " + getPuesto() +
         ", " + getSalario() + ", " + getFechaNacimiento(); 
    }

}
