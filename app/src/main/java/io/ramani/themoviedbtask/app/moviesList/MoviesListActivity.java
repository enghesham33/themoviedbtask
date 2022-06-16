package io.ramani.themoviedbtask.app.moviesList;

import android.os.Bundle;

import io.ramani.themoviedbtask.R;
import io.ramani.themoviedbtask.app.base.BaseActivity;
import io.ramani.themoviedbtask.app.viewModels.MoviesViewModel;

public class MoviesListActivity extends BaseActivity<MoviesViewModel> {

    @Override
    protected MoviesViewModel initiateViewModel() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
    }
}