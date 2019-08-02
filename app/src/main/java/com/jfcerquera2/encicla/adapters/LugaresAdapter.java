package com.jfcerquera2.encicla.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jfcerquera2.encicla.Lugares;
import com.jfcerquera2.encicla.R;
import com.jfcerquera2.encicla.entitys.EstacionEntity;

import java.util.List;

public class LugaresAdapter extends RecyclerView.Adapter<LugaresAdapter.LugaresHolder> {

    //propiedades
    private List<EstacionEntity> entities;
    private LugaresAdapterI lugaresAdapterI;

    public LugaresAdapter(List<EstacionEntity> entities, LugaresAdapterI lugaresAdapterI){
        //setear datos y interfaz
        this.entities = entities;
        this.lugaresAdapterI = lugaresAdapterI;
    }

    @NonNull
    @Override
    public LugaresHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflar vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lugares_frg_plant, parent, false);
        return new LugaresHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LugaresHolder holder, int position) {
        final EstacionEntity data = entities.get(position);

        //setear datos
        holder.lugar_name.setText(data.getName());
        holder.lugar_desc.setText(data.getDesc());
        holder.lugar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click
                lugaresAdapterI.onClick(data);
            }
        });
    }

    @Override
    public int getItemCount() { return entities.size(); }

    public class LugaresHolder extends RecyclerView.ViewHolder{

        //declarar elemtnos
        TextView lugar_name,lugar_desc;
        Button lugar_btn;

        public LugaresHolder(@NonNull View itemView) {
            super(itemView);

            //referenciar elementos con la vista
            lugar_name = itemView.findViewById(R.id.lugar_name);
            lugar_desc = itemView.findViewById(R.id.lugar_desc);
            lugar_btn = itemView.findViewById(R.id.lugar_btn);
        }
    }

    public interface LugaresAdapterI{
        void onClick(EstacionEntity data);
    }
}
