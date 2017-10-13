package com.example.zhangbing.love.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.zhangbing.love.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 * 类说明
 *
 * @author zhangbing
 * @Description: 练习自定义的View
 * @CreateDate: 2017/10/10 13:48
 * @email 314835006@qq.com
 * @UpdateUser: zhangbing
 * @UpdateDate: 2017/10/10 13:48
 * @UpdateRemark:
 */
public class CustomTitleVIew extends View {

    /**
     * 文字
     */
    private String titleText;

    /**
     * 文字的颜色
     */
    private int titleTextColor;

    /**
     * 字体的大小
     */
    private int titleTextSize;
    private Rect mRect;
    private Paint mPaint;

    public CustomTitleVIew(Context context) {
        this(context, null);
    }

    public CustomTitleVIew(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTitleVIew(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int n = a.getIndexCount();

        for (int i = 0; i < n; i++) {

            int attr = a.getIndex(i);
            switch (attr) {
                //文字
                case R.styleable.CustomTitleView_titleText:

                    titleText = a.getString(attr);
                    break;
                //字体的颜色
                case R.styleable.CustomTitleView_titleTextColor:
                    titleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                //字体的大小
                case R.styleable.CustomTitleView_titleTextSize:
                    titleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics()));
                    break;
            }

        }

        a.recycle();

        //绘制文本的大小
        //创建一个画笔
        mPaint = new Paint();
        mPaint.setTextSize(titleTextSize);

        mRect = new Rect();
        mPaint.getTextBounds(titleText, 0, titleText.length(), mRect);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "haha", Toast.LENGTH_SHORT).show();
                titleText = randomText();
                postInvalidate();
            }
        });

    }

    private String randomText() {
        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (4 > set.size()) {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set) {
            sb.append("" + i);
        }

        return sb.toString();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            mPaint.setTextSize(titleTextSize);
            mPaint.getTextBounds(titleText, 0, titleText.length(), mRect);
            int textWidth = mRect.width();
            width = getPaddingLeft() + textWidth + getPaddingRight();
        }

        int height;

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mPaint.setTextSize(titleTextSize);
            mPaint.getTextBounds(titleText, 0, titleText.length(), mRect);
            int textHergit = mRect.height();
            height = getPaddingTop() + textHergit + getPaddingBottom();
        }

        setMeasuredDimension(width, height);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(titleTextColor);
        canvas.drawText(titleText, getWidth() / 2 - mRect.width() / 2, getHeight() / 2 + mRect.height() / 2, mPaint);

    }


}
