package android.udacity.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button submitButton;
    private RadioGroup question1RG;

    private CheckBox question2ACB, question2BCB, question2CCB, question2DCB;

    private RadioGroup question3RG;

    private EditText question4ET;

    private int rightAnswerCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });

        question1RG = findViewById(R.id.radio_group_1);

        question2ACB = findViewById(R.id.checkBoxA);
        question2BCB = findViewById(R.id.checkBoxB);
        question2CCB = findViewById(R.id.checkBoxC);
        question2DCB = findViewById(R.id.checkBoxD);

        question3RG = findViewById(R.id.radio_group_q3);

        question4ET = findViewById(R.id.editText);
    }

    private void checkAnswers() {
        rightAnswerCount = 0;

        int question1 = question1RG.getCheckedRadioButtonId();
        if (question1 == R.id.radioButtonB) {
            rightAnswerCount ++;
        }

        if (question2ACB.isChecked() && !question2BCB.isChecked() && question2CCB.isChecked() && !question2DCB.isChecked()) {
            rightAnswerCount ++;
        }

        if (question3RG.getCheckedRadioButtonId() == R.id.radioButtonFalse) {
            rightAnswerCount ++;
        }

        String[] answers4 = getResources().getStringArray(R.array.answers_4);

        if (null != question4ET.getText()) {
            String answer4 = question4ET.getText().toString().toUpperCase();
            for (String ans:answers4) {
                if (ans.toUpperCase().equals(answer4)) {
                    rightAnswerCount ++;
                    break;
                }
            }
        }


        Toast.makeText(this, "You Scored: "+rightAnswerCount, Toast.LENGTH_LONG).show();
    }
}
