package com.moosa.dagger2.dependencies;

import com.moosa.dagger2.network.UserService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Moosa on 05/02/2017.
 * moosa.bh@gmail.com
 */

@Module
public class AppControllerModule {

    @Provides
    public UserService userService(Retrofit retrofit) {//7
        return retrofit.create(UserService.class);
    }


}
