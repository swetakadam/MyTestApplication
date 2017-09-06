package learning.sweta.com.mytestapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import learning.sweta.com.mytestapplication.R;
import learning.sweta.com.mytestapplication.adapter.UsersAdapter;
import learning.sweta.com.mytestapplication.model.User;
import learning.sweta.com.mytestapplication.rest.ApiClient;
import learning.sweta.com.mytestapplication.rest.ApiServiceInterface;
import learning.sweta.com.mytestapplication.rest.ApiServiceResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";

    private List<User> mUsers;

    @Bind(R.id.user_list) RecyclerView usersRecyclerView;
    Call<ApiServiceResponse> userCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //https://randomuser.me/api/?results=10

        // step1 . make api call
        // step 2 populate recycleview
        Log.v(LOG_TAG,"Starting to make API call");
        makeAPICall(20);



    }

    @Override
    protected void onDestroy() {

        // to cancel on rotation
        /* if(userCall != null && !userCall.isExecuted()){
            userCall.cancel();
        }*/

        super.onDestroy();
    }

    private void makeAPICall(int number){

       Retrofit retrofit = ApiClient.getClient();
       ApiServiceInterface apiService = retrofit.create(ApiServiceInterface.class);

       userCall = apiService.getUsers(number);

        userCall.enqueue(new Callback<ApiServiceResponse>() {
            @Override
            public void onResponse(Call<ApiServiceResponse> call, Response<ApiServiceResponse> response) {
                if(response.isSuccessful()){
                   ApiServiceResponse apiResponse = response.body();

                   mUsers = apiResponse.getUsers();

                   Log.v(LOG_TAG,"Success !!!");

                    updateUI(); // I need to make sure  ..


                }else{
                    Log.v(LOG_TAG,"Something went wrong !!!");
                }
            }

            @Override
            public void onFailure(Call<ApiServiceResponse> call, Throwable t) {

                Log.v(LOG_TAG,"Oops Error !!! "+t.getLocalizedMessage());

            }
        });


    }

    private void updateUI(){
        UsersAdapter adapter = new UsersAdapter(this,mUsers);
        // Attach the adapter to the recyclerview to populate items
        usersRecyclerView.setAdapter(adapter);
        // Set layout manager to position the items
        usersRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
