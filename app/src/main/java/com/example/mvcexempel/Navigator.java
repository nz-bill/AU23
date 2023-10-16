package com.example.mvcexempel;

import android.content.Context;
import android.content.Intent;

public class Navigator {

    private Context context;

    public Navigator(Context context) {
        this.context = context;
    }


    public void navigateToMemberActivity(){
        Intent intent = new Intent(context, MemberActivity.class);
        context.startActivity(intent);
    }
}
