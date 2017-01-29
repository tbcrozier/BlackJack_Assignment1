package com.davidroach.blackjack_assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Disable title bar */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_about);
    }
}
