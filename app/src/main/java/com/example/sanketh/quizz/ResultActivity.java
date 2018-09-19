package com.example.sanketh.quizz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * An activity that shows whether the the user has won or lost with user name
 */
public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


      int correctAnswers = getIntent().getIntExtra("numberOfCorrects", 0);

        // creating text view object and mapping to its respective view
        TextView win_lose_textView = findViewById(R.id.win_lose_text);
        // creating image view objects, mapping to their respective views and displaying happy/sad faces
        ImageView expressionImage = findViewById(R.id.expression_image);

        //displaying win/lose text and happy/sad images based on correct answers
        if (String.valueOf(correctAnswers).equals("6")) {

            win_lose_textView.setText(R.string.won);
            expressionImage.setImageResource(R.drawable.emoji_happy_smiley);
        }

        else {
            win_lose_textView.setText(R.string.lose);
            expressionImage.setImageResource(R.drawable.emoji_smiley_sad);
        }

        // getting user name from intent and displaying it on screen
        String userName = getIntent().getStringExtra("userName");
        TextView userNameTextView = findViewById(R.id.user_name_in_results);
        userNameTextView.setText(userName);





    }
}
