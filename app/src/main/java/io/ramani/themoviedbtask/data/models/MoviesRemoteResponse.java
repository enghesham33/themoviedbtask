package io.ramani.themoviedbtask.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesRemoteResponse {
    @SerializedName("page")
    public int page;

    @SerializedName("results")
    public List<MovieRemoteModel> results;

    @SerializedName("total_pages")
    public int totalPages;

    @SerializedName("total_results")
    public int totalResults;


}
