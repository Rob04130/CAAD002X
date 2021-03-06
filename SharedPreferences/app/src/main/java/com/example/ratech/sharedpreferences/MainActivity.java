package com.example.ratech.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView tvActualUnits;
    private TextView tvResult;
    private EditText etMeter;
    private Button bnConverter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the views items
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        tvActualUnits = (TextView) findViewById(R.id.tvActualUnits);
        tvResult = (TextView) findViewById(R.id.tvResult);
        etMeter = (EditText) findViewById(R.id.etMeters);
        bnConverter = (Button) findViewById(R.id.btConverter);

        // Sets the Toolbar to act as the ActionBar for this Activity window.
        setSupportActionBar(mToolbar);

        // ByDefault
        setDefaultText();

        bnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Convert(Float.parseFloat(etMeter.getText().toString()));
            }
        });

    }

    @Override
    protected void onResume() {
        tvActualUnits.setText(getString(R.string.actual_units, getActualUnitsLabel()));
        super.onResume();
    }


    private void setDefaultText() {
        tvActualUnits.setText(getString(R.string.actual_units, getActualUnitsLabel()));
        etMeter.setText("");
        tvResult.setText(getString(R.string.result,"0"));
    }

    private String getActualUnitsLabel() {
        // Shared preferences
        SharedPreferences mSharedPreferences = getSharedPreferences("ActualUnits", MODE_PRIVATE);
        // Retrieve a value
        return mSharedPreferences.getString("Label", "cm"); // "cm" default value
    }

    private float getActualUnits() {
        // Shared preferences
        SharedPreferences mSharedPreferences = getSharedPreferences("ActualUnits", MODE_PRIVATE);
        // Retrieve a value
        return mSharedPreferences.getFloat("Unit", 100f); // 100f is a default value for cm
    }

    private void Convert(float value) {
        tvResult.setText(getString(R.string.result, String.valueOf(value * getActualUnits())));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            startActivity(new Intent(this, Settings.class));
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }
}
