package com.jfcerquera2.encicla;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jfcerquera2.encicla.adapters.LugaresAdapter;
import com.jfcerquera2.encicla.entitys.EstacionEntity;

import java.util.List;

public class Lugares extends Fragment {

    //varialbes
    private View view;
    private LugaresAdapter.LugaresAdapterI lugaresAdapterI;

    public Lugares(LugaresAdapter.LugaresAdapterI lugaresAdapterI){
        this.lugaresAdapterI = lugaresAdapterI;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.lugares_frg, container, false);

        //metodos
        RecyclerView recyclerView = view.findViewById(R.id.lugares_rv);

        List<EstacionEntity> estacionEntityList =  EstacionEntity.listAll(EstacionEntity.class);
        LugaresAdapter lugaresAdapter = new LugaresAdapter(estacionEntityList, lugaresAdapterI);

        //recycler
        recyclerView.setAdapter(lugaresAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

}
