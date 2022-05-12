package com.example.fullgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tviduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tviduser=findViewById(R.id.tviduser);
        String id = getIntent().getStringExtra("id");
        tviduser.setText(id);
    }
    public void onClick(View view){
        Intent miIntent=null;
        switch(view.getId()){
            case R.id.btnregistrausuariomain:
                miIntent=new Intent(MainActivity.this, RegistroUsuarios.class);
                break;
            case R.id.button2:
                miIntent=new Intent(MainActivity.this, IngresoUsuario.class);
                break;
            /*case R.id.btndieta:
                miIntent=new Intent(this,dietas.class);
                break;*/
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }
}