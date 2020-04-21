package com.example.my_test6.ui.user;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.my_test6.R;

public class UserFragment extends Fragment {
    private UserViewModel userViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userViewModel =
                ViewModelProviders.of(this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user, container, false);
        Button message = root.findViewById(R.id.SignmessageCenter);
        Button browse = root.findViewById(R.id.SignbrowseHistory);
        Button collect = root.findViewById(R.id.Signcollect);
        Button blog = root.findViewById(R.id.Signblog);
        Button homework = root.findViewById(R.id.Signhomework);
        Button about = root.findViewById(R.id.Signabout);
        Button login = root.findViewById(R.id.log);
        TextView attentionnum = root.findViewById(R.id.UserattentionNum);
        TextView attention = root.findViewById(R.id.Userattention);
        TextView fansNum = root.findViewById(R.id.UserfansNum);
        TextView fans = root.findViewById(R.id.Userfans);
        TextView ageNum = root.findViewById(R.id.UserageNum);
        TextView age = root.findViewById(R.id.Userage);
        TextView name = root.findViewById(R.id.Username);
        ImageView head = root.findViewById(R.id.UserHeadImage);
        boolean token = true;
        if(token) {
            message.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto message
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.message");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            browse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto browseHistory
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.browse");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            collect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto collection
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.collection");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            blog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto blog
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.myblog");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            homework.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto homework
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.myhomework");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            about.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto about
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.about");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });
            login.setText("退出登录");
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto login
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });
            attention.setText("我的关注");
            fans.setText("我的粉丝");
            age.setText("我的园龄");
        }

        else {
            message.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto message
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.message");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            browse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto browseHistory
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.browse");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            collect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto collection
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.collection");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            blog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto blog
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.myblog");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            homework.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto homework
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.myhomework");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            about.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto about
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.about");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });
            login.setText("登录");
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto login
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });
            name.setText("登录");
            head.setImageResource(R.drawable.head);
        }
        /*final TextView textView = root.findViewById(R.id.text_user);
        userViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        return root;
    }
}
