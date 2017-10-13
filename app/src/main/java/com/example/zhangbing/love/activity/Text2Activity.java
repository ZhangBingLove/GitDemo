package com.example.zhangbing.love.activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import com.example.zhangbing.love.DialogActivity;
import com.example.zhangbing.love.R;
import com.example.zhangbing.love.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 类说明
 *
 * @author zhangbing
 * @Description: 练习
 * @CreateDate: 2017/10/10 10:12
 * @email 314835006@qq.com
 * @UpdateUser: zhangbing
 * @UpdateDate: 2017/10/10 10:12
 * @UpdateRemark:
 */
public class Text2Activity extends BaseActivity {


    @BindView(R.id.btn_click)
    Button btnClick; //Activity的弹出框

    @Override
    protected int setContentViewId() {
        return R.layout.activity_text2;
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.btn_click)
    public void onViewClicked() {
        String aaa = "测试EventBus";
        EventBus.getDefault().post(aaa);

//        showToast("我是吐司");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
