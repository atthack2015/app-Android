package atthack.privatechat.ui.fragments;


import android.support.v4.app.Fragment;

import atthack.privatechat.R;
import atthack.privatechat.ui.commons.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AvailableFragment extends BaseFragment  {

    private static final String TAG = AvailableFragment.class.getSimpleName();


    public AvailableFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_actives;
    }


}
