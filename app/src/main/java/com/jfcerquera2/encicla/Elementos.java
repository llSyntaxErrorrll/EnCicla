package com.jfcerquera2.encicla;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jfcerquera2.encicla.adapters.ElementoAdapter;
import com.jfcerquera2.encicla.entitys.ElementosEstacionEntity;
import com.jfcerquera2.encicla.entitys.EstacionEntity;

import java.util.List;

public class Elementos extends Fragment {

    private View view;
    private EstacionEntity estacionEntity;
    private ElementoAdapter.ElementoI elementoI;

    public Elementos(EstacionEntity estacionEntity, ElementoAdapter.ElementoI elementoI) {
        // Required empty public constructor
        this.estacionEntity = estacionEntity;
        this.elementoI = elementoI;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.elementos_frg, container, false);

        //iniciar
        RecyclerView recyclerView = view.findViewById(R.id.eleme_rv);

        List<ElementosEstacionEntity> entities = ElementosEstacionEntity.find(ElementosEstacionEntity.class,
                "ID_ESTACION=?",String.valueOf(estacionEntity.getId()));

        ElementoAdapter elementoAdapter = new ElementoAdapter(entities,elementoI);

        recyclerView.setAdapter(elementoAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

}
