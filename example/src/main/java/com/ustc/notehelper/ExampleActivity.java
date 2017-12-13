package com.ustc.notehelper;

import com.ustc.leo.activities.ProxyActivity;
import com.ustc.leo.delegates.LeoDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public LeoDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
