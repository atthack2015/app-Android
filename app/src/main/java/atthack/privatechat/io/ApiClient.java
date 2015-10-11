package atthack.privatechat.io;

import atthack.privatechat.io.model.Chat;
import atthack.privatechat.io.model.Update;
import atthack.privatechat.io.model.User;
import atthack.privatechat.io.utils.ApiConstates;
import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by LEONARDO on 11/10/2015.
 */
public class ApiClient {
    public static ApiService apiService;

    public static ApiService getInstance() {
        if (apiService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(ApiConstates.URL_BASE_VER_USUARIOS)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();

            apiService = restAdapter.create(ApiService.class);
        }
        return apiService;
    }

    public static void listUser(Callback<Chat> serverResponse) {
        getInstance().listUser(serverResponse);
    }
    public static void createUser(User user,Callback<User> userCallback){
        getInstance().createUser(user, userCallback);
    }

    public static void update(Update update,Callback<Update>updateCallback){
        getInstance().update(update,updateCallback);
    }

}
