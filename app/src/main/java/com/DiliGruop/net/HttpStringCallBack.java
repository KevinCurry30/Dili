package com.DiliGruop.net;

import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by Kevin on 2016/5/6.
 */
public  class HttpStringCallBack extends StringCallback {
    @Override
    public void onBefore(Request request) {
        super.onBefore(request);
    }

    @Override
    public void onError(Call call, Exception e) {

    }

    @Override
    public void onResponse(String response) {

    }

    @Override
    public void onAfter() {
        super.onAfter();
    }

    @Override
    public void inProgress(float progress) {
        super.inProgress(progress);
    }
}
