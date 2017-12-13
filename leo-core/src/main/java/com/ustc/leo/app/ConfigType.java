package com.ustc.leo.app;

/**
 * Created by dell on 2017/11/21.
 * 只能被初始化一次，线程安全的懒汉模式
 */

public enum ConfigType {
    API_HOST,            //网络请求域名等
    APPLICATION_CONTEXT,  //应用上下文
    CONFIG_READY,        //控制初始化、配置是否完成
    ICON                 //自己的初始化项目
}
