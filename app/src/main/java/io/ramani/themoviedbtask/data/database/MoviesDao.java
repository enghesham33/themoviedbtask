package io.ramani.themoviedbtask.data.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.ramani.themoviedbtask.domain.model.MoviesModel;
import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface MoviesDao {
    @Query("select * from movie_model")
    Single<List<MoviesModel>> getAllData();

    @Query("select * from movie_model as model where model.title like :query " +
            " and model.adult = :includeAdult")
    Single<List<MoviesModel>> getAllData(String query, boolean includeAdult);

    @Query("select * from movie_model as model where model.id = :movieId ")
    Single<List<MoviesModel>> getMovieById(int movieId);


    @Insert(onConflict = REPLACE)
    Completable insertData(MoviesModel data);

    @Insert(onConflict = REPLACE)
    void insertData(MoviesModel... dataModelList);

    @Delete
    Completable delete(MoviesModel data);
}
