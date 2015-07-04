package me.doapps.vuelvetecachimbo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import me.doapps.vuelvetecahimbo.R;

/**
 * Created by doapps on 7/4/15.
 */
public class FilterActivity extends ActionBarActivity{
    private Button btnTest;
    private Spinner spinnerYear, spinnerArea, spinnerCant;

    ArrayAdapter<String> adapterYear;
    ArrayAdapter<String> adapterArea;
    ArrayAdapter<String> adapterCant;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        spinnerYear = (Spinner) findViewById(R.id.spinnerYear);
        spinnerArea = (Spinner) findViewById(R.id.spinnerArea);
        spinnerCant = (Spinner) findViewById(R.id.spinnerCant);

        setValueSpinner(spinnerYear, new String[]{"2007", "2008"});
        setValueSpinner(spinnerArea, new String[]{"Mate", "Lengua"});
        setValueSpinner(spinnerCant, new String[]{"10", "20"});

        btnTest = (Button) findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FilterActivity.this, ResultActivity.class));
            }
        });
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
}
