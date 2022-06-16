package io.ramani.themoviedbtask.data.mappers;

import java.util.ArrayList;
import java.util.List;

import io.ramani.themoviedbtask.data.models.MovieRemoteModel;
import io.ramani.themoviedbtask.domain.model.MoviesModel;
import io.ramani.themoviedbtask.domainCore.ModelMapper;

public class MoviesRemoteMapper implements ModelMapper<MovieRemoteModel, MoviesModel> {
    @Override
    public MoviesModel mapFrom(MovieRemoteModel from) {
        return new MoviesModel.Builder()
                .adult(from.adult)
                .remoteId(from.id)
                .posterPath(from.posterPath)
                .releaseDate(from.releaseDate)
                .title(from.title)
                .voteAverage(from.voteAverage)
                .voteCount(from.voteCount)
                .build();
    }

    @Override
    public List<MoviesModel> mapFrom(List<MovieRemoteModel> from) {
        ArrayList<MoviesModel> dataList = new ArrayList<>();
        for (int index = 0; index < from.size(); index++) {
            MoviesModel moviesModel = new MoviesModel.Builder()
                    .adult(from.get(index).adult)
                    .remoteId(from.get(index).id)
                    .posterPath(from.get(index).posterPath)
                    .releaseDate(from.get(index).releaseDate)
                    .title(from.get(index).title)
                    .voteAverage(from.get(index).voteAverage)
                    .voteCount(from.get(index).voteCount)
                    .build();
            dataList.add(moviesModel);
        }
        return dataList;
    }

    @Override
    public MovieRemoteModel mapTo(MoviesModel to) {
        return new MovieRemoteModel.Builder()
                .id(to.remoteId)
                .adult(to.adult)
                .posterPath(to.posterPath)
                .releaseDate(to.releaseDate)
                .title(to.title)
                .voteAverage(to.voteAverage)
                .voteCount(to.voteCount)
                .build();
    }

    @Override
    public List<MovieRemoteModel> mapTo(List<MoviesModel> to) {
        ArrayList<MovieRemoteModel> dataList = new ArrayList<>();
        for (int index = 0; index < to.size(); index++) {
            MovieRemoteModel movieRemoteModel = new MovieRemoteModel.Builder()
                    .id(to.get(index).remoteId)
                    .adult(to.get(index).adult)
                    .posterPath(to.get(index).posterPath)
                    .releaseDate(to.get(index).releaseDate)
                    .title(to.get(index).title)
                    .voteAverage(to.get(index).voteAverage)
                    .voteCount(to.get(index).voteCount)
                    .build();
            dataList.add(movieRemoteModel);
        }
        return dataList;
    }
}
