package ievarituma.introandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ievarituma.introandroid.models.UsuarioModel;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            //String email = bundle.getString("MAIL");
            //String password = bundle.getString("PASS");
            UsuarioModel miUsuario =
                    (UsuarioModel) bundle.getSerializable("USER");

            Toast.makeText(
                    this,
                    miUsuario.toString(),
                    Toast.LENGTH_SHORT).show();

        }
    }
}