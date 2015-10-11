package atthack.privatechat.io.utils;

/**
 * Created by Edgar Salvador Maurilio on 11/10/2015.
 */
public class ApiConstates {

    public static final String URL_BASE_VER_USUARIOS = "https://shielded-reef-3210.herokuapp.com";
    public static final String PATH_USERS = "/users";
    public static final String PATH_SHOW = "/show";

    public static final String URL_LISTA_USUARIOS = PATH_USERS + PATH_SHOW;


    //CrearUusario

    public static final String URL_BASE_CREATE_USER="https://shielded-reef-3210.herokup.com";

    //Update
    public static final String URL_BASE_UPDATE="https://shielded-reef-3210.herokuapp.com/users/update";


    public enum TypeChat {
        RECEIVE, SENT
    }
}
