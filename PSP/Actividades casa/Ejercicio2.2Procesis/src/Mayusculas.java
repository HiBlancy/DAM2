import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Mayusculas {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "CambioMayusculas");
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            Process hijo = pb.start();

            BufferedReader brHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream()));
            BufferedReader brPadre = new BufferedReader(new InputStreamReader(System.in));

            String linea;
            while((linea = brPadre.readLine()) != null){
                bw.write(linea);
                bw.newLine();
                bw.flush();

                String respuesta = brHijo.readLine();
                if(respuesta != null){
                    System.out.println(linea);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

