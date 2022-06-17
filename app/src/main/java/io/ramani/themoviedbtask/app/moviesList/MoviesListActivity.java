package io.ramani.themoviedbtask.app.moviesList;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.ramani.themoviedbtask.R;
import io.ramani.themoviedbtask.app.base.BaseActivity;
import io.ramani.themoviedbtask.app.base.PaginationScrollListener;
import io.ramani.themoviedbtask.app.viewModels.MoviesViewModel;

public class MoviesListActivity extends BaseActivity<MoviesViewModel> implements CompoundButton.OnCheckedChangeListener {

    private MoviesListAdapter adapter;
    private ProgressBar loader;
    private SearchView searchView;
    private SwitchCompat includeAdultsSwitch;

    @Override
    protected MoviesViewModel initiateViewModel() {
        return new MoviesViewModel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        loader = findViewById(R.id.loader_view);
        searchView = findViewById(R.id.search_view);
        includeAdultsSwitch = findViewById(R.id.adults_switch);
        includeAdultsSwitch.setOnCheckedChangeListener(this);
        viewModel.getMoviesList(String.valueOf(searchView.getQuery()), includeAdultsSwitch.isChecked());
        setupSearchView();
        setupMoviesRecyclerView();
        observeLoading();
        observeError();
        observeMoviesList();
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                viewModel.getMoviesList(newText, includeAdultsSwitch.isChecked());
                return false;
            }
        });
    }

    private void setupMoviesRecyclerView() {
        RecyclerView moviesRecyclerView = findViewById(R.id.movies_recycler_view);
        adapter = new MoviesListAdapter(new ArrayList<>(), this);
        moviesRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        moviesRecyclerView.setLayoutManager(layoutManager);
        moviesRecyclerView.addOnScrollListener(new PaginationScrollListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                viewModel.getMoviesList(String.valueOf(searchView.getQuery()),
                        includeAdultsSwitch.isChecked());
            }

            @Override
            public boolean isLastPage() {
                return false;
            }

            @Override
            public boolean isLoading() {
                return false;
            }
        });
    }

    private void observeLoading() {
        viewModel.loading.observe(this, visible -> {
            loader.setVisibility(visible ? View.VISIBLE : View.GONE);
        });
    }

    private void observeError() {
        viewModel.error.observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        });
    }

    private void observeMoviesList() {
        viewModel.moviesList.observe(this, moviesModels -> {
            adapter.changeDataSet(moviesModels);
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        viewModel.getMoviesList(String.valueOf(searchView.getQuery()), checked);
    }
}