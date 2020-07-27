package com.example.quiz_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_2 extends AppCompatActivity {

    private Button easybutton;
    private Button mediumbutton;
    private Button difficultbutton;
    private Button inst_buttton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        easybutton = findViewById(R.id.easybutton);
        easybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_2.this, Activity_easy.class);
                startActivity(intent);
            }
        });

        mediumbutton = findViewById(R.id.mediumbutton);
        mediumbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Activity_2.this, Activity_medium.class);
                startActivity(intent1);
            }
        });

        difficultbutton = findViewById(R.id.difficultbutton);
        difficultbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Activity_2.this,Activity_difficult.class);
                startActivity(intent2);
            }
        });

        inst_buttton = findViewById(R.id.instructions);
        inst_buttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_2.this, Activity_instructions.class);
                startActivity(intent);
            }
        });
    }
}
