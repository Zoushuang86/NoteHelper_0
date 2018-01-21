package com.ustc.leo.net.callback;

/**
 * Created by dell on 2017/12/17.
 * 请求失败返回错误接口
 */

public interface IError {
    void onError(int code,String msg);
}
