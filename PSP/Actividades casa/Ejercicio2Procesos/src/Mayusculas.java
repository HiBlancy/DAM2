import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mayusculas {
    public static void main(String[] args) {
        try {
            String[] comando = {"Java", "-jar", "out/artifacts/CambioMayusculas/CambioMayusculas.jar"};

            Process proceso = null;
            proceso = new ProcessBuilder(comando).start();

        } catch (IOException e) {
            System.out.println("Error");
        }

    }
}

