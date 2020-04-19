package com.example.my_test6.ui.user.ListAdapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_test6.R;
import com.example.my_test6.ui.user.ItemBean.ItemHomework;

import java.util.ArrayList;

public class HomeworkAdapter extends RecyclerView.Adapter<HomeworkAdapter.innerHolder> {

    private final ArrayList<ItemHomework> mData;

    public HomeworkAdapter(ArrayList<ItemHomework> data){
        this.mData = data;
    }

    @NonNull
    @Override
    //创建条目View
    public innerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_homework,null);
        return new innerHolder(view);
    }

    @Override
    //用来绑定holder，设置数据
    public void onBindViewHolder(@NonNull innerHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    //返回条目的个数
    public int getItemCount() {
        if(mData != null){
            return mData.size();
        }
        return 0;
    }

    public void setOnItemClickListener() {
        //设置一个Item的监听器
    }

    public class innerHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView author;
        private TextView Abstract;
        private TextView comment;
        public innerHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_Homework_blogtitle);
            author = itemView.findViewById(R.id.item_Homework_author);
            Abstract = itemView.findViewById(R.id.item_Homework_abstract);
            comment = itemView.findViewById(R.id.item_Homework_comment);
        }
        public void setData(ItemHomework itembean){
            title.setText(itembean.title);
            comment.setText(itembean.comment);
            author.setText(itembean.author);
            Abstract.setText(itembean.Abstract);
        }
    }
}