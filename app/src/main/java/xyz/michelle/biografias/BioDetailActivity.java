package xyz.michelle.biografias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BioDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_detail);

        ImageView ivFoto = findViewById(R.id.ivFoto);
        TextView tvNome = findViewById(R.id.tvNome);
        TextView tvIdade = findViewById(R.id.tvIdade);
        TextView tvProfissao = findViewById(R.id.tvProfissao);
        TextView tvResumo = findViewById(R.id.tvResumo);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        if (intent != null) {
            Bio bio = (Bio) intent.getSerializableExtra("biografia");
            if (bio != null) {
                ivFoto.setImageResource(bio.getFoto());
                tvNome.setText(bio.getNome());
                tvIdade.setText(String.valueOf(bio.getIdade()));
                tvProfissao.setText(bio.getProfissao());
                tvResumo.setText(bio.getResumo());
            }
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Volta tela principal
                finish();
            }
        });
    }
}
