package com.iantoxi.prg01;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ToLanguageSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private Prg01Activity context;
    public int selected;

    public ToLanguageSpinnerActivity(Prg01Activity m) {
        context = m;

        Spinner spinner = (Spinner) context.findViewById(R.id.to_language_selection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.languages_display, R.layout.language_selection_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        selected = 0;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        selected = pos;
        context.toLanguageChanged();
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}