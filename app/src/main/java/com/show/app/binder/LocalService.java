package com.show.app.binder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class LocalService extends Service {
    public final static String TAG = "LocalService";

    public LocalService() {
    }

    IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void callRemoteMethod() throws RemoteException {
            Log.i(TAG, "callRemoteMethod");
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        //在onBind()返回继承自Binder的Stub类型的Binder，非常重要
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}