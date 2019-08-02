package com.jfcerquera2.encicla.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jfcerquera2.encicla.R;
import com.jfcerquera2.encicla.entitys.ElementosEstacionEntity;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ElementoAdapter extends RecyclerView.Adapter<ElementoAdapter.ElementoHolder> {

    public List<ElementosEstacionEntity> elementosEstacionEntity;
    public ElementoI elementoI;

    public ElementoAdapter(List<ElementosEstacionEntity> elementosEstacionEntity, ElementoI elementoI){
        this.elementosEstacionEntity = elementosEstacionEntity;
        this.elementoI = elementoI;
    }

    @NonNull
    @Override
    public ElementoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementos_plant, parent, false);
        return new ElementoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementoHolder holder, int position) {
        final ElementosEstacionEntity data = elementosEstacionEntity.get(position);
        Picasso.get().load(data.getPicture()).into(holder.picture);
        holder.name.setText(data.getName());
        holder.adress.setText(data.getAddress());
        holder.descripcion.setText(data.getDescription());
        holder.ubica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elementoI.onClickE(data);
            }
        });
    }

    @Override
    public int getItemCount() { return elementosEstacionEntity.size(); }

    public class ElementoHolder extends RecyclerView.ViewHolder {

        ImageView picture;
        TextView name, adress, descripcion;
        Button ubica;

        public ElementoHolder(@NonNull View itemView) {
            super(itemView);

            picture = itemView.findViewById(R.id.elemt_picture);
            name = itemView.findViewById(R.id.elemt_name);
            adress = itemView.findViewById(R.id.elemt_adress);
            descripcion = itemView.findViewById(R.id.elemt_descripcion);
            ubica = itemView.findViewById(R.id.elemt_ubica);
        }
    }

    public interface ElementoI{
        void onClickE(ElementosEstacionEntity entity);
    }
}
