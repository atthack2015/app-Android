package atthack.privatechat.ui.commons;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import atthack.privatechat.R;
import butterknife.Bind;
import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        injectViews();
        setupToolbar();
    }


    protected abstract int getLayout();

    public void setupToolbar() {
        setSupportActionBar(mToolbar);
    }

    public void setupDisplayHome() {
        ActionBar actionBar = getSupportActionBar();
        if (getSupportActionBar() != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void injectViews() {
        ButterKnife.bind(this);
    }

}

