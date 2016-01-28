package com.fossdevs.bookchat;

/**
 * Created by cyberkiller on 1/28/16.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DbHelper extends SQLiteOpenHelper{
    public static String DB_NAME="BookChat";
    public static int DB_VERSION=1;
    public static String createSql="CREATE TABLE device (device_id TEXT,username VARCHAR(255));";
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(createSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old, int newDb) {
        // TODO Auto-generated method stub
//        if(old==1 && newDb==2){
//            db.execSQL("ALTER TABLE notices ADD COLUMN downloaded TEXT DEFAULT 'false'");
//            Log.d("database","upgraded!");
//        }
    }

}