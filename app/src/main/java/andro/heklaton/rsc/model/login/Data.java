package andro.heklaton.rsc.model.login;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "UserData")
public class Data extends Model {

    @Column(name = "Username")
    @SerializedName("username")
    @Expose
    private String username;

    @Column(name = "Email")
    @SerializedName("email")
    @Expose
    private String email;

    @Column(name = "Token")
    @SerializedName("token")
    @Expose
    private String token;

    @Column(name = "RegistrationId")
    @SerializedName("registrationId")
    @Expose
    private String registrationId;

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The token
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     * The token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     *
     * @return
     * The registrationId
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     *
     * @param registrationId
     * The registrationId
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

}