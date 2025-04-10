package com.sharedpreferences;

import android.view.View;
import android.widget.AdapterView;

public class HobbySpinner implements AdapterView.OnItemSelectedListener {

    String hobby;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        hobby = parent.getItemAtPosition( position ).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        hobby = null;
    }

    public String getHobby() {
            return hobby;
    }
}
