package atthack.privatechat.ui.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import atthack.privatechat.R;
import atthack.privatechat.ui.fragments.ActivesFragment;
import atthack.privatechat.ui.fragments.AvailableFragment;
import atthack.privatechat.ui.utils.models.ModelPagerFragment;

/**
 * Created by sati on 19/07/2015.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<ModelPagerFragment> fragments;

    public MyFragmentPagerAdapter(FragmentManager fm, List<ModelPagerFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position).getmFragmentPager();
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTittleTab();
    }

    public static List<ModelPagerFragment> crateArrayModelFragments(Context context) {
        List<ModelPagerFragment> modelPagerFragments = new ArrayList<>();

        modelPagerFragments.add(new ModelPagerFragment(new AvailableFragment(), context.getString(R.string.title_tab_available)));
        modelPagerFragments.add(new ModelPagerFragment(new ActivesFragment(), context.getString(R.string.title_tab_actives)));

        return modelPagerFragments;
    }


}
