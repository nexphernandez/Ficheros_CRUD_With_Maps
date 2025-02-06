package es.nexphernandez.ficheros.crud.maps.model.file;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import es.nexphernandez.ficheros.crud.maps.model.Empleado;

public class FileOperationsMaps extends FileOperations{

    @Override
    public boolean create(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador() == null || empleado.getIdentificador().isEmpty()) {
            return false;
        }
        Map<String, Empleado> empleados = new TreeMap<>();
        
    }

    @Override
    public Empleado read(String identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public Empleado read(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean update(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Set<Empleado> empleadosPorPuesto(String puesto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'empleadosPorPuesto'");
    }

    @Override
    public Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'empleadosPorEdad'");
    }
    
}
