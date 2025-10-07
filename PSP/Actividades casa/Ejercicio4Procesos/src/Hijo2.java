import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Hijo2 {
    public static void main(String[] args) {
        //este hijo pone en el orden deseaado los elementos
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            List<String> lista = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) != null){
                lista.add(linea);
            }

            //orden inverso
            for (int i = lista.size() - 1; i >= 0; i--){
                System.out.println(lista.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

