package com.fossdevs.bookchat;

/**
 * Created by cyberkiller on 1/28/16.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by cyberkiller on 12/16/15.
 */
public class PushReceiver extends BroadcastReceiver {
    public static UpdateOnUi updateOnUi=null;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle b=intent.getExtras();
        if(updateOnUi==null){
            //create a notification
        }else{
            updateOnUi.update(b.getString("from"),b.getString("message"));
        }
        Log.d("pushy",b.getString("message"));
    }
}