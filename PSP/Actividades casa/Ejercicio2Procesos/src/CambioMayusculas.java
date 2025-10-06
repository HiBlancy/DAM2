import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CambioMayusculas {
    public static void main(String[] args) {
        try {
            //lectura
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String linea;

            while ((linea = br.readLine()) != null) {
                //conertir y sacar
                String mayusculas = linea.toUpperCase();
                System.out.println(mayusculas);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}