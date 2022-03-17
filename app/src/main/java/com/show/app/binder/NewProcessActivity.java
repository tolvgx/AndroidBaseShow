package com.show.app.binder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.show.app.R;

public class NewProcessActivity extends AppCompatActivity {
    public final static String TAG = "NewProcessActivity";
    private IMyAidlInterface mBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_process);
        Log.i(TAG, "onCreate");
    }

    public void bindService(View view) {
        //通过Intent指定服务端的服务名称和所在包，与远程Service进行绑定
        //参数与服务器端的action要一致,即"服务器包名.aidl接口文件名"
        Intent intent = new Intent("com.show.app.binder.IMyAidlInterface");

        //Android5.0后无法只通过隐式Intent绑定远程Service
        //需要通过setPackage()方法指定包名
        intent.setPackage("com.show.app");

        //绑定服务,传入intent和ServiceConnection对象
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                //使用AIDLService1.Stub.asInterface()方法获取服务器端返回的IBinder对象
                //将IBinder对象传换成了mAIDL_Service接口对象
                Log.i(TAG, "onServiceConnected");
                mBinder = IMyAidlInterface.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);
    }

    public void callRemoteMethod(View view) {
        if (mBinder != null) {
            try {
                Log.i(TAG, "callRemoteMethod");
                mBinder.callRemoteMethod();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}