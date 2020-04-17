package com.example.my_test6.ui.edu;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.my_test6.Bean.BlogSummary;
import com.example.my_test6.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EduFragment extends Fragment {
    private EduViewModel eduViewModel;
    private OkHttpClient client = new OkHttpClient();
    private static  final int GET_MESSAGE_1 = 0x01;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        eduViewModel =
                ViewModelProviders.of(this).get(EduViewModel.class);
        View root = inflater.inflate(R.layout.fragment_edu, container, false);
        final Button button1 = root.findViewById(R.id.button);
        final TextView textView1 = root.findViewById(R.id.textView);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch(msg.what){
                    case GET_MESSAGE_1:
                        String text = (String)msg.obj;
                       Gson gson = new Gson();
                        List<BlogSummary> blogSummaryList1 = gson.fromJson(text, new TypeToken<List<BlogSummary>>(){}.getType());
                       textView1.setText(blogSummaryList1.get(0).getDescription());
                        break;
                    default:
                        break;
                }
            }
        };
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                test_get(handler);
            }
        });
        return root;
    }

    private  void test_get(final Handler handler){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    String result = getUrl("https://api.cnblogs.com/api/blogposts/@picked?pageIndex=2&pageSize=10");
                    Log.d("TAG",result);
                    Message message1 = Message.obtain();
                    message1.what=GET_MESSAGE_1;
                    message1.obj = result;
                    handler.sendMessage(message1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }


    String getUrl(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization","Bearer "+"eyJhbGciOiJSUzI1NiIsImtpZCI6IjlFMjcyMkFGM0IzRTFDNzU5RTI3NEFBRDI5NDFBNzg1MDlCMDc2RDAiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJuaWNpcnpzLUhIV2VKMHF0S1VHbmhRbXdkdEEifQ.eyJuYmYiOjE1ODcwNDE5NTgsImV4cCI6MTU4NzEyODM1OCwiaXNzIjoiaHR0cDovL29wZW5hcGlfb2F1dGgtc2VydmVyIiwiYXVkIjpbImh0dHA6Ly9vcGVuYXBpX29hdXRoLXNlcnZlci9yZXNvdXJjZXMiLCJDbkJsb2dzQXBpIl0sImNsaWVudF9pZCI6IjhhYjI0MzY3LTkxZDYtNGMxOS05ODQ2LTEyMTkwOWEwZTAxZiIsInNjb3BlIjpbIkNuQmxvZ3NBcGkiXX0.fnwlC4thAiy9Q_3DT9YXBtD38f8KVrKHjuISHZzxDe4aPe_kysdFPaGEfdqnm5pI_nI_HhVfmJfA8cBmoetRhN_-Dvtyj3OV8H4Bul1CIitftOdakW7oL2vfyM41MZp7Y8i-gNuPBUctYEngbRM6kaUfX-ZtLatWjaBFKe2zEBe1liV7IY2aqI_b0gUcrjUkhiV6GqjSRfzh8z8Q227HwyNC-r229Y_xFrDeBYRIx8qdRrURtd_F4zV1WU0lznN3GcXCdNXLRCfpz_-CYiR4bkGZN_sDnz7gPOgXojfqHujbqyw_YY3yiiFpM9FpS9fAUN5pVV0CX0RenEI9Ay-HTw")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
