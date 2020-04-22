package com.example.my_test6.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import com.example.my_test6.R;
import com.example.my_test6.ui.user.ItemBean.ItemMyBlog;
import com.example.my_test6.ui.user.ListAdapters.MyBlogAdapter;

import java.util.ArrayList;

public class myblog extends AppCompatActivity {
    private RecyclerView myBlogList;
    private ArrayList<ItemMyBlog> data;
    private MyBlogAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myblog);
        myBlogList = findViewById(R.id.MyBlogRecyclerView);
        setTitle("我的博客");
        initData();
        initListener();
    }
    private void initListener() {
        adapter.setOnItemClickListener(new MyBlogAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                //处理点击事件
                Intent intent = new Intent();
                ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.Item_web");
                intent.setComponent(componentname);
                ItemMyBlog h = data.get(position);
                intent.putExtra("url",h.url);
                intent.putExtra("title",h.title);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        data = new ArrayList<>();

        for(int i = 10;i >= 0; i--){
            ItemMyBlog item = new ItemMyBlog();
            if(i <= 2){
                item.title = "Scrum Meeting " + (i+1);
            }
            else {
                item.title = "Scrum Meeting " + i;
            }
            item.author = "软工小白菜 ";
            item.comment = "评论：" + 0;
            int d = 0;
            if(i > 5 && i <= 8){
                d = 12 + i;
            }
            else if(i <=  5){
                d = 10 + i;
            }
            else if(i > 8){
                d = 13 + i;
            }
            item.time = "2020年4月" + d +"日";
            switch (i){
                case 10:
                    item.url = "https://www.cnblogs.com/team-pakchoi/p/12753805.html";
                    item.Abstract = "【软工小白菜】Scrum Meeting 8 2020/4/20 一、会议内容 1.工作及计划 | 组员代号 | 完成的工作 | 明日计划 | | | | | | 炎龙 | 1、整合整个程序 | | | 风鹰 |1、整合整个程序 || | 黑犀 ";
                    break;
                case 9:
                    item.url = "https://www.cnblogs.com/team-pakchoi/p/12752739.html";
                    item.Abstract = "【软工小白菜】Scrum Meeting 9 2020/4/22 一、会议内容 1.工作及计划 | 组员代号 | 完成的工作 | 明日计划 | | | | | | 炎龙 | 1、完成了首页的全部内容 |1、整合整个程序 | | 风鹰 |1、 |1、整合整个程序 | | 黑犀 | 1、完成了\"我的\"部";
                    break;
                case 8:
                    item.url = "https://www.cnblogs.com/team-pakchoi/p/12736897.html";
                    item.Abstract = "【软工小白菜】Scrum Meeting 8 2020/4/20 一、会议内容 1.工作及计划 | 组员代号 | 完成的工作 | 明日计划 | | | | | | 炎龙 | 1、优化了首页的UI |1、研究登录功能 | | 风鹰 |1、研究了一部分API调用的方法 |1、研究登录功能 | | 黑犀";
                    break;
                case 7:
                    item.url = "https://www.cnblogs.com/team-pakchoi/p/12723564.html";
                    item.Abstract = "【软工小白菜】Scrum Meeting 7 2020/4/19 一、会议内容 1.工作及计划 | 组员代号 | 完成的工作 | 明日计划 | | | | | | 炎龙 | 1、完成了博文列表及正文的显示工作2、封装了API的调用 | 1、完成搜索功能 | | 风鹰 | 1、完成了班级部分的所有UI";
                    break;
                case 6:
                    item.url = "https://www.cnblogs.com/team-pakchoi/p/12711537.html";
                    item.Abstract = "【软工小白菜】Scrum Meeting 6 2020/4/17 一、会议内容 1.工作及计划 | 组员代号 | 完成的工作 | 明日计划(到4月19日晚上) | | | | | | 炎龙 | 1、成功调用了API2、开始着手封装调用API成类，这样以后再调用API不需要自己实现，只需调用类的方法即";
                    break;
                case 5:
                    item.url = "https://www.cnblogs.com/team-pakchoi/p/12708233.html";
                    item.Abstract = "【软工小白菜】Scrum Meeting 5 2020/4/15 一、会议内容 1.工作及计划 由于今天我们组三位同学下午要进行计算机网络实验，因此今日进度较慢 | 组员代号 | 完成的工作 | 明日计划 | | | | | | 炎龙 | 1、查阅了很多有关API调用的资料，对API调用问题有了初步";
                    break;
                case 4:
                    item.url = "https://www.cnblogs.com/team-pakchoi/p/12694684.html";
                    item.Abstract = "【软工小白菜】Scrum Meeting 3 2020/4/14 一、会议内容 1.工作及计划 | 组员代号 | 完成的工作 | 明日计划 | | | | | | 炎龙 | 1、完成了整体activity框架的构建 | 1、开发首页的搜索功能2、研究API的调用问题 | | 风鹰 | 1、配置act";
                    break;
                case 3:
                    item.url = "https://www.cnblogs.com/team-pakchoi/p/12701318.html";
                    item.Abstract = "团队贡献分分配规则 | 项目 | 内容 | | | | | 班级：2020春季计算机学院软件工程(罗杰 任健) | \"博客园班级博客\" | | 作业：团队任务拆解 | \"团队贡献分分配规则\" | | 我们在这个课程中的目标 | 写出令客户和自己都满意的代码同时变得更强 | | 这个作业对我们实现目标";
                    item.time = "2020年4月14日";
                    item.title = "团队贡献分分配规则";
                    break;
                case 2:
                    item.time = "2020年4月13日";
                    item.url = "https://www.cnblogs.com/team-pakchoi/p/12694623.html";
                    item.Abstract = "摘要：【软工小白菜】Scrum Meeting 3 2020/4/13 一、会议内容 1.工作及计划 | 组员代号 | 完成的工作 | 明日计划 | | | | | | 炎龙 | 1、开始着手于整体activity框架的编写2、基本完成所需知识的学习3、调研了市场环境，确定安卓的开发版本为9.0 | 1、";
                    break;
                case 1:
                    item.time = "2020年4月13日";
                    item.url = "https://www.cnblogs.com/team-pakchoi/p/12679944.html";
                    item.Abstract = "【软工小白菜】Scrum Meeting 2 2020/4/12 一、会议内容 1.工作及计划 | 组员代号 | 完成的工作 | 明日计划 | | | | | | 炎龙 | 1、android studio的配置2、开始学习android开发的内容 | 1、完成相关知识的学习2、开始着手于前端的开发";
                    break;
                case 0:
                    item.time = "2020年4月11日";
                    item.url = "Scrum Meeting 1";
                    item.Abstract = "【软工小白菜】Scrum Meeting 1 一、会议内容 这是本周第一次会议，大家主要讨论了团队任务如何查分，同时将任务分配到个人，设置了每个任务的ddl如下： | | 首页 | 动态 | 博问 | 班级 | 我的 | 组会 | 测试 | | | | | | | | | | | 4月12日 | 环";
                    break;
            }
            data.add(item);
        }
        //设置RecyclerView样式(布局管理器)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myBlogList.setLayoutManager(layoutManager);
        //创建适配器
        adapter = new MyBlogAdapter(data);
        //设置到RecyclerView中
        myBlogList.setAdapter(adapter);
    }
}
