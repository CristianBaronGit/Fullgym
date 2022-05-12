package com.example.fullgym.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DbDietas extends DbHelper{

    Context context;

    public DbDietas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public void insertarDieta(String id_dieta,
                              String id_user,
                              String desayuno,
                              String brunch,
                              String lunch,
                              String onces,
                              String cena) {
        try{
            DbHelper admin = new DbHelper(context);
            SQLiteDatabase db = admin.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("id_dieta", id_dieta);
            valores.put("id_user",id_user);
            valores.put("fechareg",getDate());
            valores.put("desayuno",desayuno);
            valores.put("brunch",brunch);
            valores.put("lunch",lunch);
            valores.put("onces",onces);
            valores.put("cena",cena);

            db.insert(TABLE_DIETAS, null ,valores);
        }catch (Exception ex){
            ex.toString();
        }
    }
    private String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd/MM/yyyy hh:mm  a", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }


}
