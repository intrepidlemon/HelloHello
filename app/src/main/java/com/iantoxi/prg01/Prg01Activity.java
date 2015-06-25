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

import java.util.Locale;

public class Prg01Activity extends Activity {
    public FromLanguageSpinnerActivity from;
    public ToLanguageSpinnerActivity to;
    public PhraseSpinnerActivity phrase;

    public String[] languages;
    public String[] to_languages_displays;
    public String[][] translations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_prg01);

        int defaultLanguage = 0;
        String systemLanguage = Locale.getDefault().getLanguage();
        if ("zh".equals(systemLanguage)) {
            defaultLanguage = 1;
        } else if ("es".equals(systemLanguage)) {
            defaultLanguage = 2;
        }


        from = new FromLanguageSpinnerActivity(this, defaultLanguage);
        Resources res = getResources();
        languages = res.getStringArray(R.array.languages);


        // All different translations spinner values
        translations = new String[languages.length + 1][];

        for (int i = 0; i < languages.length; i++) {
            translations[i] = res.getStringArray(res.getIdentifier(languages[i], "array", getPackageName()));
        }
        String[] combinedTranslations = new String[translations[0].length];
        for (int i = 0; i < translations[0].length; i ++) {
            String word = "";
            for (int j = 0; j < languages.length; j++) {
                word = word + translations[j][i] + "\n";
            }
            combinedTranslations[i] = word;
        }
        translations[languages.length] = combinedTranslations;

        //Set up to_languages displays
        to_languages_displays = res.getStringArray(R.array.to_languages_display);
        to = new ToLanguageSpinnerActivity(this, res.getIdentifier(to_languages_displays[defaultLanguage], "array", getPackageName()), defaultLanguage);
        phrase = new PhraseSpinnerActivity(this, res.getIdentifier(languages[defaultLanguage], "array", getPackageName()), 0);

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

    public void fromLanguageChanged() {
        int currentPhrase = phrase.selected;
        int currentLanguage = to.selected;
        int selectedLanguagePhrases = getResources().getIdentifier(languages[from.selected], "array", getPackageName());
        int selectedLanguage = getResources().getIdentifier(to_languages_displays[from.selected], "array", getPackageName());
        to = new ToLanguageSpinnerActivity(this, selectedLanguage, currentLanguage);
        phrase = new PhraseSpinnerActivity(this, selectedLanguagePhrases, currentPhrase);
    }

    public void changePhrase() {
        TextView myTextView = (TextView) findViewById(R.id.translation_result);
        myTextView.setText(translations[to.selected][phrase.selected]);
    }

    public void toLanguageChanged(){
        changePhrase();
    }
    public void phraseChanged() {
        changePhrase();
    }
}
