import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Procesos {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        int opcion;
        do{
            opcion = menu();

            switch (opcion){
                case 1:
                    abrirCalculadora();
                    break;
                case 2:
                    crearArchivo();
                    break;
                case 3:
                    abrirURL();
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Hasta luego");
                     break;
                default:
                    System.out.println("Opción no válida");
                     break;
            }
        }while(opcion != 5);
    }

    private static int menu(){
        //System.getProperty("user.name");
        //String usuario = System.getProperty("user.name");
        //System.out.println("Tu usuario es: " + usuario);
        System.out.println("--MENU--");
        System.out.println("1. Abrir calculadora");
        System.out.println("2. Abrir fichero");
        System.out.println("3. Abrir URL");
        System.out.println("4.");
        System.out.println("5. Salir");

        int op = sc.nextInt();
        sc.nextLine();

        return op;
    }

    private static void abrirCalculadora() {
        try {
            ProcessBuilder pb = new ProcessBuilder("calc");
            pb.start();
        }catch (Exception e){
            System.out.println("Error al abrir calculadora " + e.getMessage());
        }
    }

    private static void crearArchivo() {
        try {
            System.out.println("Ruta del archivo:");
            String ruta = sc.nextLine();

            System.out.println("Nombre del archivo:");
            String nombreArchivo = sc.nextLine();

            String rutaArchivo = ruta + "/" + nombreArchivo + ".txt";

            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            try{
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Archivo creado desde JAVA");
                bw.close();

                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start", "\"\"", rutaArchivo);
                pb.start();

            } catch (Exception e){
                System.out.println("Error al crear archivo " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    private static void abrirURL() {
        try {
            System.out.println("Ruta del URL:");
            String url = sc.nextLine();

            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start", url);
            pb.start();
        } catch (Exception e) {
        System.out.println("Error " + e.getMessage());
        }
    }
}
