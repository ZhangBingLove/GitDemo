package com.example.zhangbing.love.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.zhangbing.love.R;

/**
 * 创建时间: 自定义的图片
 * 编写人:
 * 功能描述:
 */

public class CustomImageView extends View {

    /**
     * 文字
     */
    private String mTitleText;
    /**
     * 文字颜色
     */
    private int mTitleTextColor;
    private Bitmap mImage;
    private int mImageScaleType;

    public CustomImageView(Context context) {
        this(context, null);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomImageView, defStyleAttr, 0);
        int n = a.getIndexCount();

        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);

            switch (attr) {

                case R.styleable.CustomImageView_image:
                    mImage = BitmapFactory.decodeResource(getResources(), a.getResourceId(attr, 0));

                    break;

                case R.styleable.CustomImageView_imageScaleType:

                    mImageScaleType = a.getInt(attr, 0);
                    break;

                case R.styleable.CustomImageView_titleText:

                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomImageView_titleTextColor:

                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;

                case R.styleable.CustomImageView_titleTextSize:

                    a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                            16, getResources().getDisplayMetrics()));
                    break;
            }
        }

        a.recycle();




    }


}
