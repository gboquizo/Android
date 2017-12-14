package com.android.guillermo.practica_cafe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Clase que controla la petici\u00f3n de caf\u00e9s
 *
 *@author Guillermo Boquizo S\u00e1nchez
 *@version 1.0
 */
public class PedirCafe extends AppCompatActivity {

    private TextView nombre;
    private TextView cantCafe;
    private CheckBox crema;
    private CheckBox chocolate;
    private Button btnMas;
    private Button btnMenos;
    private Button btnPedir;
    private int numCafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (TextView) findViewById(R.id.nombre);
        crema = (CheckBox) findViewById(R.id.boxCrema);
        chocolate = (CheckBox) findViewById(R.id.boxChoco);
        cantCafe = (TextView) findViewById(R.id.cantCafe);
        btnMas = (Button) findViewById(R.id.btnMas);
        btnMenos = (Button) findViewById(R.id.btnMenos);
        btnPedir = (Button) findViewById(R.id.btnPedir);

        btnMas.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                agregarCafe();
            }
        });

        btnMenos.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                restarCafe();
            }
        });

        btnPedir.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                double precio = 1.20;
                precio *= numCafe;

                if (crema.isChecked() && numCafe > 0) {
                    precio += 0.5;
                }
                if (chocolate.isChecked() && numCafe > 0) {
                    precio += 0.5;
                }
                Context context = getApplicationContext();
                 String mensaje = "\tNombre: " + nombre.getText().toString()
                         + "\n" + "\t¿Añadir crema?: " + getEstado(crema) + "\n"
                         + "\t¿Añadir chocolate?: " + getEstado(chocolate) + "\n"
                         + "\tCantidad: " + numCafe + "\n"
                         + "\tPrecio: " + precio + " €\n"
                         + "\t¡¡Muchas gracias por su pedido!!";
                int lenght = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, mensaje, lenght);
                toast.show();
            }
        });
    }
    /**
     * Comprueba si se ha seleccionado chocolate, y muestra un mensaje
     * @return mensaje que devuelve el estado de la selecci\u00f3n
     */
    private String getEstado(CheckBox comprobador){
        String msj = "";
        msj += (comprobador.isChecked() ? "Sí." : "No.") ;
        return msj;
    }
    /**
     * Agrega caf\u00e9 a la cantidad actual
     */
    private void agregarCafe() {
        numCafe = Integer.valueOf(this.cantCafe.getText().toString());
        if(numCafe == 999) {
            return;
        }
        numCafe++;

        this.cantCafe.setText(String.valueOf(numCafe));
    }
    /**
     * Resta caf\u00e9 a la cantidad actual
     */
    private void restarCafe() {
        numCafe = Integer.valueOf(this.cantCafe.getText().toString());
        if(numCafe == 0) {
            return;
        }
        numCafe--;

        this.cantCafe.setText(String.valueOf(numCafe));
    }
}

