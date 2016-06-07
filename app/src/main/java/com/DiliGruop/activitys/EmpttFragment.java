package com.DiliGruop.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.DiliGruop.R;

/**
 * Created by Kevin on 2016/5/5.
 */
public class EmpttFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_entry,null);
        view.findViewById(R.id.btn_entry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WelcomeActivity  activity= (WelcomeActivity) getActivity();
                activity.entryApp();

            }
        });

        return view;
    }
}
