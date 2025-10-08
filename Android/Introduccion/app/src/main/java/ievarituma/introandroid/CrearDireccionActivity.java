package ievarituma.introandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ievarituma.introandroid.models.DireccionModel;

public class CrearDireccionActivity extends AppCompatActivity {

    private TextView lblTitulo;
    private EditText txtCalle;
    private EditText txtNumero;
    private EditText txtCiudad;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_direccion);

        inicializarVistas();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String calle = txtCalle.getText().toString();
                int numero = Integer.parseInt(txtNumero.getText().toString());
                String ciudad = txtCiudad.getText().toString();

                DireccionModel miDireccion = new DireccionModel(
                        calle, numero, ciudad
                );

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("DIR", miDireccion);
                intent.putExtras(bundle);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void inicializarVistas() {
        lblTitulo = findViewById(R.id.lblTituloCrearDireccion);
        txtCalle = findViewById(R.id.txtCalleCrearDireccion);
        txtNumero = findViewById(R.id.txtNumeroCrearDireccion);
        txtCiudad = findViewById(R.id.txtCiudadCrearDireccion);
        btnCrear = findViewById(R.id.btnCrearCrearDireccion);
    }
}