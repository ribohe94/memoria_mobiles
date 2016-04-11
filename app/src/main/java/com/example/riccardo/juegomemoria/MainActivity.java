package com.example.riccardo.juegomemoria;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        setToggleImg();
    }

    //Cambio imagen de botón cuando se presiona

    public void setToggleImg() {
        final ToggleButton tglBtn = (ToggleButton) findViewById(R.id.imageButton);
        tglBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tglBtn.setBackgroundResource(R.drawable.button_play_pressed);
                } else {
                    tglBtn.setBackgroundResource(R.drawable.button_play_default);
                }
            }
        });
    }


}
