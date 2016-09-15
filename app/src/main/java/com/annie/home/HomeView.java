package com.annie.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ma on 2016/9/8.
 */
public class HomeView extends ViewGroup {


    public HomeView(Context context) {
        super(context);
    }

    public HomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    /**
     *  定义一个类用来封装一行的数据,包括该行的所有字view,行宽和行高
     */
    class Line {
        private ArrayList<View> viewList; //用来存放该行的所有view对象
        private int width; //表示所有view对象的宽 + 水平间距
        private int height; //行的高度,在摆放的时候使用

        public Line() {
            viewList = new ArrayList<View>();
        }

        /**
         * 添加view对象的方法
         */
        public void addLineView(View view) {
            if (!viewList.contains(view)) {
                viewList.add(view);

                //更新当前行的宽
                if (viewList.size() == 1) {
                    //说明当前的view是第一个view对象，
                    width = view.getMeasuredWidth();
                } else {
                    //应该在当前width的基础上 + 水平间距 + view的宽
                    // width += horizontalSpacing + view.getMeasuredWidth();
                }

                //更新高度,行的高度就是View的高度
                height = view.getMeasuredHeight();

            }
        }

        /**
         * 获取行的宽
         *
         * @return
         */
        public int getLineWidth() {
            return width;
        }

        /**
         * 获取行的高
         *
         * @return
         */
        public int getLineHeight() {
            return height;
        }

        /**
         * 获取行的view集合
         *
         * @return
         */
        public ArrayList<View> getViewList() {
            return viewList;
        }

    }}
