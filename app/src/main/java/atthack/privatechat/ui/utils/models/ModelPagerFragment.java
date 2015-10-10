package atthack.privatechat.ui.utils.models;

import android.support.v4.app.Fragment;

/**
 * Created by sati on 19/07/2015.
 */
public class ModelPagerFragment {

    private Fragment mFragmentPager;
    private String tittleTab;

    public ModelPagerFragment(Fragment mFragmentPager, String tittleTab) {
        this.mFragmentPager = mFragmentPager;
        this.tittleTab = tittleTab;
    }

    public Fragment getmFragmentPager() {
        return mFragmentPager;
    }

    public String getTittleTab() {
        return tittleTab;
    }
}
