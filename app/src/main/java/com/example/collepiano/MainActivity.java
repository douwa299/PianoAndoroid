package com.example.collepiano;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.collepiano.R;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private MaterialButton a, b, c, d, e, f;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        a = findViewById(R.id.A);
        b = findViewById(R.id.B);
        c = findViewById(R.id.C);
        d = findViewById(R.id.D);
        e = findViewById(R.id.E);
        f = findViewById(R.id.F);

        // Ajout des écouteurs de clic
        a.setOnClickListener(this::BellClick);
        b.setOnClickListener(this::BellClick);
        c.setOnClickListener(this::BellClick);
        d.setOnClickListener(this::BellClick);
        e.setOnClickListener(this::BellClick);
        f.setOnClickListener(this::BellClick);
    }

    public void BellClick(View view) {
        int id = view.getId();
        try {
            if (mp != null) {
                mp.release(); // Libère l'ancienne ressource
            }

            if (id == R.id.A) {
                mp = MediaPlayer.create(this, R.raw.s1);
            } else if (id == R.id.B) {
                mp = MediaPlayer.create(this, R.raw.s2);
            } else if (id == R.id.C) {
                mp = MediaPlayer.create(this, R.raw.s3);
            } else if (id == R.id.D) {
                mp = MediaPlayer.create(this, R.raw.s4);
            } else if (id == R.id.E) {
                mp = MediaPlayer.create(this, R.raw.s5);
            } else if (id == R.id.F) {
                mp = MediaPlayer.create(this, R.raw.s6);
            }

            if (mp != null) {
                mp.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp != null) {
            mp.release(); // Libère le MediaPlayer à la fermeture de l'activité
            mp = null;
        }
    }
    
}
