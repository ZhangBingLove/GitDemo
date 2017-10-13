package com.example.zhangbing.love.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zhangbing.love.R;

import java.util.List;

/**
 * 创建时间: 2017/10/13.
 * 编写人:
 * 功能描述:
 */

public class MyTestAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MyTestAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv2, item)
                .addOnClickListener(R.id.btn1)
                .addOnClickListener(R.id.btn2)
        ;

    }
}
