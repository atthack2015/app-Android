package atthack.privatechat.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import atthack.privatechat.R;
import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by LEONARDO on 10/10/2015.
 */
public class MyAdapterRecyclerView extends RecyclerView.Adapter<MyAdapterRecyclerView.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView circleImageView;
        TextView textView;


        public ViewHolder(View itemView, int idcircleimage, int idTextView) {
            super(itemView);
            itemView.setOnClickListener(this);

            circleImageView = (CircleImageView) itemView.findViewById(idcircleimage);
            textView = (TextView) itemView.findViewById(idTextView);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
