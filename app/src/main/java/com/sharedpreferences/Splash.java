package com.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {


    public static final String formDataCache = "formData";
    private static final int modo_private = Context.MODE_PRIVATE;

    String hobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        validateHobby();
    }

    private void validateHobby() {
        hobby = getApplicationContext().getSharedPreferences(formDataCache, modo_private).getString("hobby", null);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i;
                if ( hobby == null) {
                    i = new Intent(Splash.this, Form.class);
                    startActivity(i);
                } else {
                    switch (hobby) {
                        case "Cine":
                            i = new Intent(Splash.this, CineActivity.class);
                            startActivity(i);
                            break;
                        case "Deporte":
                            i = new Intent(Splash.this, DeporteActivity.class);
                            startActivity(i);
                            break;
                        case "Musica":
                            i = new Intent(Splash.this, MusicaActivity.class);
                            startActivity(i);
                            break;
                        default:
                            break;
                    }
                }
            }
        }, 2000);
    }
}