package com.example.quiz_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button submitbutton;
    private EditText username;
    private EditText password;
    String toast_string1 = "Wrong username or password";
    String toast_string2 = "username:Admin password: 1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitbutton = findViewById(R.id.submitbutton);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, Activity_2.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),toast_string2,Toast.LENGTH_LONG).show();
        }
    }
}
