package com.example.carlos.memoria_moviles.Activities;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.example.carlos.memoria_moviles.R;

public class ActividadJugar extends AppCompatActivity {
    private int cardId=0;
    AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        int nivel=bundle.getInt("nivel");
        switch(nivel){
            case 1:{
                crearNivel(2,2);
                startChronometer();
                //animacion
                break;
            }
            case 2:{
                crearNivel(3,3);
                startChronometer();
                break;
            }
            case 3:{
                crearNivel(4,4);
                startChronometer();
                break;
            }
            case 4:{
                crearNivel(5,5);
                startChronometer();
                break;
            }
            case 5:{
                crearNivel(6,6);
                startChronometer();
                break;
            }
            case 6:{
                crearNivel(7,7);
                startChronometer();
                break;
            }
            default:{
                Mensaje("Error al seleccionar nivel");
                break;
            }
        }

        //configurarClickListeners();

    }
    public void startChronometer() {
        ((Chronometer) findViewById(R.id.cronometro)).start();
    }

    public void stopChronometer() {
        ((Chronometer) findViewById(R.id.cronometro)).stop();
    }

    private void crearNivel(int TableRows, int TableCols) {
        TableLayout table=(TableLayout) findViewById(R.id.ButtonTable);
        for(int row=0;row<TableRows;row++){
            TableRow newRow=new TableRow(this);
            table.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(newRow);
            for(int col=0;col<TableCols;col++){
                Button newButton=new Button(this);
                newButton.setLayoutParams(new TableRow.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.MATCH_PARENT,
                        1.0f));
                configurarCarta(newButton);
                newRow.addView(newButton);

            }
        }
    }

    private void configurarCarta(final Button newButton) {
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    public void Mensaje(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    };
}


//
//    public void ajustarImagen() {
//        TableLayout tl = (TableLayout) findViewById(R.id.ButtonTable);
//    }
//
//    public void configurarClickListeners() {
//        final ImageView btn01 = (ImageView) findViewById(R.id.imageButton01);
//        btn01.setBackgroundResource(R.drawable.animation);
//        final ImageView btn02 = (ImageView) findViewById(R.id.imageButton02);
//        btn02.setBackgroundResource(R.drawable.animation);
//        final ImageView btn03 = (ImageView) findViewById(R.id.imageButton03);
//        btn03.setBackgroundResource(R.drawable.animation);
//        final ImageView btn04 = (ImageView) findViewById(R.id.imageButton04);
//        btn04.setBackgroundResource(R.drawable.animation);
//        final ImageView btn05 = (ImageView) findViewById(R.id.imageButton05);
//        btn05.setBackgroundResource(R.drawable.animation);
//        final ImageView btn06 = (ImageView) findViewById(R.id.imageButton06);
//        btn06.setBackgroundResource(R.drawable.animation);
//        final ImageView btn07 = (ImageView) findViewById(R.id.imageButton07);
//        btn07.setBackgroundResource(R.drawable.animation);
//        final ImageView btn08 = (ImageView) findViewById(R.id.imageButton08);
//        btn08.setBackgroundResource(R.drawable.animation);
//        final ImageView btn09 = (ImageView) findViewById(R.id.imageButton09);
//        btn09.setBackgroundResource(R.drawable.animation);
//        final ImageView btn10 = (ImageView) findViewById(R.id.imageButton10);
//        btn10.setBackgroundResource(R.drawable.animation);
//        final ImageView btn11 = (ImageView) findViewById(R.id.imageButton11);
//        btn11.setBackgroundResource(R.drawable.animation);
//        final ImageView btn12 = (ImageView) findViewById(R.id.imageButton12);
//        btn12.setBackgroundResource(R.drawable.animation);
//        final ImageView btn13 = (ImageView) findViewById(R.id.imageButton13);
//        btn13.setBackgroundResource(R.drawable.animation);
//        final ImageView btn14 = (ImageView) findViewById(R.id.imageButton14);
//        btn14.setBackgroundResource(R.drawable.animation);
//        final ImageView btn15 = (ImageView) findViewById(R.id.imageButton15);
//        btn15.setBackgroundResource(R.drawable.animation);
//        final ImageView btn16 = (ImageView) findViewById(R.id.imageButton16);
//        btn16.setBackgroundResource(R.drawable.animation);
//    }
//        btn01.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn01.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn01.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn02.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn02.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn02.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn03.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn03.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn03.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn04.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn04.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn04.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn05.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn05.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn05.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn06.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn06.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn06.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn07.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn07.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn07.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn08.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn08.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn08.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn09.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn09.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn09.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn10.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn10.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn11.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn11.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn11.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn12.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn12.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn12.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn13.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn13.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn13.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn14.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn14.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn14.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn15.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn15.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn15.setBackground(cadh);
//                cadh.start();
//            }
//        });
//        btn16.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*Nota: Necesita API 21 como minimo*/
//                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
//                    @Override
//                    public void onAnimationFinish() {
//                        btn16.setBackgroundResource(R.drawable.card_10_of_clubs);
//                    }
//                };
//                /*Nota: Necesita API 16 como minimo*/
//                btn16.setBackground(cadh);
//                cadh.start();
//            }
//        });
//
//
//    }


