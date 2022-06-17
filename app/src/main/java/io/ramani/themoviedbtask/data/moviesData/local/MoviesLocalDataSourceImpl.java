package io.ramani.themoviedbtask.data.moviesData.local;

import java.util.List;

import io.ramani.themoviedbtask.App;
import io.ramani.themoviedbtask.data.database.MoviesDao;
import io.ramani.themoviedbtask.domain.model.MoviesModel;
import io.ramani.themoviedbtask.domain.model.MoviesResponseModel;
import io.reactivex.Single;

public class MoviesLocalDataSourceImpl implements MoviesLocalDataSource {

    private static MoviesLocalDataSourceImpl instance;
    private MoviesDao dao;

    public MoviesLocalDataSourceImpl() {
        this.dao = App.getAppDatabase().moviesDao();
    }

    public static MoviesLocalDataSourceImpl getInstance() {
        if (instance == null)
            instance = new MoviesLocalDataSourceImpl();
        return instance;
    }

    @Override
    public Single<MoviesResponseModel> getMoviesList(String query, boolean includeAdult) {
        if (query.trim().isEmpty()) {
            return this.dao.getAllData().flatMap(data -> Single.just(new MoviesResponseModel(data, false)));
        } else {
            return this.dao.getAllData(query, includeAdult).flatMap(data -> Single.just(new MoviesResponseModel(data, false)));
        }
    }

    @Override
    public Single<MoviesModel> getMovieDetails(int movieId) {
        return this.dao.getMovieById(movieId).flatMap(moviesModels -> {
            if (moviesModels.isEmpty()) {
                return Single.just(new MoviesModel());
            }
            return Single.just(moviesModels.get(0));
        });
    }

    @Override
    public void saveMoviesList(List<MoviesModel> moviesModels) {
        MoviesModel[] arrayOfDataModel = new MoviesModel[moviesModels.size()];
        moviesModels.toArray(arrayOfDataModel);
        this.dao.insertData(arrayOfDataModel);
    }
}
