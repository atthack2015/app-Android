package atthack.privatechat.ui.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import butterknife.Bind;

/**
 * Created by LEONARDO on 10/10/2015.
 */
public class InvitacionDialogFragment extends DialogFragment {
    public static final String TAG = InvitacionDialogFragment.class.getSimpleName();

    public InvitacionDialogFragment() {

    }

    public static InvitacionDialogFragment newInstance(String title) {
        InvitacionDialogFragment fragmentdialog = new InvitacionDialogFragment();
        Bundle args = new Bundle();
        args.putString("Invitacion", title);
        fragmentdialog.setArguments(args);
        return fragmentdialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog= new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Invitacion");
        alertDialog.setMessage("Aceptar invitacion");
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return alertDialog.create();
                    }

    public  void showAlertDialog(Context context, String title , String message, Boolean status){

    }
}
