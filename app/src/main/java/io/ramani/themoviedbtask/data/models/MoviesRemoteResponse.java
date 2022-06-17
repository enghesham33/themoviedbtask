package io.ramani.themoviedbtask.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.ramani.themoviedbtask.domainCore.IBuilder;

public class MoviesRemoteResponse {
    @SerializedName("page")
    public int page;

    @SerializedName("results")
    public List<MovieRemoteModel> results;

    @SerializedName("total_pages")
    public int totalPages;

    @SerializedName("total_results")
    public int totalResults;

    public MoviesRemoteResponse() {
        this.page = 0;
        this.results = new ArrayList();
        this.totalPages = 0;
        this.totalResults = 0;
    }

    public MoviesRemoteResponse(int page, List<MovieRemoteModel> results, int totalPages, int totalResults) {
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    public static class Builder implements IBuilder<MoviesRemoteResponse> {

        private int page;
        private List<MovieRemoteModel> results;
        private int totalPages;
        private int totalResults;

        public Builder page(int page) {
            this.page = page;
            return this;
        }

        public Builder results(List<MovieRemoteModel> results) {
            this.results = results;
            return this;
        }

        public Builder totalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public Builder totalResults(int totalResults) {
            this.totalResults = totalResults;
            return this;
        }

        @Override
        public MoviesRemoteResponse build() {
            return new MoviesRemoteResponse(page, results, totalPages, totalResults);
        }
    }
}
