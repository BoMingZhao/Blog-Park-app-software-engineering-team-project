package com.example.my_test6.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import com.example.my_test6.R;
import com.example.my_test6.ui.user.ItemBean.ItemHomework;
import com.example.my_test6.ui.user.ListAdapters.HomeworkAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class myhomework extends AppCompatActivity {
    private RecyclerView homeworkList;
    private ArrayList<ItemHomework> data;
    private HomeworkAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhomework);
        homeworkList = findViewById(R.id.HomeworkRecyclerView);
        setTitle("我的作业");
        initData();
        initListener();
    }

    private void initListener() {
        adapter.setOnItemClickListener(new HomeworkAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                //处理点击事件
                Intent intent = new Intent();
                ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.Item_web");
                intent.setComponent(componentname);
                ItemHomework h = data.get(position);
                intent.putExtra("url",h.url);
                intent.putExtra("title",h.title);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        data = new ArrayList<>();

        for(int i = 0;i <= 15; i++){
            ItemHomework item = new ItemHomework();
            item.title = "Scrum Meeting " + i;
            item.Abstract = "这些都是模拟数据";
            item.author = "软工小白菜 ";
            item.comment = "提交：" + i;
            item.time = "2020年4月19日-2020年4月24日";
            if(i == 0){
                item.url = "https://www.cnblogs.com/team-pakchoi/p/12679258.html";
                item.src = 1;
            }
            else {
                item.url = "https://www.cnblogs.com/team-pakchoi/p/12679181.html";
                item.src = 0;
            }
            data.add(item);
        }
        //设置RecyclerView样式(布局管理器)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        homeworkList.setLayoutManager(layoutManager);
        //创建适配器
        adapter = new HomeworkAdapter(data);
        //设置到RecyclerView中
        homeworkList.setAdapter(adapter);
    }
}
