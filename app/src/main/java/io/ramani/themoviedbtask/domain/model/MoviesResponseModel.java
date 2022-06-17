package io.ramani.themoviedbtask.domain.model;

import java.util.ArrayList;
import java.util.List;

import io.ramani.themoviedbtask.domainCore.IBuilder;

public class MoviesResponseModel {

    public List<MoviesModel> moviesModelList;
    public boolean canLoadMore;

    public MoviesResponseModel() {
        this.moviesModelList = new ArrayList<>();
        this.canLoadMore = true;
    }

    public MoviesResponseModel(List<MoviesModel> moviesModelList, boolean canLoadMore) {
        this.moviesModelList = moviesModelList;
        this.canLoadMore = canLoadMore;
    }

    public static class Builder implements IBuilder<MoviesResponseModel> {

        private boolean canLoadMore;
        private List<MoviesModel> moviesModelList;

        public Builder canLoadMore(boolean canLoadMore) {
            this.canLoadMore = canLoadMore;
            return this;
        }

        public Builder moviesModelList(List<MoviesModel> moviesModelList) {
            this.moviesModelList = moviesModelList;
            return this;
        }

        @Override
        public MoviesResponseModel build() {
            return new MoviesResponseModel(moviesModelList, canLoadMore);
        }
    }
}
