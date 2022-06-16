package io.ramani.themoviedbtask.data.models;

import com.google.gson.annotations.SerializedName;

public class ImageMediaDetailsRemoteModel {

    @SerializedName("aspect_ratio")
    public double aspectRatio;

    @SerializedName("height")
    public int height;

    @SerializedName("iso_639_1")
    public String iso_639_1;

    @SerializedName("file_path")
    public String filePath;

    @SerializedName("vote_average")
    public double voteAverage;

    @SerializedName("vote_count")
    public int voteCount;

    @SerializedName("width")
    public int width;

}
