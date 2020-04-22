package com.example.my_test6.ui.user;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my_test6.R;
import com.example.my_test6.ui.user.ItemBean.ItemHomework;
import com.example.my_test6.ui.user.ListAdapters.HomeworkAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotFinishHomeworkFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ItemHomework> mdata;
    private HomeworkAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_notfinishhomework, container, false);
        recyclerView = root.findViewById(R.id.FragementRecyclerview2);
        initData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new HomeworkAdapter(mdata);
        recyclerView.setAdapter(mAdapter);
        initListener();
        return root;
    }

    private void initData() {
        mdata = new ArrayList<>();

        for(int i = 0;i <= -1; i++){
            ItemHomework item = new ItemHomework();
            item.title = "Scrum Meeting " + i;
            item.Abstract = "这些都是模拟数据";
            item.author = "软工小白菜 ";
            item.comment = "提交：" + i;
            item.time = "2020年4月19日-2020年4月24日";
            item.src = 1;
            if(i == 0){
                item.url = "https://www.cnblogs.com/team-pakchoi/p/12679258.html";
            }
            else {
                item.url = "https://www.cnblogs.com/team-pakchoi/p/12679181.html";
            }
            mdata.add(item);
        }
        //设置RecyclerView样式(布局管理器)
        //创建适配器
        //设置到RecyclerView中
    }

    private void initListener() {
        mAdapter.setOnItemClickListener(new HomeworkAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                //处理点击事件
                Intent intent = new Intent();
                ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.Item_web");
                intent.setComponent(componentname);
                ItemHomework h = mdata.get(position);
                intent.putExtra("url",h.url);
                intent.putExtra("title",h.title);
                startActivity(intent);
            }
        });
    }
}
