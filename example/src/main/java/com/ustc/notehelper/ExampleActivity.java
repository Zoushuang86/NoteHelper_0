package com.ustc.notehelper;

import com.ustc.leo.activities.ProxyActivity;
import com.ustc.leo.delegates.LeoDelegate;
import com.ustc.leo.ec.launcher.LauncherDelegate;
import com.ustc.leo.ec.launcher.LauncherScrollDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public LeoDelegate setRootDelegate() {
        return new LauncherScrollDelegate();
//        return new LauncherDelegate();
//        return new ExampleDelegate();
    }
}
