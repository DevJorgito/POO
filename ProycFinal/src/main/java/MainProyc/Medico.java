package MainProyc;


/**
 *
 * @author delga
 */

import java.util.Scanner;

public class Medico extends Persona implements Registrable {

    
    private String especialidad;
    private String numeroColegiado;
    private ClinicaPrivada clinica;

    public Medico() {
        super("", "", "", "", "", "");
        this.especialidad = "";
        this.numeroColegiado = "";
    }
    
   // Constructor que recibe la clínica como parámetro
    public Medico(String nombre, String apellidos, String dni, String sexo, String celular, String direccion,
                  String especialidad, String numeroColegiado) {
        super(nombre, apellidos, dni, sexo, celular, direccion);
        this.especialidad = especialidad;
        this.numeroColegiado = numeroColegiado;
    }
    

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(String numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }
    
    public void registrarseEnClinica(ClinicaPrivada clinica) {
        this.clinica = clinica;
    }

    @Override
    public void ingresarPorConsola(Scanner scanner) {
        System.out.print("Nombre: ");
        this.setNombre(scanner.nextLine());

        System.out.print("Apellidos: ");
        this.setApellidos(scanner.nextLine());

        System.out.print("DNI: ");
        this.setDni(scanner.nextLine());

        System.out.print("Sexo: ");
        this.setSexo(scanner.nextLine());

        System.out.print("Celular: ");
        this.setCelular(scanner.nextLine());

        System.out.print("Dirección: ");
        this.setDireccion(scanner.nextLine());

        System.out.print("Especialidad: ");
        this.setEspecialidad(scanner.nextLine());

        System.out.print("Número de Colegiado: ");
        this.setNumeroColegiado(scanner.nextLine());
    }

    @Override
    public String toString() {
        return String.format("Medico{%s, Especialidad='%s', NumeroColegiado='%s'}",
                             super.toString(), especialidad, numeroColegiado);
    }

    
 
    
}
