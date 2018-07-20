package com.wy.fragmenttabhosttwoimplementions.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wy.fragmenttabhosttwoimplementions.R;

/**
 * 订单
 */

public class OrderTabFragment extends Fragment {

    private Context context;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        if (view == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                view = View.inflate(context, R.layout.fragment_tab_order_v19, null);
            } else {
                view = View.inflate(context, R.layout.fragment_tab_order, null);
            }
        }
        return view;
    }
}
