package com.example.carlos.memoria_moviles.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.carlos.memoria_moviles.R;

public class LevelSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selector);
        OnclickDelButton(R.id.btnNivel1);
        OnclickDelButton(R.id.btnNivel2);
        OnclickDelButton(R.id.btnNivel3);
        OnclickDelButton(R.id.btnNivel4);
        OnclickDelButton(R.id.btnNivel5);
        OnclickDelButton(R.id.btnNivel6);
    }
    public void OnclickDelButton(int ref) {
        View view =findViewById(ref);
        Button miButton = (Button) view;
        miButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnNivel1:{
                        Intent intento = new Intent(getApplicationContext(), ActividadJugar.class);
                        intento.putExtra("nivel",1);
                        startActivity(intento);
                        break;
                    }
                    case R.id.btnNivel2:{
                        Intent intento = new Intent(getApplicationContext(), ActividadJugar.class);
                        intento.putExtra("nivel",2);
                        startActivity(intento);
                        break;
                    }
                    case R.id.btnNivel3:{
                        Intent intento = new Intent(getApplicationContext(), ActividadJugar.class);
                        intento.putExtra("nivel",3);
                        startActivity(intento);
                        break;
                    }
                    case R.id.btnNivel4:{
                        Intent intento = new Intent(getApplicationContext(), ActividadJugar.class);
                        intento.putExtra("nivel",4);
                        startActivity(intento);
                        break;
                    }
                    case R.id.btnNivel5:{
                        Intent intento = new Intent(getApplicationContext(), ActividadJugar.class);
                        intento.putExtra("nivel",5);
                        startActivity(intento);
                        break;
                    }
                    case R.id.btnNivel6:{
                        Intent intento = new Intent(getApplicationContext(), ActividadJugar.class);
                        intento.putExtra("nivel",6);
                        startActivity(intento);
                        break;
                    }
                    default:break; }// fin de casos
            }// fin del onclick
        });
    }// fin de OnclickDelButton
}
