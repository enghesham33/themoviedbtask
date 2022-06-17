package io.ramani.themoviedbtask.domain.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import io.ramani.themoviedbtask.domainCore.IBuilder;

@Entity(tableName = "movie_model")
public class MoviesModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", index = true)
    public Integer localId;

    @ColumnInfo(name = "remote_id")
    public int remoteId;

    @ColumnInfo(name = "adult")
    public boolean adult;

    @ColumnInfo(name = "poster_path")
    public String posterPath;

    @ColumnInfo(name = "release_date")
    public String releaseDate;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "vote_average")
    public double voteAverage;

    @ColumnInfo(name = "vote_count")
    public int voteCount;

    @ColumnInfo(name = "video_id")
    public String videoId;

    public MoviesModel() {
    }

    public MoviesModel(int remoteId, boolean adult, String posterPath, String releaseDate, String title,
                       double voteAverage, int voteCount, String videoId) {
        this.remoteId = remoteId;
        this.adult = adult;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.title = title;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.videoId = videoId;
    }

    public static class Builder implements IBuilder<MoviesModel> {

        private int remoteId;
        private boolean adult;
        private String posterPath;
        private String releaseDate;
        private String title;
        private double voteAverage;
        private int voteCount;
        private String videoId;

        public Builder remoteId(int remoteId) {
            this.remoteId = remoteId;
            return this;
        }

        public Builder adult(boolean adult) {
            this.adult = adult;
            return this;
        }

        public Builder posterPath(String posterPath) {
            this.posterPath = posterPath;
            return this;
        }

        public Builder releaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
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

        public Builder videoId(String videoId) {
            this.videoId = videoId;
            return this;
        }

        @Override
        public MoviesModel build() {
            return new MoviesModel(remoteId, adult, posterPath, releaseDate, title, voteAverage, voteCount, videoId);
        }
    }
}
