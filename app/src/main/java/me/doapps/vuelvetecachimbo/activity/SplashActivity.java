package me.doapps.vuelvetecachimbo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import me.doapps.vuelvetecachimbo.R;
import me.doapps.vuelvetecachimbo.util.FontUtil;

/**
 * Created by doapps on 7/4/15.
 */
public class SplashActivity extends ActionBarActivity {
    private TextView textSplash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        textSplash = (TextView) findViewById(R.id.textSplash);
        textSplash.setTypeface(FontUtil.setVarsity(this));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, UniversityActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
