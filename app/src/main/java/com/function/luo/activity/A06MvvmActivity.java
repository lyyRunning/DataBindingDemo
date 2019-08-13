package com.function.luo.activity;



import com.function.luo.common.ComponentHolder;
import com.function.luo.databindingdemo.R;
import com.function.luo.databindingdemo.databinding.A06ActivityMvvmBinding;
import com.function.luo.di.component.A06Component;
import com.function.luo.di.component.DaggerA06Component;
import com.function.luo.di.module.A06Module;
import com.function.luo.viewmodel.A06MvvmViewModel;

import javax.inject.Inject;

/**
 * Created by fcn-mq on 2017/5/26.
 * 第一个Mvvm架构的Activity
 */

public class A06MvvmActivity extends BaseMvvmActivity<A06ActivityMvvmBinding, A06MvvmViewModel> {

    @Inject
    A06MvvmViewModel mViewModel;

    @Override
    protected void inject() {
        A06Component component = DaggerA06Component.builder()
                .appComponent(ComponentHolder.getComponent())
                .a06Module(new A06Module(this))
                .build();
        component.injectActivity(this);
        component.injectViewModel(mViewModel);

        mBinding.setActivity(this);
        mBinding.setViewModel(mViewModel);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.a06_activity_mvvm;
    }


}
