package io.ramani.themoviedbtask.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VideoRemoteModel {
    @SerializedName("backdrops")
    public ArrayList<ImageRemoteModel> backdrops;
}
