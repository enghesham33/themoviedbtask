package io.ramani.themoviedbtask.app.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    public MutableLiveData<Boolean> loading = new MutableLiveData();
    public MutableLiveData<String> error = new MutableLiveData();
}
