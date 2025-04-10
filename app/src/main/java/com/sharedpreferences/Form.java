package com.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Form extends AppCompatActivity {

    EditText edt_name, edt_edad;
    Button btn_login;
    Spinner spinner_hobby;

    public static final String formDataCache = "formData";
    private static final int modo_private = Context.MODE_PRIVATE;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form);

        edt_name = findViewById(R.id.edt_name);
        edt_edad = findViewById(R.id.edt_edad);

        spinner_hobby = findViewById(R.id.spinner_hobby);
        initSpinner( spinner_hobby );

        sharedPreferences = getSharedPreferences(formDataCache, modo_private);
        editor = sharedPreferences.edit();

        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_name.getText().toString();
                String edad = edt_edad.getText().toString();
                String hobby = getSpinnerValue();

                if ( name.isEmpty() || edad.isEmpty()) {
                    Toast.makeText(Form.this, "You must complete all fields", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("name", name);
                    editor.putString("edad", edad);
                    editor.putString("hobby", hobby);


                }
            }
        });



    }

    private void initSpinner(Spinner spinner) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.hobby_options,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter( adapter );

        HobbySpinner hobbySpinner = new HobbySpinner();
        spinner.setOnItemSelectedListener( hobbySpinner );
    }

    private String getSpinnerValue() {
        HobbySpinner hobbySpinner = new HobbySpinner();
        return hobbySpinner.getHobby();
    }
}