package com.ustc.notehelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ustc.leo.delegates.LeoDelegate;

/**
 * Created by dell on 2017/11/25.
 */

public class ExampleDelegate extends LeoDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    //对每一个控件的操作
    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
