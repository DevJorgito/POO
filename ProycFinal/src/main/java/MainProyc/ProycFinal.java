
package MainProyc;


/**
 *
 * @author delga
 */
import java.util.Scanner;

public class ProycFinal {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;
        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Ingresar Paciente");
            System.out.println("2. Ingresar Médico");
            System.out.println("3. Ingresar Cita");
            System.out.println("4. Mostrar Pacientes");
            System.out.println("5. Mostrar Médicos");
            System.out.println("6. Mostrar Citas");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    ingresarPaciente();
                    break;
                case 2:
                    ingresarMedico();
                    break;
                case 3:
                    ingresarCita();
                    break;
                case 4:
                    mostrarPacientes();
                    break;
                case 5:
                    mostrarMedicos();
                    break;
                case 6:
                    mostrarCitas();
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }

        } while (opcion != 7);
    }

    private static void ingresarPaciente() {
        Paciente paciente = new Paciente();
        paciente.ingresarPorConsola(scanner);
        Persistencia.adicionarDatoTexto("pacientes.txt", paciente.toString());
    }

    private static void ingresarMedico() {
        Medico medico = new Medico();
        medico.ingresarPorConsola(scanner);

        ClinicaPrivada clinica = ClinicaPrivada.getInstancia();
        clinica.agregarMedico(medico);

        Persistencia.adicionarDatoTexto("medicos.txt", medico.toString());
    }

   private static void ingresarCita() {
        Cita cita = new Cita();
        cita.ingresarPorConsola(scanner);
        Persistencia.adicionarDatoTexto("citas.txt", cita.toString());
    }

    private static void mostrarPacientes() {
        String[] pacientes = Persistencia.obtenerDatosTexto("pacientes.txt", String[].class);
        mostrarDatos(pacientes);
    }

    private static void mostrarMedicos() {
        String[] medicos = Persistencia.obtenerDatosTexto("medicos.txt", String[].class);
        mostrarDatos(medicos);
    }

    private static void mostrarCitas() {
        String[] citas = Persistencia.obtenerDatosTexto("citas.txt", String[].class);
        mostrarDatos(citas);
    }

    private static void mostrarDatos(String[] datos) {
        if (datos != null && datos.length > 0) {
            for (String dato : datos) {
                System.out.println(dato);
                System.out.println("------------------------------");
            }
        } else {
            System.out.println("No hay datos para mostrar.");
        }
    }
}
