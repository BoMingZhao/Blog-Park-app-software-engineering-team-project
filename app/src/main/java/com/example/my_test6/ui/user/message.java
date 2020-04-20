package com.example.my_test6.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import com.example.my_test6.R;
import com.example.my_test6.ui.user.ItemBean.ItemMessage;
import com.example.my_test6.ui.user.ListAdapters.MessageAdapter;

import java.util.ArrayList;

public class message extends AppCompatActivity {
    private RecyclerView messageList;
    private ArrayList<ItemMessage> data;
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        messageList = findViewById(R.id.MessageRecyclerView);
        setTitle("消息中心");
        initData();
        initListener();
    }

    private void initListener() {
        adapter.setOnItemClickListener(new MessageAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                //处理点击事件
                Intent intent = new Intent();
                ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.Item_web");
                intent.setComponent(componentname);
                ItemMessage h = data.get(position);
                intent.putExtra("url",h.url);
                intent.putExtra("title",h.title);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        data = new ArrayList<>();

        for(int i = 0;i <= 3; i++){
            ItemMessage item = new ItemMessage();
            item.title = "系统通知";
            item.Abstract = "RE：博客园博客申请通知";
            item.time = "2020年4月20日";
            if(i == 0){
                item.url = "https://www.cnblogs.com/team-pakchoi/p/12679258.html";
            }
            else {
                item.url = "https://www.cnblogs.com/team-pakchoi/p/12679181.html";
            }
            data.add(item);
        }
        //设置RecyclerView样式(布局管理器)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        messageList.setLayoutManager(layoutManager);
        //创建适配器
        adapter = new MessageAdapter(data);
        //设置到RecyclerView中
        messageList.setAdapter(adapter);
    }
}
