package com.jane.mybasis.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by StarMushroom on 2017/5/13.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, view);
        init(view);
        return view;
    }

    //获取布局文件
    public abstract int getLayoutResId();

     // 进行初始化操作
    public abstract void init(View view);
}
