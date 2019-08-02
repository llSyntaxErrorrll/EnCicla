package com.jfcerquera2.encicla;

import com.jfcerquera2.encicla.entitys.EnCiclaEntity;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MainI {

    //interfaz que va a ser implementada en el main

    @GET("/estado")
    Call<EnCiclaEntity> getAllData();
}
