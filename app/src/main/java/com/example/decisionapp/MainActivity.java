package com.example.decisionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] questions = {"Java was introduced in 1920?","Is java a person?", "Is java was created using Python",
            "Is Java has abstract classes","Is Java supports interfaces"};
    private boolean[] answers = {false, false, false, true, true};
    private int score = 0;
    Button YES;
    Button NO;
    TextView question;
    private int index = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        YES = findViewById(R.id.YES);
        NO = findViewById(R.id.NO);
        question = findViewById(R.id.question);
        question.setText(questions[index]);
        YES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index <= questions.length-1)
                {
                    //if you have given correct answer
                    if(answers[index]==true)
                    {
                        score++;
                    }
                    //goto next question
                    index++;
                    if(index <= questions.length-1)
                    {
                        question.setText(questions[index]);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Your Score is" + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Restart the app to open again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        NO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if the array is not going out of bound
                if(index <= questions.length-1)
                {
                    //if you have given correct answer
                    if(answers[index]==false)
                    {
                        score++;
                    }
                    //goto next question
                    index++;
                    if(index <= questions.length-1)
                    {
                        question.setText(questions[index]);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Your Score is" + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Restart the app to open again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}