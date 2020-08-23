package com.example.delete_sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class SampleAdapter extends BaseAdapter {
    private List<Sample> samples;
    private Context context;
    private LayoutInflater inflater;

    public SampleAdapter(Context context, List<Sample> samples) {
        if (samples == null) {
            this.samples = new ArrayList<>();
        } else {
            this.samples = samples;
        }
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    void removeSample(int position) {
        samples.remove(position);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return samples.size();
    }

    @Override
    public Sample getItem(int position) {
        if (position < samples.size()) {
            return samples.get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.item_list, parent, false);
        }

        Sample sampleData = samples.get(position);

        TextView title = view.findViewById(R.id.textViewTitle);
        TextView subtitle = view.findViewById(R.id.textViewSubtitle);
        Button button = view.findViewById(R.id.btn_del);
        title.setText(sampleData.getTitle());
        subtitle.setText(sampleData.getSubtitle());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeSample(position);
            }
        });



        return view;
    }
}
