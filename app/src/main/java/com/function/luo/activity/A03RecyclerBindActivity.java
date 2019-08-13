package com.function.luo.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.function.luo.adapter.SimpleBindAdapter;
import com.function.luo.adapter.base.IBaseBindingPresenter;
import com.function.luo.bean.Student;
import com.function.luo.databindingdemo.R;
import com.function.luo.databindingdemo.databinding.ActivityRecyclerBindBinding;

import java.util.ArrayList;

/**
 * Created by luo on 2019/8/12.
 */

public class A03RecyclerBindActivity extends Activity{

    private  ActivityRecyclerBindBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
    }

    private void bind() {

         binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_bind);

        ArrayList<Student> students = getStudents();

        SimpleBindAdapter adapter = new SimpleBindAdapter(students, R.layout.item_recycler_view);
        adapter.setItemPresenter(new RecyclerBindPresenter());
        binding.recyclerView
                .setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recyclerView
                .setAdapter(adapter);

    }


    /**
     * Recycler的Presenter
     */
    public class RecyclerBindPresenter implements IBaseBindingPresenter {

        public void onNameClick(Student student) {
            Toast.makeText(A03RecyclerBindActivity.this, student.name.get() + "要改名字", Toast.LENGTH_SHORT).show();
            student.name.set("我改名字啦！");
        }

        /**
         * 点击用户年龄 += 3，且空间的左内边距+=3；
         *{@link com.function.luo.adapter.base.BindingUtil}
         */
        public void onAgeClick(Student student) {
            Toast.makeText(A03RecyclerBindActivity.this, String.valueOf("涨了三岁"), Toast.LENGTH_SHORT).show();
            student.setAge(student.getAge() + 30);
        }
    }

    /**
     * 造的数据源
     * @return
     */
    private ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("jack", 12));
        students.add(new Student("rose", 13));
        students.add(new Student("qingmei2", 18));
        students.add(new Student("unknown", 21));
        return students;
    }
}
