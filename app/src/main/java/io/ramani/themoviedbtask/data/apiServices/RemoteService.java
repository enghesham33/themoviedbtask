package io.ramani.themoviedbtask.data.apiServices;

import io.ramani.themoviedbtask.data.MoviesAPICall;
import io.ramani.themoviedbtask.data.commonData.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RemoteService {

    private static final String URL = Constants.BASE_URL;

    private final MoviesAPICall apiCall;

    private static RemoteService singleton;

    private RemoteService() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientWithLoggingInterceptor())
                .baseUrl(URL).build();

        apiCall = mRetrofit.create(MoviesAPICall.class);
    }

    private OkHttpClient httpClientWithLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    public static RemoteService getInstance() {
        if (singleton == null) {
            singleton = new RemoteService();
        }
        return singleton;
    }

    public MoviesAPICall getApiCall() {
        return apiCall;
    }

}
