package com.jonathan.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jonathan.customview.views.BarChart;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] data = {600,100,300};
        ((BarChart)findViewById(R.id.barchart)).setValeurs(data);


    }
}
