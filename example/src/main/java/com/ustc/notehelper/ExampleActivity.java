package com.ustc.notehelper;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.ustc.leo.activities.ProxyActivity;
import com.ustc.leo.delegates.LeoDelegate;
import com.ustc.leo.ec.launcher.LauncherDelegate;
import com.ustc.leo.ec.launcher.LauncherScrollDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
    }

    @Override
    public LeoDelegate setRootDelegate() {
//        return new LauncherScrollDelegate();
        return new LauncherDelegate();
//        return new ExampleDelegate();
    }
}
