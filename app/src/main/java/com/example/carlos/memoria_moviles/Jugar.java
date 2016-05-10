package com.example.carlos.memoria_moviles;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;

public class Jugar extends AppCompatActivity {

    AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        configurarClickListeners();

    }

    public void ajustarImagen() {
        TableLayout tl = (TableLayout) findViewById(R.id.tableLayout01);
    }

    public void configurarClickListeners() {
        final ImageButton btn01 = (ImageButton) findViewById(R.id.imageButton01);
        final ImageButton btn02 = (ImageButton) findViewById(R.id.imageButton02);
        final ImageButton btn03 = (ImageButton) findViewById(R.id.imageButton03);
        final ImageButton btn04 = (ImageButton) findViewById(R.id.imageButton04);
        final ImageButton btn05 = (ImageButton) findViewById(R.id.imageButton05);
        final ImageButton btn06 = (ImageButton) findViewById(R.id.imageButton06);
        final ImageButton btn07 = (ImageButton) findViewById(R.id.imageButton07);
        final ImageButton btn08 = (ImageButton) findViewById(R.id.imageButton08);
        final ImageButton btn09 = (ImageButton) findViewById(R.id.imageButton09);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn01.setBackgroundResource(R.drawable.animation);
                animation =  (AnimationDrawable) btn01.getBackground();
                animation.start();
            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn01.setBackgroundResource(R.drawable.animation);
                animation =  (AnimationDrawable) btn01.getBackground();
                animation.start();
            }
        });
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn01.setBackgroundResource(R.drawable.animation);
                animation =  (AnimationDrawable) btn01.getBackground();
                animation.start();
            }
        });
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn01.setBackgroundResource(R.drawable.animation);
                animation =  (AnimationDrawable) btn01.getBackground();
                animation.start();
            }
        });
        btn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn01.setBackgroundResource(R.drawable.animation);
                animation =  (AnimationDrawable) btn01.getBackground();
                animation.start();
            }
        });
        btn06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn01.setBackgroundResource(R.drawable.animation);
                animation =  (AnimationDrawable) btn01.getBackground();
                animation.start();
            }
        });
        btn07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn01.setBackgroundResource(R.drawable.animation);
                animation =  (AnimationDrawable) btn01.getBackground();
                animation.start();
            }
        });
        btn08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn01.setBackgroundResource(R.drawable.animation);
                animation =  (AnimationDrawable) btn01.getBackground();
                animation.start();
            }
        });
        btn09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn01.setBackgroundResource(R.drawable.animation);
                animation =  (AnimationDrawable) btn01.getBackground();
                animation.start();
            }
        });


    }

}
