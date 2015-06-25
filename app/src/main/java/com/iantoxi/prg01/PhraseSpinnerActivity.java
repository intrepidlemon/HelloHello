package com.iantoxi.prg01;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PhraseSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private Prg01Activity context;
    public int selected;

    public PhraseSpinnerActivity(Prg01Activity m, int phraseArray, int selectedPhrase) {
        context = m;

        Spinner spinner = (Spinner) context.findViewById(R.id.phrase_selector);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                phraseArray, R.layout.phrase_selection_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(selectedPhrase);
        selected = selectedPhrase;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        selected = pos;
        context.phraseChanged();
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}