package com.example.my_test6.Pool;

import com.example.my_test6.ui.user.GsonBean.Users;

public class MinePool {
    private static  MinePool minePool = null;
    public Users users;
    private MinePool(){

    }

    public static  MinePool getMinePool(){
        if(minePool==null){
            minePool = new MinePool();
        }
        return minePool;
    }
}
