package atthack.privatechat.ui.fragments;


import android.support.v4.app.Fragment;

import atthack.privatechat.R;
import atthack.privatechat.ui.commons.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivesFragment extends BaseFragment  {

    private static final String TAG = ActivesFragment.class.getSimpleName();


    public ActivesFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_actives;
    }


}
