package MainProyc;

import java.util.List;
import java.util.Scanner;

public class Cita implements Registrable {

    private static final int DURACION_CITA_HORAS = 1;
    private static final int HORA_INICIO = 8;
    private static final int HORA_FIN = 17;
    ClinicaPrivada clinica = ClinicaPrivada.getInstancia();
    private String fecha;
    private String hora;
    private Medico medico;

    public Cita() {
        this.fecha = "";
        this.hora = "";
        this.medico = new Medico();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public void ingresarPorConsola(Scanner scanner) {
        ClinicaPrivada clinica = ClinicaPrivada.getInstancia();

        System.out.print("Elija una opción:\n1. Ver especialidades disponibles\n2. Hacer una cita\nIngrese el número de la opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        switch (opcion) {
            case 1:
                // Mostrar especialidades disponibles
                System.out.println("Especialidades disponibles:");
                clinica.getEspecialidadesDisponibles().forEach(System.out::println);
                break;
            case 2:
                // Hacer una cita
                System.out.print("Especialidad: ");
                String especialidad = scanner.nextLine();

                List<Medico> medicosDisponibles = clinica.getMedicosPorEspecialidad(especialidad);

                if (medicosDisponibles.isEmpty()) {
                    System.out.println("No hay médicos disponibles para la especialidad ingresada.");
                    return;
                }

                // Mostrar los médicos disponibles para que el usuario elija
                System.out.println("Médicos disponibles:");
                for (int i = 0; i < medicosDisponibles.size(); i++) {
                    System.out.println(i + 1 + ". " + medicosDisponibles.get(i).getNombre());
                }

                System.out.print("Elija un médico (1-" + medicosDisponibles.size() + "): ");
                int indiceMedico = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                if (indiceMedico < 1 || indiceMedico > medicosDisponibles.size()) {
                    System.out.println("Opción no válida. Volviendo al menú principal.");
                    return;
                }

                Medico medicoElegido = medicosDisponibles.get(indiceMedico - 1);
                this.setMedico(medicoElegido);

                // Mostrar horarios disponibles y permitir al usuario elegir
                System.out.println("Horarios disponibles:");
                mostrarHorariosDisponibles();
                System.out.print("Elija una hora disponible (formato HH:MM): ");
                this.setHora(scanner.nextLine());

                // Aquí puedes agregar la lógica para guardar la cita en algún lugar si es necesario
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void mostrarHorariosDisponibles() {
        for (int hora = HORA_INICIO; hora < HORA_FIN; hora++) {
            for (int minuto = 0; minuto < 60; minuto += 60 / DURACION_CITA_HORAS) {
                String horaFormato = String.format("%02d:%02d", hora, minuto);
                System.out.println(horaFormato);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Cita{Fecha='%s', Hora='%s', Médico='%s'}", fecha, hora, medico.getNombre());
    }
}
