package com.example.guillermo.sopadeletrasexamen;
import java.util.ArrayList;

class Game {
    private static final int NFILAS = 10;
    private static final int NCOLUMNAS = 10;
    private char[][] tablero = new char[10][10];
    private ArrayList <Capital> capitales = new ArrayList<>();

    Game() {
        cargarCapitales();
        colocarLetras();
        colocarCapitales();
    }

    private void cargarCapitales() {
        Capital capital1 = new Capital("roma");
        Capital capital2 = new Capital("paris");
        Capital capital3 = new Capital("tokyo");
        Capital capital4 = new Capital("seul");
        Capital capital5 = new Capital("pekin");
        capitales.add(capital1);

        capitales.add(capital2);

        capitales.add(capital3);

        capitales.add(capital4);

        capitales.add(capital5);

    }

    private void colocarLetras(){
        for (int i=0; i< NFILAS;i++){
            for (int j=0;j< NCOLUMNAS;j++){
                int aleatorio = (int) Math.round(Math.random()*(25));
                String arrayLetras = "abcdefghijklmnopqrstuvwxyz";
                char letrasrandom = arrayLetras.charAt(aleatorio);
                tablero [i][j]=letrasrandom;
            }
        }
    }

   private void colocarCapitales() {
       for (int i=0; i< 5 ; i++){
           capitales.get(i).setFilaInicial(0);
           capitales.get(i).setFilaFinal(0);
           capitales.get(i).setColumnaInicial(0);

           for (int j=0; j<= capitales.get(i).tamanno()-1;j++){

               tablero[i][j] = capitales.get(i).getCapital().charAt(j);
           }
           capitales.get(i).setFilaFinal(capitales.get(i).tamanno()-1);
       }
  }
    public String obtenerTablero(int fila, int columna) {
        return "" + tablero[fila][columna];
    }
}
