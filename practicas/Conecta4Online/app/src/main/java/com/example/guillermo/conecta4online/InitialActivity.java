package com.example.guillermo.conecta4online;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
public class InitialActivity extends AppCompatActivity {

    private Button btnOffline;
    private Button btnOnline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("");
        setContentView(R.layout.activity_initial);

        btnOffline = (Button) findViewById(R.id.btnOffline);
        btnOnline  =  (Button) findViewById(R.id.btnOnline);

        btnOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(MainActivity);
            }
        });

        btnOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent interfazOnline = new Intent(getApplicationContext(), InterfazOnline.class);
                startActivity(interfazOnline);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menuAbout){

            Intent about = new Intent(getApplicationContext(), About.class);
            startActivity(about);

            Intent acercaDes = new Intent(getApplicationContext(), About.class);
            startActivity(acercaDes);

            return true;
        }else if (id == R.id.menuSendMessage) {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Este es mi texto a enviar.");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        }else if (id == R.id.menuSettings){
            startActivity(new Intent(this, Settings.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}