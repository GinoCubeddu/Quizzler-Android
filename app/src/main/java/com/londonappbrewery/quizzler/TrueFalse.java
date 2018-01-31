package com.londonappbrewery.quizzler;


/**
 * Created by Gino on 31/01/2018.
 */

public class TrueFalse {

    private int mQuestionID;
    private boolean mAwnser;

    public TrueFalse(int questionResourceID, boolean trueOrFalse) {
        mQuestionID = questionResourceID;
        mAwnser = trueOrFalse;
    }

    public int getQuestionID() {
        return mQuestionID;
    }

    public void setQuestionID(int questionID) {
        mQuestionID = questionID;
    }

    public boolean isAwnser() {
        return mAwnser;
    }

    public void setAwnser(boolean awnser) {
        mAwnser = awnser;
    }
}
