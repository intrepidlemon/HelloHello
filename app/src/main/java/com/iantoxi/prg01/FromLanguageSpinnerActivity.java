package com.iantoxi.prg01;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class FromLanguageSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private Prg01Activity mainActivity;
    public int selectedInt;

    public FromLanguageSpinnerActivity(Prg01Activity m) {
        mainActivity = m;

        Spinner spinner = (Spinner) findViewById(R.id.from_language_selection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages, R.layout.language_selection_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        selectedInt = 0;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        selectedInt = pos;
        mainActivity.fromLanguageChanged();
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}