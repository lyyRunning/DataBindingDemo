package com.function.luo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.function.luo.adapter.MulTypeBindAdapter;
import com.function.luo.adapter.base.IBaseBindingPresenter;
import com.function.luo.bean.Student;
import com.function.luo.databindingdemo.R;
import com.function.luo.databindingdemo.databinding.ActivityRecyclerBindBinding;

import java.util.ArrayList;

/**
 * 多类型列表
 */
public class A04MulTypeRecyclerBindActivity extends AppCompatActivity {

    private ActivityRecyclerBindBinding binding;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
    }

    private void bind() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_bind);

        ArrayList<Student> students = getStudents();

        MulTypeBindAdapter adapter = new MulTypeBindAdapter(students);
        adapter.setItemPresenter(new MulRecyclerBindPresenterI());

        binding.recyclerView
                .setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recyclerView
                .setAdapter(adapter);
    }

    public class MulRecyclerBindPresenterI implements IBaseBindingPresenter {

        public void onNameClick(Student student) {
            Toast.makeText(A04MulTypeRecyclerBindActivity.this, student.name.get(), Toast.LENGTH_SHORT).show();
        }

        public void onAgeClick(Student student) {
            Toast.makeText(A04MulTypeRecyclerBindActivity.this, String.valueOf(student.getAge()), Toast.LENGTH_SHORT).show();
        }
    }

    private ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("jack", 36));
        students.add(new Student("rose", 13));
        students.add(new Student("qingmei2", 34));
        students.add(new Student("unknown", 21));
        return students;
    }
}
