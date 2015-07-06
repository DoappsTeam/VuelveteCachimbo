package me.doapps.vuelvetecachimbo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import me.doapps.vuelvetecachimbo.R;

/**
 * Created by doapps on 7/4/15.
 */
public class FilterActivity extends ActionBarActivity implements View.OnClickListener {
    private Button btnTest, btnRandom, buttonStart;
    private Spinner spinnerYear, spinnerArea, spinnerCant;
    private LinearLayout linearYear, linearArea, linearCant;

    private Toolbar toolbar;

    ArrayAdapter<String> adapterYear;
    ArrayAdapter<String> adapterArea;
    ArrayAdapter<String> adapterCant;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerYear = (Spinner) findViewById(R.id.spinnerYear);
        spinnerArea = (Spinner) findViewById(R.id.spinnerArea);
        spinnerCant = (Spinner) findViewById(R.id.spinnerCant);

        setValueSpinner(spinnerYear, new String[]{"2007", "2008", "2009", "2010", "2012", "2013"});
        setValueSpinner(spinnerArea, new String[]{"Mate", "Lengua"});
        setValueSpinner(spinnerCant, new String[]{"10", "20"});

        linearYear = (LinearLayout) findViewById(R.id.linearYear);
        linearArea = (LinearLayout) findViewById(R.id.linearArea);
        linearCant = (LinearLayout) findViewById(R.id.linearCant);

        btnRandom = (Button) findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(this);

        btnTest = (Button) findViewById(R.id.btnTest);
        btnTest.setOnClickListener(this);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(this);

    }


    public void setValueSpinner(Spinner spinner, String[] values) {
        ArrayAdapter arrayAdapter = null;
        String blank = " ";
        arrayAdapter = new ArrayAdapter<String>(FilterActivity.this, android.R.layout.simple_spinner_dropdown_item) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView) v.findViewById(android.R.id.text1)).setText("");
                    ((TextView) v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }
                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1; // you dont display last item. It is used as hint.
            }
        };
        if (values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                arrayAdapter.add(values[i]);
            }
            //arrayAdapter.add(selected);

        } else {
            arrayAdapter.add(blank);
        }
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(arrayAdapter.getCount());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonStart:
                startActivity(new Intent(FilterActivity.this, MainActivity.class));
                break;
            case R.id.btnTest:
                btnTest.setBackgroundResource(R.drawable.selector_type);
                btnTest.setTextColor(getResources().getColor(R.color.white));
                btnRandom.setBackgroundResource(R.drawable.selector_type_white);
                btnRandom.setTextColor(getResources().getColor(R.color.primary));
                linearArea.setVisibility(View.GONE);
                linearCant.setVisibility(View.GONE);
                break;
            case R.id.btnRandom:
                btnRandom.setBackgroundResource(R.drawable.selector_type);
                btnRandom.setTextColor(getResources().getColor(R.color.white));
                btnTest.setBackgroundResource(R.drawable.selector_type_white);
                btnTest.setTextColor(getResources().getColor(R.color.primary));
                linearArea.setVisibility(View.VISIBLE);
                linearCant.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
}
