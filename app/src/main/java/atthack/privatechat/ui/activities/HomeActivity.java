package atthack.privatechat.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import atthack.privatechat.R;
import atthack.privatechat.ui.adapters.MyFragmentPagerAdapter;
import atthack.privatechat.ui.commons.BaseActivity;
import atthack.privatechat.ui.fragments.InvitacionDialogFragment;
import butterknife.Bind;

public class HomeActivity extends BaseActivity {

    public static final String TAG = HomeActivity.class.getSimpleName();


    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViewPager();

    }

    @Override
    protected int getLayout() {
        return R.layout.home_main;
    }

    private void setupViewPager() {

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), MyFragmentPagerAdapter.crateArrayModelFragments(this));
        mViewPager.setAdapter(myFragmentPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
