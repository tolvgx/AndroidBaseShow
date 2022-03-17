package com.show.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 跨进程AIDL Client端
    public void aidlClient(View view) {
        Intent intent = new Intent(MainActivity.this, AIDLClientActivity.class);
        startActivity(intent);
    }
}