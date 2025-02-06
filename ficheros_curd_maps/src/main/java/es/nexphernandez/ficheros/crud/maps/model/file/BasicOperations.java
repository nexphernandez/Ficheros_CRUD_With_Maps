package es.nexphernandez.ficheros.crud.maps.model.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

import es.nexphernandez.ficheros.crud.maps.model.Empleado;

abstract class BasicOperations {
    
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

    public boolean create (String data, File file){
        if (data == null || data.isEmpty()) {
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))){
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
