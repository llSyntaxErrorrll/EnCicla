package com.jfcerquera2.encicla;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jfcerquera2.encicla.entitys.ElementosEstacionEntity;

public class Maps extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private View view;
    private ElementosEstacionEntity entity;

    public Maps(ElementosEstacionEntity entity){
        this.entity = entity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.activity_maps, container, false);

        //referenciar etc
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //solo muestra una veterinaria
        LatLng obj = new LatLng(entity.getLat(), entity.getLon());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(obj);
        markerOptions.title(entity.getName());
        markerOptions.icon(getBitmapDescriptor(R.drawable.ic_location));

        //crea el maker
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(obj, 5));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13), 3000, null);
    }

    public BitmapDescriptor getBitmapDescriptor(int id) {
        //este metood obtiene el vector para el icon
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            VectorDrawable vectorDrawable = (VectorDrawable) getResources().getDrawable(id);

            int h = vectorDrawable.getIntrinsicHeight()+25;
            int w = vectorDrawable.getIntrinsicWidth()+25;

            vectorDrawable.setBounds(0, 0, w, h);

            Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bm);
            vectorDrawable.draw(canvas);

            return BitmapDescriptorFactory.fromBitmap(bm);
        } else {
            return BitmapDescriptorFactory.fromResource(id);
        }
    }
}
