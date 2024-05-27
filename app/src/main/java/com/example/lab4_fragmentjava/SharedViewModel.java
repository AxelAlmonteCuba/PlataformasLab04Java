package com.example.lab4_fragmentjava;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<UserData> userData = new MutableLiveData<>();

    public void setUserData(UserData data) {
        userData.setValue(data);
    }

    public LiveData<UserData> getUserData() {
        return userData;
    }
}
