package com.example.fullgym.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NOMBRE="gimnasio.db";
    public static final String TABLE_USUARIOS ="t_usuarios";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+ TABLE_USUARIOS +"(" +
                "id INTEGER PRIMARY KEY NOT NULL," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "telefono INT NOT NULL," +
                "password TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table "+ TABLE_USUARIOS );
        onCreate(sqLiteDatabase);
    }

    public Cursor ConsultarUsuPas(String id, String password) throws SQLException{
        Cursor mcursor=null;
        mcursor=this.getReadableDatabase().query("t_usuarios", new String[]{"id","nombre","apellido","telefono","password"},"id like '"+id+"' and password like '"+password+"'",null,null,null,null);
        return mcursor;
    }


}
