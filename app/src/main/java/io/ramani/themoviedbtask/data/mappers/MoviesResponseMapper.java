package io.ramani.themoviedbtask.data.mappers;

import java.util.ArrayList;
import java.util.List;

import io.ramani.themoviedbtask.data.models.MoviesRemoteResponse;
import io.ramani.themoviedbtask.domain.model.MoviesResponseModel;
import io.ramani.themoviedbtask.domainCore.ModelMapper;

public class MoviesResponseMapper implements ModelMapper<MoviesRemoteResponse, MoviesResponseModel> {

    @Override
    public MoviesResponseModel mapFrom(MoviesRemoteResponse from) {
        MoviesRemoteMapper moviesRemoteMapper = new MoviesRemoteMapper();
        return new MoviesResponseModel.Builder()
                .moviesModelList(moviesRemoteMapper.mapFrom(from.results))
                .canLoadMore(from.page < from.totalPages)
                .build();
    }

    @Override
    public List<MoviesResponseModel> mapFrom(List<MoviesRemoteResponse> from) {
        MoviesRemoteMapper moviesRemoteMapper = new MoviesRemoteMapper();
        ArrayList<MoviesResponseModel> dataList = new ArrayList<>();

        for (int index = 0; index < from.size(); index++) {
            MoviesResponseModel moviesResponseModel = new MoviesResponseModel.Builder()
                    .moviesModelList(moviesRemoteMapper.mapFrom(from.get(index).results))
                    .canLoadMore(from.get(index).page < from.get(index).totalPages)
                    .build();
            dataList.add(moviesResponseModel);
        }
        return dataList;
    }

    @Override
    public MoviesRemoteResponse mapTo(MoviesResponseModel to) {
        return null;
    }

    @Override
    public List<MoviesRemoteResponse> mapTo(List<MoviesResponseModel> to) {
        return null;
    }
}
