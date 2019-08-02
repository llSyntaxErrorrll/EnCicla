package com.jfcerquera2.encicla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.jfcerquera2.encicla.adapters.ElementoAdapter;
import com.jfcerquera2.encicla.adapters.LugaresAdapter;
import com.jfcerquera2.encicla.entitys.ElementosEstacionEntity;
import com.jfcerquera2.encicla.entitys.EnCiclaEntity;
import com.jfcerquera2.encicla.entitys.EstacionEntity;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main extends AppCompatActivity implements LugaresAdapter.LugaresAdapterI, ElementoAdapter.ElementoI {

    //varaibles
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //iniciar metodos
        getAllData();
    }

    private void getAllData() {
        Long EstacionCount = EstacionEntity.count(EstacionEntity.class);
        if(EstacionCount == 0){

            Toast.makeText(this, "Consultando Registros. espere por favor", Toast.LENGTH_LONG).show();

            //solo si la tabla esta vacia los consulta
            MainI apiInterface = getClient().create(MainI.class);
            Call<EnCiclaEntity> call = apiInterface.getAllData();

            ((Call) call).enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    //Sale error del propio JSON consultado
                    //Gson gson = new Gson();
                    //gson.fromJson(displayResponse, LugaresCiclasEntity.class);

                    EnCiclaEntity enCiclaEntity = (EnCiclaEntity) response.body();
                    for (EnCiclaEntity.stations x: enCiclaEntity.stations){

                        //entidad
                        EstacionEntity estacionEntity = new EstacionEntity();
                        estacionEntity.setIdEstacion(x.id);
                        estacionEntity.setName(x.name);
                        estacionEntity.setDesc(x.desc);
                        estacionEntity.save();

                        for (EnCiclaEntity.stations.items z : x.items){

                            //elementos de cada estacion
                            ElementosEstacionEntity estacionTemp = new ElementosEstacionEntity();
                            estacionTemp.setIdElementoEstacion(z.id);
                            estacionTemp.setOrderElement(z.order);
                            estacionTemp.setName(z.name);
                            estacionTemp.setAddress(z.address);
                            estacionTemp.setDescription(z.description);
                            estacionTemp.setLat(z.lat);
                            estacionTemp.setLon(z.lon);
                            estacionTemp.setType(z.type);
                            estacionTemp.setCapacity(z.capacity);
                            estacionTemp.setBikes(z.bikes);
                            estacionTemp.setPlaces(z.places);
                            estacionTemp.setPicture(z.picture);
                            estacionTemp.setBikesState(z.bikesState);
                            estacionTemp.setPlacesState(z.placesState);
                            estacionTemp.setClosed(z.closed);
                            estacionTemp.setCdo(z.cdo);
                            estacionTemp.setIdEstacion(x.id);
                            estacionTemp.save();
                        }
                    }

                    //muestra mensaje y carga los datos
                    Toast.makeText(Main.this, "Datos guardados correctamente.", Toast.LENGTH_LONG).show();
                    loadFrg();
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    //fallo
                    Toast.makeText(Main.this, t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }else{
            //cargar datos si ya existen
            loadFrg();
        }
    }

    private void loadFrg() {
        //iniciar fragmento
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_container, new Lugares(this));
        ft.commit();
    }

    private Retrofit getClient() {
        //iniciar configuraciones
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        //iniciar el retrofit y pasar url para consumir
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.encicla.gov.co")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        //retornar
        return retrofit;
    }

    @Override
    public void onClick(EstacionEntity data) {
        //iniciar fragmento
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        Elementos elementos = new Elementos(data,this);

        ft.replace(R.id.main_container, elementos);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onClickE(ElementosEstacionEntity entity) {
        //iniciar fragmento
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        Maps maps = new Maps(entity);

        ft.replace(R.id.main_container, maps);
        ft.addToBackStack(null);
        ft.commit();
    }
}
