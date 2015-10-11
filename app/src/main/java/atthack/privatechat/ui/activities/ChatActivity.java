package atthack.privatechat.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import atthack.privatechat.R;
import atthack.privatechat.io.model.Chat;
import atthack.privatechat.io.utils.ApiConstates;
import atthack.privatechat.ui.adapters.ChatRecyclerAdapter;
import atthack.privatechat.ui.commons.BaseActivity;
import butterknife.Bind;

public class ChatActivity extends BaseActivity {

    @Bind(R.id.recyclerViewChat)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        ChatRecyclerAdapter chatRecyclerAdapter = new ChatRecyclerAdapter(this, createChatList());
        recyclerView.setAdapter(chatRecyclerAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_chat;
    }


    public List<Chat> createChatList() {
        List<Chat> chatList = new ArrayList<>();

        chatList.add(new Chat(R.mipmap.ic_launcher, "Hola como estas", ApiConstates.TypeChat.SENT));
        chatList.add(new Chat(R.mipmap.ic_launcher, "Bien y tu??", ApiConstates.TypeChat.RECEIVE));

        return chatList;
    }


}
