import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UltimaLinea {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String linea;
            String ultima = null;

            while ((linea = br.readLine()) != null){
                ultima =linea;
            }

            if(ultima != null){
            System.out.println(ultima);}
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

