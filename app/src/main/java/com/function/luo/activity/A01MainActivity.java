package com.function.luo.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.function.luo.databindingdemo.R;
import com.function.luo.databindingdemo.databinding.ActivityMainBinding;

public class A01MainActivity extends AppCompatActivity {
    public Presenter presenter;

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化 DataBinding
        inject();
    }

    private void inject() {

         binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //初始化Presenter对象
        presenter = new Presenter();
        //将presenter对象赋予XML中的 data -> variable -> presenter
        binding.setPresenter(presenter);


    }



    public  class Presenter {

        public String message = " ~ ";
        public String name = "小明";

        /**
         * DataBinding基础使用
         */
        public void baseDataBinding() {
            startActivity(new Intent(A01MainActivity.this,A02DataBindingBaseActivity.class));
        }

        /**
         * recyclerView的展示列表
         */
        public void recyclerView(){
            startActivity(new Intent(A01MainActivity.this,A03RecyclerBindActivity.class));


        }

        /**
         *
         * DataBinding 展示多类型列表
         */
        public void mulTypeRecyclerView(){
            startActivity(new Intent(A01MainActivity.this,A04MulTypeRecyclerBindActivity.class));

        }

        /**
         * MultiType库学习
         *
         */
        public void studyLibrary(){

            startActivity(new Intent(A01MainActivity.this,A05MultiTypeStudyActivity.class));

        }


        /**
         * ataBinding Mvvm
         *
         */
        public void mvvm(){

            startActivity(new Intent(A01MainActivity.this,A06MvvmActivity.class));

        }


    }

}
