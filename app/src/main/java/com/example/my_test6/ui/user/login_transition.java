
package com.example.my_test6.ui.user;

        import android.annotation.SuppressLint;
        import android.content.ComponentName;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.os.Message;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import com.example.my_test6.Pool.MinePool;
        import com.example.my_test6.Pool.TokenPool;
        import com.example.my_test6.R;
        import com.example.my_test6.netWork.GetUserApi;
        import com.example.my_test6.ui.user.GsonBean.Users;
        import com.google.gson.Gson;

public class login_transition extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_login_transition);
        Intent intent = new Intent();
        ComponentName componentname = new ComponentName("com.example.my_test6", "com.example.my_test6.ui.user.login");
        intent.setComponent(componentname);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(TokenPool.getTokenPool().isLogin) {
            @SuppressLint("HandlerLeak")
            Handler handler = new Handler() {
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    if (msg.what == 0x1) {//设置用户信息
                        Gson gson = new Gson();
                        String json = (String) msg.obj;
                        Users users;
                        users = gson.fromJson(json, Users.class);
                        MinePool.getMinePool().users = users;
                        System.out.println("blogApp: " + users.BlogApp);
                        login_transition.this.finish();
                    }
                }
            };
            GetUserApi api = new GetUserApi();
            String url = "https://api.cnblogs.com/api/users";
            api.getMyApi(handler, url, 1);
        }
    }
}

