package com.DiliGruop.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

/**
 * BaseActivity
 * Created by Kevin on 2016/5/11.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }
    /**
     *
     * @Description:关闭软键盘
     *
     */
    public void closeSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && this.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
