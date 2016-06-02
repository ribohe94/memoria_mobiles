package com.example.carlos.memoria_moviles.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.memoria_moviles.R;

public class Perfil extends AppCompatActivity {
    private ImageView picture;
    private EditText nombre;
    private TextView correo;
    private Usuario user;;
    private Button camara;
    private Button galeria;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Perfil");





        picture = (ImageView) findViewById(R.id.userImage);
        nombre = (EditText) findViewById(R.id.txtNickName);
        correo = (TextView) findViewById(R.id.txtEmail);
        user = Usuario.getInstance();
        camara = (Button) findViewById(R.id.btnCámara);
        galeria = (Button) findViewById(R.id.btnSeleccionar);
        OnclickDelButton(R.id.btnCámara);
        OnclickDelButton(R.id.btnSeleccionar);
        OnchangeDelTexto(R.id.txtNickName);
        fillOrofileData();

    }

    private void OnchangeDelTexto(int ref) {
        View view =findViewById(ref);
        EditText miTexto = (EditText) view;
        miTexto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setName(nombre.getText().toString());
            }
        });
    }


    public void OnclickDelButton(int ref) {
        View view =findViewById(ref);
        Button miButton = (Button) view;
        miButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.btnCámara:
                          openCamera();
                        break;

                    case R.id.btnSeleccionar:
                        openGallery();
                        break;

                    default:
                        break;
                }// fin de casos
            }// fin del onclick
        });
    }// fin de OnclickDelButton
    private void fillOrofileData() {
        if (user.getName() != null) {
            nombre.setText(user.getName());
            correo.setText(user.getEmail());
            picture.setImageBitmap(user.getProfilePicture());
        } else {
            user.setName("Invitado");
            user.setEmail("N/A");
            nombre.setText(user.getName());
            correo.setText(user.getEmail());
        }
    }

    private void openCamera() {
        Intent camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera,2);
    }

    private void openGallery() {
        Intent gallery=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,1);
    }
    public void onActivityResult(int reqCode, int resCode, Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        if(resCode ==RESULT_OK){
            switch(reqCode){
                case 1:{
                    picture.setDrawingCacheEnabled(true);
                    picture.buildDrawingCache(true);
                    picture.setImageURI(data.getData());
                    Bitmap bp=Bitmap.createBitmap(picture.getDrawingCache());
                    user.setProfilePicture(bp);

                    break;
                }
                case 2:{
                    Bitmap bp = (Bitmap) data.getExtras().get("data");
                    picture.setImageBitmap(bp);
                    user.setProfilePicture(bp);
                    break;
                }
                default:{
                    Mensaje("Volver a intentar");
                }
            }

        }
    }
    public void Mensaje(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    };
}
