package com.example.guillermo.practicaeventos2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView vText =(TextView)findViewById (R.id.textView);
                vText.setText("Botón corto pulsado");
            }
        });
        button.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TextView vText =(TextView)findViewById (R.id.textView);
                vText.setText("Botón largo pulsado");
                return false;
            }
        });
    }
}
