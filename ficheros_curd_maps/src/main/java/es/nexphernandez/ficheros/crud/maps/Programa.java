package es.nexphernandez.ficheros.crud.maps;

import es.nexphernandez.ficheros.crud.maps.model.Empleado;
import es.nexphernandez.ficheros.crud.maps.model.file.FileOperationsMaps;

public class Programa {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("2", "Alex", "Vicedirector", 20000,"13/10/1994");
        System.out.println(empleado);
        System.out.println(empleado.getEdad(empleado.getFechaNacimiento()));
        
        FileOperationsMaps operacionesMap = new FileOperationsMaps();
        boolean insertar = operacionesMap.createMap(empleado);
        if (insertar) {
            System.out.println("Se ha insertado correctamente");
        }  else{
            System.out.println("No se ha insertado el elemento");
        }
        
    }
}