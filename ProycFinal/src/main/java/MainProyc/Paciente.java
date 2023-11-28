package MainProyc;

import java.util.Scanner;

public class Paciente extends Persona implements Registrable {

    private String idPaciente;

    public Paciente() {
        super("", "", "", "", "", "");
        this.idPaciente = "";
    }
    
    public Paciente(String nombre, String apellidos, String dni, String sexo, String celular, String direccion, String idPaciente) {
        super(nombre, apellidos, dni, sexo, celular, direccion);
        this.idPaciente = idPaciente;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
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

        System.out.print("IdPaciente: ");
        this.setIdPaciente(scanner.nextLine());
    }

    @Override
    public String toString() {
        return String.format("Paciente{%s, IdPaciente='%s'}", super.toString(), idPaciente);
    }
}
