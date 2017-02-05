package com.moosa.dagger2.dependencies;

import com.moosa.dagger2.network.UserService;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Moosa on 05/02/2017.
 * moosa.bh@gmail.com
 */

@Component(modules = {AppControllerModule.class,PicassoModule.class})
public interface AppControllerComponent {

    UserService getUserService();

    Picasso getPicasso();
}
