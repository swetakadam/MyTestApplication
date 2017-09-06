package learning.sweta.com.mytestapplication.rest;

/**
 * Created by swetashinde on 9/6/17.
 */

import okhttp3.Request;
import okhttp3.Response;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by swetashinde on 7/28/16.
 */
public class ApiClient {

    // To DO read it from configuration file or store it in preferred location
    // default must be api.signnow.com
    // user can overwrite this value in app settings
    // can be replaced by signing link hostname .. this must be flexible ..
    // this property should be able to be overwritten hence static final not gonna work :(
    public static final String BASE_URL = "https://randomuser.me/"; // trailing slash needed


    private static Retrofit retrofit = null;

    private static Retrofit retrofitBasic  = null;
   // private static Retrofit retrofitBearer = null;
   // private static Retrofit retrofitBearerLink = null; // this is for signing using links -- not logged in user or web links and so on ...


    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    //private static OkHttpClient.Builder httpClientBearer = new OkHttpClient.Builder();

    //private static OkHttpClient.Builder httpClientBearerLink = new OkHttpClient.Builder();





    public static Retrofit getClient(){
        if(retrofit == null){

            // can add here interceptors and so on  ... like pass access token with every api call
            // fetch access token from file or database or from url  ...

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();



        }

        return retrofit;

    }







    /**
     * Needed during log off process to clear out tokens in header ...
     */
    public static void clearClients(){
        retrofit = null;
        retrofitBasic = null;
        //retrofitBearer = null;
        //retrofitBearerLink = null;


    }
    // method to overwrite default api server
    // method to use second signer token

}
