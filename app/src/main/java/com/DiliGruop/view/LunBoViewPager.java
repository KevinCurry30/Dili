package com.DiliGruop.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;

/**
 * Created by Kevin on 2016/5/11.
 */
public class LunBoViewPager extends ViewPager {
    public LunBoViewPager(Context context) {
        super(context);
    }
    public static boolean GO_TOUTH_CHILD=true;
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (GO_TOUTH_CHILD){
            //此句代码是为了通知他的父ViewPager现在进行的是本控件的操作，不要对我的操作进行干扰
            getParent().requestDisallowInterceptTouchEvent(true);
            super.onTouchEvent(ev); //注意这句不能 return super.onTouchEvent(arg0); 否则触发parent滑动
            return true;
        }
        //
        return super.onTouchEvent(ev);
    }
}
