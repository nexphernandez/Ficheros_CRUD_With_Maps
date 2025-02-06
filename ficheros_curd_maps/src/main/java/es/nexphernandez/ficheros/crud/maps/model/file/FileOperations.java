package es.nexphernandez.ficheros.crud.maps.model.file;

import java.io.File;
import java.util.Set;
import java.net.URL;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
import es.nexphernandez.ficheros.crud.maps.model.Empleado;
import es.nexphernandez.ficheros.crud.maps.model.IOperations;

public class FileOperations implements IOperations{
    File file;
    String nombreFichero = "empleado.txt";
    
    /**
     * Constructor de la clase FileOperations
     */
    public FileOperations(){
        try {
            URL resourse = getClass().getClassLoader().getResource(this.nombreFichero);
            this.file = new File(resourse.toURI());
            if (!file.exists() || file.isFile()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean create(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
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

}
