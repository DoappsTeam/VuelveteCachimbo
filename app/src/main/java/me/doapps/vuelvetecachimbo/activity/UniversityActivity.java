package me.doapps.vuelvetecachimbo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import me.doapps.vuelvetecahimbo.R;

/**
 * Created by doapps on 7/4/15.
 */
public class UniversityActivity extends ActionBarActivity {
    private ImageView imgUni;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);

        imgUni = (ImageView) findViewById(R.id.imgUni);
        imgUni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UniversityActivity.this, FilterActivity.class));
            }
        });
    }
}
