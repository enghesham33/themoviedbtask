package io.ramani.themoviedbtask.app.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<VM extends BaseViewModel> extends AppCompatActivity {
    protected VM viewModel;

    protected abstract VM initiateViewModel();

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.viewModel = initiateViewModel();
    }
}
