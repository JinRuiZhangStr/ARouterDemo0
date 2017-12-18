package com.example.x.arouterdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path="/test/dactivity")
public class DActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        ARouter.getInstance().inject(this);
        Intent intent  = new Intent();
        intent.putExtra("name","王五");
        this.setResult(0,intent);

    }
}
