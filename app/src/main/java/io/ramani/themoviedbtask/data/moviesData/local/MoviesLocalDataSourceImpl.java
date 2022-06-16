package io.ramani.themoviedbtask.data.moviesData.local;

import java.util.List;

import io.ramani.themoviedbtask.App;
import io.ramani.themoviedbtask.data.database.MoviesDao;
import io.ramani.themoviedbtask.domain.model.MoviesModel;
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
    public Single<List<MoviesModel>> getMoviesList(String query, boolean includeAdult) {
        return query.trim().isEmpty() ? this.dao.getAllData() : this.dao.getAllData(query, includeAdult);
    }

    @Override
    public void saveMoviesList(List<MoviesModel> moviesModels) {
        MoviesModel[] arrayOfDataModel = new MoviesModel[moviesModels.size()];
        moviesModels.toArray(arrayOfDataModel);
        this.dao.insertData(arrayOfDataModel);
    }
}
