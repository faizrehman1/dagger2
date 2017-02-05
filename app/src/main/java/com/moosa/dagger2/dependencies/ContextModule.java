package com.moosa.dagger2.dependencies;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Moosa on 05/02/2017.
 * moosa.bh@gmail.com
 */

@Module
public class ContextModule {

    public Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context getContext() {
        return context;
    }

}
