package atthack.privatechat.io;

import android.provider.SyncStateContract;

import java.util.Calendar;

import atthack.privatechat.io.model.Chat;
import atthack.privatechat.io.model.Update;
import atthack.privatechat.io.model.User;
import atthack.privatechat.io.utils.ApiConstates;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by LEONARDO on 11/10/2015.
 */
public interface ApiService {
    @GET(ApiConstates.URL_LISTA_USUARIOS)

    void listUser(@Query(ApiConstates.URL_LISTA_USUARIOS)Callback<Chat>serviceResponse);

    @POST(ApiConstates.URL_BASE_CREATE_USER)
    void createUser(@Body User user,Callback<User>serviceCallbackUser );

    @POST(ApiConstates.URL_BASE_UPDATE)
    void update(@Body Update update,Callback<Update>updateCallback);
}
