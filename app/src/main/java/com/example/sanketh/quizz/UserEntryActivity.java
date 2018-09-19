package com.example.sanketh.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * An activity where user can his/her name
 */
public class UserEntryActivity extends AppCompatActivity {
    private EditText name;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_entry);
        name  = findViewById(R.id.user_name);
        startButton = findViewById(R.id.start_Button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getUserName().isEmpty())
                    Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT).show();

                else {
                    Intent intent = new Intent(UserEntryActivity.this, QuizActivity.class);
                    intent.putExtra("name", getUserName());
                    startActivity(intent);

                }
            }

        });




    }

    /**
     * method to get user name
     *
     * @return user name
     */
    public String getUserName() {

        return name.getText().toString().trim();
    }

}
