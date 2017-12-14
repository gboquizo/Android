package com.example.guillermo.practicaeventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView vText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vText = (TextView) findViewById(R.id.textView);
    }

    public void botonClick(View view) {
        vText.setText("Botón presionado");
    }
}
