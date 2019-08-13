package com.function.luo.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.function.luo.bean.Student;
import com.function.luo.databindingdemo.BR;
import com.function.luo.databindingdemo.R;
import com.function.luo.databindingdemo.databinding.ActivityDataBaseBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by luo on 2019/8/9.
 */

public class A02DataBindingBaseActivity extends Activity {

    ActivityDataBaseBinding binding;
    Student student;
    private List<String> contents = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    private void inject() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_base);


        student = new Student("小明", 25);
        contents.add("content ===== 这是 list 列表数据 1");
        contents.add("content ====== 这是 list 列表数据 2");


        // 以下两种方式 给XML中 student 赋值

        // binding.setStudent(student);
        binding.setVariable(BR.student, student);
        binding.setPresenter(new Presenter());
        binding.setContents(contents);

    }


    public class Presenter {

        public void onNameClick(String name) {
            Toast.makeText(A02DataBindingBaseActivity.this, name, Toast.LENGTH_LONG).show();
        }



        public void onAgeClick(int age) {
            Toast.makeText(A02DataBindingBaseActivity.this, String.valueOf(age), Toast.LENGTH_SHORT).show();
        }


        /**
         * 监听器和对象绑定 ,详情请查看Student类
         * {@link Student}
         * ObservableObject 实现动态更新数据
         */

        public void onAgeAdd3() {
            student.setAge(student.getAge() + 3);
        }

        /**
         * ObservableField 实现动态更新数据（更清晰明了）
         */
        public void onNameAppendPoint() {
            student.name.set(student.name.get() + "*");
        }

        /**
         *
         * Observable Collections
         */
        public ObservableArrayMap<String, Object> datas = new ObservableArrayMap<>();

        {
            datas.put("string", "我是中国人");
            datas.put("int", 1000);
            datas.put("student", student);
        }

    }

}
