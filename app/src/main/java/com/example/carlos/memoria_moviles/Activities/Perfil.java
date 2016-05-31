package com.example.carlos.memoria_moviles.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.memoria_moviles.R;

public class Perfil extends AppCompatActivity {
    private ImageView picture;
    private TextView nombre;
    private TextView correo;
    private Usuario user;
    Bitmap bmp;

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
        nombre = (TextView) findViewById(R.id.txtNickName);
        correo = (TextView) findViewById(R.id.txtEmail);
        user = Usuario.getInstance();
        user.setName("Carlos");
        user.setEmail("carloshv93@gmail.com");
        if (user.getName() != null) {
            nombre.setText(user.getName());
            correo.setText(user.getEmail());
        } else {
            user.setName(nombre.getText().toString());
            user.setEmail(correo.getText().toString());
        }
    }

    public void onActivityResult(int reqCode, int resCode, Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        if (reqCode == 1) {
            //Cambiar imagen
            //He buscado pero no sirvem :S
        }
    }
    public void Mensaje(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    };
}
