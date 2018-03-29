package com.minminaya.library;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * <p>Created by LGM on 2018-03-29 13:21</p>
 * <p>Email:minminaya@gmail.com</p>
 */
public class LGMRoundButton extends AppCompatButton {

    private ColorStateList colorStateListForTextColorForPressed;

    public LGMRoundButton(Context context) {
        super(context);
        init(context, null, 0);
    }

    /**
     * xml引入方式
     */
    public LGMRoundButton(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.LGMRoundButtonStyle);
        init(context, attrs, R.attr.LGMRoundButtonStyle);
    }

    public LGMRoundButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }


    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        LGMRoundButtonDrawable mRoundButtonDrawable = LGMRoundButtonDrawable.obtainAttributeData(context, attrs, defStyleAttr);
        colorStateListForTextColorForPressed = mRoundButtonDrawable.getColorStateListForTextColorForPressed();
        //处理原按钮padding
        int[] padding = new int[]{this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom()};
        this.setBackground(mRoundButtonDrawable);//将drawable设置给当前Button
        this.setPadding(padding[0], padding[1], padding[2], padding[3]);
    }

    ColorStateList colorStateList = null;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                colorStateList = getTextColors();
                Log.e("onTouchEvent", "按下");
                this.setTextColor(colorStateListForTextColorForPressed);

                break;
            case MotionEvent.ACTION_UP:
                this.setTextColor(colorStateList);
                break;
        }


        return true;
    }
}

