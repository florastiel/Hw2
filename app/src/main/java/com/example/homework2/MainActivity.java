package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText grade1;
    private EditText grade2;
    private EditText grade3;
    private EditText grade4;
    private EditText grade5;
    private TextView displayGPA;
    private ConstraintLayout Background;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grade1 = (EditText) findViewById(R.id.class1edit);
        grade2 = (EditText) findViewById(R.id.class2edit);
        grade3 = (EditText) findViewById(R.id.class3edit);
        grade4 = (EditText) findViewById(R.id.class4edit);
        grade5 = (EditText) findViewById(R.id.class5edit);
        displayGPA = (TextView) findViewById(R.id.display);
        Background = (ConstraintLayout) findViewById(R.id.background);
        calculate = (Button) findViewById(R.id.calcButton);
    }

    public void calculate(View view) {
        if (calculate.getText().toString().matches("Clear")) {
            grade1.setText("");
            grade2.setText("");
            grade3.setText("");
            grade4.setText("");
            grade5.setText("");
            calculate.setText(getString(R.string.calculate_gpa));
            Background.setBackgroundColor(Color.WHITE);
            return;
        }

        if (grade1.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter a grade for Grade 1", Toast.LENGTH_SHORT).show();
            grade1.setBackgroundColor(Color.RED);
            return;
        }
        else if (grade2.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter a grade for Grade 2", Toast.LENGTH_SHORT).show();
            grade2.setBackgroundColor(Color.RED);
            return;
        }
        else if (grade3.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter a grade for Grade 3", Toast.LENGTH_SHORT).show();
            grade3.setBackgroundColor(Color.RED);
            return;
        }
        else if (grade4.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter a grade for Grade 4", Toast.LENGTH_SHORT).show();
            grade4.setBackgroundColor(Color.RED);
            return;
        }
        else if (grade5.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter a grade for Grade 5", Toast.LENGTH_SHORT).show();
            grade5.setBackgroundColor(Color.RED);
            return;
        }

        double totalBefore = 0;
        totalBefore += Integer.parseInt(grade1.getText().toString());
        totalBefore += Integer.parseInt(grade2.getText().toString());
        totalBefore += Integer.parseInt(grade3.getText().toString());
        totalBefore += Integer.parseInt(grade4.getText().toString());
        totalBefore += Integer.parseInt(grade5.getText().toString()); // get the text and parse into an int. add each int to total before

        if ((totalBefore/5)<61)
        {
            Background.setBackgroundColor(Color.RED);
        }
        else if (totalBefore/5 > 60 && totalBefore/5 < 80)
        {
            Background.setBackgroundColor(Color.YELLOW);
        }
        else
        {
            Background.setBackgroundColor(Color.GREEN);
        }


        displayGPA.setText("" + totalBefore/5);
        calculate.setText(getString(R.string.clear));

    }
}
