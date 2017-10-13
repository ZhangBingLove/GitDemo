package com.example.zhangbing.love.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zhangbing.love.R;
import com.example.zhangbing.love.adapter.MyTestAdapter;
import com.example.zhangbing.love.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseRecyclerViewAdapterHelperActivity extends BaseActivity {

    @BindView(R.id.rv_recycleView)
    RecyclerView rvRecycleView;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_base_recycler_view_adapter_helper;

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        List<String> mList = new ArrayList<>();
        mList.add("0000000");
        mList.add("1111111");
        mList.add("2222222");
        mList.add("3333333");
        mList.add("4444444");
        mList.add("5555555");
        mList.add("6666666");
        mList.add("7777777");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");
        mList.add("6666666");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvRecycleView.setLayoutManager(linearLayoutManager);
        MyTestAdapter myTestAdapter = new MyTestAdapter(R.layout.item_base_recycle, mList);
        myTestAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        myTestAdapter.isFirstOnly(false);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null);

        myTestAdapter.addHeaderView(view);
        rvRecycleView.setAdapter(myTestAdapter);

        myTestAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                showToast("item" + position + "被点击了");
            }

        });

        myTestAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                showToast("长点击-------item" + position + "被点击了");
                return false;
            }
        });

        myTestAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                int id = view.getId();
                switch (id) {
                    case R.id.btn1:
                        showToast("item中的子布局btn1" + position + "被点击了");
                        break;

                    case R.id.btn2:
                        showToast("item中的子布局btn2" + position + "被点击了");
                        break;

                }
            }
        });


    }


}
