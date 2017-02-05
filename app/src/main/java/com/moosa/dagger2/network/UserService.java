package com.moosa.dagger2.network;

import com.moosa.dagger2.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Moosa on 05/02/2017.
 * moosa.bh@gmail.com
 */

public interface UserService {
    @GET("/users")
    Call<List<User>> getAllUsers();
}
