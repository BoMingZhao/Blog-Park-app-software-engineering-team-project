package com.example.my_test6.ui.user;

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
public class FinishHomeworkFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ItemHomework> mdata;
    private HomeworkAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_finishhomework, container, false);
        recyclerView = root.findViewById(R.id.FragementRecyclerview1);
        initData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new HomeworkAdapter(mdata);
        recyclerView.setAdapter(mAdapter);
        return root;
    }

    private void initData() {
        mdata = new ArrayList<>();

        for(int i = 0;i <= 7; i++){
            ItemHomework item = new ItemHomework();
            item.title = "Scrum Meeting " + i;
            item.Abstract = "这些都是模拟数据";
            item.author = "软工小白菜 ";
            item.comment = "提交：" + i;
            item.time = "2020年4月19日-2020年4月24日";
            item.src = 0;
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
}
