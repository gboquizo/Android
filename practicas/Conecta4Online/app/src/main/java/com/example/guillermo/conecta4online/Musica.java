package com.example.guillermo.conecta4online;

import android.app.Activity;
import android.media.MediaPlayer;

class Musica {
    private static MediaPlayer player;

    public static void play(Activity activity, int musicimotion) {
        player = MediaPlayer.create(activity,R.raw.cancion);
        player.start();
        player.setLooping(true);
    }

    public static void stop() {
        if(player != null){
            player.stop();
            player.release();
            player = null;
        }
    }
}