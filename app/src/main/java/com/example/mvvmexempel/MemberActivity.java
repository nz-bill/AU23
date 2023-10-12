package com.example.mvvmexempel;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmexempel.databinding.ActivityMemberBinding;

import java.util.ArrayList;
import java.util.List;

public class MemberActivity extends AppCompatActivity {



    private MemberViewModel memberViewModel;
    private MemberAdapter adapter;
    private List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMemberBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_member);
        memberViewModel = new ViewModelProvider(this).get(MemberViewModel.class);
        binding.setMemberViewModel(memberViewModel);
        binding.setLifecycleOwner(this);



       userList = memberViewModel.getUserListLiveData().getValue();
       ListView listView = binding.lvMembers;
       adapter = new MemberAdapter(this, userList);
       listView.setAdapter(adapter);

       memberViewModel.getUserListLiveData().observe(this, new Observer<List<User>>() {
           @Override
           public void onChanged(List<User> users) {
               userList = users;
               adapter.notifyDataSetChanged();
           }
       });


    }
}