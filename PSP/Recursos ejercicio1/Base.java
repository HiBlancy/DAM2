package Base;

import java.io.IOException;

public class Base {
    public static void main(String[] args) {
        // Lo primero que vamos a hacer es crear los argumentos del proceso
        // que vamos a crear. Estos argumentos serán el programa y sus comandos
        // En este primer ejemplo voy a usar la calculadora
        // Dependiendo del SO que tengamos usaremos unos u otros comandos
        // Para Windows --> "calc"
        // Para ioS --> "open", "/System/Applications/Calculator.app"
        // Para ubuntu --> Vamos a /usr/share/applications
        // Botón derecho en la aplicación --> propiedades --> order
        // El comando sería --> "comando", "argumentos"
        // firefox es "firefox %u" --> "firefox", "%u"

        // Listado de comandos de Windows
        // Explorador de archivos --> explorer
        // Bloc de notas --> notepad
        // paint --> mspaint
        // simbolo del sistema --> cmd
        // Administrador de tareas --> taskmgr

        String[] comandosWin = {"notepad", "nombredelfichero.txt"};
        String[] comandosioS = {"open", "/System/Applications/Textedit.app"};
        String[] comandosUbuntu = {"firefox", "%u"};

        // Para lanzar un ejecutable en Windows tenemos que
        // utilizar la ruta del ejecutable
        String[] comandoChrome = {"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "www.youtube.com", "www.cieep.com"};
        String[] comandoSafariioS = {"open", "-a", "Safari", "http://www.google.com"};

        try {
            // Iniciamos el proceso mediante el ProcessBuilder,
            // pasándole los comandos con la función start
            Process miProceso = new ProcessBuilder(comandoChrome).start();

            // Forma alternativa de lanzar un proceso
            // Process miProcesoExtra = Runtime.getRuntime().exec(comandosWin);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
