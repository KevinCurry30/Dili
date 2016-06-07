package com.DiliGruop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.DiliGruop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜品分类Fragment
 * Created by Kevin on 2016/5/11.
 */
public class ClassifyFragment extends Fragment {
    View view;
    ViewPager fenlei_pager;
    RadioGroup radioGroup;
    List<Fragment> fragment_list;
    Fragment_ChuanCai chuanFragment;
    Fragment_LuCai luFragment;
    Fragment_SuCai suFragment;
    Fragment_XiangCai xiangFragment;
    Fragment_ZheCai zheFragment;
    Fragment_YueCai yueFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        fragment_list = new ArrayList<>();
        chuanFragment = new Fragment_ChuanCai();
        luFragment = new Fragment_LuCai();
        zheFragment = new Fragment_ZheCai();
        yueFragment = new Fragment_YueCai();
        suFragment = new Fragment_SuCai();
        xiangFragment = new Fragment_XiangCai();
        fragment_list.add(chuanFragment);
        fragment_list.add(luFragment);
        fragment_list.add(zheFragment);
        fragment_list.add(yueFragment);
        fragment_list.add(suFragment);
        fragment_list.add(xiangFragment);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.class_fragment, null);
        fenlei_pager = (ViewPager) view.findViewById(R.id.fenlei_viewpager);
        radioGroup = (RadioGroup) view.findViewById(R.id.fenlei_radiogroup);
        final HorizontalScrollView daohangview = (HorizontalScrollView) view.findViewById(R.id.class_scroll);
        classFragmentAdapter  adapter =new classFragmentAdapter(getActivity().getSupportFragmentManager());
        fenlei_pager.setAdapter(adapter);
        fenlei_pager.setOffscreenPageLimit(2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ScaleAnimation sAnim = new ScaleAnimation(1, 1.1f, 1, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                sAnim.setDuration(500);
                sAnim.setFillAfter(true);
                for (int i = 0; i < group.getChildCount(); i++) {
                    RadioButton radioBtn = (RadioButton) group.getChildAt(i);
                    if (radioBtn.isChecked()) {
                        radioBtn.startAnimation(sAnim);
                    } else {
                        radioBtn.clearAnimation();
                    }
                }
                switch (view.getId()) {
                    case R.id.xinwen_rb1:
                        fenlei_pager.setCurrentItem(0);
                        break;
                    case R.id.xinwen_rb2:
                        fenlei_pager.setCurrentItem(1);
                        break;
                    case R.id.xinwen_rb3:
                        fenlei_pager.setCurrentItem(2);
                        break;
                    case R.id.xinwen_rb4:
                        fenlei_pager.setCurrentItem(3);
                        break;
                    case R.id.xinwen_rb5:
                        fenlei_pager.setCurrentItem(4);
                        break;
                    case R.id.xinwen_rb6:
                        fenlei_pager.setCurrentItem(5);
                        break;

                }
            }
        });
        fenlei_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // 获取对应位置的RadioButton
                RadioButton radioBtn = (RadioButton) radioGroup.getChildAt(position);
                // 设置对应位置的RadioButton为选中的状态
                radioBtn.setChecked(true);
                /* 滚动HorizontalScrollView使选中的RadioButton处于屏幕中间位置 */
                //获取屏幕信息
                DisplayMetrics outMetrics = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
                //获取每一个RadioButton的宽度
                int radioBtnPiexls = radioBtn.getWidth();
                //计算滚动距离
                int distance = (int) ((position + 0.5) * radioBtnPiexls - outMetrics.widthPixels / 2);
                //滚动
                daohangview.scrollTo(distance, 0);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    //分类 fragment 适配器
    class classFragmentAdapter extends FragmentPagerAdapter {

        public classFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragment_list.get(position);
        }

        @Override
        public int getCount() {
            return fragment_list.size();
        }
    }
}
