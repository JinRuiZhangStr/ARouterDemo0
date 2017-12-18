package com.example.x.arouterdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_tv)
    TextView tvTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    public void top_b(View view) {
        ARouter.getInstance().build(ARouterHelper.top_a)
                .withString("tv_name", "张三")//传一个String值给下个页面
                .withBoolean("isLogin", false)//boolean值
                .withInt("tv_age", 1)//int值
                .withTransition(android.R.anim.fade_in, android.R.anim.fade_out)//跳转动画
                .navigation(this); //使用此种方式对跳转添加动画，必须写 context
    }

    public void top_c(View view) {

        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        ARouter.getInstance().build(ARouterHelper.top_b)
                //传一个bean给下个页面
                .withParcelable("bean", new Bean("李四", 2))
                //跳转动画(API>19可以使用)
                .withOptionsCompat(activityOptionsCompat)
                .navigation();
    }

    public void top_d(View view) {
        ARouter.getInstance().build(ARouterHelper.top_c)
                .navigation(this, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == 0) {
            String name = data.getStringExtra("name");
            tvTv.setText(name);
        }
    }
}
