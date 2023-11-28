package MainProyc;

/**
 *
 * @author delga
 */
// Clase madre Persona que implementa la interfaz Registrable

public abstract class Persona implements Registrable {
    private String nombre;
    private String apellidos;
    private String dni;
    private String sexo;
    private String celular;
    private String direccion;

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String dni, String sexo, String celular, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.sexo = sexo;
        this.celular = celular;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //METODO IMPLEMENTADO POR LAS CLASES HIJAS, POL
    @Override
    public String toString() {
        return "Persona{" +
                "Nombre ='" + nombre + '\'' +
                ", Apellidos ='" + apellidos + '\'' +
                ", DNI = '" + dni + '\'' +
                ", Sexo = '" + sexo + '\'' +
                ", Celular = '" + celular + '\'' +
                ", Direccion ='" + direccion + '\'' +
                '}';
    }

    // Método abstracto para ser implementado por las clases hijas
    public abstract void ingresarPorConsola(java.util.Scanner scanner);
}
