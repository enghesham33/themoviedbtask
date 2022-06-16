package io.ramani.themoviedbtask.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ImageRemoteModel {
    @SerializedName("backdrops")
    public ArrayList<ImageRemoteModel> backdrops;

    @SerializedName("logos")
    public ArrayList<ImageRemoteModel> logos;

    @SerializedName("posters")
    public ArrayList<ImageRemoteModel> posters;
}
