package ldAntDron2k25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import ldAntDron2k25.ldEntornoHormiga.Omnivoro;
import ldAntDron2k25.ldEntornoHormiga.ldHZangano;

public class ldAppAntDron2K25 {

    public void ldSimular() {

        System.out.println("\n =======BIENVENIDO AL SISTEMA=========");
        System.out.println("\n======MOSTRAR INFORMACION=============");
        System.out.println("\n[+] INFORMACIÓN:");
        System.out.println("Nombre: Lima Diego ");
        System.out.println("Cédula:0928707660 ");

        ldHZangano ldHormiga = new ldHZangano();

        Scanner ldIngresoDatos = new Scanner(System.in);

        System.out.println("\n ¿Desea alimentar a la hormiga ponga si o no?");
        String ldRespuesta = ldIngresoDatos.nextLine();

        if (!ldRespuesta.equalsIgnoreCase("si")) {
            System.out.println("\n La hormiga NO fue alimentada, se murió");
            return;
        }

        Omnivoro ldAlimento = new Omnivoro();
        boolean ldComio = ldHormiga.ldComer(ldAlimento);
        ldHormiga.ldVive(ldComio);

        ldAntCiberDron ldDron = new ldAntCiberDron(ldHormiga);
        ldArchivo archivo = new ldArchivo();

        System.out.println("\n COORDENADAS UCRANIANAS:\n");

        try (BufferedReader br = new BufferedReader(new FileReader(archivo.getldRuta()))) {
            String ldLinea;
            ldLinea = br.readLine();
            System.out.println(ldLinea);

            while ((ldLinea = br.readLine()) != null) {
                String[] ldColumnas = ldLinea.split(",", -1);
                ldCargarAnimacion(); // spinner
                System.out.println(String.join("   ,   ", ldColumnas));
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo para mostrar tabla: " + e.getMessage());
        }

        System.out.println("\nProcesando archivo...\n");
        System.out.println("\n COORDENADAS UCRANIANAS A DESTRUIR:\n");
        archivo.ldLeerArchivo(ldDron);

        System.out.println("\n--- Proceso terminado ---\n");

    }

    public static void ldCargarAnimacion() {
        try {
            String[] spinner = { "o", "0", "o" };
            int porcentaje = 0;

            while (porcentaje <= 100) {
                System.out.print("\r"); 
                System.out.print(spinner[porcentaje % spinner.length] + " " + porcentaje + "%");
                Thread.sleep(75);
                porcentaje += 5;
            }

            System.out.println(); // salto de línea al finalizar

        } catch (InterruptedException e) {
            System.out.println("Error en la animación.");
        }
    }

}
