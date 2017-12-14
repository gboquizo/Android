package com.example.guillermo.marcadorbaloncesto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtLocal;
    private EditText txtVisitante;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLocal = (EditText) findViewById(R.id.txtNombreLocal);
        txtVisitante = (EditText) findViewById(R.id.txtNombreVisitante);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MarcadorBaloncesto.class);
                Bundle b = new Bundle();
                b.putString("LOCAL", txtLocal.getText().toString());
                b.putString("VISITANTE", txtVisitante.getText().toString());

                intent.putExtras(b);
                startActivity(intent);

            }
        });

        //protected void onResume(){
        //  super.onResume();
        //Musica.play(this,R.raw.cancion);
        //}

        //protected void onPause(){
        //  super.onPause();
        // Musica.stop(this);
    }
}
