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
    private Prg01Activity context;
    public int selected;

    public FromLanguageSpinnerActivity(Prg01Activity m, int s) {
        context = m;
        selected = s;
        Spinner spinner = (Spinner) context.findViewById(R.id.from_language_selection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.languages_display, R.layout.language_selection_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(selected);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        selected = pos;
        context.fromLanguageChanged();
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}