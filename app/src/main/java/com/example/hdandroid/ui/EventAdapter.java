package com.example.hdandroid.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hdandroid.R;
import com.example.hdandroid.data.model.Schedule;

import org.w3c.dom.Text;

import androidx.recyclerview.widget.RecyclerView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {
    private Schedule[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTitle;
        public TextView mTime;
        public TextView mLocation;
        public MyViewHolder(LinearLayout v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.schedule_title);
            mTime = (TextView) v.findViewById(R.id.schedule_time);
            mLocation = (TextView) v.findViewById(R.id.schedule_location);
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public EventAdapter(Schedule[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public EventAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTitle.setText(mDataset[position].title);
        holder.mTime.setText(mDataset[position].time);
        holder.mLocation.setText(mDataset[position].location);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
