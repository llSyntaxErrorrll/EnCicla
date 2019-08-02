package com.jfcerquera2.encicla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jfcerquera2.encicla.entitys.LugaresCiclasEntity;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main extends AppCompatActivity {

    //varaibles
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //iniciar metodos
        referenciar();
        getAllData();
    }

    private void getAllData() {
        MainI apiInterface = getClient().create(MainI.class);
        Call<LugaresCiclasEntity> call = apiInterface.getAllData();

        ((Call) call).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                //datos puros
                String displayResponse = response.body().toString().trim();

                //por medio de gson guardarlo en la entidad
                Gson gson = new Gson();
                gson.fromJson(displayResponse, LugaresCiclasEntity.class);
                txt.setText(gson.toString());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                //fallo
                txt.setText(t.getMessage());
                Toast.makeText(Main.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void referenciar() {
        txt = findViewById(R.id.main_txt);
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
}
