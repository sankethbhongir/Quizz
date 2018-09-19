package com.example.sanketh.quizz;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * An activity that checks answers for different answer type like -blanks, radio options, check boxes. And tracks correct answers
 */
public class QuizActivity extends AppCompatActivity {

    private EditText blank1_question1, blank2_question2;
    private RadioButton radioOption_question3, radioOption_question4;
    private CheckBox checkBox_optionType1_question5, checkBox_optionType2_question5, checkBox_optionType3_question5, checkBox_optionType4_question5, checkBox_optionType1_question6, checkBox_optionType2_question6, checkBox_optionType3_question6, checkBox_optionType4_question6;

    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //creating view objects and mapping to their respective view
        blank1_question1 = findViewById(R.id.blank_1_of_question1);
        blank2_question2 = findViewById(R.id.blank_2_of_question2);
        radioOption_question3 = findViewById(R.id.b_option_of_question3);
        radioOption_question4 = findViewById(R.id.niether_option_question4);
        checkBox_optionType1_question5 = findViewById(R.id.dinner_option);
        checkBox_optionType2_question5 = findViewById(R.id.supper_option);
        checkBox_optionType3_question5 = findViewById(R.id.lunch_option);
        checkBox_optionType4_question5 = findViewById(R.id.snacks_option);
        checkBox_optionType1_question6 = findViewById(R.id.clown_option);
        checkBox_optionType2_question6 = findViewById(R.id.joker_option);
        checkBox_optionType3_question6 = findViewById(R.id.sharks_option);
        checkBox_optionType4_question6 = findViewById(R.id.hunter_option);
        submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int incorrect = 6 - result();
                Toast.makeText(QuizActivity.this, "correct : " + result() + "\nincorrect: " + incorrect, Toast.LENGTH_SHORT).show();
                String userNameFromUserEntry = getIntent().getStringExtra("name");
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("userName", userNameFromUserEntry);
                intent.putExtra("numberOfCorrects", result());
                startActivity(intent);

            }
        });

    }

    /**
     * method to check whether blanks are matched to their respective answers and track correct answers
     *
     * @param answer1      answer for first question
     * @param answer2type1 answer type1 for second question
     * @param answer2Type2 answer type2 for second question
     * @return number correct answers for blanks
     */
    public int answerCheckForBlanks(String answer1, String answer2type1, String answer2Type2) {


        int correctBlank = 0;


        if ((blank1_question1.getText().toString().trim()).equalsIgnoreCase(answer1)) {
            blank1_question1.setBackgroundColor(Color.GREEN);
            correctBlank += 1;
        }
        else
            blank1_question1.setTextColor(Color.RED);


        if ((blank2_question2.getText().toString().trim()).equalsIgnoreCase(answer2type1) || (blank2_question2.getText().toString()).equalsIgnoreCase(answer2Type2))
            correctBlank += 1;
        return correctBlank;

    }

    /**
     * method to check whether the checked radio option is correct answer or not and track correct options
     *
     * @return number of correct options
     */
    public int answerCheckForRadioOptions() {

        int correctOption = 0;

        if (radioOption_question3.isChecked())
            correctOption += 1;
        if (radioOption_question4.isChecked())
            correctOption += 1;
        return correctOption;
    }

    /**
     * method to check whether the checked boxes are correct answers, only two boxes are correct and track correct boxes
     *
     * @return number of correct boxes
     */

    public  int answerCheckForCheckBoxes() {


        int correctCheckBox = 0;
        if ((checkBox_optionType1_question5.isChecked() && checkBox_optionType2_question5.isChecked()) && (!(checkBox_optionType3_question5.isChecked() || checkBox_optionType4_question5.isChecked()))){
            correctCheckBox += 1;
        }


        if ((checkBox_optionType1_question6.isChecked() && checkBox_optionType2_question6.isChecked()) && (!(checkBox_optionType3_question6.isChecked() || checkBox_optionType4_question6.isChecked())))
            correctCheckBox += 1;
        return correctCheckBox;

    }

    /**
     * method to total correct answers by adding all answers
     *
     * @return total correct answers
     */

    public int result() {
        return answerCheckForBlanks(getString(R.string.answer_of_q1), getString(R.string.answer_type1_ofq2), getString(R.string.answer_type2_of_q2)) + answerCheckForRadioOptions() + answerCheckForCheckBoxes();
    }






}
