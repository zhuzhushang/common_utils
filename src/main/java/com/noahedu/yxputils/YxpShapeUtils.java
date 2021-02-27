package com.noahedu.yxputils;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

/**
 * Author: shaoqw
 * Date: 2020/12/1 20:03
 * Description: 创建圆角shape
 */
public class YxpShapeUtils {

    public static ShapeDrawable createCornersShapeDrawable(int radius, int color, boolean isDp) {

        if(isDp){

            radius = YxpSizeUtils.dp2px(radius);
        }
        /**
         * 外部矩形弧度
         */
        float[] outerRadian = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
        /**
         * 如果insetDistance与insideRadian设为null亦可
         */
        RoundRectShape roundRectShape = new RoundRectShape(outerRadian, null, null);
        ShapeDrawable drawable = new ShapeDrawable(roundRectShape);
        /**
         * 指定填充颜色
         */
        drawable.getPaint().setColor(color);
        /**
         * 指定填充模式
         */
        drawable.getPaint().setStyle(Paint.Style.FILL);

        return drawable;
    }

    public static ShapeDrawable createCornersShapeDrawable(int leftTopRadius, int rightTopRadius, int leftBottomRadius, int rightBottomRadius,int color, boolean isDp) {


        if(isDp){

            leftTopRadius = YxpSizeUtils.dp2px(leftTopRadius);
            rightTopRadius = YxpSizeUtils.dp2px(rightTopRadius);
            leftBottomRadius = YxpSizeUtils.dp2px(leftBottomRadius);
            rightBottomRadius = YxpSizeUtils.dp2px(rightBottomRadius);
        }
        /**
         * 外部矩形弧度
         */
        float[] outerRadian = new float[]{leftTopRadius, leftTopRadius, rightTopRadius, rightTopRadius, leftBottomRadius, leftBottomRadius, rightBottomRadius, rightBottomRadius};
        /**
         * 如果insetDistance与insideRadian设为null亦可
         */
        RoundRectShape roundRectShape = new RoundRectShape(outerRadian, null, null);
        ShapeDrawable drawable = new ShapeDrawable(roundRectShape);
        /**
         * 指定填充颜色
         */
        drawable.getPaint().setColor(color);
        /**
         * 指定填充模式
         */
        drawable.getPaint().setStyle(Paint.Style.FILL);

        return drawable;
    }


}
