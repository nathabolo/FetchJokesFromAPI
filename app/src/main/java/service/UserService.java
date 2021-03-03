package service;

import java.util.List;

import model.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("random")
    Call<ApiResponse> getAllJokes();

}
