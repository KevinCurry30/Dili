package com.DiliGruop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.DiliGruop.R;

/**
 * Created by Kevin on 2016/5/13.
 */
public class Fragment_ChuanCai extends Fragment {
    View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.classify_fragment, null, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_name);

        textView.setText("CHUAN CAI ");
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
