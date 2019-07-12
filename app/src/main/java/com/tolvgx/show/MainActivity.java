package com.tolvgx.show;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tolvgx.show.animator.Animator1Activity;
import com.tolvgx.show.animator.AnimatorActivity;
import com.tolvgx.show.defineview.DefineActivity;
import com.tolvgx.show.jetpack.JetpackActivity;
import com.tolvgx.show.launchmode.Main1Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Animator1Activity.class);
                startActivity(intent);
            }
        });
    }
}
