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
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import ievarituma.introandroid.models.DireccionModel;
import ievarituma.introandroid.models.UsuarioModel;

public class MainActivity extends AppCompatActivity {

    //Variables de interfaz
    private TextView lblVeces;
    private Button btnPulsame;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnRegistrarse;
    private Button btnCrearDireccion;

    //Variables de logica
    private int contador;
    private ArrayList<UsuarioModel> listaUsuarios;
    private ActivityResultLauncher<Intent> launcherDirecciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("ESTADOS", "1. Estoy en onCreate");

        inicializarVistas();
        inicializarLauchers();
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
                UsuarioModel miUsuario = new UsuarioModel(email, password);

                Intent intent = new Intent(
                        MainActivity.this,
                        SecondActivity.class);

                Bundle bundle = new Bundle();
                //bundle.putString("MAIL", email);
                //bundle.putString("PASS", password);
                bundle.putSerializable("USER", miUsuario);
                intent.putExtras(bundle);

                startActivity(intent);

                txtEmail.setText("");
                txtPassword.setText("");
            }
        });

        btnCrearDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        CrearDireccionActivity.class
                );
                launcherDirecciones.launch(intent);
            }
        });

    }

    private void inicializarLauchers() {
        launcherDirecciones = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if (o.getResultCode() == RESULT_OK) {
                    if (o.getData() != null) {
                        Bundle bundle = o.getData().getExtras();
                        DireccionModel miDireccion =
                                (DireccionModel) bundle.getSerializable("DIR");
                        Toast.makeText(
                                MainActivity.this,
                                miDireccion.toString(),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(
                                MainActivity.this,
                                "No había coche",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(
                            MainActivity.this,
                            "La otra actividad explotó sin permiso",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializarVistas() {
        lblVeces = findViewById(R.id.lblVecesMain);
        btnPulsame = findViewById(R.id.btnPulsameMain);
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnRegistrarse = findViewById(R.id.btnRegistrarseMain);
        btnCrearDireccion = findViewById(R.id.btnCrearDireccionMain);
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