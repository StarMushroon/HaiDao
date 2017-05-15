package com.jane.mybasis.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import butterknife.ButterKnife;

/**
 * Created by StarMushroom on 2017/5/12.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetcontentView();
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        init();
    }

    private void doBeforeSetcontentView() {

        //设置无标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
     //   setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    //获取布局文件
    public abstract int getLayoutResId();

    //初始化操作
    public abstract void init();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
