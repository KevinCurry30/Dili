package com.DiliGruop.net;

import com.DiliGruop.bean.User;
import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;


/**
 * Created by Kevin on 2016/5/6.
 * User  数据回调接口;
 */
public abstract class UserCallback extends Callback<User> {
    @Override
    public User parseNetworkResponse(Response response) throws Exception {
        String string = response.body().string();
        User user = new Gson().fromJson(string, User.class);
        return user;
    }
}