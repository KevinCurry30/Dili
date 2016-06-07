package com.DiliGruop.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.DiliGruop.R;
import com.DiliGruop.adapter.RecycleViewAdapter;
import com.DiliGruop.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐Fragment
 * Created by Kevin on 2016/5/11.
 */
public class RecommendFragment extends Fragment implements RecycleViewAdapter.OnItemClickListener {

    RecyclerView recyclerView;
    View view;
    RecycleViewAdapter mAdapter;
    List<String> urls;
    Context mContext;
    SwipeRefreshLayout swipeRefreshLayout;
    private Handler handler = new Handler();
    boolean isLoading;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        urls = new ArrayList<>();
        urls.add("http://img3.3lian.com/2013/v8/72/d/61.jpg");
        urls.add("http://img4.imgtn.bdimg.com/it/u=1296702992,1090972040&fm=21&gp=0.jpg");
        urls.add("http://www.shifenkafei.com/data/upload/553deb1621af2.jpg");
        urls.add("http://img5.xiawu.com/xiawu-img/58/ZlYbEbzoEN_1338822517_210.jpg");
        urls.add("http://img1.gamersky.com/image2014/06/20140627tqy_2/gamersky_01small_02_20146271915C4C.jpg");
        urls.add("http://cww.181010.com/uploads/allimg/150330/3-150330094Z1V7.jpg");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.push_fragment, null);
        view=inflater.inflate(R.layout.push_fragment,null);
//        ButterKnife.bind(this, view);
        initWidget();
        initData();
        return view;

    }

    public void initData() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        }, 1500);

    }

    private void initWidget() {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.SwipeRefreshLayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.recy_listview);
        mAdapter = new RecycleViewAdapter(mContext, urls);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setItemClickListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.blueStatus);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        urls.clear();
                        getData();
                    }
                }, 1500);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d("test", "StateChanged = " + newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d("test", "onScrolled");

                int lastVisibleItemPosition = new LinearLayoutManager(mContext).findLastVisibleItemPosition();
                if (lastVisibleItemPosition + 1 == mAdapter.getItemCount()) {
                    Log.d("test", "loading executed");
                    boolean isRefreshing = swipeRefreshLayout.isRefreshing();
                    if (isRefreshing) {
                        mAdapter.notifyItemRemoved(mAdapter.getItemCount());
                        return;
                    }
                    if (!isLoading) {
                        isLoading = true;
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                getData();
                                Log.d("test", "load more completed");
                                isLoading = false;
                            }
                        }, 1000);
                    }
                }
            }
        });
    }

    /**
     * 获取测试数据
     */
    private void getData() {
        for (int i = 0; i < 6; i++) {
//            Map<String, Object> map = new HashMap<>();
            String url = "http://img5q.duitang.com/uploads/item/201505/01/20150501193016_4zhVm.jpeg";
            String url2 = "http://ww2.sinaimg.cn/crop.0.0.1080.1080.1024/a1e54d0bjw8encfl7hv68j20u00u0jt6.jpg";
            urls.add(url);
            urls.add(url2);
        }
        mAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
        mAdapter.notifyItemRemoved(mAdapter.getItemCount());
    }

    @Override
    public void onItemClicked(View view, int position) {
        ToastUtil.showShort(mContext, "Item_Clicked");
    }

    @Override
    public void onItemLongClicked(View view, int position) {
        ToastUtil.showShort(mContext, "Item_Long_Clicked");
    }
}
