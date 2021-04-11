package com.hansung.android.tablephonefragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        DetailsFragment detailsfragment = DetailsFragment.newInstance(getIntent().getIntExtra("index", -1));

        getSupportFragmentManager().beginTransaction().replace(R.id.details, detailsfragment).commit();
    }


}