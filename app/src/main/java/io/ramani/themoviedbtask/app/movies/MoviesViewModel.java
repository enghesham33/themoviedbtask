package io.ramani.themoviedbtask.app.viewModels;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import io.ramani.themoviedbtask.app.base.BaseViewModel;
import io.ramani.themoviedbtask.domain.model.MoviesModel;
import io.ramani.themoviedbtask.domain.useCases.MoviesUseCase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MoviesViewModel extends BaseViewModel {

    private final MoviesUseCase useCase;

    public MoviesViewModel() {
        useCase = new MoviesUseCase();
    }

    public MutableLiveData<List<MoviesModel>> moviesList = new MutableLiveData<List<MoviesModel>>();
    public MutableLiveData<MoviesModel> movieDetails = new MutableLiveData<MoviesModel>();
    private List<MoviesModel> allMovies = new ArrayList<>();

    private int moviesCurrentPage = 0;
    private SearchCriteria searchCriteria;
    private boolean canLoadMore = true;

    private void handlePaginationLogic(String searchQuery, boolean includeAdult) {
        if (searchCriteria == null) {
            resetPaginationData(searchQuery, includeAdult);
        } else {
            if (searchCriteria.isTheSameCriteria(searchQuery, includeAdult)) {
                moviesCurrentPage++;
            } else {
                resetPaginationData(searchQuery, includeAdult);
            }
        }
    }

    private void resetPaginationData(String searchQuery, boolean includeAdult) {
        searchCriteria = new SearchCriteria(searchQuery, includeAdult);
        moviesCurrentPage = 1;
        canLoadMore = true;
        allMovies.clear();
    }

    public void getMoviesList(String searchQuery, boolean includeAdult) {
        handlePaginationLogic(searchQuery, includeAdult);
        if (canLoadMore) {
            loading.postValue(true);
            useCase.loadMoviesListUseCase(searchQuery, includeAdult, moviesCurrentPage).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(moviesResponseModel -> {
                canLoadMore = moviesResponseModel.canLoadMore;
                loading.postValue(false);
                allMovies.addAll(moviesResponseModel.moviesModelList);
                moviesList.postValue(allMovies);
            }, onError -> {
                loading.postValue(false);
                error.postValue(onError.getLocalizedMessage());
            });
        }
    }

    public void refreshMoviesList(String searchQuery, boolean includeAdult) {
        resetPaginationData(searchQuery, includeAdult);
        loading.postValue(true);
        useCase.loadMoviesListUseCase(searchQuery, includeAdult, moviesCurrentPage).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(moviesResponseModel -> {
            canLoadMore = moviesResponseModel.canLoadMore;
            loading.postValue(false);
            moviesList.getValue().clear();
            moviesList.postValue(moviesResponseModel.moviesModelList);
        }, onError -> {
            loading.postValue(false);
            error.postValue(onError.getLocalizedMessage());
        });
    }

    public void getMovieDetails(int movieId) {
        loading.postValue(true);
        useCase.loadMovieDetailsUseCase(movieId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(moviesModel -> {
            loading.postValue(false);
            movieDetails.postValue(moviesModel);
        }, onError -> {
            loading.postValue(false);
            error.postValue(onError.getLocalizedMessage());
        });
    }

    private static class SearchCriteria {
        String searchKey;
        boolean includeAdult;

        public SearchCriteria(String searchKey, boolean includeAdult) {
            this.searchKey = searchKey;
            this.includeAdult = includeAdult;
        }

        public boolean isTheSameCriteria(String searchKey, boolean includeAdult) {
            return this.searchKey.equals(searchKey) && this.includeAdult == includeAdult;
        }
    }
}
