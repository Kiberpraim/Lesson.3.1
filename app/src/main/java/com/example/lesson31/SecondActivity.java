package com.example.lesson31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvFirstName;
    TextView tvLastName;
    TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViews();
        setText();
    }

    private void findViews() {
        tvFirstName = findViewById(R.id.tv_first_name);
        tvLastName = findViewById(R.id.tv_last_name);
        tvAge = findViewById(R.id.tv_age);
    }

    private void setText() {
        tvFirstName.setText(getIntent().getStringExtra("firstName"));
        tvLastName.setText(getIntent().getStringExtra("lastName"));
        tvAge.setText(getIntent().getStringExtra("age"));
    }
}