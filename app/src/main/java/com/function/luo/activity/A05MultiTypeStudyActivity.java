package com.function.luo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.function.luo.adapter.base.IBaseBindingPresenter;
import com.function.luo.adapter.binder.MultiTypeBinder;
import com.function.luo.adapter.binder.MultiTypeBinder1;
import com.function.luo.adapter.binder.MultiTypeBinder2;
import com.function.luo.bean.Student;
import com.function.luo.databindingdemo.R;
import com.function.luo.databindingdemo.databinding.ActivityRecyclerBindBinding;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by fcn-mq on 2017/5/27.
 * <p>
 * drakeet/Effective-MultiType Library学习Activity
 */

public class A05MultiTypeStudyActivity extends AppCompatActivity {

    private ActivityRecyclerBindBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_bind);

//        showSingleList();
        showMultiTypeList();
    }

    /**
     * 展示简单列表
     */
    public void showSingleList(){
        MultiTypeAdapter adapter = new MultiTypeAdapter();
        adapter.register(Student.class, new MultiTypeBinder());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        Items items = new Items();
        for (int i = 0; i < 10; i++) {
            items.add(new Student("xiaoming", 29));
            items.add(new Student("qingmei2", 18));
        }
        Log.i("tag", "items.size() " + items.size());
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }

    /**
     * 展示多类型列表
     */
    public void showMultiTypeList(){
        MultiTypeAdapter adapter = new MultiTypeAdapter();
        adapter.register(Student.class,new MultiTypeBinder1());
        adapter.register(String.class,new MultiTypeBinder2());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        Items items = new Items();
        for (int i = 0; i < 10; i++) {
            items.add(new String("Songs"));
            items.add(new Student("xiaoming", 29));
            items.add(new Student("qingmei2", 18));
        }
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_multi_type_library,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.singleList:
                showSingleList();
                break;
            case R.id.multiTypeList:
                showMultiTypeList();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }


    public class MulRecyclerBindPresenterI implements IBaseBindingPresenter {

        public void onNameClick(Student student) {
            Toast.makeText(A05MultiTypeStudyActivity.this, student.name.get(), Toast.LENGTH_SHORT).show();
        }

        public void onAgeClick(Student student) {
            Toast.makeText(A05MultiTypeStudyActivity.this, String.valueOf(student.getAge()), Toast.LENGTH_SHORT).show();
        }
    }

}
