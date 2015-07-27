package com.github.stone.clickablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private MyAdapter adapter;
    private List<Bean> datas = new ArrayList<>();

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        datas = getData();
        adapter = new MyAdapter(this, datas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        singleChangeState(position);
        multipleChangeState(position);
    }

    //单选处理
    private void singleChangeState(int position) {
        if (datas.get(position).isSelected) {
            datas.get(position).isSelected = false;
        } else {
            datas.get(position).isSelected = true;
        }
        adapter.notifyDataSetChanged();
    }

    //多选处理
    private void multipleChangeState(int position) {
        for (int i = 0; i < datas.size(); i++) {
            if (i == position) {
                datas.get(i).isSelected = true;
            } else {
                datas.get(i).isSelected = false;
            }
        }
        adapter.notifyDataSetChanged();
    }

    //初始化ListView的数据
    private List<Bean> getData() {
        List<Bean> beans = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Bean bean = new Bean();
            bean.name = "name - " + i;
            beans.add(bean);
        }
        return beans;
    }
}
