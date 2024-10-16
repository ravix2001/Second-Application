package com.example.secondapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private Button t_btn;
    private Button r_btn;
    private Button s_btn;
    private Button a_btn;


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

        title = findViewById(R.id.title);
        t_btn = findViewById(R.id.t_btn);
        r_btn = findViewById(R.id.r_btn);
        s_btn = findViewById(R.id.s_btn);
        a_btn = findViewById(R.id.a_btn);


        Animation translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        Animation rotate =AnimationUtils.loadAnimation(this,R.anim.rotate);
        Animation scale =AnimationUtils.loadAnimation(this,R.anim.scale);
        Animation alpha =AnimationUtils.loadAnimation(this,R.anim.alpha);

        t_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Translating", Toast.LENGTH_SHORT).show();
                title.startAnimation(translate);
            }
        });

        r_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Rotating", Toast.LENGTH_SHORT).show();
                title.startAnimation(rotate);
            }
        });

        s_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Scaling", Toast.LENGTH_SHORT).show();
                title.startAnimation(scale);
            }
        });

        a_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Visible & Invisible", Toast.LENGTH_SHORT).show();
                title.startAnimation(alpha);
            }
        });
    }
}