package com.function.luo.di.component;



import com.function.luo.activity.A06MvvmActivity;
import com.function.luo.di.AppComponent;
import com.function.luo.di.module.A06Module;
import com.function.luo.di.scope.ActivityScope;
import com.function.luo.viewmodel.A06MvvmViewModel;

import dagger.Component;

/**
 * Created by fcn-mq on 2017/5/31.
 */
@ActivityScope
@Component(modules = A06Module.class, dependencies = AppComponent.class)
public interface A06Component {

    void injectActivity(A06MvvmActivity activity);

    void injectViewModel(A06MvvmViewModel viewModel);
}
