package io.ramani.themoviedbtask.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class VideoMediaDetailsRemoteModel {

    @SerializedName("iso_639_1")
    public String iso_639_1;

    @SerializedName("iso_3166_1")
    public String iso_3166_1;

    @SerializedName("name")
    public String name;

    @SerializedName("key")
    public String key;

    @SerializedName("site")
    public String site;

    @SerializedName("size")
    public int size;

    @SerializedName("type")
    public String type;

    @SerializedName("official")
    public boolean official;

    @SerializedName("published_at")
    public Date publishedAt;

    @SerializedName("id")
    public String id;
}
