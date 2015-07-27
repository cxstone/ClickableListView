package com.github.stone.clickablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/7/27.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Bean> datas;

    public MyAdapter(Context context, List<Bean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Bean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_list, parent,
                    false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        TextView textView = (TextView) convertView.findViewById(R.id.text);

        Bean bean = this.getItem(position);
        if (bean.isSelected) {
            imageView.setBackgroundResource(R.mipmap.select);
        } else {
            imageView.setBackgroundResource(R.mipmap.normal);
        }
        textView.setText(bean.name == null ? "" : bean.name);
        return convertView;
    }
}
