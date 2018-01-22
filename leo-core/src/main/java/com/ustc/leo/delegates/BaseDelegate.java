package com.ustc.leo.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ustc.leo.activities.ProxyActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by dell on 2017/11/24.
 */

//不希望自己或别人创建一个实例
@SuppressWarnings("SpellCheckingInspection")
public abstract class BaseDelegate extends SwipeBackFragment {

    //butterknife定义
    private Unbinder mUnbinder = null;

    //传入的布局对象不明确，故使用Object
    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle savedInstanceState, View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        } else {
            throw new ClassCastException("setLayout() type must be int or View!");
        }

        mUnbinder = ButterKnife.bind(this, rootView);
        //绑定根视图
        onBindView(savedInstanceState, rootView);
        return rootView;
    }

    public final ProxyActivity getProxyActivity(){
        return (ProxyActivity) _mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //解除绑定
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
