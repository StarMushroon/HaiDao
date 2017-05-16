package com.jane.haidao;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.jane.common.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.bottomBar_activity_main)
    BottomNavigationBar mNavigationBar;

    private FragmentIndex mFragmentIndex;
    private FragmentType mFragmentType;
    private FragmentStores mFragmentStores;
    private FragmentCart mFragmentCart;
    private FragmentMy mFragmentMy;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        initBottomBar();
    }

    private void initBottomBar() {

        mNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.tab_index_hit, "首页").setInactiveIconResource(R.mipmap.tab_index_normal))
                .addItem(new BottomNavigationItem(R.mipmap.tab_type_new_hit, "分类").setInactiveIconResource(R.mipmap.tab_type_new_normal))
                .addItem(new BottomNavigationItem(R.mipmap.tab_stores_hit, "实体店").setInactiveIconResource(R.mipmap.tab_stores_normal))
                .addItem(new BottomNavigationItem(R.mipmap.tab_cart_hit, "购物车").setInactiveIconResource(R.mipmap.tab_cart_normal))
                .addItem(new BottomNavigationItem(R.mipmap.tab_my_hit, "我的").setInactiveIconResource(R.mipmap.tab_my_normal))

                /*MODE_FIXED 填充模式，未选中的Item会显示文字，没有换挡动画。
                  MODE_SHIFTING 换挡模式，未选中的Item不会显示文字，选中的会显示文字。在切换的时候会有一个像换挡的动画*/
                .setMode(BottomNavigationBar.MODE_SHIFTING)

                /*BACKGROUND_STYLE_DEFAULT
                        如果Mode为MODE_FIXED，  将使用BACKGROUND_STYLE_STATIC 。
                        如果Mode为MODE_SHIFTING 将使用BACKGROUND_STYLE_RIPPLE。
                 BACKGROUND_STYLE_STATIC  点击的时候没有水波纹效果
                 BACKGROUND_STYLE_RIPPLE  点击的时候有水波纹效果*/
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)

                /*在BACKGROUND_STYLE_STATIC下，表示整个容器的背景色。
                而在BACKGROUND_STYLE_RIPPLE下，表示选中Item的图标和文本颜色。默认 Color.WHITE*/
                .setBarBackgroundColor(R.color.colorWrite)

                /*在BACKGROUND_STYLE_STATIC下，表示选中Item的图标和文本颜色。
                而在BACKGROUND_STYLE_RIPPLE下，表示整个容器的背景色。默认Theme's Primary Color*/
                .setActiveColor(R.color.colorBlue)

                /*表示未选中Item中的图标和文本颜色。默认为 Color.LTGRAY*/
                .setInActiveColor(R.color.colorBlack)
                .setFirstSelectedPosition(0)//设置默认选择item
                .initialise();//初始化

        mNavigationBar.setTabSelectedListener(this);

        mFragmentIndex = new FragmentIndex();
        getSupportFragmentManager().beginTransaction().replace(R.id.ll_activity_main, mFragmentIndex).commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (mFragmentIndex == null) {
                    mFragmentIndex = new FragmentIndex();
                }
                transaction.replace(R.id.ll_activity_main, mFragmentIndex);
                break;
            case 1:
                if (mFragmentType == null) {
                    mFragmentType = new FragmentType();
                }
                transaction.replace(R.id.ll_activity_main, mFragmentType);
                break;
            case 2:
                if (mFragmentStores == null) {
                    mFragmentStores = new FragmentStores();
                }
                transaction.replace(R.id.ll_activity_main, mFragmentStores);
                break;
            case 3:
                if (mFragmentCart == null) {
                    mFragmentCart = new FragmentCart();
                }
                transaction.replace(R.id.ll_activity_main, mFragmentCart);
                break;
            case 4:
                if (mFragmentMy == null) {
                    mFragmentMy = new FragmentMy();
                }
                transaction.replace(R.id.ll_activity_main, mFragmentMy);
                break;

          /*  default:
                if (mFragmentOne == null) {
                    mFragmentOne = FragmentOne.newInstance("First Fragment");
                }
                transaction.replace(R.id.ll_activity_main, mFragmentOne);
                break;*/
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
