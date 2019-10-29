package com.example.hdandroid;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.hdandroid.data.model.Schedule;
import com.example.hdandroid.ui.EventAdapter;
import com.example.hdandroid.ui.OnItemClickListener;
import com.example.hdandroid.ui.ScheduleAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng duke;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Marker curMarker;
    Schedule[] myDataset = {new Schedule("Check-In", "9:00 AM - 10:45 AM", "Schiciano Atrium", 36.0031861, -78.9397401),
            new Schedule("Opening Ceremonies", "11:00 AM - 12:15 PM", "Reynolds Theatre", 36.0010549, -78.9410783),
            new Schedule("Track Talks", "12:30 PM - 1:00 PM", "Scichiano, Hudson"),
            new Schedule("Lunch", "1:00 PM - 2:00 PM", "CIEMAS 1st Floor", 36.003448, -78.939482),
            new Schedule("Hacking Commences", "2:00 PM", "-"),
            new Schedule("Team Formation Mixer", "2:00 PM - 2:30 PM", "Schiciano Foyer", 36.0031861, -78.9397401),
            new Schedule("Workshop Session 1", "2:00 PM", "Hudson Hall", 36.0037903, -78.9403108),
            new Schedule("Workshop Session 2", "3:00 PM", "Hudson Hall", 36.0037903, -78.9403108),
            new Schedule("Puppies!!!!!!", "3:00 PM - 5:00 PM", "Harrington Quad", 36.004548, -78.940220),
            new Schedule("Spikeball & Frisbee", "3:00 PM - 7:00 PM", "Harrington Quad", 36.004548, -78.940220),
            new Schedule("Workshop Session 3", "4:00 PM", "Hudson Hall", 36.0037903, -78.9403108),
            new Schedule("Mixer for Female-Identifying and Non-Binary Hackers", "6:00 PM - 7:00 PM", "Innovation Co-Lab", 36.0034782, -78.9387273),
            new Schedule("Dinner", "6:30 PM - 8:00 PM", "Schiciano Foyer", 36.0031861, -78.9397401),
            new Schedule("Pie and Organizer", "7:30 PM - 8:00 PM", "CIEMAS 1st Floor", 36.003448, -78.939482),
            new Schedule("MLH Minigame", "8:00 PM - 9:00 PM", "CIEMAS 1st Floor", 36.003448, -78.939482),
            new Schedule("WIT Mixer", "9:00 PM - 10:00 PM", "Location TBA"),
            new Schedule("Nerf War", "10:00 PM - 10:45 PM", "Twinnie's 2nd Floor", 36.0034683, -78.9395882),
            new Schedule("Spicy Noodle Challenge", "11:00 PM - 11:45 PM", "Schiciano Foyer", 36.0031861, -78.9397401),
            new Schedule("Midnight Snacks", "12:00 AM - 8:00 AM", "Twinnie's", 36.0034683, -78.9395882),
            new Schedule("Nap Time", "12:00 AM - 8:00 AM", "-"),
            new Schedule("Breakfast", "9:00 AM - 9:45 AM", "Schiciano Foyer", 36.0031861, -78.9397401),
            new Schedule("Workshops", "10:00 AM - 12:00 PM", "Locations TBA"),
            new Schedule("Lunch", "12:00 PM - 1:30 PM", "Schiciano Foyer", 36.0031861, -78.9397401),
            new Schedule("Duke ML Keynote: Dr. Usama Fayyad", "1:00 PM - 2:00 PM", "Gross Hall, Ahmadieh Family Auditorium", 36.0012909, -78.9469324),
            new Schedule("Hacking Ends", "1:30 PM", "-"),
            new Schedule("Judging Begins", "2:00 PM", "-"),
            new Schedule("First Round Judging", "2:00 PM - 2:45 PM", "CIEMAS Lobby", 36.003448, -78.939482),
            new Schedule("Finalist Demos", "2:45 PM - 3:30 PM", "CIEMAS Lobby", 36.003448, -78.939482),
            new Schedule("Judging Ends", "4:00 PM", "-"),
            new Schedule("Closing Ceremony", "4:30 PM - 5:30 PM", "Page Auditorium", 36.003171, -78.941788),
            new Schedule("Busses Leave", "6:00 PM", "Science Drive")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        recyclerView = (RecyclerView) this.findViewById(R.id.events_list);

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        // specify an adapter (see also next example)
        mAdapter = new EventAdapter(myDataset, new OnItemClickListener() {
            @Override
            public void onItemClick(Schedule item) {
                curMarker.setPosition(new LatLng(item.lat, item.lng));
                curMarker.setTitle(item.location);

                if(item.lat == 0.0) {
                    curMarker.setPosition(duke);
                }

                curMarker.showInfoWindow();
            }
        });
        recyclerView.setAdapter(mAdapter);
        recyclerView.setClickable(true);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Duke, North Carolina.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        duke = new LatLng(36.0014, -78.9382);
        curMarker = mMap.addMarker(new MarkerOptions().position(duke).title("Duke University"));
        curMarker.showInfoWindow();
        LatLng center = new LatLng(35.9472, -78.9382);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16.0f));
    }


}
