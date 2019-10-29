package com.example.hdandroid.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hdandroid.R;
import com.example.hdandroid.data.model.Schedule;

public class SaturdayFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public static SaturdayFragment newInstance(int index) {
        SaturdayFragment fragment = new SaturdayFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_saturday, container, false);

        Schedule[] myDataset = {new Schedule("Check-In", "9:00 AM - 10:45 AM", "Schiciano Atrium"),
                                new Schedule("Opening Ceremonies", "11:00 AM - 12:15 PM", "Reynolds Theatre"),
                                new Schedule("Track Talks", "12:30 PM - 1:00 PM", "Scichiano A - Education, Scichiano B - Health, Hudson 207 - Energy, Hudson 208 - Inequality, Hudson 208 - Nonprofit"),
                                new Schedule("Lunch", "1:00 PM - 2:00 PM", "CIEMAS 1st Floor"),
                                new Schedule("Hacking Commences", "2:00 PM", "-"),
                                new Schedule("Team Formation Mixer", "2:00 PM - 2:30 PM", "Schiciano Foyer"),
                                new Schedule("Workshop Session 1", "2:00 PM", "Hudson Hall, Room TBD"),
                                new Schedule("Workshop Session 2", "3:00 PM", "Hudson Hall, Room TBD"),
                                new Schedule("Puppies!!!!!!", "3:00 PM - 5:00 PM", "Harrington Quad"),
                                new Schedule("Spikeball & Frisbee", "3:00 PM - 7:00 PM", "Harrington Quad"),
                                new Schedule("Workshop Session 3", "4:00 PM", "Hudson Hall, Room TBD"),
                                new Schedule("Mixer for Female-Identifying and Non-Binary Hackers", "6:00 PM - 7:00 PM", "Innovation Co-Lab"),
                                new Schedule("Dinner", "6:30 PM - 8:00 PM", "Schiciano Foyer"),
                                new Schedule("Pie and Organizer", "7:30 PM - 8:00 PM", "CIEMAS 1st Floor"),
                                new Schedule("MLH Minigame", "8:00 PM - 9:00 PM", "CIEMAS 1st Floor"),
                                new Schedule("WIT Mixer", "9:00 PM - 10:00 PM", "Location TBA"),
                                new Schedule("Nerf War", "10:00 PM - 10:45 PM", "Twinnie's 2nd Floor"),
                                new Schedule("Spicy Noodle Challenge", "11:00 PM - 11:45 PM", "Schiciano Foyer")};


        recyclerView = (RecyclerView) root.findViewById(R.id.saturday_schedule);

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ScheduleAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);


        return root;
    }
}