package com.example.guillermo.conecta4online;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    Game partida;
    String urlServidor = "http://192.168.115.55";
    String idPartidaOnline;
    int turnoOnline;

    private RequestQueue queue;
    private int[][] arrayTablero = {
            {R.id.boton00, R.id.boton01, R.id.boton02, R.id.boton03, R.id.boton04, R.id.boton05, R.id.boton06},
            {R.id.boton10, R.id.boton11, R.id.boton12, R.id.boton13, R.id.boton14, R.id.boton15, R.id.boton16},
            {R.id.boton20, R.id.boton21, R.id.boton22, R.id.boton23, R.id.boton24, R.id.boton25, R.id.boton26},
            {R.id.boton30, R.id.boton31, R.id.boton32, R.id.boton33, R.id.boton34, R.id.boton35, R.id.boton36},
            {R.id.boton40, R.id.boton41, R.id.boton42, R.id.boton43, R.id.boton44, R.id.boton45, R.id.boton46},
            {R.id.boton50, R.id.boton51, R.id.boton52, R.id.boton53, R.id.boton54, R.id.boton55, R.id.boton56}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = VolleySingleton.getInstance(this).getRequestQueue();
        Intent intent = getIntent();
        if(!intent.hasExtra("ID")){
            int turno = Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("jugadorEmpieza","1"));
            partida = new Game(turno);

            if (partida.getTurno() == Game.MAQUINA && !partida.estado.equals("Terminado")) {
                int col = partida.maquinaRespondeMovimientoA((int) Math.round(Math.random()*(6 - 0)));
                jugar(col);
            }

        }else {
            partida = new Game(getTurnoOnline());
            setIdPartidaOnline(getIntent().getStringExtra("ID"));
        }

        setTitle("Conecta 4");
    }

    public int getTurnoOnline() {
        return turnoOnline;
    }

    public void setTurnoOnline(int turnoOnline) {
        this.turnoOnline = turnoOnline;
    }

    public void actualizarTurnoOnline() {

        String url = urlServidor + "/updateTurno.php?id="+ getIdPartidaOnline() + "&turno=" + ((getTurnoOnline() == 1)?2:1);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Context context = getApplicationContext();
                CharSequence text = "No se puede conectar con el servidor.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        queue.add(request);
    }

    public void obtenerTurnoOnline(){
        String url = urlServidor + "/getTurno.php?id="+ getIdPartidaOnline();
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    InputSource is = new InputSource();
                    is.setCharacterStream(new StringReader(response));
                    Document doc = db.parse(is);
                    NodeList nodes = doc.getElementsByTagName("game");

                    for (int i = 0; i < nodes.getLength(); i++) {
                        Element element = (Element) nodes.item(i);
                        setTurnoOnline(Integer.parseInt(element.getAttribute("turno")));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Context context = getApplicationContext();
                CharSequence text = "Error en la conexión.";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        queue.add(request);
    }

    public String getIdPartidaOnline() {
        return idPartidaOnline;
    }

    public void setIdPartidaOnline(String idPartidaOnline) {
        this.idPartidaOnline = idPartidaOnline;
    }

    @Override
    public void onResume() {
        if(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("musica",true))
            Musica.play(MainActivity.this,R.raw.cancion);
        super.onResume();
    }

    @Override
    public void onPause() {
        if(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("musica",true))
            Musica.stop();
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAbout:
                startActivity(new Intent(this, About.class));
                return true;
            case R.id.menuSendMessage:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "CONECTA 4");
                intent.putExtra(Intent.EXTRA_TEXT, "Nueva aplicación Android");
                startActivity(intent);
                return true;
            case R.id.menuSettings:
                startActivity(new Intent(this, Settings.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog dialog = crearDialogSalir();
        dialog.show();
    }

    public AlertDialog crearDialogSalir() {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AppTheme));
        builder.setTitle("¿Desea volver al menú principal?");
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });

        return builder.create();
    }

    void pintarFicha(int fila, int columna, int turno) {
        ImageView fichaPulsada = (ImageView) findViewById(arrayTablero[fila][columna]);
        Intent intent = getIntent();
        if (intent.hasExtra("ID")){
            if (getTurnoOnline() == 1){
                fichaPulsada.setImageResource(R.drawable.ficha1);
            }else if(getTurnoOnline() == 2) {
                fichaPulsada.setImageResource(R.drawable.ficha2);
            }
        }else {
            if (turno == Game.JUGADOR){
                fichaPulsada.setImageResource(R.drawable.ficha1);
            }else if(turno == Game.MAQUINA) {
                fichaPulsada.setImageResource(R.drawable.ficha2);
            }
        }
    }

    public void pulsarFicha(View v) {
        Intent intent = getIntent();

        if (intent.hasExtra("ID")) {

            obtenerTurnoOnline();
            actualizarTurnoOnline();
            Context context = getApplicationContext();
            CharSequence text = "El turno cambió " + " a " + getTurnoOnline();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            for (int i = 0; i < arrayTablero.length; i++) {
                for (int j = 0; j < arrayTablero[i].length; j++) {
                    if (v.getId() == arrayTablero[i][j]) {
                        if (partida.estado != "Terminado")
                            jugar(j);
                        else
                           mostrarGanador();
                    }
                    if (partida.getTurno() == Game.MAQUINA && !partida.estado.equals("Terminado")) {
                        int col = partida.maquinaRespondeMovimientoA(j);
                        jugar(col);
                    }
                }
            }
        }
    }

    public void jugar(int j) {
        for (int i = 0; i < arrayTablero.length; i++) {
            if ((i == (arrayTablero.length - 1) || !partida.isVacio(i + 1, j)) && partida.isVacio(i, j)) {
                if (partida.estado == "Jugando") {
                    partida.setFicha(i, j);
                    pintarFicha(i, j, partida.getTurno());
                }
                if (partida.comprobarPartida(i, j)) {
                    mostrarGanador();
                    partida.estado = "Terminado";
                }
                partida.cambiarTurno();
            } else if (partida.estado == "Terminado") {
                mostrarGanador();
            }
        }
    }
    private void mostrarGanador() {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AppTheme));
        if(partida.ganador == "Jugador") {
            builder.setMessage(R.string.mensajeGanadorJugador);

        }else if(partida.ganador =="Maquina"){
            builder.setMessage(R.string.mensajeGanadorMaquina);

        }
        else if (partida.ganador == "Empate"){
            builder.setMessage(R.string.mensajeEmpate);
        }
        builder.setTitle(R.string.mensajeTitulo);
        builder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        builder.setNegativeButton(R.string.salir, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onBackPressed();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}