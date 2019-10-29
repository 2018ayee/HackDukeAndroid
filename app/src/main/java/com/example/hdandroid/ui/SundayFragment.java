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

public class SundayFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public static SundayFragment newInstance(int index) {
        SundayFragment fragment = new SundayFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sunday, container, false);

        Schedule[] myDataset = {new Schedule("Midnight Snacks", "12:00 AM - 8:00 AM", "Twinnie's"),
                                new Schedule("Nap Time", "12:00 AM - 8:00 AM", "-"),
                                new Schedule("Breakfast", "9:00 AM - 9:45 AM", "Schiciano Foyer"),
                                new Schedule("Workshops", "10:00 AM - 12:00 PM", "Locations TBA"),
                                new Schedule("Lunch", "12:00 PM - 1:30 PM", "Schiciano Foyer"),
                                new Schedule("Duke ML Keynote: Dr. Usama Fayyad", "1:00 PM - 2:00 PM", "Gross Hall, Ahmadieh Family Auditorium"),
                                new Schedule("Hacking Ends", "1:30 PM", "-"),
                                new Schedule("Judging Begins", "2:00 PM", "-"),
                                new Schedule("First Round Judging", "2:00 PM - 2:45 PM", "CIEMAS Lobby"),
                                new Schedule("Finalist Demos", "2:45 PM - 3:30 PM", "CIEMAS Lobby"),
                                new Schedule("Judging Ends", "4:00 PM", "-"),
                                new Schedule("Closing Ceremony", "4:30 PM - 5:30 PM", "Page Auditorium"),
                                new Schedule("Busses Leave", "6:00 PM", "Science Drive")};


        recyclerView = (RecyclerView) root.findViewById(R.id.sunday_schedule);

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