package MainProyc;


import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {

    public static final String CARPETA_ARCHIVOS = "C:\\Users\\delga\\Documents\\NetBeansProjects\\ProycFinal\\src\\main\\java\\MainProyc\\Archivos\\";


    public static <T> void adicionarDatoTexto(String nombreArchivo, String dato) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(CARPETA_ARCHIVOS + nombreArchivo, true))) {
        writer.println(dato);
        System.out.println("Datos escritos en el archivo: " + nombreArchivo);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static <T> T[] obtenerDatosTexto(String nombreArchivo, Class<T[]> tipoArray) {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CARPETA_ARCHIVOS + nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }

        if (!lineas.isEmpty()) {
            T[] datos = (T[]) Array.newInstance(tipoArray.getComponentType(), lineas.size());
            for (int i = 0; i < lineas.size(); i++) {
                datos[i] = (T) lineas.get(i);
            }

            System.out.println("Datos leídos desde el archivo: " + nombreArchivo);
            return datos;
        }

        return null;
    }
    
    
}
