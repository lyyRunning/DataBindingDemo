package com.function.luo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.function.luo.adapter.base.IMulTypeBindingBean;
import com.function.luo.databindingdemo.BR;
import com.function.luo.databindingdemo.R;

/**
 * Created by luo on 2019/8/9.
 * 首先继承 BaseObservale类
 */

public class Student extends BaseObservable implements IMulTypeBindingBean {
    /**
     * ObservableObject 实现数据绑定
     * 这里最好是private，否则在xml的代码提示会有两个age（1，成员变量的直接引用 2，代码模板生成），
     * 虽然都能用，但强迫症不能忍
     */
    private int age;

    public Student(String name,int age) {
        this.age = age;
        this.name.set(name);
    }

    /**
     * @Bindable这个注解，在setAge()可以使用BR.age方法
     *
     */
    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    /**
     * ObservableFields 实现数据绑定（推荐）
     * name这样写
     */
    public final ObservableField<String> name = new ObservableField<>();



    /**
     * IMulTypeBindingBean接口的实现方法
     *
     * 使用方法请见DataBinding多类型列表Activity的展示（该接口方法仅在该界面使用）
     * {@link com.function.luo.activity.A04MulTypeRecyclerBindActivity}
     *
     * @return 如果30岁以下和30岁以上，数据展示在不同的layout上（背景色不同）
     */
    @Override
    public int getLayoutResouse() {
        if (age <= 30) {
            return R.layout.item_recycler_view1;
        } else {
            return R.layout.item_recycler_view2;
        }
    }
}
