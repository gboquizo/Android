package com.example.guillermo.calculadoradivisasexamen;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class CalculadoraDivisas extends AppCompatActivity {

        private EditText cantidad;
        private TextView total;
        private double cantidadInicial, resultado;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calculadoradivisas);
            cantidad = (EditText)findViewById(R.id.cantidad);
            total = (TextView)findViewById(R.id.total);
            cantidad.setText("0");
        }

        public void PulsarBoton(View v){
            cantidadInicial = Double.parseDouble(cantidad.getText().toString());
            String moneda = "";
            DecimalFormat df = new DecimalFormat("#.####");
            switch (v.getId()) {
                case R.id.conversioneurodolar:
                    double conversioneurodolar = Double.parseDouble(getIntent().getStringExtra("eurodollar"));
                    resultado = cantidadInicial * conversioneurodolar;
                    moneda = "€";
                    break;
                case R.id.conversiondolareuro:
                    double conversiondolareuro = Double.parseDouble(getIntent().getStringExtra("dolareuro"));
                    resultado = cantidadInicial * conversiondolareuro;
                    moneda = "$";
                    break;
                case R.id.conversiondolarlibra:
                    double conversiondolarlibra = Double.parseDouble(getIntent().getStringExtra("dolarlibra"));
                    resultado = cantidadInicial * conversiondolarlibra;
                    moneda = "$";
                    break;
                case R.id.conversionlibradolar:
                    double conversionlibradolar = Double.parseDouble(getIntent().getStringExtra("libradolar"));
                    resultado = cantidadInicial * conversionlibradolar;
                    moneda = "£";
                    break;
                case R.id.conversiondolaryuan:
                    double conversiondolaryuan = Double.parseDouble(getIntent().getStringExtra("dolaryuan"));
                    resultado = cantidadInicial * conversiondolaryuan;
                    moneda = "$";
                    break;
                case R.id.conversionyuandolar:
                    double conversionyuandolar = Double.parseDouble(getIntent().getStringExtra("yuandolar"));
                    resultado = cantidadInicial * conversionyuandolar;
                    moneda = "¥";
                    break;

                case R.id.conversioneuroyuan:
                    double conversioneuroyuan = Double.parseDouble(getIntent().getStringExtra("euroyuan"));
                    resultado = cantidadInicial * conversioneuroyuan;
                    moneda = "€ ";
                    break;
                case R.id.conversionyuanaeuro:
                    double conversionyuaneuro = Double.parseDouble(getIntent().getStringExtra("yuaneuro"));
                    resultado = cantidadInicial * conversionyuaneuro;
                    moneda = "¥";
                    break;
                case R.id.conversionlibraeuro:
                    double conversionlibraeuro = Double.parseDouble(getIntent().getStringExtra("libraeuro"));
                    resultado = cantidadInicial * conversionlibraeuro;
                    moneda = "£";
                    break;
                case R.id.conversioneurolibra:
                    double conversioneurolibra = Double.parseDouble(getIntent().getStringExtra("eurolibra"));
                    resultado = cantidadInicial * conversioneurolibra;
                    moneda = "€";
                    break;
                case R.id.conversionlibrayuan:
                    double conversionlibrayuan = Double.parseDouble(getIntent().getStringExtra("librayuan"));
                    resultado = cantidadInicial * conversionlibrayuan;
                    moneda = "£";
                    break;
                case R.id.conversionyuanlibra:
                    double conversionyuanlibra = Double.parseDouble(getIntent().getStringExtra("yuanlibra"));
                    resultado = cantidadInicial * conversionyuanlibra;
                    moneda = "¥";
                    break;
            }
            total.setText(df.format(resultado) + " " + moneda);
        }
    }