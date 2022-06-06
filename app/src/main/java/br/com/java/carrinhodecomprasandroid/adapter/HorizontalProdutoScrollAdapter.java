package br.com.java.carrinhodecomprasandroid.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import br.com.java.carrinhodecomprasandroid.R;
import br.com.java.carrinhodecomprasandroid.activity.ProdutosDetalhesAcivity;
import br.com.java.carrinhodecomprasandroid.model.HorizontalProdutoScrollModelo;

public class HorizontalProdutoScrollAdapter extends RecyclerView.Adapter<HorizontalProdutoScrollAdapter.ViewHolder> {

    private List<HorizontalProdutoScrollModelo> modelos;

    public HorizontalProdutoScrollAdapter(List<HorizontalProdutoScrollModelo> modelos) {
        this.modelos = modelos;
    }

    @NonNull
    @Override
    public HorizontalProdutoScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProdutoScrollAdapter.ViewHolder holder, int position) {

        String proId=modelos.get(position).getProdutoId();
        String res = modelos.get(position).getProdutoImagem();
        String nome = modelos.get(position).getProdutoNome();
        String des = modelos.get(position).getProdutoDes();
        String preco = modelos.get(position).getProdutoPreco();

        holder.definirDado(proId,res,nome,des,preco);

    }

    @Override
    public int getItemCount() {
        if (modelos.size() > 8) {
            return 8;
        }
        return modelos.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagemView;
        private TextView textoView1, textoView2, textoView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemView = itemView.findViewById(R.id.hspImagem);
            textoView1 = itemView.findViewById(R.id.hspNome);
            textoView2 = itemView.findViewById(R.id.hspDes);
            textoView3 = itemView.findViewById(R.id.hspPreco);
        }
        private void definirDado(final String produtoId, String r, String nome, String des, String preco) {
            Glide.with(itemView.getContext()).load(r).apply(new RequestOptions().placeholder(R.mipmap.home_logo_icon)).into(imagemView);
            textoView1.setText(nome);
            textoView2.setText(des);
            textoView3.setText("Rs." + preco + "/-");

            if (!textoView1.equals("")) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(itemView.getContext(), ProdutosDetalhesAcivity.class);
                        intent.putExtra("PRODUTO_ID", produtoId);
                        itemView.getContext().startActivity(intent);
                    }
                });
            }
        }
    }
}
