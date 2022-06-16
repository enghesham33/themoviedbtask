package io.ramani.themoviedbtask;

import android.app.Application;

import androidx.room.Room;

import io.ramani.themoviedbtask.data.database.LocalDatabaseManager;

public class App extends Application {

    private static App sInstance;
    private static LocalDatabaseManager mAppDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mAppDatabase = Room.databaseBuilder(
                getApplicationContext(),
                LocalDatabaseManager.class, "Movies-Local-Database"
        ).fallbackToDestructiveMigration().build();
    }

    public static App getInstance() {
        return sInstance;
    }

    public static LocalDatabaseManager getAppDatabase() {
        return mAppDatabase;
    }

}
