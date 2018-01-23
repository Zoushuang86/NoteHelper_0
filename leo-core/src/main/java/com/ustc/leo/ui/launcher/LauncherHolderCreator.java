package com.ustc.leo.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created by dell on 2018/1/23.
 */

public class LauncherHolderCreator implements CBViewHolderCreator{

    @Override
    public Object createHolder() {
        return new LauncherHolder();
    }
}
