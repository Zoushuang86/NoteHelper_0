package com.ustc.notehelper;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.ustc.leo.app.Leo;
import com.ustc.leo.ec.icon.FontEcModule;
import com.ustc.leo.net.Interceptors.DebugInterceptor;

/**
 * Created by dell on 2017/11/24.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Leo.init(this)
                .withIcon(new FontAwesomeModule()) //第三方通用图标
                .withIcon(new FontEcModule()) //alipay图标
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .configure();
    }
}
