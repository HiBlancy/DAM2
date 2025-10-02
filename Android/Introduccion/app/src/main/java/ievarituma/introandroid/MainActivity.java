package ievarituma.introandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import ievarituma.introandroid.models.UsuarioModel;

public class MainActivity extends AppCompatActivity {

    //Variables de interfaz
    private TextView lblVeces;
    private Button btnPulsame;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnRegistrarse;

    private Button btnAbrir;

    //Variables de logica
    private int contador;
    private ArrayList<UsuarioModel> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("ESTADOS", "1. Estoy en onCreate");

        inicializarVistas();
        contador = 0;

        btnPulsame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Boton pulsado",
                        Toast.LENGTH_SHORT).show();
                contador++;
                lblVeces.setText(contador + " veces");
            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                UsuarioModel adrian = new UsuarioModel(email, password);
                Toast.makeText(MainActivity.this, adrian.toString(),
                        Toast.LENGTH_LONG).show();
                txtEmail.setText("");
                txtPassword.setText("");
            }
        });

        btnAbrir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        SecondActivity.class
                );
                startActivity(intent);
            }
        });
    }

    private void inicializarVistas() {
        lblVeces = findViewById(R.id.lblVecesMain);
        btnPulsame = findViewById(R.id.btnPulsameMain);
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnRegistrarse = findViewById(R.id.btnRegistrarseMain);

        btnAbrir = findViewById(R.id.btnAbrirMain);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ESTADOS", "2. Estoy en onStart");
        //Estados de las actividades (pantalla que se ve en ese instante)
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ESTADOS", "3. Estoy en onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ESTADOS", "5. Estoy en onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ESTADOS", "6. Estoy en onDestroy");
    }
}