package atthack.privatechat.ui.activities;

import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import atthack.privatechat.R;
import atthack.privatechat.ui.adapters.MyFragmentPagerAdapter;
import atthack.privatechat.ui.commons.BaseActivity;

import atthack.privatechat.ui.dialogs.OutAreaDialog;
import atthack.privatechat.ui.dialogs.SharedInfoDialog;
import atthack.privatechat.ui.fragments.InvitacionDialogFragment;

import butterknife.Bind;

public class HomeActivity extends BaseActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    public static final String TAG = HomeActivity.class.getSimpleName();


    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;

    /**
     * Provides the entry point to Google Play services.
     */
    protected GoogleApiClient googleApiClient;
    /**
     * My last or current location
     */
    protected Location myCurrentLocation;
    /**
     * Request for updates location
     */
    protected LocationRequest locationRequest;
    public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 30000;
    public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViewPager();
        buildGoogleApiClient();
    }

    @Override
    protected void onResume() {
        super.onResume();
        googleApiClient.connect();
    }

    protected synchronized void buildGoogleApiClient(){
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        createLocationRequest();
    }

    protected void createLocationRequest(){
        locationRequest = new LocationRequest();
        locationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        locationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    protected void startLocationUpdate(){
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
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


    @Override
    public void onConnected(Bundle bundle) {
        myCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (myCurrentLocation != null){
            Log.d(TAG, String.valueOf(myCurrentLocation.getLatitude()));
            Log.d(TAG, String.valueOf(myCurrentLocation.getLongitude()));
        }
        startLocationUpdate();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    /**
     * Implemented by LocationListener
     */
    @Override
    public void onLocationChanged(Location location) {
        myCurrentLocation =location;
        Log.d(TAG, myCurrentLocation.toString());
    }
}
