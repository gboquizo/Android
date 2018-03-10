package com.example.guillermo.conecta4online;
import android.preference.PreferenceActivity;
import android.os.Bundle;


public class Settings extends PreferenceActivity {

    public final static String PLAY_MUSIC = "music";
    public final static boolean PLAY_MUSIC_DEFAULT = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment()).commit();

    }
}