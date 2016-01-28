package com.fossdevs.bookchat;

/**
 * Created by cyberkiller on 1/28/16.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import me.pushy.sdk.Pushy;

/**
 * Created by cyberkiller on 12/16/15.
 */
public class RegisterPushy extends AsyncTask<Context, Context, String> {
    Context ctx;
    String username;
    public RegisterPushy(String username){
        this.username=username;
    }
    public RegisterPushyInterface registerPushyInterface=null;
    @Override
    protected String doInBackground(Context... context) {
        String registration;
        ctx=context[0];
        try{
            registration= Pushy.register(context[0]);
            DbHelper dbHelper=new DbHelper(ctx);
            SQLiteDatabase db=dbHelper.getWritableDatabase();
            SQLiteStatement stmt = db.compileStatement("INSERT INTO device (device_id,username) VALUES(?,?);");
            stmt.bindString(1, registration);
            stmt.bindString(2, username);
            stmt.execute();
            String path=GlobalConfig.SERVER_URL+"/device/register?device_id="+registration+"&username="+username;
            String response;
            path=path.replace(" ","+");
            URL url = new URL(path);
            URLConnection connection=url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) connection;
            int responseCode=httpConnection.getResponseCode();
            if(responseCode==HttpURLConnection.HTTP_OK){
                InputStream in;
                in=httpConnection.getInputStream();
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                response = r.readLine();
            }else{
                response=null;
            }
        }catch(Exception e){
            Log.d("error",e.toString());
            registration=null;
        }
        return registration;
    }
    @Override
    protected void onPostExecute(String registration){
        Log.d("pussy_on_post_execute", registration);
        if(registration!=null){
            registerPushyInterface.Registered(registration);
        }
    }
}
