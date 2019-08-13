package com.function.luo.di;

import android.content.Context;
import android.content.SharedPreferences;


import com.function.luo.api.ServiceManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by fcn-mq on 2017/5/31.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    SharedPreferences sharedPreferences();

    Context context();

    ServiceManager serviceManager();

}

