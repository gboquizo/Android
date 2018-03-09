package com.example.guillermo.conecta4online;
import android.preference.PreferenceActivity;
import android.os.Bundle;


public class Settings extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
