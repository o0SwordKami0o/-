package com.example.work2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;
    private Mybinder binder;
    public MyService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music1);
        mediaPlayer.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        binder=new Mybinder();
        return binder;
    }

    class Mybinder extends Binder{
        public void myplay(){
            mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music1);
            mediaPlayer.start();
        }
    }


}