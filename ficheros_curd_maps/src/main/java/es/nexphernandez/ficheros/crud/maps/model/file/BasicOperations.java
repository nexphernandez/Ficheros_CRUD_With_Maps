package es.nexphernandez.ficheros.crud.maps.model.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
import es.nexphernandez.ficheros.crud.maps.model.Empleado;

public abstract class BasicOperations {
    
    /**
     * Funcion que lee los elementos de un fichero
     * @param file fichero que se debe leer 
     * @return lista con los datos del fichero
     */
    public Set<Empleado> read(File file){
        Set<Empleado> empleados = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arrayLine = line.trim().split(",");
                Empleado empleado = new Empleado(arrayLine[0], arrayLine[1], arrayLine[2], 
                Double.parseDouble(arrayLine[3]), arrayLine[4]);
                empleados.add(empleado);
            }
        } catch (Exception e) {
            return new HashSet<>();
        }
        return empleados;
    }

    /**
     * Funcion que aniade un informacion al fichero
     * @param data informacion que hay que aniadir al fichero
     * @param file fichero donde aniadir la informacion 
     * @return true/false
     */
    public boolean create (String data, File file){
        if (data == null || data.isEmpty()) {
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))){
            writer.write(data);
            writer.newLine();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Funcion que actualiza un fichero mediante una lista de empleados
     * @param empleados lista de empleados a usar
     * @param file fichero a actualizar
     * @return true/false
     */
    public boolean updateFile (Set<Empleado> empleados, File file){
        if (empleados == null ) {
            return false;
        }
        try {
            file.delete();
            file.createNewFile();
        } catch (Exception e) {
            return false;
        }
        for (Empleado empleado : empleados) {
            create(empleado.toString(), file);
        }
        return true;
    }
}
