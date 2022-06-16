package io.ramani.themoviedbtask.data.models;

import com.google.gson.annotations.SerializedName;

public class SpokenLanguageRemoteModel {

    @SerializedName("english_name")
    public String englishName;

    @SerializedName("iso_639_1")
    public String iso_639_1;

    @SerializedName("name")
    public String name;
}
