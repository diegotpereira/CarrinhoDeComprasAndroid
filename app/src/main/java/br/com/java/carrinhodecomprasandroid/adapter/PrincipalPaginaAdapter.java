package br.com.java.carrinhodecomprasandroid.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PrincipalPaginaAdapter extends RecyclerView.Adapter {

    public static final int BANNER_SLIDER = 0;

    private int ultimaPosicao = -1;
    private RecyclerView.RecycledViewPool recycledViewPool;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
