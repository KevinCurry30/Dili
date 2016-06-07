package com.DiliGruop.other;

import android.content.Context;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.DiliGruop.R;
import com.DiliGruop.bean.AD_Banner;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyFrameLayout extends FrameLayout {
    private ViewPager adViewPager;
    private List<ImageView> imageViews;// 滑动的图片集合

    private List<View> dots; // 图片标题正文的那些点
    private List<View> dotList;

    private int currentItem = 0; // 当前图片的索引号
    // 定义的五个指示点
    private View dot0;
    private View dot1;
    private View dot2;
    private View dot3;
    private View dot4;
    View view;
    private ScheduledExecutorService scheduledExecutorService;
    Context context;
    // 轮播banner的数据
    private static List<AD_Banner> ADLIST;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            adViewPager.setCurrentItem(currentItem);
        }

        ;
    };

    public MyFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initUi(context);
        initData();
        startAd();
    }

    private void startAd() {
        // TODO Auto-generated method stub
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 当Activity显示出来后，每两秒切换一次图片显示
        scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2,
                TimeUnit.SECONDS);
    }

    private class ScrollTask implements Runnable {

        @Override
        public void run() {
            synchronized (adViewPager) {
                currentItem = (currentItem + 1) % imageViews.size();
                handler.obtainMessage().sendToTarget();
            }
        }
    }

    private void initUi(Context context) {
//        this.removeAllViews();
        view = LayoutInflater.from(context).inflate(R.layout.banner, null);
        this.addView(view);
        this.invalidate();
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    }

    private void initData() {
        ADLIST = new ArrayList<>();
        AD_Banner banner1 = new AD_Banner();
        banner1.setUrl("http://img4.imgtn.bdimg.com/it/u=3107613829,3873828763&fm=21&gp=0.jpg");
        ADLIST.add(banner1);
        AD_Banner banner2 = new AD_Banner();
        banner2.setUrl("http://img.taopic.com/uploads/allimg/110727/1819-110HG6064035.jpg");
        ADLIST.add(banner2);
        AD_Banner banner3 = new AD_Banner();
        banner3.setUrl("http://pic10.nipic.com/20101103/5063545_000227976000_2.jpg");
        ADLIST.add(banner3);
        AD_Banner banner4 = new AD_Banner();
        banner4.setUrl("http://img3.imgtn.bdimg.com/it/u=2883277031,2810817002&fm=21&gp=0.jpg");
        ADLIST.add(banner4);
        imageViews = new ArrayList<>();
        // 点
        dots = new ArrayList<>();
        dotList = new ArrayList<>();
        dot0 = view.findViewById(R.id.v_dot0);
        dot1 = view.findViewById(R.id.v_dot1);
        dot2 = view.findViewById(R.id.v_dot2);
        dot3 = view.findViewById(R.id.v_dot3);
        dot4 = view.findViewById(R.id.v_dot4);
        dots.add(dot0);
        dots.add(dot1);
        dots.add(dot2);
        dots.add(dot3);
        dots.add(dot4);

        adViewPager = (ViewPager) findViewById(R.id.vp);
        addDynamicView();
        adViewPager.setAdapter(new MyAdapter());// 设置填充ViewPager页面的适配器
        // 设置一个监听器，当ViewPager中的页面改变时调用
        adViewPager.addOnPageChangeListener(new MyPageChangeListener());
        addDynamicView();
    }

    private void addDynamicView() {
        // 动态添加图片和下面指示的圆点
        // 初始化图片资源
        for (int i = 0; i < ADLIST.size(); i++) {
            ImageView imageView = new ImageView(context);
            // 异步加载图片
//			mImageLoader.displayImage(adList.get(i).getImgUrl(), imageView,
//					options);
            Glide.with(context).load(ADLIST.get(i).getUrl()).error(R.drawable.appmain_subject_1).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(imageView);
            dots.get(i).setVisibility(View.VISIBLE);
            dotList.add(dots.get(i));
        }
    }

    private class MyPageChangeListener implements OnPageChangeListener {

        private int oldPosition = 0;

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {
            currentItem = position;
//			AdDomain adDomain = adList.get(position);
//			tv_title.setText(adDomain.getTitle()); // 设置标题
//			tv_date.setText(adDomain.getDate());
//			tv_topic_from.setText(adDomain.getTopicFrom());
//			tv_topic.setText(adDomain.getTopic());
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(position).setBackgroundResource(R.drawable.dot_focused);
            oldPosition = position;
        }
    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return ADLIST.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = imageViews.get(position);
            (container).addView(iv);
//			final AD_Banner adDomain = adList.get(position);
            // 在这个方法里面设置图片的点击事件
            iv.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // 处理跳转逻辑
                }
            });
            return iv;
        }


        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

        @Override
        public void finishUpdate(View arg0) {

        }


    }


}
