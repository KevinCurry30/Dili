package com.DiliGruop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.DiliGruop.fragment.ClassifyFragment;
import com.DiliGruop.fragment.RecommendFragment;
import com.DiliGruop.fragment.UserFragment;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    //    @Bind(R.id.tv_name)
//    TextView tv_name;
//    @Bind(R.id.iv_show)
//    ImageView iv_show;
//    @Bind(R.id.bt_getdata)
//    Button bt_get;
    @Bind(R.id.content_viewpager)
    ViewPager content_pager;
    @Bind(R.id.rb_push)
    RadioButton rb_push;
    @Bind(R.id.rb_fenlei)
    RadioButton rb_fenlei;
    @Bind(R.id.rb_user)
    RadioButton rb_user;
    @Bind(R.id.rg_bottom)
    RadioGroup rg_bottom;

    //
    RecommendFragment recommen_fragment;
    UserFragment user_fragment;
    ClassifyFragment class_fragment;
    //

    ArrayList<Fragment> fragment_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recommen_fragment = new RecommendFragment();
        user_fragment = new UserFragment();
        class_fragment = new ClassifyFragment();
        fragment_list = new ArrayList<>();
        fragment_list.add(recommen_fragment);
        fragment_list.add(class_fragment);
        fragment_list.add(user_fragment);
        content_pager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));

        // Glide.with(this).load("http://www.haotm.cn/UpLoadPics/xgt/7493635.jpg").into(iv_show);
//        OkHttpUtils.get()
//                .url("http://images.csdn.net/20150817/1.jpg")
//                .tag(this)
//                .build()//
//                .connTimeOut(20000)
//                .readTimeOut(20000)
//                .writeTimeOut(20000)
//                .execute(new BitmapCallback() {
//                    @Override
//                    public void onError(Call call, Exception e) {
//                        tv_name.setText("onError"+e.getMessage());
//                    }
//
//                    @Override
//                    public void onResponse(Bitmap response) {
//                        Log.e("TAG","onResponse：complete");
//                        iv_show.setImageBitmap(response);
//                        tv_name.setText("ok_success");
//                    }
//                });
    }


    @OnClick(R.id.rb_push)
    public void clickPush() {
        content_pager.setCurrentItem(0);
//        recommen_fragment = new RecommendFragment();
//        trancsaction.replace(R.id.content_viewpager, recommen_fragment);
//        trancsaction.commit();
    }

    @OnClick(R.id.rb_fenlei)
    public void clickFenLei() {
        content_pager.setCurrentItem(1);

//        class_fragment = new ClassifyFragment();
//        trancsaction.replace(R.id.content_viewpager, class_fragment);
//        trancsaction.commit();
    }

    @OnClick(R.id.rb_user)
    public void clickUser() {
        content_pager.setCurrentItem(2);

//        user_fragment = new UserFragment();
//        trancsaction.replace(R.id.content_viewpager, user_fragment);
//        trancsaction.commit();
    }


    public class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int arg0) {
            return fragment_list.get(arg0);
        }

        @Override
        public int getCount() {
            return fragment_list.size();
        }

//        @Override
//        public CharSequence getPageTitle(int position) {
//            // TODO Auto-generated method stub
//            return titleList.get(position);
//        }


    }


    //    @OnClick(R.id.bt_getdata)
//    public void getData(View v) {
//        //
//        Toast.makeText(this, "click_it",Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(this, DBTestActivity.class));
//    }
//
    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(this);
    }

    private long timeMillis;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - timeMillis) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                timeMillis = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
