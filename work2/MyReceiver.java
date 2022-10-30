package com.example.work2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

//广播接收器
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d("zzy","onRecieve...");
        Intent intent1 = new Intent(context,MusicActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent1);
    }
}