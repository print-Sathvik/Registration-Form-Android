package com.example.spinnerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ForgotActivity extends AppCompatActivity
{
    Spinner spinner;
    EditText answerWidget;
    String answer;
    String[] Questions = {"Your favourite food?", "Your birth place", "Your pet name"};
    int selectedQuestion=0;
    String[] answers = {"you", "hospital", "don"};
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinnerlayout);
        answerWidget = findViewById(R.id.answer);

        spinner = findViewById(R.id.spin);
        ArrayAdapter<String> arad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Questions);
        arad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                selectedQuestion = position;
                Toast.makeText(getBaseContext(), "Selected " + Questions[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner.setAdapter(arad);
    }

    public void checkForgot(View v)
    {
        answer = answerWidget.getText().toString();
        if(answer.equals(answers[selectedQuestion]))
        {
            Toast.makeText(getBaseContext(), "Correct Answer " + answer + selectedQuestion, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(), "Wrong Answer "+ answer + selectedQuestion, Toast.LENGTH_SHORT).show();
        }
    }
}
