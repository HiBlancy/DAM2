import java.io.*;

public class DirPipe {
    public static void main(String[] args) {
        try{
            String[] comando = {"cmd.exe", "/c", "dir"};

            Process procesoComando = new ProcessBuilder(comando).start();

            String[] comandoHijo = {"java", "-cp", "out/production/Ejercicio3Procesos" , "UltimaLinea"};
            Process procesoHijo = new ProcessBuilder(comandoHijo).start();

            BufferedReader brComando = new BufferedReader(new InputStreamReader(procesoComando.getInputStream()));
            PrintWriter bwHijo = new PrintWriter(procesoHijo.getOutputStream());

            String linea;
            while ((linea = brComando.readLine()) != null) {
                bwHijo.println(linea);
            }
            bwHijo.flush();

            BufferedReader brHijo = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
            String resultado = brHijo.readLine();
            if (resultado != null) {
                System.out.println(resultado);
            }

            brComando.close();
            bwHijo.close();
            brHijo.close();

            procesoComando.waitFor();
            procesoHijo.waitFor();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

