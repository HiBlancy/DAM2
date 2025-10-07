import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try {
            String archivo = "src/nombres.txt";

            String[] comandoHijo1 = {"java", "-cp", "out/production/Ejercicio4Procesos", "Hijo1", archivo}; //archivo
            Process procesoHijo1 = new ProcessBuilder(comandoHijo1).start();

            String[] comandoHijo2 = {"java", "-cp", "out/production/Ejercicio4Procesos" , "Hijo2"};
            Process procesoHijo2 = new ProcessBuilder(comandoHijo2).start();

            BufferedReader brHijo1 = new BufferedReader(new InputStreamReader(procesoHijo1.getInputStream()));
            PrintWriter pwHijo2 = new PrintWriter(procesoHijo2.getOutputStream());

            String linea;
            while ((linea = brHijo1.readLine()) != null){
                pwHijo2.println(linea);
                pwHijo2.flush();
            }


            pwHijo2.close(); //avisar al hijo2 que no hay mas datos
            procesoHijo1.waitFor();

            BufferedReader brHijo2 = new BufferedReader(new InputStreamReader(procesoHijo2.getInputStream()));
            while ((linea = brHijo2.readLine()) != null){
                System.out.println(linea);
            }

            brHijo1.close();
            brHijo2.close();
            procesoHijo2.waitFor();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

