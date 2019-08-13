package com.function.luo.common;


import com.function.luo.di.AppComponent;

/**
 * Created by fcn-mq on 2017/5/31.
 */

public class ComponentHolder {

    private static AppComponent mComponent;

    public static AppComponent getComponent() {
        return mComponent;
    }

    public static void setComponent(AppComponent component) {
        mComponent = component;
    }
}
