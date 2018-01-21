package com.ustc.notehelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.ustc.leo.delegates.LeoDelegate;
import com.ustc.leo.net.RestClient;
import com.ustc.leo.net.callback.IError;
import com.ustc.leo.net.callback.IFailure;
import com.ustc.leo.net.callback.ISuccess;

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
        testRestClient();
    }

    private void testRestClient(){
        RestClient.builder()
                .url("http://news.baidu.com")
                //.params("","")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
//                        Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
