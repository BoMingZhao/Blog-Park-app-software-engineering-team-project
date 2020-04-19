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
import com.google.android.material.bottomappbar.BottomAppBar;

public class UserFragment_login extends Fragment {
    private UserViewModel userViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userViewModel =
                ViewModelProviders.of(this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user_login, container, false);
        Button message = root.findViewById(R.id.SignmessageCenter);
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
        Button browse = root.findViewById(R.id.SignbrowseHistory);
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
        Button collect = root.findViewById(R.id.Signcollect);
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
        Button blog = root.findViewById(R.id.Signblog);
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
        Button homework = root.findViewById(R.id.Signhomework);
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
        Button about = root.findViewById(R.id.Signabout);
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
        Button login = root.findViewById(R.id.Undologin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Undo login

            }
        });

        String s = "1";
        TextView attention = root.findViewById(R.id.Userattention);
        attention.setText(s);
        TextView fans = root.findViewById(R.id.Userfans);
        fans.setText(s);
        TextView age = root.findViewById(R.id.Userage);
        age.setText(s);
        TextView name = root.findViewById(R.id.Username);
        name.setText(s);
        return root;
    }
}
