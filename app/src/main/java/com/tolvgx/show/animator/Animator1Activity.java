package com.tolvgx.show.animator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tolvgx.show.R;

public class Animator1Activity extends AppCompatActivity {

    LoginItem loginItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator1);

        loginItem = findViewById(R.id.loginItem);
        loginItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginItem.startAnimator();
            }
        });
    }
}
