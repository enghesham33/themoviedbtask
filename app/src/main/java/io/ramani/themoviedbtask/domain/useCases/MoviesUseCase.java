package io.ramani.themoviedbtask.domain.useCases;

import io.ramani.themoviedbtask.data.apiServices.RemoteService;
import io.ramani.themoviedbtask.data.moviesData.MoviesDataRepository;
import io.ramani.themoviedbtask.domain.model.MoviesModel;
import io.ramani.themoviedbtask.domain.model.MoviesResponseModel;
import io.reactivex.Single;

public class MoviesUseCase {

    private final MoviesDataRepository repo;

    public MoviesUseCase() {
        repo = new MoviesDataRepository();
    }

    public Single<MoviesResponseModel> loadMoviesListUseCase(String searchKey, boolean includeAdult, int page) {
        return repo.getMoviesList(searchKey, page, includeAdult).flatMap(data -> {

            if (!data.moviesModelList.isEmpty() && RemoteService.getInstance().isInternetAvailable()
                    && page == 1) {
                repo.saveData(data.moviesModelList);
            }
            return Single.just(data);
        });
    }

    public Single<MoviesModel> loadMovieDetailsUseCase(int movieId) {
        return repo.getMovieDetails(movieId);
    }
}
