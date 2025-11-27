package ldAntDron2k25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ldArchivo {

    private String ldRuta = "src/LimaDiego.csv";

    public String getldRuta() {
        return ldRuta;
    }

    public void setldRuta(String ldRuta) {
        this.ldRuta = ldRuta;
    }

    public void ldLeerArchivo(ldAntCiberDron ldDron) {

        try (BufferedReader ldLeerArchivo = new BufferedReader(new FileReader(ldRuta))) {

            String ldLinea;

            // saltar encabezado
            ldLeerArchivo.readLine();
             System.out.printf("%-15s %-15s %-10s%n", "Geoposicion", "TipoArsenal", "Accion");

            while ((ldLinea = ldLeerArchivo.readLine()) != null) {
                String[] ldColumnas = ldLinea.split(",", -1);

                if (ldColumnas.length < 7) {
                    System.out.println("Error, no tiene las columnas completas " + ldLinea);
                    continue;
                }

                String ldCoordenada = ldColumnas[0];
                String ldArsenal = ldColumnas[6];

                // procesar con ldDron
                if (ldDron.ldBuscar(ldArsenal)) {
                System.out.printf("%-15s %-15s %-10s%n", ldCoordenada, ldArsenal, "True");
            }
            }

        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }
}
