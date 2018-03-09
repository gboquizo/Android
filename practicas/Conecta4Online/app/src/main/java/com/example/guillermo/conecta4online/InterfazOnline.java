package com.example.guillermo.conecta4online;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class InterfazOnline extends AppCompatActivity {

    private ArrayList<String> partida;
    private ListView partidas;
    RequestQueue queue;
    private String urlServidor = "http://192.168.115.55";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfazonline);
        setTitle("Lista partidas");
        queue = VolleySingleton.getInstance(this).getRequestQueue();
        Button creaJuego = (Button) findViewById(R.id.creaJuego);
        partidas = (ListView) findViewById(R.id.partidas);

        crearPartida(creaJuego);

        mostrarPartidas();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mostrarPartidas();
                    }
                });
            }
        }, 3000, 5000);
    }

    private void crearPartida(Button creaJuego) {
        creaJuego.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View view){
        String url = urlServidor + "/start.php";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    String idPartida = "";
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    InputSource is = new InputSource();
                    is.setCharacterStream(new StringReader(response));
                    Document doc = db.parse(is);
                    NodeList nodes = doc.getElementsByTagName("game");
                    for (int i = 0; i < nodes.getLength(); i++) {
                        Element element = (Element) nodes.item(i);
                        idPartida = element.getAttribute("id");
                    }
                    Intent creacion = new Intent(InterfazOnline.this, MainActivity.class);
                    Bundle b = new Bundle();
                    b.putString("ID", idPartida);
                    b.putString("COLOR", "1");
                    b.putString("Estado", "J");
                    creacion.putExtras(b);
                    startActivity(creacion);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Context context = getApplicationContext();
                CharSequence text = "Conexión correcta";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Context context = getApplicationContext();
                CharSequence text = "Error en la conexión!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        queue.add(request);
    }
    });
}


    private void mostrarPartidas() {

        partida = new ArrayList<String>();
        String url = urlServidor + "/games.php";
        StringRequest request = new StringRequest( url, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                try {
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    InputSource is = new InputSource();
                    is.setCharacterStream(new StringReader(response));
                    Document doc = db.parse(is);
                    NodeList nodes = doc.getElementsByTagName("game");
                    for (int i = 0; i < nodes.getLength(); i++){
                        Element element = (Element) nodes.item(i);

                        partida.add("Partida" + element.getAttribute("id" + "\n"));

                    }
                    ArrayAdapter myAdapter = new ArrayAdapter(getApplicationContext(),R.layout.items,R.id.items, partida);
                    partidas.setAdapter(myAdapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Context context = getApplicationContext();
                CharSequence text = "Error en la conexión!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        queue.add(request);
    }
}