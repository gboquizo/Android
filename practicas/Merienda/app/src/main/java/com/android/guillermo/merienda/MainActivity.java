package com.android.guillermo.merienda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            button = (Button) findViewById(R.id.btncookie);
            textView = (TextView) findViewById(R.id.textView);
            imageView  = (ImageView)findViewById(R.id.imageView);

            button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                textView.setText("Estoy lleno...");
                imageView.setImageResource(R.drawable.after_cookie);
                button.setText("Gracias por usarme");

            }
        });

    }
}