package learning.sweta.com.mytestapplication.rest;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

import learning.sweta.com.mytestapplication.model.User;

/**
 * Created by swetashinde on 9/6/17.
 */
@Parcel
public class ApiServiceResponse {

    @SerializedName("results")
    List<User> users;

    public ApiServiceResponse() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
