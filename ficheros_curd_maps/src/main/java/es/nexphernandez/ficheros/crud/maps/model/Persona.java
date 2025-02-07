package es.nexphernandez.ficheros.crud.maps.model;
import java.util.Objects;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public abstract class Persona {
    private String identificador;
    private String nombre;
    private String fechaNacimiento;

    /**
     * Cosntructor por defecto
     */
    protected Persona() {}

    /**
     * Constructor del atributo clave de la clase
     * @param identificador identficador de la persona
     */
    protected Persona(String identificador) {
        this.identificador = identificador;
    }

    /**
     * Cpnstructor de los atrinutos de la clase
     * @param identificador identifiacador de la persona
     * @param nombre nombre de la persona
     * @param fechaNacimiento fecha de nacimiento de la persona
     */
    protected Persona(String identificador, String nombre, String fechaNacimiento) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Funcion equals de la clase
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return Objects.equals(identificador, persona.identificador);
    }

    /**
     * Funcion HashCode de la clase
     */
    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    /**
     * Funcion toString de la clase 
     */
    @Override
    public String toString() {
        return getIdentificador() + "," + getNombre() + "," + getFechaNacimiento();
    }
    
}
