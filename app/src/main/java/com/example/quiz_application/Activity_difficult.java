package com.example.quiz_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_difficult extends AppCompatActivity {

    TextView questionLabel, questionCountLabel, scoreLabel;
    EditText answerEdt;
    Button submitButton;
    ProgressBar progressBar;
    ArrayList<QuestionModel> questionModelArrayList;

    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficult);


        questionCountLabel = findViewById(R.id.noQuestion);
        questionLabel = findViewById(R.id.question);
        scoreLabel = findViewById(R.id.score);

        answerEdt = findViewById(R.id.answer);
        submitButton = findViewById(R.id.submit);
        progressBar = findViewById(R.id.progress);

        questionModelArrayList = new ArrayList<>();

        setUpQuestion();

        setData();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer();
            }
        });
    }

    public void checkAnswer(){

        String answerString = answerEdt.getText().toString().trim();

        if(answerString.equalsIgnoreCase(questionModelArrayList.get(currentPosition).getAnswer())){

            numberOfCorrectAnswer ++;
            Log.e("answer","right");
        }else {
            Log.e("answer","wrong");
        }

        currentPosition ++;
        if(currentPosition==5) {
            Intent intent3 = new Intent(Activity_difficult.this, Activity_score.class);
            intent3.putExtra("keyscore", numberOfCorrectAnswer);
            intent3.putExtra("totalques", questionModelArrayList.size());
            startActivity(intent3);
        }else {
            setData();
            answerEdt.setText("");

            int x = ((currentPosition + 1) * 100) / questionModelArrayList.size();

            progressBar.setProgress(x);
        }
    }


    public void setUpQuestion(){

        questionModelArrayList.add(new QuestionModel(  "Differentiate sin(x)=?", "cos(x)"));
        questionModelArrayList.add(new QuestionModel( "integral sin(x)=?", "-cos(x)"));
        questionModelArrayList.add(new QuestionModel( "sin(2x)=?", "2sin(x)cos(x)"));
        questionModelArrayList.add(new QuestionModel( "equation of a straight line=?", "y=mx+c"));
        questionModelArrayList.add(new QuestionModel( "sin(45)-cos(45)=?", "0"));

    }

    public void setData(){

        questionLabel.setText(questionModelArrayList.get(currentPosition).getQuestionString());
        questionCountLabel.setText("Question no: "+(currentPosition+1));
        scoreLabel.setText("Score : " + numberOfCorrectAnswer +"/"+ questionModelArrayList.size());

    }




}