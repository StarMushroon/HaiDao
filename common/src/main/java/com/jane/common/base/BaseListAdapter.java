package com.jane.common.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;


/**
 * Created by StarMushroom on 2017/5/13.
 */

public abstract class BaseListAdapter<T> extends BaseAdapter {

    private ArrayList<T> mList;

    public BaseListAdapter(ArrayList<T> list) {
        mList = list;
    }

    @Override
    public int getCount() {
        return mList!=null?mList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);

}
