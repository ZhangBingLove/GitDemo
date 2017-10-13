package com.example.zhangbing.love;


import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class DialogActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_dialog);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }

    public void tip(View view) {
        Toast.makeText(this, "hahaahahahahaha", Toast.LENGTH_SHORT).show();
    }
}
