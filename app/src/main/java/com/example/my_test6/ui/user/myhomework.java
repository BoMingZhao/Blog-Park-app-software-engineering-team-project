package com.example.my_test6.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.my_test6.R;
import com.example.my_test6.ui.user.ItemBean.ItemHomework;
import com.example.my_test6.ui.user.ListAdapters.HomeworkAdapter;

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
        adapter.setOnItemClickListener();
    }

    private void initData() {
        data = new ArrayList<>();

        for(int i = 0;i <= 15; i++){
            ItemHomework item = new ItemHomework();
            item.title = "Scrum Meeting " + i;
            item.Abstract = "这些都是模拟数据";
            item.author = "软工小白菜 2020年4月19日";
            item.comment = "评论：" + i;
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
