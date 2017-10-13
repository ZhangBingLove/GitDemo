package com.example.zhangbing.love.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhangbing.love.R;
import com.example.zhangbing.love.base.BaseActivity;
import com.example.zhangbing.love.dao.StudioDao;
import com.example.zhangbing.love.dao.entity.Student;
import com.example.zhangbing.love.dao.entity.StudentDao;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConstraintLayoutActivity extends BaseActivity {

    @BindView(R.id.btn_insert)
    Button btnInsert;
    @BindView(R.id.btn_query_all)
    Button btnQueryAll;
    @BindView(R.id.tv_text)
    TextView tvText;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_constraint_layout;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String aaa) {
        tvText.setText(aaa);
    }


    @OnClick({R.id.btn_insert, R.id.btn_query_all, R.id.btn_query_one, R.id.start_activity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_insert://插入数据
                Student student1 = new Student(1112, "章冰1", 11, "男");
                Student student2 = new Student(1113, "章冰2", 11, "男");
                Student student3 = new Student(1114, "章冰3", 11, "男");

                List<Student> mList = new ArrayList<>();
                mList.add(student1);
                mList.add(student2);
                mList.add(student3);


                StudioDao.insertStudents(mList);


                break;
            case R.id.btn_query_all: //查询数据

                List<Student> students = StudioDao.queryAll();

                Log.e("haha", students.toString());

                break;

            case R.id.btn_query_one: //查询数据

                List<Student> studen = StudioDao.findStudent("章冰1");

                Log.e("haha", studen.toString());

                break;

            case R.id.start_activity: //打开一个Activity


                Intent intent = new Intent(this, Text2Activity.class);
                startActivity(intent);

                break;


        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}