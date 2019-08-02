package com.jfcerquera2.encicla.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EstadoAdapter extends RecyclerView.Adapter<EstadoAdapter.EstadoHolder> {


    @NonNull
    @Override
    public EstadoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EstadoHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class EstadoHolder extends RecyclerView.ViewHolder{

        public EstadoHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
