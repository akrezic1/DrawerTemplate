package andro.heklaton.rsc.api;

import andro.heklaton.rsc.api.request.LoginRequest;
import andro.heklaton.rsc.model.login.User;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by Andro on 11/19/2015.
 */
public interface RestAPI {

    String HEADER="application/json";

    @POST("/login")
    void login(
            @Header("Content-Type") String contentType,
            @Body LoginRequest email,
            Callback<User> response
    );

}
