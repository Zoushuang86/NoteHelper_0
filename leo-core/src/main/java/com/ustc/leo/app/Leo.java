package com.ustc.leo.app;

import android.content.Context;
import android.os.Handler;

import java.util.HashMap;

/**
 * Created by dell on 2017/11/21.
 */

public final class Leo {

//    public  static  Configurator init(Context context){
//        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
//        return  Configurator.getInstance();
//    }
//
//    public static HashMap<Object,Object> getConfigurations(){
//        return Configurator.getInstance().getLeoConfigs();
//    }
//
//    public static Context getApplication(){
//        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
//    }


    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getLeoConfigs()
                .put(ConfigType.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplication() {
        return getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigType.HANDLER);
    }

    public static void test(){
    }
}
