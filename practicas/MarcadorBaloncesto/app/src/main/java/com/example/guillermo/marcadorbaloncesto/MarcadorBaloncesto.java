package com.example.guillermo.marcadorbaloncesto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MarcadorBaloncesto extends AppCompatActivity implements View.OnClickListener {

    private int resultadoLocal,resultadoVisitante;
    private TextView marcadorLocal,marcadorVis,lEquipo1,lEquipo2;
    private Button boton1Local,boton2Local,boton3Local,botonAumentarLocal,botonDisminuirLocal,
                    boton1Vis,boton2Vis,boton3Vis,botonAumentarVis,botonDisminuirVis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcador_baloncesto);
        marcadorLocal = (TextView) findViewById(R.id.marcadorLocal);
        marcadorVis = (TextView) findViewById(R.id.marcadorVis);

        lEquipo1 = (TextView) findViewById(R.id.lEquipo1);
        lEquipo2 = (TextView) findViewById(R.id.lEquipo2);
        Bundle bundle = this.getIntent().getExtras();
        lEquipo1.setText(bundle.getString("LOCAL").toUpperCase());
        lEquipo2.setText(bundle.getString("VISITANTE").toUpperCase());

        boton1Local = (Button) findViewById(R.id.boton1Local);
        boton2Local = (Button) findViewById(R.id.boton2Local);
        boton3Local = (Button) findViewById(R.id.boton3Local);
        botonAumentarLocal = (Button) findViewById(R.id.aumentarButtonLocal);
        botonDisminuirLocal = (Button) findViewById(R.id.disminuirButtonLocal);
        boton1Vis = (Button) findViewById(R.id.boton1Visitante);
        boton2Vis = (Button) findViewById(R.id.boton2Visitante);
        boton3Vis = (Button) findViewById(R.id.boton3Visitante);
        botonAumentarVis = (Button) findViewById(R.id.aumentarButtonVis);
        botonDisminuirVis = (Button) findViewById(R.id.disminuirButtonVis);

        boton1Local.setOnClickListener(this);
        boton2Local.setOnClickListener(this);
        boton3Local.setOnClickListener(this);
        botonAumentarLocal.setOnClickListener(this);
        botonDisminuirLocal.setOnClickListener(this);
        boton1Vis.setOnClickListener(this);
        boton2Vis.setOnClickListener(this);
        boton3Vis.setOnClickListener(this);
        botonAumentarVis.setOnClickListener(this);
        botonDisminuirVis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        resultadoLocal = Integer.parseInt(marcadorLocal.getText().toString());
        resultadoVisitante = Integer.parseInt(marcadorVis.getText().toString());
        switch (v.getId()){
            case R.id.boton1Local:
                resultadoLocal += 1;
                break;
            case R.id.boton2Local:
                resultadoLocal += 2;
                break;
            case R.id.boton3Local:
                resultadoLocal += 3;
                break;
            case R.id.aumentarButtonLocal:
                resultadoLocal += 1;
                break;
            case R.id.disminuirButtonLocal:
                if (resultadoLocal > 0){
                    resultadoLocal -= 1;
                }
                break;
            case R.id.boton1Visitante:
                resultadoVisitante += 1;
                break;
            case R.id.boton2Visitante:
                resultadoVisitante += 2;
                break;
            case R.id.boton3Visitante:
                resultadoVisitante += 3;
                break;
            case R.id.aumentarButtonVis:
                resultadoVisitante += 1;
                break;
            case R.id.disminuirButtonVis:
                if (resultadoVisitante > 0){
                    resultadoVisitante -= 1;
                }
                break;
        }
        marcadorLocal.setText(Integer.toString(resultadoLocal));
        marcadorVis.setText(Integer.toString(resultadoVisitante));
    }
}