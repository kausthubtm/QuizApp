package com.example.quiz_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_score extends AppCompatActivity {

    private TextView score;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        int score2 = getIntent().getIntExtra("keyscore",0);
        int totalnoques = getIntent().getIntExtra("totalques",5);
        score = findViewById(R.id.score1);
        score.setText("SCORE : "+score2+"/"+totalnoques);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_score.this,Activity_2.class);
                startActivity(intent);
            }
        });
    }
}
