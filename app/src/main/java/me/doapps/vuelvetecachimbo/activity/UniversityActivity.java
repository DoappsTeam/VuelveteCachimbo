package me.doapps.vuelvetecachimbo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import me.doapps.vuelvetecachimbo.R;
import me.doapps.vuelvetecachimbo.adapter.UniversityAdapter;
import me.doapps.vuelvetecachimbo.model.University;

/**
 * Created by doapps on 7/4/15.
 */
public class UniversityActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    private GridView gridUniversity;
    private List<University> universities;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        universities = new ArrayList<>();
        universities.add(new University("UNMSM", R.mipmap.ic_unmsm));
        universities.add(new University("UNI", R.mipmap.ic_uni));
        universities.add(new University("UNAC", R.mipmap.ic_unac));
        universities.add(new University("PUCP", R.mipmap.ic_pucp));

        gridUniversity = (GridView) findViewById(R.id.gridUniversity);
        gridUniversity.setOnItemClickListener(this);
        gridUniversity.setAdapter(new UniversityAdapter(universities, UniversityActivity.this));

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(new Intent(UniversityActivity.this, FilterActivity.class));
    }
}
