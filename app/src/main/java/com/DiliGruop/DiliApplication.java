package com.DiliGruop;

import android.app.Application;
import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;

/**
 * 进行一些 数据和第三方的初始化
 * Created by Kevin on 2016/5/6.
 */
public class DiliApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        // 初始化数据库

        //设置自签名证书
        OkHttpUtils.getInstance().setCertificates();
        // OkHttpUtils.getInstance().set
        //
        //  OkHttpUtils.getInstance().debug("").setConnectTimeout(100000, TimeUnit.MILLISECONDS);
        //使用这种方式，设置多个OkHttpClient参数
        //   OkHttpClient.Builder client=new OkHttpClient.Builder();
        // OkHttpClient.Builder builder = client.addInterceptor(new Interceptor.Chain().);
        //client.connectTimeoutMillis();
        //OkHttpUtils.getInstance(new OkHttpClient.Builder().dispatcher(new Dispatcher()).build());
        //  OkHttpUtils.getInstance(new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).build());

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
