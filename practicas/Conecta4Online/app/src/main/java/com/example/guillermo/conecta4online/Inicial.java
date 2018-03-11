package com.example.guillermo.conecta4online;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Inicial extends AppCompatActivity implements OnClickListener {
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial);
        ImageView img = (ImageView) findViewById(R.id.initial_img);
        img.setOnClickListener(this);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.initial);
        img.startAnimation(animation);

        View initial = (View) findViewById(R.id.initial);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.initial2);
        initial.startAnimation(animation2);

    }

    public void onClick(View v) {
        Intent InitialActivity = new Intent(getApplicationContext(), InitialActivity.class);
        startActivity(InitialActivity);
    }

    public void Salida() {
        finishAffinity();
     }
}

