package atthack.privatechat.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import atthack.privatechat.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Edgar Salvador Maurilio on 10/10/2015.
 */
public class SharedInfoDialog extends DialogFragment {

    private static final String TAG = SharedInfoDialog.class.getSimpleName();
    @Bind(R.id.checkBoxFacebook)
    CheckBox checkBoxFacebook;

    @Bind(R.id.checkBoxTwitter)
    CheckBox checkBoxTwitter;

    @Bind(R.id.checkBoxPhone)
    CheckBox checkBoxPhone;

    private OnSendSocialNetworkListener onSendSocialNetworkListener;

    private boolean checkSocialNetwork[] = {false, false, false};

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        onSendSocialNetworkListener = (OnSendSocialNetworkListener) context;
//    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle(R.string.shared_you);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View viewItem = inflater.inflate(R.layout.dialog_sheared_info, null);

        ButterKnife.bind(this, viewItem);

        builder.setView(viewItem);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                onSendSocialNetworkListener.socialNetwork(checkSocialNetwork);
            }
        });

        builder.setNegativeButton(R.string.cancel, null);

        return builder.create();
    }


    @OnClick({R.id.containerFacebook, R.id.containerTwitter, R.id.containerPhone})
    public void onClickContainer(View container) {
        switch (container.getId()) {
            case R.id.containerFacebook:
                checkSocialNetwork[0] = !checkBoxFacebook.isChecked();
                checkBoxFacebook.setChecked(!checkBoxFacebook.isChecked());
                break;
            case R.id.containerTwitter:
                checkSocialNetwork[1] = !checkBoxFacebook.isChecked();
                checkBoxTwitter.setChecked(!checkBoxTwitter.isChecked());
                break;
            case R.id.containerPhone:
                checkSocialNetwork[2] = !checkBoxFacebook.isChecked();
                checkBoxPhone.setChecked(!checkBoxPhone.isChecked());
                break;
        }
    }

    public interface OnSendSocialNetworkListener
    {
        void socialNetwork(boolean[] checkSocialNetwork);
    }

}
