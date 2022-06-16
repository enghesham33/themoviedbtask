package io.ramani.themoviedbtask.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.ramani.themoviedbtask.domainCore.IBuilder;

public class MovieRemoteModel {
    @SerializedName("id")
    public int id;

    @SerializedName("adult")
    public boolean adult;

    @SerializedName("backdrop_path")
    public String backdropPath;

    @SerializedName("belongs_to_collection")
    public BelongsToCollectionRemoteModel belongsToCollection;

    @SerializedName("budget")
    public int budget;

    @SerializedName("genres")
    public ArrayList<GenreRemoteModel> genres;

    @SerializedName("homepage")
    public String homepage;

    @SerializedName("imdb_id")
    public String imdbId;

    @SerializedName("original_language")
    public String originalLanguage;

    @SerializedName("original_title")
    public String originalTitle;

    @SerializedName("overview")
    public String overview;

    @SerializedName("popularity")
    public double popularity;

    @SerializedName("poster_path")
    public String posterPath;

    @SerializedName("production_companies")
    public ArrayList<ProductionCompanyRemoteModel> productionCompanies;

    @SerializedName("production_countries")
    public ArrayList<ProductionCountryRemoteModel> productionCountries;

    @SerializedName("release_date")
    public String releaseDate;

    @SerializedName("revenue")
    public int revenue;

    @SerializedName("runtime")
    public int runtime;

    @SerializedName("spoken_languages")
    public ArrayList<SpokenLanguageRemoteModel> spokenLanguages;

    @SerializedName("status")
    public String status;

    @SerializedName("tagline")
    public String tagline;

    @SerializedName("title")
    public String title;

    @SerializedName("video")
    public boolean video;

    @SerializedName("vote_average")
    public double voteAverage;

    @SerializedName("vote_count")
    public int voteCount;

    @SerializedName("videos")
    public VideoRemoteModel videos;

    @SerializedName("images")
    public ImageRemoteModel images;


    public MovieRemoteModel() {
        this.id = -1;
        this.adult = false;
        this.backdropPath = "";
        this.belongsToCollection = null;
        this.budget = 0;
        this.genres = null;
        this.homepage = "";
        this.imdbId = "";
        this.originalLanguage = "";
        this.originalTitle = "";
        this.overview = "";
        this.popularity = 0.0;
        this.posterPath = "";
        this.productionCompanies = null;
        this.productionCountries = null;
        this.releaseDate = "";
        this.revenue = 0;
        this.runtime = 0;
        this.spokenLanguages = null;
        this.status = "";
        this.tagline = "";
        this.title = "";
        this.video = false;
        this.voteAverage = 0;
        this.voteCount = 0;
        this.videos = null;
        this.images = null;
    }

    public MovieRemoteModel(int id, boolean adult, String backdropPath, BelongsToCollectionRemoteModel belongsToCollection,
                            int budget, ArrayList<GenreRemoteModel> genres, String homepage, String imdbId,
                            String originalLanguage,
                            String originalTitle, String overview, double popularity, String posterPath,
                            ArrayList<ProductionCompanyRemoteModel> productionCompanies,
                            ArrayList<ProductionCountryRemoteModel> productionCountries, String releaseDate,
                            int revenue, int runtime, ArrayList<SpokenLanguageRemoteModel> spokenLanguages, String status,
                            String tagline, String title, boolean video, double voteAverage, int voteCount,
                            VideoRemoteModel videos, ImageRemoteModel images) {
        this.id = id;
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.belongsToCollection = belongsToCollection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.videos = videos;
        this.images = images;
    }

    public static class Builder implements IBuilder<MovieRemoteModel> {
        private int id;
        private boolean adult;
        private String backdropPath;
        private BelongsToCollectionRemoteModel belongsToCollection;
        private int budget;
        private ArrayList<GenreRemoteModel> genres;
        private String homepage;
        private String imdbId;
        private String originalLanguage;
        private String originalTitle;
        private String overview;
        private double popularity;
        private String posterPath;
        private ArrayList<ProductionCompanyRemoteModel> productionCompanies;
        private ArrayList<ProductionCountryRemoteModel> productionCountries;
        private String releaseDate;
        private int revenue;
        private int runtime;
        private ArrayList<SpokenLanguageRemoteModel> spokenLanguages;
        private String status;
        private String tagline;
        private String title;
        private boolean video;
        private double voteAverage;
        private int voteCount;
        private VideoRemoteModel videos;
        private ImageRemoteModel images;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder adult(boolean adult) {
            this.adult = adult;
            return this;
        }

        public Builder backdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
            return this;
        }

        public Builder belongsToCollection(BelongsToCollectionRemoteModel belongsToCollection) {
            this.belongsToCollection = belongsToCollection;
            return this;
        }

        public Builder budget(int budget) {
            this.budget = budget;
            return this;
        }

        public Builder genres(ArrayList<GenreRemoteModel> genres) {
            this.genres = genres;
            return this;
        }

        public Builder homepage(String homepage) {
            this.homepage = homepage;
            return this;
        }

        public Builder imdbId(String imdbId) {
            this.imdbId = imdbId;
            return this;
        }

        public Builder originalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
            return this;
        }

        public Builder originalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
            return this;
        }

        public Builder overview(String overview) {
            this.overview = overview;
            return this;
        }

        public Builder popularity(double popularity) {
            this.popularity = popularity;
            return this;
        }

        public Builder posterPath(String posterPath) {
            this.posterPath = posterPath;
            return this;
        }

        public Builder productionCompanies(ArrayList<ProductionCompanyRemoteModel> productionCompanies) {
            this.productionCompanies = productionCompanies;
            return this;
        }

        public Builder productionCountries(ArrayList<ProductionCountryRemoteModel> productionCountries) {
            this.productionCountries = productionCountries;
            return this;
        }

        public Builder releaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder revenue(int revenue) {
            this.revenue = revenue;
            return this;
        }

        public Builder runtime(int runtime) {
            this.runtime = runtime;
            return this;
        }

        public Builder spokenLanguages(ArrayList<SpokenLanguageRemoteModel> spokenLanguages) {
            this.spokenLanguages = spokenLanguages;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder tagline(String tagline) {
            this.tagline = tagline;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder video(boolean video) {
            this.video = video;
            return this;
        }

        public Builder voteAverage(double voteAverage) {
            this.voteAverage = voteAverage;
            return this;
        }

        public Builder voteCount(int voteCount) {
            this.voteCount = voteCount;
            return this;
        }

        public Builder videos(VideoRemoteModel videos) {
            this.videos = videos;
            return this;
        }

        public Builder images(ImageRemoteModel images) {
            this.images = images;
            return this;
        }

        @Override
        public MovieRemoteModel build() {
            return new MovieRemoteModel(id, adult, backdropPath, belongsToCollection, budget, genres, homepage, imdbId,
                    originalLanguage, originalTitle, overview, popularity, posterPath, productionCompanies, productionCountries,
                    releaseDate, revenue, runtime, spokenLanguages, status, tagline, title, video,
                    voteAverage, voteCount, videos, images);
        }
    }
}
