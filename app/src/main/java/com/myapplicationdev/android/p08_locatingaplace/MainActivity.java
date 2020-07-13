package com.myapplicationdev.android.p08_locatingaplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                UiSettings ui = map.getUiSettings();
                ui.setZoomControlsEnabled(true);

                LatLng poi_sg= new LatLng(1.436065, 103.786263);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_sg,
                        15));

                LatLng poi_NORTH = new LatLng(1.458601, 103.821918);
                Marker north = map.addMarker(new
                        MarkerOptions()
                        .position(poi_NORTH)
                        .title("HQ- North")
                        .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm\n" +
                                "Tel:65433456")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                LatLng poi_CENTRAL = new LatLng(1.304707, -256.166906);
                Marker central = map.addMarker(new
                        MarkerOptions()
                        .position(poi_CENTRAL)
                        .title("Central")
                        .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                "Operating hours: 11am-8pm\n" +
                                "Tel:67788652")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                LatLng poi_EAST = new LatLng(1.353043, -256.056301);
                Marker east = map.addMarker(new
                        MarkerOptions()
                        .position(poi_EAST)
                        .title("East")
                        .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                "Operating hours: 9am-5pm\n" +
                                "Tel:66776677\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            }
        });

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

    btn1.setOnClickListener(new View.OnClickListener() {
         @Override
            public void onClick(View v) {     if(map != null){
             LatLng poi_NORTH = new LatLng(1.458601, 103.821918);
             map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_NORTH,
                     15));
         }


             }
         });

    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LatLng poi_CENTRAL = new LatLng(1.304707, -256.166906);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_CENTRAL,
                    15));
        }
    });

    btn3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LatLng poi_EAST = new LatLng(1.353043, -256.056301);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_EAST,
                    15));
        }
    });
    }
}
