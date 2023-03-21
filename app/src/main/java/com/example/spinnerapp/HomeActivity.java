package com.example.spinnerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends Activity {
    TextView t1, t2;
    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.homelayout);
        t1=findViewById(R.id.userIdDisplay);
        t2=findViewById(R.id.passwordDisplay);
        Intent i = getIntent();
        String s1 = i.getStringExtra("userid");
        String s2 = i.getStringExtra("passwd");
        t1.setText(s1);
        t2.setText(s2);
    }
}
