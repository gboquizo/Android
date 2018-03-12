package com.example.guillermo.sopadeletrasexamen;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private String[] pulsaciones = new String[2];
    private int contador = 0;
    private int[][] ids = {
            {R.id.boton00, R.id.boton01, R.id.boton02, R.id.boton03, R.id.boton04, R.id.boton05, R.id.boton06, R.id.boton07, R.id.boton08, R.id.boton09},
            {R.id.boton10, R.id.boton11, R.id.boton12, R.id.boton13, R.id.boton14, R.id.boton15, R.id.boton16, R.id.boton17, R.id.boton18, R.id.boton19},
            {R.id.boton20, R.id.boton21, R.id.boton22, R.id.boton23, R.id.boton24, R.id.boton25, R.id.boton26, R.id.boton27, R.id.boton28, R.id.boton29},
            {R.id.boton30, R.id.boton31, R.id.boton32, R.id.boton33, R.id.boton34, R.id.boton35, R.id.boton36, R.id.boton37, R.id.boton38, R.id.boton39},
            {R.id.boton40, R.id.boton41, R.id.boton42, R.id.boton43, R.id.boton44, R.id.boton45, R.id.boton46, R.id.boton47, R.id.boton48, R.id.boton49},
            {R.id.boton50, R.id.boton51, R.id.boton52, R.id.boton53, R.id.boton54, R.id.boton55, R.id.boton56, R.id.boton57, R.id.boton58, R.id.boton59},
            {R.id.boton60, R.id.boton61, R.id.boton62, R.id.boton63, R.id.boton64, R.id.boton65, R.id.boton66, R.id.boton67, R.id.boton68, R.id.boton69},
            {R.id.boton70, R.id.boton71, R.id.boton72, R.id.boton73, R.id.boton74, R.id.boton75, R.id.boton76, R.id.boton77, R.id.boton78, R.id.boton79},
            {R.id.boton80, R.id.boton81, R.id.boton82, R.id.boton83, R.id.boton84, R.id.boton85, R.id.boton86, R.id.boton87, R.id.boton88, R.id.boton89},
            {R.id.boton90, R.id.boton91, R.id.boton92, R.id.boton93, R.id.boton94, R.id.boton95, R.id.boton96, R.id.boton97, R.id.boton98, R.id.boton99}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Game sopaletras = new Game();
        cargarLetras(sopaletras);
        pulsarFichas();
    }

    private void cargarLetras(Game sopaletras) {
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < ids[i].length; j++) {
                ImageView imgLetra = (ImageView) findViewById(ids[i][j]);
                imgLetra.setBackgroundResource(getResources().getIdentifier("" + sopaletras.obtenerTablero(i, j), "drawable", getPackageName()));
            }
        }
    }

    private void pulsarFichas(){
        for (int[] id : ids) {
            for (int anId : id) {
                ImageView imgLetra = (ImageView) findViewById(anId);
                imgLetra.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        comprobarCapital(getResources().getResourceEntryName(v.getId()));
                    }
                });
            }
        }
    }

    private void comprobarCapital(String capital){
        pulsaciones[contador] = capital;
        contador++;
        if (contador == 2){
            if(pulsaciones[0].equals("boton00") && pulsaciones[1].equals("boton03")){
                Toast.makeText(MainActivity.this, "Muy bien, has encontrado la capital roma", Toast.LENGTH_SHORT).show();
            }else if(pulsaciones[0].equals("boton10") && pulsaciones[1].equals("boton14")){
                Toast.makeText(MainActivity.this, "Muy bien, has encontrado la capital paris", Toast.LENGTH_SHORT).show();
            }else if(pulsaciones[0].equals("boton20") && pulsaciones[1].equals("boton24")){
                Toast.makeText(MainActivity.this, "Muy bien, has encontrado la capital tokyo", Toast.LENGTH_SHORT).show();
            }else if(pulsaciones[0].equals("boton30") && pulsaciones[1].equals("boton33")){
                Toast.makeText(MainActivity.this, "Muy bien, has encontrado la capital seul", Toast.LENGTH_SHORT).show();;
            }else if(pulsaciones[0].equals("boton40") && pulsaciones[1].equals("boton44")){
                Toast.makeText(MainActivity.this, "Muy bien, has encontrado la capital pekin", Toast.LENGTH_SHORT).show();
            }
            contador = 0;
        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog dialog = crearDialogSalir();
        dialog.show();
    }

    public AlertDialog crearDialogSalir() {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AppTheme));
        builder.setTitle(getString(R.string.deseasalir));
        builder.setNegativeButton(getString(R.string.cancelar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton(getString(R.string.salir), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finishAffinity();

            }
        });

        return builder.create();
    }
}