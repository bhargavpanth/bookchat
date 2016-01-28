package com.fossdevs.bookchat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.pushy.sdk.Pushy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Pushy.listen(this);
        DbHelper dbHelper=new DbHelper(getApplicationContext());
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM device",null);
        if(c.getCount()==0){
            Intent intent=new Intent(getApplicationContext(),SignUp.class);
            startActivity(intent);
        }else{
            setContentView(R.layout.activity_main);
        }
    }
}
