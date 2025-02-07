package es.nexphernandez.ficheros.crud.maps.model.file;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
 *@author nexphernandez
 *@version 1.0.0 
 */
import es.nexphernandez.ficheros.crud.maps.model.Empleado;

public class FileOperationsMaps extends FileOperations {

    /**
     * Constructor vacio
     */
    public FileOperationsMaps(){
        super();
    }

    /**
     * Funcion que agrega elementos al fichero ordenado
     * @param empleado empleado a agregar
     * @return true/false
     */
    @Override
    public boolean create(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador() == null || empleado.getIdentificador().isEmpty()) {
            return false;
        }
        Map<String, Empleado> empleados = new TreeMap<>();
        Set<Empleado> setEmpleados = read(file);
        if (setEmpleados.contains(empleado)) {
            return false;
        }
        
        for (Empleado esEmpleadoBuscar : setEmpleados) {
            empleados.put(esEmpleadoBuscar.getIdentificador(), esEmpleadoBuscar);
        }
        empleados.put(empleado.getIdentificador(), empleado);
        file.delete();
        try {
            file.createNewFile();
    
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }        
        for (Empleado empleadocrear : empleados.values()) {
            create(empleadocrear.toString(), file); 
        }
        return true;
    }
    
    /**
     * Funcion que actualiza un fichero mediante una lista de empleados
     * @param empleados lista de empleados a usar
     * @param file fichero a actualizar
     * @return true
     */
    public boolean updateFile (Map<String,Empleado> empleados, File file){
        if (empleados == null ) {
            return false;
        }
        try {
            file.delete();
            file.createNewFile();
        } catch (Exception e) {
            return false;
        }
        for (Empleado empleado : empleados.values()) {
            create(empleado);
        }
        return true;
    }

    /**
     * Funcion que actuliza un empleado de un fichero
     * @param empleado empleado a actualizar
     * @return true/false
     */
    @Override
    public boolean update(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador().isEmpty() || empleado.getIdentificador() == null) {
            return false;
        }
        Set<Empleado> empleados = read(super.file);
        boolean encontrado = false;
        Map<String,Empleado> actualizados = new TreeMap<>();
        for (Empleado empleadoActualizar : empleados) {
            if (empleadoActualizar.equals(empleado)) {
                actualizados.put(empleado.getIdentificador(), empleado);
                encontrado = true;
            } else{
                actualizados.put(empleadoActualizar.getIdentificador(), empleadoActualizar);
            }
        }
        if (!encontrado) {
            return false;
        }
        return updateFile(actualizados, super.file);
    }
    
}
