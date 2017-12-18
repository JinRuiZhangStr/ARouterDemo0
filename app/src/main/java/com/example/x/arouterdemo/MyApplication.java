package com.example.x.arouterdemo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by X on 2017/12/18.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    private boolean debug = true;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initRouter(instance);
    }

    public static MyApplication getInstance(){
        return instance;
    }
    private void initRouter(MyApplication mApplication) {
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(mApplication);

    }

    public boolean isDebug() {
        return debug;
    }
}
