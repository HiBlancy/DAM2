package LeerHijo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ping {
    public static void main(String[] args) {
        String[] comandoWin = {"cmd","/C","ping", "-n", "3", "google.com"};
        String[] comandoIOS = {"ping", "-c", "3", "google.com"};

        try {
            Process miProceso = new ProcessBuilder(comando).start();
            //Una vez tenemos mi proceso creado, vamos a crear un flujo de datos
            //Del hijo hacia el padre
            BufferedReader brPadre = new BufferedReader(
                    new InputStreamReader(miProceso.getInputStream()));
            //Una vez tengo el flujo de datos, leo los datos que salen del hijo
            //Hasta que me devuelva null porque no quedan más datos
            String linea;
            while((linea=brPadre.readLine())!=null){
                System.out.println(linea);
            }

            //Espero a que termine el hijo y miro su salida al terminar
            //Si es 0 es que todo ha ido bien, si no será -1
            int exitCode = miProceso.waitFor();
            System.out.println("\n Salimos con código: "+exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
