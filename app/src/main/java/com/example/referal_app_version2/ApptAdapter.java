package com.example.referal_app_version2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ApptAdapter extends ArrayAdapter {
    private int resourceId;

    public ApptAdapter(Context context, int textViewResourceId, List<Appointment> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Appointment appt = (Appointment) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        TextView apptTitle = (TextView) view.findViewById(R.id.appt_title);
        TextView apptDate = (TextView) view.findViewById(R.id.appt_date);
        apptTitle.setText(appt.getTitle());
        apptDate.setText(appt.getAppoint_date());
        return view;
    }
}
