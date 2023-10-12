package com.example.mvvmexempel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MemberAdapter extends ArrayAdapter<User> {

    public MemberAdapter(Context context, List users){
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.listitem_member, parent, false);
        }

        User user = getItem(position);

        TextView tv = view.findViewById(R.id.tv_name);
        tv.setText(user.getUserName());


        return view;
    }
}
