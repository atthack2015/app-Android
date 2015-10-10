package atthack.privatechat.ui.commons;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {

    protected Context CONTEXT;

    public BaseFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CONTEXT = context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbindViews();
    }

    protected abstract int getFragmentLayout();

    private void bindViews(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    private void unbindViews() {
        ButterKnife.unbind(this);
    }

}
