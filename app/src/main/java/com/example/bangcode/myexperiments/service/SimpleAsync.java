package com.example.bangcode.myexperiments.service;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by bangcode on 12/14/17.
 */

public class SimpleAsync extends AsyncTask<Void, Void, String> {

    TextView mTextView;

    public SimpleAsync(TextView tv) {
        mTextView = tv;
    }

    @Override
    protected String doInBackground(Void... params) {
        Random r = new Random();
        int n = r.nextInt(11);

        int s = n * 200;

        try {
            Thread.sleep(s);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "Awake at last after sleeping for " + s + " miliseconds";
    }

    @Override
    protected void onPostExecute(String s) {
        mTextView.setText(s);
    }


}
