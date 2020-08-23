package com.example.delete_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Sample sample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Sample> samples = new ArrayList<>();
        String[] arrayContent = getString(R.string.large_text).split("\\n\\n");

        for (int i = 0; i < arrayContent.length; i++) {
            sample = new Sample(arrayContent[i], String.valueOf(arrayContent[i].length()));
            samples.add(sample);
        }

        ListView listView = findViewById(R.id.listView);
        final SampleAdapter sampleAdapter = new SampleAdapter(this, samples);
        listView.setAdapter(sampleAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                sample = sampleAdapter.getItem(position);
                Toast.makeText(MainActivity.this, "№ по порядку " + (position + 1), Toast.LENGTH_LONG).show();

                return false;
            }
        });


    }
}