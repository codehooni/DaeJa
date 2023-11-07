package com.app.daeja.ui.starting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.daeja.ui.starting.ui.main.StartingFragment;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, StartingFragment.newInstance())
                    .commitNow();
        }
    }
}