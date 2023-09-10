package xyz.michelle.biografias;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BioAdapter extends RecyclerView.Adapter<BioAdapter.ViewHolder> {
    private List<Bio> bioList;

    public BioAdapter(List<Bio> bioList) {
        this.bioList = bioList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bio_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bio bio = bioList.get(position);
        holder.bind(bio);
    }

    @Override
    public int getItemCount() {
        return bioList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFoto;
        private TextView tvNome;
        private TextView tvIdadeProfissao;
        private TextView tvResumo;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.ivFoto);
            tvNome = itemView.findViewById(R.id.tvNome);
            tvIdadeProfissao = itemView.findViewById(R.id.tvIdadeProfissao);
            tvResumo = itemView.findViewById(R.id.tvResumo);
        }

        void bind(Bio bio) {
            ivFoto.setImageResource(bio.getFoto());
            tvNome.setText(bio.getNome());
            String idadeProfissao = bio.getIdade() + " anos | " + bio.getProfissao();
            tvIdadeProfissao.setText(idadeProfissao);
            tvResumo.setText(bio.getResumo());
        }
    }
}

