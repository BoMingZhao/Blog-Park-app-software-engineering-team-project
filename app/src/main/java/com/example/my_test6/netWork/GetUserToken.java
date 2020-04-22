package com.example.my_test6.netWork;


import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class GetUserToken {
    private String UserToken;
    private String code;

    public GetUserToken(String Code){
        code = Code;
    }

    public void gettoken(){
        String url = "https://oauth.cnblogs.com/connect/token ";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("client_id","8ab24367-91d6-4c19-9846-121909a0e01f")
                .add("client_secret","nD63VpKAHFeE8ObrKiPYOZD0yPwoT1pxfgDhZG_E1SpgDyZogA2n0Z_0-3qXOq92z8avekcEzxDmy4Qp")
                .add("grant_type","authorization_code")
                .add("code",code)
                .add("redirect_uri","https://oauth.cnblos.com/auth/callback")
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .header("application", "x-www-form-urlencoded")
                .post(body)
                .build();
        final Call call = okHttpClient.newCall(request);
    }
}
