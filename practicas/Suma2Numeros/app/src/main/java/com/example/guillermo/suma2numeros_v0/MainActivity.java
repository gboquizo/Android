package com.example.guillermo.suma2numeros_v0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.guillermo.suma2numeros_v0.R.id.textView3;

public class MainActivity extends AppCompatActivity {

    EditText numero1,numero2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = (EditText)findViewById(R.id.editText);
        numero2 = (EditText)findViewById(R.id.editText1);
        final TextView tvTotalSuma = (TextView)findViewById(R.id.textView3);

        Button btnSuma = (Button) findViewById(R.id.btnSuma);
        btnSuma.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intNumero1 = Integer.valueOf(numero1.getText().toString());
                int intNumero2 = Integer.valueOf(numero2.getText().toString());
                int totalSuma = intNumero1 + intNumero2;
                tvTotalSuma.setText("" + totalSuma);
            }
        });
    }
}
