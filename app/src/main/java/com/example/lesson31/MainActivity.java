package com.example.lesson31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edFirstName;
    EditText edLastName;
    EditText edAge;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setClick();
    }

    private void findViews() {
        edFirstName = findViewById(R.id.edit_first_name);
        edLastName = findViewById(R.id.edit_last_name);
        edAge = findViewById(R.id.edit_age);
        button = findViewById(R.id.btn_next);
    }

    private void setClick() {
        button.setOnClickListener(v ->{
        if (!edFirstName.getText().toString().isEmpty() && !edLastName.getText().toString().isEmpty() && !edAge.getText().toString().isEmpty()){
            navigateToSecond();
        }else {
        Toast.makeText(MainActivity.this,"Заполните поле: " + WhichIsEmpty(),Toast.LENGTH_LONG).show();
        }
        }
        );
    }

    private String WhichIsEmpty() {
        String string = "";
        if(edFirstName.getText().toString().isEmpty()){
            string = string + "Имя";
        }
        if (edLastName.getText().toString().isEmpty()) {
            string = string + ", Фамилия";
        }
        if (edAge.getText().toString().isEmpty()) {
            string = string + ", Возраст.";
        }
        return string;
    }

    private void navigateToSecond() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("firstName", edFirstName.getText().toString());
        intent.putExtra("lastName", edLastName.getText().toString());
        intent.putExtra("age", edAge.getText().toString());
        startActivity(intent);
    }
}