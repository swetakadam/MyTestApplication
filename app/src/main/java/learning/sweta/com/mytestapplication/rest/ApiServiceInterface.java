package learning.sweta.com.mytestapplication.rest;

import java.util.List;

import learning.sweta.com.mytestapplication.model.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by swetashinde on 9/6/17.
 */

public interface ApiServiceInterface {
    @GET("api")
    Call<ApiServiceResponse> getUsers(@Query("results") int numberOfUsers);
}
