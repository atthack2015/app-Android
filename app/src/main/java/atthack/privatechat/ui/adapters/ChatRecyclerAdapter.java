package atthack.privatechat.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import atthack.privatechat.R;
import atthack.privatechat.io.model.Chat;
import atthack.privatechat.io.utils.ApiConstates;
import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by LEONARDO on 10/10/2015.
 */
public class ChatRecyclerAdapter extends RecyclerView.Adapter<ChatRecyclerAdapter.ViewHolder> {

    private List<Chat> chatList;
    private LayoutInflater inflater;

    public ChatRecyclerAdapter(Context context, List<Chat> chatList) {
        inflater = LayoutInflater.from(context);
        this.chatList = chatList;
    }


    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    public void addChat(Chat chat) {
        chatList.add(0,chat);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {

        if (chatList.get(position).getTypeChat() == ApiConstates.TypeChat.RECEIVE) {
            return R.layout.item_chat_receive;
        } else {
            return R.layout.item_chat_sent;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(viewType, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Chat chat = chatList.get(position);
        holder.setImage(chat.getIdImage());
        holder.setText(chat.getChat());
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.imageViewPerfil)
        CircleImageView imageViewPerfil;

        @Bind(R.id.textViewChat)
        TextView textViewChat;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setImage(int idImage) {
            imageViewPerfil.setImageResource(idImage);
        }

        public void setText(String text) {
            textViewChat.setText(text);
        }

    }
}
