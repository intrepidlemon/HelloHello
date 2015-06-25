package com.iantoxi.prg01;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Prg01Activity extends Activity {
    public FromLanguageSpinnerActivity from;
    public ToLanguageSpinnerActivity to;
    public PhraseSpinnerActivity phrase;

    public String[] languages;
    public String[][] translations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_prg01);

        from = new FromLanguageSpinnerActivity(this);
        to = new ToLanguageSpinnerActivity(this);
        phrase = new PhraseSpinnerActivity(this, R.array.english, 0);

        Resources res = getResources();
        languages = res.getStringArray(R.array.languages);

        translations = new String[languages.length][];

        for (int i = 0; i < languages.length; i++) {
            translations[i] = res.getStringArray(res.getIdentifier(languages[i], "array", getPackageName()));
        }

        changePhrase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prg01, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changePhrase() {
        TextView myTextView = (TextView) findViewById(R.id.translation_result);
        myTextView.setText(translations[to.selected][phrase.selected]);
    }

    public void fromLanguageChanged() {

    }
    public void toLanguageChanged(){
        changePhrase();
    }
    public void phraseChanged() {
        changePhrase();
    }
}
