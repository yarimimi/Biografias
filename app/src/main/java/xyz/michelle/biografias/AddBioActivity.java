package xyz.michelle.biografias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddBioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bio);

        final EditText Nome = findViewById(R.id.etNome);
        final EditText Idade = findViewById(R.id.etIdade);
        final EditText Profissao = findViewById(R.id.etProfissao);
        final EditText Resumo = findViewById(R.id.etResumo);
        Button btnAdicionar = findViewById(R.id.btnAdicionar);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = Nome.getText().toString();
                int idade = Integer.parseInt(Idade.getText().toString());
                String profissao = Profissao.getText().toString();
                String resumo = Resumo.getText().toString();

                // Criar nova biografía  dados ingresados (puedes usar una imagen predeterminada)
                Bio nuevaBio = new Bio(nome, idade, profissao, resumo, R.drawable.default_avatar);

                // Enviar la nueva biografía a la pantalla principal
                Intent intent = new Intent();
                intent.putExtra("nueva_biografia", nuevaBio);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
