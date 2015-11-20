package andro.heklaton.rsc.util;

import com.activeandroid.query.Select;

import andro.heklaton.rsc.model.login.User;

/**
 * Created by Andro on 11/20/2015.
 */
public class DBHelper {

    public static User getUser() {
        return new Select().from(User.class).executeSingle();
    }

}
