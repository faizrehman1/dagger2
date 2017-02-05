package com.moosa.dagger2.dependencies;

import android.content.Context;

import com.moosa.dagger2.util.Constants;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Moosa on 05/02/2017.
 * moosa.bh@gmail.com
 */

@Module(includes = {NetworkModule.class, ContextModule.class})
public class NetworkModule {

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {//6
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory() {//5
        return GsonConverterFactory.create();
    }

    @Provides
    public OkHttpClient okHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor) {//4
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build();
    }


    @Provides
    public HttpLoggingInterceptor loggingInterceptor() {//3
        return new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Timber.d(message);
                    }
                });
    }

    @Provides
    public File file(Context context) {//1
        return new File(context.getCacheDir(), "okHttpClient");
    }

    @Provides
    public Cache cache(File file) {//2
        return new Cache(file, 10 * 1000 * 1000);
    }

}
