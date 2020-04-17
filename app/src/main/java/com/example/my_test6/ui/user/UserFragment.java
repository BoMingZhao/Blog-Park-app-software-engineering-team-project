package com.example.my_test6.ui.user;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        Boolean notLogin = true;
        if(notLogin) {
            Button message = root.findViewById(R.id.messageCenter);
            message.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto message
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });
            Button browse = root.findViewById(R.id.browseHistory);
            browse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto browseHistory
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });
            Button collect = root.findViewById(R.id.collect);
            collect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto collection
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });
            Button blog = root.findViewById(R.id.blog);
            blog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto blog
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });
            Button homework = root.findViewById(R.id.homework);
            homework.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto homework
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });
            Button about = root.findViewById(R.id.about);
            about.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto about
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.about");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });
            Button login = root.findViewById(R.id.login);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto login
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });
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
