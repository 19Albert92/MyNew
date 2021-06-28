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
    EditText edHome;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonHome = (Button) findViewById(R.id.button_home);
        buttonHome.setOnClickListener(this);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/ViaodaLibre-Regular.ttf");
        buttonHome.setTypeface(tf);
        edHome = (EditText) findViewById(R.id.editTextHome);
        edHome.setTypeface(tf);
        aSwitch = (Switch) findViewById(R.id.switchHome);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", edHome.getText().toString());
        startActivity(intent);
    }
}