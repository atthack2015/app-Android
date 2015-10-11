package atthack.privatechat.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import atthack.privatechat.R;
import atthack.privatechat.io.model.Chats;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ariana on 11/10/15.
 */
public class ChatsRecyclerAdapter extends RecyclerView.Adapter<ChatsRecyclerAdapter.ViewHolder> {

    Context context;
    private ArrayList<Chats> chats;

    public ChatsRecyclerAdapter(Context context){
        this.context = context;
        this.chats = new ArrayList<>();
    }

    @Override
    public ChatsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View artistView = LayoutInflater.from(context).inflate(R.layout.item_chat_active, parent, false);

        return new ChatsRecyclerAdapter.ViewHolder(artistView);
    }

    @Override
    public void onBindViewHolder(ChatsRecyclerAdapter.ViewHolder holder, int position) {
        Chats chat = chats.get(position);
        holder.setUserAvatar(chat.getAvatar());
        holder.setUsername(chat.getUsername());
        holder.setTags(chat.getTags());
    }

    public void setChatRoom(ArrayList<Chats> chats){
        this.chats.addAll(chats);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.user_avatar)
        TextView userAvatar;

        @Bind(R.id.username)
        TextView username;

        @Bind(R.id.user_tags)
        TextView tags;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), getPosition(), Toast.LENGTH_LONG)
                            .show();
                }
            });
        }

        public void setUserAvatar(String avatar){
            this.userAvatar.setText(avatar);
        }

        public void setUsername(String username){
            this.username.setText(username);
        }

        public void setTags(String tags){
            this.tags.setText(tags);
        }
    }
}
