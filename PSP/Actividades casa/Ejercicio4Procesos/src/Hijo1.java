import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Hijo1 {
    public static void main(String[] args) {
        //este hijo lo recibe, lo lee y elimina el FIN

        if (args.length == 0) {
            System.out.println("error");
            return;
        }

        String rutaArchivo = args[0];

        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));

            for (String linea : lineas) {
                if("FIN".equals(linea)){
                    break;
                }
                System.out.println(linea);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

