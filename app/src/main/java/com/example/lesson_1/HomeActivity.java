package com.example.lesson_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonHome;
    EditText editTextHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonHome = (Button) findViewById(R.id.button_home);
        buttonHome.setOnClickListener(this);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/ViaodaLibre-Regular.ttf");
        buttonHome.setTypeface(tf);
        editTextHome = (EditText) findViewById(R.id.editTextHome);
        editTextHome.setTypeface(tf);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent("action.myCanculator.show");
        intent.putExtra("name", editTextHome.getText().toString());
        startActivity(intent);
    }
}