package PadreHijo.Hijo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CuentaLetras {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String frase;
            try {
                frase = br.readLine();
                System.out.println(frase.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


}
