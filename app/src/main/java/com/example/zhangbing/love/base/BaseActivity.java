package com.example.zhangbing.love.base;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.zhangbing.love.R;

import butterknife.ButterKnife;

/**
 * 类说明
 * 项目中Activity都有的共性:
 * 1.都有布局文件
 * 2.基本都有标题  基本都有返回键
 * 3.基本都有退出和进入的动画
 * 4.跳转
 *
 * @author zhangbing
 * @Description: BaseActivity的封装
 * @CreateDate: 2017/9/27 15:25
 * @email 314835006@qq.com
 * @UpdateUser: zhangbing
 * @UpdateDate: 2017/9/27 15:25
 * @UpdateRemark:
 */
public abstract class BaseActivity extends AppCompatActivity {


    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Activity生命周期 --------> onCreate()");

        if (getAllowFullScreen()) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        if (getSteepStatusBar()) {
            steepStatusBar();
        }

        setContentView(setContentViewId());
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 加载布局Activity的布局
     *
     * @author zhangbing
     * @date 2017/9/27 15:48
     * @email 314835006@qq.com
     */
    protected abstract int setContentViewId();

    /**
     * 初始化布局
     *
     * @author zhangbing
     * @date 2017/9/27 15:51
     * @email 314835006@qq.com
     */
    protected abstract void initView();


    /**
     * 设置全屏  默认不是全屏的 需要设置全屏的话 在子类中重写这个方法
     *
     * @Params isAllowFullScreen 是否设置全屏
     * @author zhangbing
     * @date 2017/9/27 16:00
     * @email 314835006@qq.com
     */
    public boolean getAllowFullScreen() {
        return false;
    }

    public boolean getSteepStatusBar() {
        return false;
    }

    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.from_right_in, R.anim.to_left_out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.from_left_in, R.anim.to_right_out);
    }

    /**
     * 吐司
     */
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
