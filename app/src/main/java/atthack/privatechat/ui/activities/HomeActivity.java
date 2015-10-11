package atthack.privatechat.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import atthack.privatechat.R;
import atthack.privatechat.ui.adapters.MyFragmentPagerAdapter;
import atthack.privatechat.ui.commons.BaseActivity;
<<<<<<< HEAD
import atthack.privatechat.ui.dialogs.OutAreaDialog;
import atthack.privatechat.ui.dialogs.SharedInfoDialog;
=======
import atthack.privatechat.ui.fragments.InvitacionDialogFragment;
>>>>>>> feautere_uiinvitacion
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
        return R.layout.activity_home;
    }

    private void setupViewPager() {

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), MyFragmentPagerAdapter.crateArrayModelFragments(this));
        mViewPager.setAdapter(myFragmentPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_out_area:
                showOutAreDialog();
                break;
            case R.id.action_share_info:
                SharedInfoDialog sharedInfoDialog = new SharedInfoDialog();
                sharedInfoDialog.show(getSupportFragmentManager(), null);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showOutAreDialog() {
        OutAreaDialog outAreaDialog = new OutAreaDialog();
        outAreaDialog.show(getSupportFragmentManager(), null);
    }


}
