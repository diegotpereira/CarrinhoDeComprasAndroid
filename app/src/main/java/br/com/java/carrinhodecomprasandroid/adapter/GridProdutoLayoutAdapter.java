package br.com.java.carrinhodecomprasandroid.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import br.com.java.carrinhodecomprasandroid.R;
import br.com.java.carrinhodecomprasandroid.activity.ProdutoDetalhesActivity;
import br.com.java.carrinhodecomprasandroid.model.HorizontalProdutoScrollModelo;

public class GridProdutoLayoutAdapter extends BaseAdapter {

    List<HorizontalProdutoScrollModelo> modelos;

    public GridProdutoLayoutAdapter(List<HorizontalProdutoScrollModelo> modelos) {
        this.modelos = modelos;
    }

    @Override
    public int getCount() {
        return modelos.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View ver1 ;
        if (view == null) {
            ver1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_item_layout, null);
            ver1.setElevation(0);
            ver1.setBackgroundColor(Color.parseColor("#ffffff"));

            ver1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent iniciarProdutoDetalhesIntent = new Intent(viewGroup.getContext(), ProdutoDetalhesActivity.class);
                    iniciarProdutoDetalhesIntent.putExtra("PRODUTO_ID", modelos.get(i).getProdutoId());
                    viewGroup.getContext().startActivity(iniciarProdutoDetalhesIntent);
                }
            });
            ImageView imageView = ver1.findViewById(R.id.hspImagem);
            TextView textNome = ver1.findViewById(R.id.hspNome);
            TextView textDesc = ver1.findViewById(R.id.hspDes);
            TextView textPreco = ver1.findViewById(R.id.hspPreco);

            Glide.with(viewGroup.getContext()).load(modelos.get(i).getProdutoImagem())
                    .apply(new RequestOptions().placeholder(R.mipmap.home_logo_icon)).into(imageView);
            textNome.setText(modelos.get(i).getProdutoNome());
            textDesc.setText(modelos.get(i).getProdutoDes());
            textPreco.setText(modelos.get(i).getProdutoPreco());
        } else {
            ver1 = view;
        }
        return ver1;
    }
}
