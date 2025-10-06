import java.io.*;

public class Mayusculas {
    public static void main(String[] args) {
        try {
            String[] comando = {"Java", "-jar", "out/artifacts/CambioMayusculas/CambioMayusculas.jar"};

            Process proceso = null;
            proceso = new ProcessBuilder(comando).start();

            BufferedReader brTeclado = new BufferedReader(new InputStreamReader(System.in));
            String respuesta;
            try {
                respuesta = brTeclado.readLine();
            } catch (IOException e){
                throw new RuntimeException(e);
            }

            PrintWriter pwTeclado = new PrintWriter(proceso.getOutputStream());
            pwTeclado.println(respuesta);
            pwTeclado.flush();
            pwTeclado.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            try {
                System.out.println(br.readLine());
            } catch (IOException e) {
                System.out.println("Error al leer desde el subproceso");
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}