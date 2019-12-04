package com.example.cpsc471app.ui.self_care;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SelfCareViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SelfCareViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is self_care fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}