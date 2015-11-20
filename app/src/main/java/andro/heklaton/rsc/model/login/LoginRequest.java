package andro.heklaton.rsc.model.login;

import com.google.gson.annotations.Expose;

/**
 * Created by Andro on 11/19/2015.
 */
public class LoginRequest {

    @Expose
    private String username;
    @Expose
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
