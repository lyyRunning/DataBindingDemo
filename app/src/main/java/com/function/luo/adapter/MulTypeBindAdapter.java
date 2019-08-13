package com.function.luo.adapter;



import com.function.luo.adapter.base.BaseBindingMulTypeAdapter;
import com.function.luo.adapter.base.BaseViewHolder;
import com.function.luo.bean.Student;
import com.function.luo.databindingdemo.databinding.ItemRecyclerViewBinding;

import java.util.List;

/**
 * Created by fcn-mq on 2017/5/26.
 * 多类型列表
 */

public class MulTypeBindAdapter extends BaseBindingMulTypeAdapter<Student, ItemRecyclerViewBinding> {

    public MulTypeBindAdapter(List<Student> mDatas) {
        super(mDatas);
    }

    /**
     * 如果有特殊需求可以实现在该方法中
     * @param holder
     */
    @Override
    public void onCreateViewHolder(BaseViewHolder<ItemRecyclerViewBinding> holder) {

    }


}
