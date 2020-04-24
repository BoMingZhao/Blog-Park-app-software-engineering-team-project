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
public class FinishHomeworkFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ItemHomework> mdata;
    private HomeworkAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.user_fragment_finishhomework, container, false);
        recyclerView = root.findViewById(R.id.FragementRecyclerview1);
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

        for(int i = 0;i <= 11; i++){
            ItemHomework item = new ItemHomework();
            item.src = 1;
            switch (i){
                case 0:
                    item.title = "Scrum Meeting 博客";
                    item.Abstract = "本学期共进行 Alpha-Beta 两轮迭代。每次迭代包含4周时间，第一周进行设计和计划，第二、三周进行实现（冲刺），第四周进行测试、发布和稳定。 在第二、三周这一冲刺阶段，要求：至少发布 10 篇 Scrum Meeting 博客（例子）。 每篇 Scrum Meeting 博客的要求： 1. 每";
                    item.author = "分解(谢静芬)";
                    item.comment = "提交：" + 13;
                    item.time = "2020-04-06 20:00 ~ 2020-04-16 00:00";
                    item.url = "https://edu.cnblogs.com/campus/buaa/BUAA_SE_2020_LJ/homework/10602";
                    break;
                case 1:
                    item.title = "功能规格说明书";
                    item.Abstract = "请阅读书本有关规格说明书的部分。 请分析你们团队项目的典型用户和场景，并写一个团队博客发布你们团队项目的功能规格说明书。 模板： 盲目地套用最全面的模板，对项目有很大的副作用，PM尤其要注意！ spec的目标是什么，不包括什么？ spec的用户和典型场景是什么？ spec用到了哪些术语，它们的定义是";
                    item.author = "分解(谢静芬)";
                    item.comment = "提交：" + 14;
                    item.time = "2020-04-02 18:00 ~ 2020-04-08 23:00";
                    item.url = "https://edu.cnblogs.com/campus/buaa/BUAA_SE_2020_LJ/homework/10590";
                    break;
                case 2:
                    item.title = "技术规格说明书";
                    item.Abstract = "写一个博客团队博客发布你们项目的设计文档（技术规格说明书）。 请在设计文档内说明你们的设计是如何体现下列原则的： 抽象 内聚/耦合/模块化 信息隐藏和封装 界面和实现的分离 如何处理错误情况 程序模板对于运行环境、相关模板、输入输出参数有什么假设？这些假设和相关的人员验证过么？ 应对变化的灵活性 对";
                    item.author = "分解(谢静芬)";
                    item.comment = "提交：" + 13;
                    item.time = "2020-04-02 18:00 ~ 2020-04-08 23:00";
                    item.url = "https://edu.cnblogs.com/campus/buaa/BUAA_SE_2020_LJ/homework/10591";
                    break;
                case 3:
                    item.title = "团队任务拆解";
                    item.Abstract = "要求： 请阅读书本有关WBS的部分（8.7），将alpha阶段目标拆解成各个任务 使用各种估计方法（1），（2），估计每个任务的时间。 将各个任务交给个人。每个任务必须有估计的时间，并且时间不能多于8小时 把所有任务更新之后，截屏、统计你们项目到底需要多少时间做完。 示例： https://edu.";
                    item.author = "分解(谢静芬)";
                    item.comment = "提交：" + 13;
                    item.time = "2020-04-02 18:00 ~ 2020-04-11 23:00";
                    item.url = "https://edu.cnblogs.com/campus/buaa/BUAA_SE_2020_LJ/homework/10592";
                    break;
                case 4:
                    item.title = "团队贡献分分配规则";
                    item.Abstract = "我们的团队有的人多（7个），有的人少（5个）。 那么贡献分应当如何科学的分配，是一个十分重要的问题。 请阅读书本有关效绩管理的部分或这个博客：现代软件工程 10 绩效管理。 每个团队开一个讨论会，协商讨论团队贡献分的分配方式。 每个团队的团队贡献分为50分/人。 要求： 分数为自然数 每个人分数不能";
                    item.author = "分解(谢静芬)";
                    item.comment = "提交：" + 13;
                    item.time = "2020-04-02 18:00 ~ 2020-04-15 23:00";
                    item.url = "https://edu.cnblogs.com/campus/buaa/BUAA_SE_2020_LJ/homework/10593";
                    break;
                case 5:
                    item.title = "团队项目选择";
                    item.Abstract = "各个团队要在第六周课前决定做哪一个项目（按黄金点游戏排出的次序挑选），确定之后写团队博客描述他们要做的究竟是什么系统 （不懂的地方可以在博客上提问或联系老师）。 这次课程2个班共有13个学生团队，备选项目有6个，至少有6个团队需要从备选项目中选择，每个备选项目最多被1个团队选择，7个团队可以自选项目";
                    item.author = "LJie(罗杰)";
                    item.comment = "提交：" + 13;
                    item.time = "2020-03-26 12:00 ~ 2020-04-02 13:00";
                    item.url = "https://edu.cnblogs.com/campus/buaa/BUAA_SE_2020_LJ/homework/10559";
                    break;
                case 6:
                    item.title = "个人博客作业-软件案例分析";
                    item.Abstract = "声明：本作业以邹欣老师博客1和2为基础进行修改。 零、说在前面的话 很多同学有疑惑： 软件工程课是否就是枯燥的理论课？ 或者是几个牛人拼命写代码，其他人抱大腿的课？ 要不然就是学习一个程序语言，练习某个框架，搞一个职业培训的课？ 都不对！软件工程有理论，有实践，更重要的是分析，思辨，总结。在课程中，";
                    item.author = "LJie(罗杰)";
                    item.comment = "提交：" + 84;
                    item.time = "2020-03-15 14:00 ~ 2020-03-26 19:00 ";
                    item.url = "https://edu.cnblogs.com/campus/buaa/BUAA_SE_2020_LJ/homework/10481";
                    break;
                case 7:
                    item.title = "团队作业-团队介绍和采访";
                    item.Abstract = "团队作业 #1 每个团队取一个名字，并选出一位同学作为联系人，更新到助教统计团队的石墨文档中，以便后续跟助教和老师沟通。 每个团队在cnblogs上创建一个团队博客，并将团队博客地址更新到团队统计的石墨文档中。 在团队博客上撰写一个博客介绍一下团队的成员，有图有真相。 初步确定一下每个团队成员的角色";
                    item.author = "LJie(罗杰)";
                    item.comment = "提交：" + 13;
                    item.time = "2020-03-15 14:00 ~ 2020-03-22 14:00";
                    item.url = "https://edu.cnblogs.com/campus/buaa/BUAA_SE_2020_LJ/homework/10482";
                    break;
                case 8:
                    item.title = "结对项目作业";
                    item.Abstract = "结对项目作业 零、任务概览 实现一个能求解简单几何形状之间交点的软件。 一、前言 本次作业为个人项目中求解交点的增量扩展，主要目的是为了让同学们通过身体力行了解以下三点：软件需求的变更，封装，接口与松耦合，以及错误处理。 软件需求的变更 软件的需求不是一成不变的，随着时间的演进，已有的需求可能会改变";
                    item.author = "braveTester(刘子渊)";
                    item.comment = "提交：" + 84;
                    item.time = "2020-03-11 11:00 ~ 2020-03-24 19:00";
                    item.url = "https://edu.cnblogs.com/campus/buaa/BUAA_SE_2020_LJ/homework/10466";
                    break;
                case 9:
                    item.title = "个人项目作业";
                    item.Abstract = "个人项目作业 零、任务概览 实现一个能求解简单几何形状之间交点的控制台程序。 一、总体要求 阅读《构建之法》第一章至第三章的内容，并在下方作业里体现出阅读后的成果。特别是第二章中的效能分析及个人软件开发流程（PSP）。 使用 Visual Studio Community 2019 进行开发，采用";
                    item.author = "braveTester(刘子渊)";
                    item.comment = "提交：" + 84;
                    item.time = "未设置 ~ 2020-03-17 10:00";
                    item.src = 0;
                    item.url = "https://edu.cnblogs.com/campus/buaa/BUAA_SE_2020_LJ/homework/10429";
                    break;
                case 10:
                    item.title = "个人博客作业";
                    item.Abstract = "个人博客作业 快速看完整部教材（教材还没买到的同学，可以先看邹欣老师的博客园讲义），列出你仍然不懂的5到10个问题，发布在你的个人博客上。 如何提出有价值的问题？ 请看这个文章：http://www.cnblogs.com/rocedu/p/5167941.html，以及在互联网时代如何提问题。 还";
                    item.author = "分解(谢静芬)";
                    item.comment = "提交：" + 84;
                    item.time = "2020-02-27 02:00 ~ 2020-03-08 19:00";
                    item.url = "https://edu.cnblogs.com/campus/buaa/BUAA_SE_2020_LJ/homework/10414";
                    break;
                case 11:
                    item.title = "第一次作业-热身！";
                    item.Abstract = "热身 首先欢迎各位 :) 开学第一周，请同学们加油完成我们精心准备的课程热身作业。 一、准备工作 准备一个github账号。 如果你还没有在博客园写过博客，请参考这篇博客创建自己的博客园账号，并申请开通博客。 博客开通后，请在这个文档中登记你的信息。 若助教没有及时将你添加到班级博客中，可以通过这个";
                    item.author = "分解(谢静芬)";
                    item.comment = "提交：" + 84;
                    item.time = "2020-02-26 14:00 ~ 2020-03-03 19:00";
                    item.url = "https://edu.cnblogs.com/campus/buaa/BUAA_SE_2020_LJ/homework/10410";
                    break;
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
