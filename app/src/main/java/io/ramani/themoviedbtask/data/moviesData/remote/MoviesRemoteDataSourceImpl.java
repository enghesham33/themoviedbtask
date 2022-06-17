package io.ramani.themoviedbtask.data.moviesData.remote;

import io.ramani.themoviedbtask.data.MoviesAPICall;
import io.ramani.themoviedbtask.data.commonData.Constants;
import io.ramani.themoviedbtask.data.mappers.MoviesRemoteMapper;
import io.ramani.themoviedbtask.data.mappers.MoviesResponseMapper;
import io.ramani.themoviedbtask.domain.model.MoviesModel;
import io.ramani.themoviedbtask.domain.model.MoviesResponseModel;
import io.reactivex.Single;

public class MoviesRemoteDataSourceImpl implements MoviesRemoteDataSource {

    private static MoviesRemoteDataSourceImpl instance;

    private final MoviesAPICall moviesAPICall;

    private final MoviesResponseMapper moviesResponseMapper = new MoviesResponseMapper();
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
    public Single<MoviesResponseModel> getMoviesList(String query, int page, boolean includeAdult) {
        String fakeQuery = query;
        if (query.isEmpty()) {
            fakeQuery = "action";
        }
        return this.moviesAPICall.getMoviesList(Constants.API_KEY, fakeQuery, page, includeAdult)
                .flatMap(moviesRemoteResponse -> Single.just(moviesResponseMapper.mapFrom(moviesRemoteResponse)));
    }

    @Override
    public Single<MoviesModel> getMovieDetails(int id) {
        return this.moviesAPICall.getMovieDetails(id, Constants.API_KEY, "videos,images")
                .flatMap(data -> Single.just(moviesRemoteMapper.mapFrom(data)));
    }
}
