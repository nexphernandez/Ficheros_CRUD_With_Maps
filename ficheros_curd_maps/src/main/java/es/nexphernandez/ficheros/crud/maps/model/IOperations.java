package es.nexphernandez.ficheros.crud.maps.model;

import java.util.Set;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public interface IOperations {
    public boolean create(Empleado empleado);
    public Empleado read(String identificador);
    public Empleado read(Empleado empleado);
    public boolean update(Empleado empleado);
    public boolean delete(String identificador);
    public Set<Empleado> empleadosPorPuesto(String puesto);
}
