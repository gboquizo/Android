package com.example.guillermo.conecta4online;
import android.app.FragmentTransaction;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.preference.PreferenceFragment;


public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
