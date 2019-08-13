package com.function.luo.adapter;

import com.function.luo.adapter.base.BaseBindingAdapter;
import com.function.luo.adapter.base.BaseViewHolder;
import com.function.luo.bean.Student;
import com.function.luo.databindingdemo.databinding.ItemRecyclerViewBinding;


import java.util.List;

/**
 * Created by fcn-mq on 2017/5/26.
 */

public class SimpleBindAdapter extends BaseBindingAdapter<Student, ItemRecyclerViewBinding> {

    public SimpleBindAdapter(List<Student> mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    /**
     * 如果有特殊需求可以实现在该方法中
     * @param holder
     */
    @Override
    public void onCreateViewHolder(BaseViewHolder<ItemRecyclerViewBinding> holder) {

    }

}
