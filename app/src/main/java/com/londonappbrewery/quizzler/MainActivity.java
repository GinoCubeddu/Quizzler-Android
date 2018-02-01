package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    // TODO: Declare member variables here:
    private Button mTrueButton;
    private Button mFalseButton;
    private TextView mQuestionTextView;
    private TextView mScoreTextView;
    private ProgressBar mProgressBar;
    private int mCurrentQuestion;
    private int mScore;
    private int mCurrentQuestionTextID;

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    // TODO: Declare constants here
    final int PROGRESS_BAR_INCREMENT = (int)Math.ceil(100.0 / mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve the TextView for the question
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mScoreTextView = (TextView) findViewById(R.id.score);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mCurrentQuestion = 0;
        mCurrentQuestionTextID = mQuestionBank[mCurrentQuestion].getQuestionID();

        // Retrieve the buttons from the layout
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);

        // Set the OnClickListeners for the buttons
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                nextQuestion();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                nextQuestion();
            }
        });
    }

    private void checkAnswer(boolean answer) {
        // Display toast based on if answer was correct.
        if (mQuestionBank[mCurrentQuestion].isAwnser(answer)) {
            Toast.makeText(
                    getApplicationContext(), getText(R.string.correct_toast), Toast.LENGTH_SHORT
            ).show();
            mScore++;
            mScoreTextView.setText("Score " + mScore + "/" + mQuestionBank.length);
        }
        else
            Toast.makeText(
                    getApplicationContext(), getText(R.string.incorrect_toast), Toast.LENGTH_SHORT
            ).show();

    }

    private void nextQuestion() {
        // Display the next question if there is another one
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        if (mCurrentQuestion + 1 >= mQuestionBank.length) {
            Toast.makeText(
                    getApplicationContext(), "That was the last question!", Toast.LENGTH_LONG
            ).show();
            return;
        }
        mCurrentQuestion++;
        mCurrentQuestionTextID = mQuestionBank[mCurrentQuestion].getQuestionID();
        mQuestionTextView.setText(getText(mCurrentQuestionTextID));
    }
}
