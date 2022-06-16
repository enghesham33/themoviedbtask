package io.ramani.themoviedbtask.data.models;

import com.google.gson.annotations.SerializedName;

public class BelongsToCollectionRemoteModel {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("poster_path")
    public String posterPath;

    @SerializedName("backdrop_path")
    public String backdropPath;
}
