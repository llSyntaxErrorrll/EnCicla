package com.jfcerquera2.encicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //poner pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //asociar vista
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        //iniciar asplash
        Splash splash = new Splash();
        splash.execute();
    }

    public class Splash extends AsyncTask{
        @Override
        protected Object doInBackground(Object[] objects) {

            //inicia el splash simple en tarea asincronica
            try{
                Thread.sleep(2000);
                startActivity(new Intent(SplashScreen.this, Main.class));
                finish();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
}
