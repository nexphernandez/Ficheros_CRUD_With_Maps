package es.nexphernandez.ficheros.crud.maps.model.file;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
import es.nexphernandez.ficheros.crud.maps.model.Empleado;
import es.nexphernandez.ficheros.crud.maps.model.IOperations;

public class FileOperations extends BasicOperations implements IOperations {
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

    /**
     * Funcion que aniade un empleado al fichero
     * @param empleado empleado a aniadir
     * @return true/false;
     */
    @Override
    public boolean create(Empleado empleado) {
        if (empleado == null) {
            return false;
        }
        Set<Empleado> empleados = read(file);
        if (empleados.contains(empleado)) {
            return false;
        }
        return create(empleados.toString(), file);
    }

    /**
     * Funcion que busca un empleado por el identificador en un fichero
     * @param identificador identificador del empleado a buscar
     * @return empleado buscado
     */
    @Override
    public Empleado read(String identificador) {
        if (identificador == null || identificador.isEmpty()) {
            return null;
        }
        Empleado empleado = new Empleado(identificador);
        return read(empleado);
    }

    /**
     * Funcion que busca un empleado en un fichero
     * @param empleado empleado a buscar
     * @return empleado buscado
     */
    @Override
    public Empleado read(Empleado empleado) {
        if (empleado == null) {
            return empleado;
        }
        Set<Empleado> empleados = read(file);
        for (Empleado empleadoBuscar : empleados) {
            if (empleadoBuscar.equals(empleado)) {
                return empleadoBuscar;
            }
        }
        return null;
    }

    /**
     * Funcion que actuliza un empleado de un fichero
     * @param empleado empleado a actualizar
     * @return true/false
     */
    @Override
    public boolean update(Empleado empleado) {
        if (empleado == null) {
            return false;
        }
        Set<Empleado> empleados = read(file);
        boolean encontrado = false;
        Set<Empleado> actualizados = new HashSet<>();
        for (Empleado empleadoActualizar : empleados) {
            if (empleadoActualizar.equals(empleado)) {
                actualizados.add(empleado);
                encontrado = true;
            } else{
                actualizados.add(empleadoActualizar);
            }
        }
        if (!encontrado) {
            return false;
        }
        return updateFile(actualizados, file);
    }

    /**
     * Funcion que borra un elemento de un fichero por su identificador
     * @param identificador identificador de la persona a borrar
     * @return true/false
     */
    @Override
    public boolean delete(String identificador) {
        if (identificador == null || identificador.isEmpty()) {
            return false;
        }
        Empleado empleado = new Empleado(identificador);
        Set<Empleado> empleados = read(file);
        if (!empleados.contains(empleado)) {
            return false;
        }
        empleados.remove(empleado);
        return updateFile(empleados,file);
    }

    /**
     * Funcion que ordena un fichero por los puestos de empleados
     * @param puesto puesto de los empleados a ordenar
     * @return lista de empleados ordenados por el puesto
     */
    @Override
    public Set<Empleado> empleadosPorPuesto(String puesto) {
        if (puesto == null || puesto.isEmpty()) {
            return new HashSet<>();
        }
        Set<Empleado>empleados = read(file);
        Set<Empleado> porPuestos = new HashSet<>();
        for (Empleado empleado : empleados) {
            if (empleado.getPuesto().trim().equals(puesto.trim())) {
                porPuestos.add(empleado);
            }
        }
        return porPuestos;
    }

    /**
     * Funcion que genera una lista de empleados por la fecha de nacimiento respecto
     * a una fecha de inicio y fecha de fin
     * @param fechaInicio fecha de inicio de la cual generar la lista
     * @param fechaFin fecha fin de la cual generar la lista
     * @return lista de empleados
     */
    @Override
    public Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin) {
        if (fechaFin == null || fechaInicio == null || 
        fechaFin.isEmpty() || fechaInicio.isEmpty()) {
            return new HashSet<>();
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio = LocalDate.parse(fechaInicio, formato);
        LocalDate fin = LocalDate.parse(fechaFin, formato);
        Set<Empleado> empleados = read(file);
        Set<Empleado> porEdad = new HashSet<>();
        for (Empleado empleado : empleados) {
            LocalDate cumpleanio = LocalDate.parse(empleado.getFechaNacimiento().trim(), formato);
            if ((cumpleanio.equals(inicio) || cumpleanio.isAfter(inicio) && cumpleanio.isBefore(fin))) {
                porEdad.add(empleado);
            }
        }
        return porEdad;
    }

}
