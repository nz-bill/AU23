package com.example.mvcexempel;

import java.util.List;

public interface MemberContract {

    interface View{
        void displayMembers(List<User> members);
    }
    interface Presenter{
        void onViewCreated();
        void onDestroy();
    }
}
