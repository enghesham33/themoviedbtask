package io.ramani.themoviedbtask.data.moviesData.remote;

import java.util.List;

import io.ramani.themoviedbtask.data.MoviesAPICall;
import io.ramani.themoviedbtask.data.commonData.Constants;
import io.ramani.themoviedbtask.data.mappers.MoviesRemoteMapper;
import io.ramani.themoviedbtask.domain.model.MoviesModel;
import io.reactivex.Single;

public class MoviesRemoteDataSourceImpl implements MoviesRemoteDataSource {

    private static MoviesRemoteDataSourceImpl instance;

    private final MoviesAPICall moviesAPICall;

    private final MoviesRemoteMapper moviesRemoteMapper = new MoviesRemoteMapper();

    private MoviesRemoteDataSourceImpl(MoviesAPICall moviesAPICall) {
        this.moviesAPICall = moviesAPICall;
    }

    public static MoviesRemoteDataSourceImpl getInstance(MoviesAPICall moviesAPICall) {
        if (instance == null)
            instance = new MoviesRemoteDataSourceImpl(moviesAPICall);
        return instance;
    }

    @Override
    public Single<List<MoviesModel>> getMoviesList(String query, int page, boolean includeAdult) {
        String fakeQuery = query;
        if (query.isEmpty()) {
            fakeQuery = "action";
        }
        return this.moviesAPICall.getMoviesList(Constants.API_KEY, fakeQuery, page, includeAdult)
                .flatMap(data -> Single.just(moviesRemoteMapper.mapFrom(data.results)));
    }

    @Override
    public Single<MoviesModel> getMovieDetails(int id) {
        return this.moviesAPICall.getMovieDetails(Constants.API_KEY, id, "videos,images")
                .flatMap(data -> Single.just(moviesRemoteMapper.mapFrom(data)));
    }
}