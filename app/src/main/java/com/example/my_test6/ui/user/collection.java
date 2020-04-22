package com.example.my_test6.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import com.example.my_test6.R;
import com.example.my_test6.ui.user.ItemBean.ItemCollection;
import com.example.my_test6.ui.user.ListAdapters.MyCollectionAdapter;

import java.util.ArrayList;

public class collection extends AppCompatActivity {
    private RecyclerView myCollectionList;
    private ArrayList<ItemCollection> data;
    private MyCollectionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        myCollectionList = findViewById(R.id.CollectionRecyclerView);
        setTitle("我的收藏");
        initData();
        initListener();
    }

    private void initListener() {
        adapter.setOnItemClickListener(new MyCollectionAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                //处理点击事件
                Intent intent = new Intent();
                ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.Item_web");
                intent.setComponent(componentname);
                ItemCollection h = data.get(position);
                intent.putExtra("url",h.url);
                intent.putExtra("title",h.title);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        data = new ArrayList<>();

        for(int i = 0;i <= -1; i++){
            ItemCollection item = new ItemCollection();
            item.title = "Scrum Meeting " + i;
            item.Abstract = "这些都是模拟数据";
            item.author = "软工小白菜 ";
            item.comment = "评论：" + i;
            item.time = "2020年4月19日";
            if(i == 0)
                item.url = "https://www.cnblogs.com/team-pakchoi/p/12679258.html";
            else
                item.url = "https://www.cnblogs.com/team-pakchoi/p/12679181.html";
            data.add(item);
        }
        //设置RecyclerView样式(布局管理器)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myCollectionList.setLayoutManager(layoutManager);
        //创建适配器
        adapter = new MyCollectionAdapter(data);
        //设置到RecyclerView中
        myCollectionList.setAdapter(adapter);
    }
}
