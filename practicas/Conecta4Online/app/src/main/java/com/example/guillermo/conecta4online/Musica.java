package com.example.guillermo.conecta4online;

import android.app.Activity;
import android.media.MediaPlayer;

public class Musica {
    private static MediaPlayer player;

    public static  void play (Activity activity, int id) {
        player = MediaPlayer.create(activity, R.raw.cancion);
        player.setLooping(true);
        player.start();
    }

    public static void stop() {
        if(player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }
}