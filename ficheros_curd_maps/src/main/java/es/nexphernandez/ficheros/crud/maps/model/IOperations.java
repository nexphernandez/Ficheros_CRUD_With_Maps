package es.nexphernandez.ficheros.crud.maps.model;

import java.util.Set;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public interface IOperations {

    /**
     * Funcion que aniade un empleado al fichero
     * @param empleado empleado a aniadir
     * @return true/false;
     */
    public boolean create(Empleado empleado);
    
    /**
     * Funcion que busca un empleado por el identificador en un fichero
     * @param identificador identificador del empleado a buscar
     * @return empleado buscado
     */
    public Empleado read(String identificador);

    /**
     * Funcion que busca un empleado en un fichero
     * @param empleado empleado a buscar
     * @return empleado buscado
     */
    public Empleado read(Empleado empleado);

    /**
     * Funcion que actuliza un empleado de un fichero
     * @param empleado empleado a actualizar
     * @return true/false
     */
    public boolean update(Empleado empleado);

    /**
     * Funcion que borra un elemento de un fichero por su identificador
     * @param identificador identificador de la persona a borrar
     * @return true/false
     */
    public boolean delete(String identificador);

    /**
     * Funcion que ordena un fichero por los puestos de empleados
     * @param puesto puesto de los empleados a ordenar
     * @return lista de empleados ordenados por el puesto
     */
    public Set<Empleado> empleadosPorPuesto(String puesto);

    /**
     * Funcion que genera una lista de empleados por la fecha de nacimiento respecto
     * a una fecha de inicio y fecha de fin
     * @param fechaInicio fecha de inicio de la cual generar la lista
     * @param fechaFin fecha fin de la cual generar la lista
     * @return lista de empleados
     */
    public Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin);
}
