package atthack.privatechat.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import atthack.privatechat.R;
import atthack.privatechat.io.model.Chat;
import atthack.privatechat.io.utils.ApiConstates;
import atthack.privatechat.ui.adapters.ChatRecyclerAdapter;
import atthack.privatechat.ui.commons.BaseActivity;
import butterknife.Bind;
import butterknife.OnClick;

public class ChatActivity extends BaseActivity {

    @Bind(R.id.recyclerViewChat)
    RecyclerView recyclerView;

    @Bind(R.id.editTextChat)
    EditText editText;

    private ChatRecyclerAdapter chatRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupDisplayHome();
        setupRecyclerView();
        setupEdittextChat();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        chatRecyclerAdapter = new ChatRecyclerAdapter(this, createChatList());
        recyclerView.setAdapter(chatRecyclerAdapter);
    }

    public void setupEdittextChat() {
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    sendMessage();
                }
                return false;
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_chat;
    }


    @OnClick(R.id.floatingButtonChat)
    public void sendChat() {
        sendMessage();
    }

    private void sendMessage() {
        String message = editText.getText().toString();
        if (!TextUtils.isEmpty(message)) {
            chatRecyclerAdapter.addChat(new Chat(R.mipmap.ic_launcher, message, ApiConstates.TypeChat.SENT));
        }
    }


    public List<Chat> createChatList() {
        List<Chat> chatList = new ArrayList<>();

        chatList.add(new Chat(R.mipmap.ic_launcher, "Bien y tu??", ApiConstates.TypeChat.RECEIVE));
        chatList.add(new Chat(R.mipmap.ic_launcher, "Hola como estas", ApiConstates.TypeChat.SENT));

        return chatList;
    }


}
