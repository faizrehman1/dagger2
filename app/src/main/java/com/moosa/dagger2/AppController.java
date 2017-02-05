package com.moosa.dagger2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.moosa.dagger2.dependencies.AppControllerModule;
import com.moosa.dagger2.network.UserService;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by Moosa on 05/02/2017.
 * moosa.bh@gmail.com
 * Following Tutorial
 * Github Link
 * https://github.com/TwistedEquations/dagger2-tutorial
 * Youtube Link
 * https://www.youtube.com/watch?v=Qwk7ESmaCq0
 * <p>
 * #####Dependencies###### -> Bottom to Top Initialization
 * <p>
 * <p>
 * UserService   Picasso
 * <p>
 * Retrofit
 * <p>
 * GsonConverterFactory
 * <p>
 * OkHttpDownloader
 * <p>
 * OkHttpClient
 * <p>
 * HttpLogInterceptor  Cache
 * <p>
 * Timber             File
 * <p>
 * Context
 */

public class AppController extends Application {
    private Picasso picasso;

    private UserService service;
    private Context context;

    public static AppController get(Activity activity) {
        return (AppController) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

//
        //Context  -->> Pass as Parameter to getPicasso(ctx); --> AppControllerComponent.class
        context = this;
//        AppControllerModule controllerModule =
        //Network --> AppControllerModule.class
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                Timber.d(message);
//            }
//        });
//        File file = new File(getCacheDir(), "okHttpClient");
//        Cache cache = new Cache(file, 10 * 1000 * 1000);
//

        /*
        // --> { AppControllerModule.class}
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(loggingInterceptor)
//                .cache(cache)
//                .build();

        //Picasso  ---> AppControllerModule.class
//        picasso = new Picasso.Builder(context)
//                .downloader(new OkHttp3Downloader(okHttpClient))
//                .build();

        //Client  ----> AppControllerModule.class
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Constants.BASE_URL)
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

        // ------> AppControllerComponent.class
//        service = retrofit.create(UserService.class);
   */
    }


    public UserService getService() {
        return service;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
