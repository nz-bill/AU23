package com.example.mvcexempel;

public interface MainContract {
    interface View {
        void showLoginSuccessMessage();

        void showLoginFaildMessage();

        void showRegisteredSuccessMessage(User user);

        void showRegisteredFailedMessage();
        String getUserName();
        String getUserPassword();
    }

    interface Presenter {
        void onLoginButtonClicked();
        void onRegisterButtonClicked();

        void onViewCreated();
        void onDestroy();
    }
}
