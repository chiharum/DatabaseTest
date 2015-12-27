package jp.com.ogchiharu.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    static final String DATABASE = "database.db";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_NAME = "database_table";

    public MySQLiteOpenHelper(Context context){
        super(context, DATABASE, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase database){
        database.execSQL("create table " + TABLE_NAME + " (_id  primary key integer autoincrement not null, textA text not null, number integer )");
    }

    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){

    }
}
