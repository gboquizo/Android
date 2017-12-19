package com.example.guillermo.calculadoradivisasexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEnviar = (Button) findViewById(R.id.buttonenviar);
        final EditText txtEuroEuro = (EditText) findViewById(R.id.txtView1);
        final EditText txtEuroDolar = (EditText) findViewById(R.id.txtView2);
        final EditText txtEuroLibra = (EditText) findViewById(R.id.txtView3);
        final EditText txtEuroYuan = (EditText) findViewById(R.id.txtView4);
        final EditText txtDolarEuro = (EditText) findViewById(R.id.txtView5);
        final EditText txtDolarDolar = (EditText) findViewById(R.id.txtView6);
        final EditText txtDorarLibra = (EditText) findViewById(R.id.txtView7);
        final EditText txtDolarYuan = (EditText) findViewById(R.id.txtView8);
        final EditText txtLibraEuro = (EditText) findViewById(R.id.txtView9);
        final EditText txtLibraDolar = (EditText) findViewById(R.id.txtView10);
        final EditText txtLibraLibra = (EditText) findViewById(R.id.txtView11);
        final EditText txtLibraYuan = (EditText) findViewById(R.id.txtView12);
        final EditText txtYuanEuro = (EditText) findViewById(R.id.txtView13);
        final EditText txtYuanDolar = (EditText) findViewById(R.id.txtView14);
        final EditText txtYuanLibra = (EditText) findViewById(R.id.txtView15);
        final EditText txtYuanYuan = (EditText) findViewById(R.id.txtView16);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CalculadoraDivisas.class);

                intent.putExtra("euroeuro", txtEuroEuro.getText().toString());
                intent.putExtra("eurodollar", txtEuroDolar.getText().toString());
                intent.putExtra("eurolibra", txtEuroLibra.getText().toString());
                intent.putExtra("euroyuan", txtEuroYuan.getText().toString());
                intent.putExtra("dolareuro", txtDolarEuro.getText().toString());
                intent.putExtra("dolardolar", txtDolarDolar.getText().toString());
                intent.putExtra("dolarlibra", txtDorarLibra.getText().toString());
                intent.putExtra("dolaryuan", txtDolarYuan.getText().toString());
                intent.putExtra("libraeuro", txtLibraEuro.getText().toString());
                intent.putExtra("libradolar", txtLibraDolar.getText().toString());
                intent.putExtra("libralibra", txtLibraLibra.getText().toString());
                intent.putExtra("librayuan", txtLibraYuan.getText().toString());
                intent.putExtra("yuaneuro", txtYuanEuro.getText().toString());
                intent.putExtra("yuandolar", txtYuanDolar.getText().toString());
                intent.putExtra("yuanlibra", txtYuanLibra.getText().toString());
                intent.putExtra("yuanyuan", txtYuanYuan.getText().toString());
                startActivityForResult(intent,0);
            }
        });
    }
}
