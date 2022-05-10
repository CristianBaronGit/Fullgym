package com.example.fullgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fullgym.db.DbHelper;
import com.example.fullgym.db.DbUsuarios;

public class IngresoUsuario extends AppCompatActivity {

    private EditText userlogin, passwordlogin;
    private Button btningresaruser, btnregistraruser;
    DbUsuarios dbUsuarios = new DbUsuarios(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_usuario);

        userlogin = (EditText) findViewById(R.id.etiduseringreso);
        passwordlogin = findViewById(R.id.etpasswordingreso);
        btnregistraruser=findViewById(R.id.btnregistroingreso);
        btnregistraruser.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i= new Intent(getApplicationContext(),RegistroUsuarios.class);
                startActivity(i);
            }
        });

        btningresaruser=findViewById(R.id.btningresoingreso);
        btningresaruser.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try{

                Cursor cursor=dbUsuarios.ConsultarUsuPas(userlogin.getText().toString(),passwordlogin.getText().toString());
                    if(cursor.getCount()>0){
                        Intent i= new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(),"Usuario o COntraseña incorrectos",
                            Toast.LENGTH_LONG).show();
                    }
                    userlogin.setText("");
                    passwordlogin.setText("");
                    userlogin.findFocus();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    }
