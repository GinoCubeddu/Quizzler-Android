package com.londonappbrewery.quizzler;


/**
 * Created by Gino on 31/01/2018.
 */

public class TrueFalse {

    private int mQuestionID;
    private boolean mAnswer;

    public TrueFalse(int questionResourceID, boolean trueOrFalse) {
        mQuestionID = questionResourceID;
        mAnswer = trueOrFalse;
    }

    public int getQuestionID() {
        return mQuestionID;
    }

    public void setQuestionID(int questionID) {
        mQuestionID = questionID;
    }

    public boolean isAwnser(boolean answer) {
        return mAnswer == answer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
