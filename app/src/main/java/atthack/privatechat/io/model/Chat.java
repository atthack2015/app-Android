package atthack.privatechat.io.model;

import android.text.Editable;

import atthack.privatechat.io.utils.ApiConstates;

/**
 * Created by Edgar Salvador Maurilio on 11/10/2015.
 */
public class Chat {

    private int idImage;
    private String chat;
    private ApiConstates.TypeChat typeChat;

    public Chat(int idImage, String chat, ApiConstates.TypeChat typeChat) {
        this.idImage = idImage;
        this.chat = chat;
        this.typeChat = typeChat;
    }



    public int getIdImage() {
        return idImage;
    }

    public String getChat() {
        return chat;
    }

    public ApiConstates.TypeChat getTypeChat() {
        return typeChat;
    }



}
