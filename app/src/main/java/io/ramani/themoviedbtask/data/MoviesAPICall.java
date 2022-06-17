package io.ramani.themoviedbtask.data;

import io.ramani.themoviedbtask.data.commonData.Constants;
import io.ramani.themoviedbtask.data.models.MovieRemoteModel;
import io.ramani.themoviedbtask.data.models.MoviesRemoteResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesAPICall {
    @GET(Constants.BASE_URL + "search/movie")
    Single<MoviesRemoteResponse> getMoviesList(@Query("api_key") String apiKey, @Query("query") String query,
                                               @Query("page") int page, @Query("include_adult") boolean includeAdult);

    @GET(Constants.BASE_URL + "movie/{movie_id}")
    Single<MovieRemoteModel> getMovieDetails(@Path("movie_id") int id, @Query("api_key") String apiKey,
                                             @Query("append_to_response") String appendToResponse);
}
