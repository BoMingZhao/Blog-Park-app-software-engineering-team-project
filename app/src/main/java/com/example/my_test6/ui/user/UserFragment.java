package com.example.my_test6.ui.user;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
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
import com.example.my_test6.netWork.GetUserToken;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class UserFragment extends Fragment {
    private UserViewModel userViewModel;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private View root;
    private Button message;
    private Button browse;
    private Button collect;
    private Button blog;
    private Button homework;
    private Button about;
    private Button login;
    private TextView attentionNum;
    private TextView attention;
    private TextView fansNum;
    private TextView fans;
    private TextView ageNum;
    private TextView age;
    private TextView name;
    private ImageView head1;
    private ImageView head2;
    private String Usertoken;
    private String code;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0x2){
                Usertoken = (String) msg.obj;
                int i = Usertoken.indexOf("\"",17);
                Usertoken = Usertoken.substring(17,i);
                attentionNum.setText("0");
                fansNum.setText("0");
                ageNum.setText("1个月");
                name.setText("软工小白菜");
                head1.setImageResource(R.drawable.circle);
                head2.setImageResource(R.drawable.fake_head);
            }
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userViewModel =
                ViewModelProviders.of(this).get(UserViewModel.class);
        root = inflater.inflate(R.layout.fragment_user, container, false);
        message = root.findViewById(R.id.SignmessageCenter);
        browse = root.findViewById(R.id.SignbrowseHistory);
        collect = root.findViewById(R.id.Signcollect);
        blog = root.findViewById(R.id.Signblog);
        homework = root.findViewById(R.id.Signhomework);
        about = root.findViewById(R.id.Signabout);
        login = root.findViewById(R.id.log);
        attentionNum = root.findViewById(R.id.UserattentionNum);
        attention = root.findViewById(R.id.Userattention);
        fansNum = root.findViewById(R.id.UserfansNum);
        fans = root.findViewById(R.id.Userfans);
        ageNum = root.findViewById(R.id.UserageNum);
        age = root.findViewById(R.id.Userage);
        name = root.findViewById(R.id.Username);
        head1 = root.findViewById(R.id.UserHeadImage);
        head2 = root.findViewById(R.id.Userhead);
        sp = getActivity().getSharedPreferences("UserCode",Context.MODE_PRIVATE);
        editor = sp.edit();
        setUI();
        /*final TextView textView = root.findViewById(R.id.text_user);
        userViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        return root;
    }

    public void onResume() {
        setUI();
        super.onResume();
    }

    private void setUI(){
        code = sp.getString("Code","");
        Usertoken = sp.getString("UserToken","");
        if(!code.equals("")) {
            //如果没有UserToken，不做改变
            /*if(!Usertoken.equals("")){
                attentionNum.setText("0");
                fansNum.setText("0");
                ageNum.setText("1个月");
                name.setText("软工小白菜");
                head1.setImageResource(R.drawable.circle);
                head2.setImageResource(R.drawable.fake_head);
            }*/
            attentionNum.setText("0");
            fansNum.setText("0");
            ageNum.setText("1个月");
            name.setText("软工小白菜");
            head1.setImageResource(R.drawable.circle);
            head2.setImageResource(R.drawable.fake_head);
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
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            browse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto browseHistory
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            collect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto collection
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            blog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto blog
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            homework.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto homework
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.login");
                    intent.setComponent(componentname);
                    startActivity(intent);
                }
            });

            about.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //goto about
                    Intent intent = new Intent();
                    ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.login");
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
            head1.setImageResource(R.drawable.head);
        }
    }
}
