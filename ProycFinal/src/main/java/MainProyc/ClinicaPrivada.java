package MainProyc;

/**
 *
 * @author delga
        * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ClinicaPrivada {

    private String nombre;
    private Map<String, List<Medico>> especialidadesMedicos;
    private List<Medico> medicos;
    private static ClinicaPrivada instancia;

    // Constructor sin la especialidad
    private ClinicaPrivada(String nombre) {
        this.nombre = nombre;
        this.medicos = new ArrayList<>();
        this.especialidadesMedicos = new HashMap<>();
    }

    public List<Medico> getMedicosPorEspecialidad(String especialidad) {
         return especialidadesMedicos.getOrDefault(especialidad, new ArrayList<>());
    }

    public static ClinicaPrivada getInstancia() {
        if (instancia == null) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese el nombre de la clínica: ");
            String nombreClinica = scanner.nextLine();

            instancia = new ClinicaPrivada(nombreClinica);
        }
        return instancia;
    }

    public void agregarMedico(Medico medico) {
        String especialidad = medico.getEspecialidad();
        especialidadesMedicos.computeIfAbsent(especialidad, k -> new ArrayList<>()).add(medico);
    }

    public List<String> getEspecialidadesDisponibles() {
        return new ArrayList<>(especialidadesMedicos.keySet());
    }

    
    @Override
    public String toString() {
        return "ClinicaPrivada{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

