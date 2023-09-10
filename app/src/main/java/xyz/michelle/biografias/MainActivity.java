package xyz.michelle.biografias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Bio> bioList = new ArrayList<>();
    private BioAdapter bioAdapter;
    private static final int REQUEST_ADD_BIO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        bioAdapter = new BioAdapter(bioList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bioAdapter);

        Button btnAddBio = findViewById(R.id.btnAddBio);
        btnAddBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abre la pantalla de agregar biografías
                Intent intent = new Intent(MainActivity.this, AddBioActivity.class);
                startActivityForResult(intent, REQUEST_ADD_BIO);
            }
        });

        // biografías
        bioList.add(new Bio("Maria", 30, "Engenheira", "Descricao de Maria", R.drawable.avatar1));

        bioAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ADD_BIO && resultCode == RESULT_OK) {
            // Recibe la nueva biografía y agrégala a la lista
            if (data != null) {
                Bio nuevaBiografia = (Bio) data.getSerializableExtra("nueva_biografia");
                if (nuevaBiografia != null) {
                    bioList.add(nuevaBiografia);
                    bioAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}
