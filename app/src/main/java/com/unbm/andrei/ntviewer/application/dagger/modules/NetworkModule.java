package com.unbm.andrei.ntviewer.application.dagger.modules;

import android.content.Context;

import com.unbm.andrei.ntviewer.application.dagger.AppScope;
import com.unbm.andrei.ntviewer.application.network.FakeInterceptor;
import com.unbm.andrei.ntviewer.application.network.SitesProviderService;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Andrei on 4/30/2017.
 */

@Module
public class NetworkModule {

    private static final long CACHE_MAX_SIZE = 10 * 1000 * 1000; // 10MB
    public static final String CACHE_FILE_NAME = "okhttp3_cache";

    @Provides
    @AppScope
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> Timber.i(message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Provides
    @AppScope
    public File provideCacheFile(Context context) {
        return new File(context.getCacheDir(), CACHE_FILE_NAME);
    }

    @Provides
    @AppScope
    public Cache provideCache(File cacheFile) {
        return new Cache(cacheFile, CACHE_MAX_SIZE);
    }

    @Provides
    @AppScope
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new FakeInterceptor()) // TODO: 5/1/2017 remove this whenyou have a server
                .cache(cache)
                .build();
    }

    @Provides
    @AppScope
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(SitesProviderService.BASE_URL)
                .build();
    }

    @Provides
    @AppScope
    public SitesProviderService providePostsService(Retrofit retrofit) {
        return retrofit.create(SitesProviderService.class);
    }
}
