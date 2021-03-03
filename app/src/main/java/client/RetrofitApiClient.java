package client;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.UserService;

public class RetrofitApiClient {

    public static  final String BASE_URL = "https://api.chucknorris.io/jokes/";
    public static Retrofit retrofit = null;
    private static Retrofit getRetrofit(){

        if (retrofit == null){

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

        }

        return retrofit;
    }

    public static UserService getUserService(){
        UserService userService = getRetrofit().create(UserService.class);
        return userService;
    }
}
