package com.minminaya.library;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

/**
 * <p>只兼容API>=21</p>
 * <p>
 * <p>Created by LGM on 2018-03-29 14:21</p>
 * <p>Email:minminaya@gmail.com</p>
 */
public class LGMRoundButtonDrawable extends GradientDrawable {

    /**
     * 标记是否圆角为指定View的高度的一半，假如用在Button中，会表现为左右为圆角的button
     */
    private boolean isRadiusAdjustBounds = true;
    private int textColorForPress = 0;
    private ColorStateList colorStateListForTextColorForPressed;

    public static LGMRoundButtonDrawable obtainAttributeData(Context context, AttributeSet attributeSet, int defStyleAttr) {

        LGMRoundButtonDrawable roundButtonDrawable = new LGMRoundButtonDrawable();
        roundButtonDrawable.initAttributeData(context, attributeSet, defStyleAttr, roundButtonDrawable);
        return roundButtonDrawable;
    }


    @Override
    protected void onBoundsChange(Rect r) {
        super.onBoundsChange(r);
        if (isRadiusAdjustBounds) {
            //四角半径为最短边的一半
            setCornerRadius(Math.min(r.width(), r.height()) / 2);
        }
    }

    private void initAttributeData(Context context, AttributeSet attributeSet, int defStyleAttr, LGMRoundButtonDrawable mRoundButtonDrawable) {

        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.LGMRoundButton, defStyleAttr, 0);
        int radius = typedArray.getDimensionPixelSize(R.styleable.LGMRoundButton_radius, 0);
        int radiusTopLeft = typedArray.getDimensionPixelSize(R.styleable.LGMRoundButton_radiusForTopLeft, 0);
        int radiusTopRight = typedArray.getDimensionPixelSize(R.styleable.LGMRoundButton_radiusForTopRight, 0);
        int radiusBottomLeft = typedArray.getDimensionPixelSize(R.styleable.LGMRoundButton_radiusForBottomLeft, 0);
        int radiusBottomRight = typedArray.getDimensionPixelSize(R.styleable.LGMRoundButton_radiusForBottomRight, 0);

        //默认2px
        int borderWidth = typedArray.getDimensionPixelSize(R.styleable.LGMRoundButton_borderWidth, 2);

        boolean attrForisRadiusAutoHalf = typedArray.getBoolean(R.styleable.LGMRoundButton_isRadiusAutoHalf, false);

        //默认不透明
        int alpha = typedArray.getDimensionPixelSize(R.styleable.LGMRoundButton_alphaForDrawable, 255);


        colorStateListForTextColorForPressed = typedArray.getColorStateList(R.styleable.LGMRoundButton_textColorForPressed);

        ColorStateList colorStateListForBgColor = typedArray.getColorStateList(R.styleable.LGMRoundButton_bgColor);
        ColorStateList colorStateListForBorderColor = typedArray.getColorStateList(R.styleable.LGMRoundButton_borderColor);

        typedArray.recycle();

        //设置关键数据
        super.setColor(colorStateListForBgColor);
        super.setStroke(borderWidth, colorStateListForBorderColor);
        super.setAlpha(alpha);
        //下面开始处理四角的半径
        if (radiusBottomLeft > 0 || radiusBottomRight > 0 || radiusTopLeft > 0 || radiusTopRight > 0) {
            //如果这四个角有一个值不为0，说明按钮的角要单独调整
            //构建float数组，每两个值为一组，分别作为左上，右上，右下，左下的半径值
            float[] radii = new float[]{
                    radiusTopLeft, radiusTopLeft,
                    radiusTopRight, radiusTopRight,

                    radiusBottomRight, radiusBottomRight,
                    radiusBottomLeft, radiusBottomLeft
            };
            mRoundButtonDrawable.setCornerRadii(radii);
            attrForisRadiusAutoHalf = false;
        } else {
            //如果四个角的值不指定，那么全部设置为一样的
            mRoundButtonDrawable.setCornerRadius(radius);
            if (radius > 0) {
                attrForisRadiusAutoHalf = false;
            }
        }
        //将是否处理为四角半径保存
        mRoundButtonDrawable.setRadiusAdjustBounds(attrForisRadiusAutoHalf);
    }


    public void setRadiusAdjustBounds(boolean radiusAdjustBounds) {
        isRadiusAdjustBounds = radiusAdjustBounds;
    }

    public ColorStateList getColorStateListForTextColorForPressed() {
        return colorStateListForTextColorForPressed;
    }

    public void setColorStateListForTextColorForPressed(ColorStateList colorStateListForTextColorForPressed) {
        this.colorStateListForTextColorForPressed = colorStateListForTextColorForPressed;
    }
}
