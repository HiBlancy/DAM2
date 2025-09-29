package PadreHijo.Padre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Padre {
    public static void main(String[] args) {
        String[] comando = {"Java", "-jar", "out/artifacts/CuentaLetras/CuentaLetras.jar"};
        String[] comandoUnix = {"java", "-jar", "out/artifacts/CuentaLetras/CuentaLetras.jar"};
        System.out.println("Dime una frase y te diré cuantas letras tiene");
        BufferedReader brPadre = new BufferedReader(new InputStreamReader(System.in));
        String respuesta = null;
        try{
            respuesta= brPadre.readLine();
            Process cuentaLetras = new ProcessBuilder(comando).start();
            PrintStream psHijo = new PrintStream(cuentaLetras.getOutputStream());
            // para mandar la información uso println() y al terminar flush()
            psHijo.println(respuesta);
            psHijo.flush();
            psHijo.close();

            // aquí podría seguir realizando mi código hasta que necesitara
            // la respuesta del hijo

            // ahora voy a regoger la respuesta del hijo
            BufferedReader brHijo = new BufferedReader(
                    new InputStreamReader(cuentaLetras.getInputStream()));

            String respuestaHijo = brHijo.readLine();
            System.out.println("El número total es: "+ respuestaHijo+" letras");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
