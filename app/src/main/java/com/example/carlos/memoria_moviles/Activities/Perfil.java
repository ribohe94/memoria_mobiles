package com.example.carlos.memoria_moviles.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.carlos.memoria_moviles.R;

public class Perfil extends AppCompatActivity {
    ImageView picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        picture = (ImageView) findViewById(R.id.userImage);
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Seleccione una foto de perfil"), 1);
            }
        });
    }

    public void onActivityResult(int reqCode,int resCode, Intent data){
        if(resCode==RESULT_OK){
            if(reqCode==1){
                picture.setImageURI(data.getData());
            }

        }

    }
}
