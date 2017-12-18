package com.example.x.arouterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/test/bactivity")
public class BActivity extends AppCompatActivity {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.age)
    TextView age;
    @BindView(R.id.sex)
    TextView sex;

    @Autowired
    String tv_name;
    @Autowired
    int tv_age;
    @Autowired
    boolean is_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ARouter.getInstance().inject(this);
        ButterKnife.bind(this);
        name.setText(tv_name);
        age.setText(tv_age+"");
        sex.setText(is_Login+"");
    }
}
