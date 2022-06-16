package io.ramani.themoviedbtask.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import io.ramani.themoviedbtask.domain.model.MoviesModel;

@Database(
        entities = {MoviesModel.class},
        version = 1,
        exportSchema = false
)
public abstract class LocalDatabaseManager extends RoomDatabase {
    public abstract MoviesDao moviesDao();
}

