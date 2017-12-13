package com.ustc.leo.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dell on 2017/11/21.
 * 配置文件存储和获取
 */

public class Configurator {
    //存放配置文件
    private static final HashMap<String, Object> LEO_CONFIGS = new HashMap<>();
    //存放图标并封装
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator() {
        //开始配置，未完成
        LEO_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<String, Object> getLeoConfigs() {
        return LEO_CONFIGS;
    }

    //静态内部类单例初始化
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        initIcons();
        LEO_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        LEO_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    //初始化图标
    private void  initIcons(){
        if(ICONS.size()>0){
            //初始化
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for(int i=1;i<ICONS.size();i++){
                initializer.with(ICONS.get(i));
            }
        }
    }

    public  final Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }
    private void checkConfiguration() {
        final boolean isReady = (boolean) LEO_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready, call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguaration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) LEO_CONFIGS.get(key.name());
    }
}
