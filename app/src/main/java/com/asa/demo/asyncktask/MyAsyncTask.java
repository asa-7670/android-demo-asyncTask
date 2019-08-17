package com.asa.demo.asyncktask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class MyAsyncTask extends AsyncTask<Integer, Void, String> {

    private final TextView textView;

    public MyAsyncTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onPreExecute(){
        textView.setText ( null );
    }

    @Override
    protected String doInBackground(Integer... integers) {
        int seconds = integers[0];
        int secodParam = integers[1];
        Log.d ("MyAsyncTask", String.valueOf ( secodParam));

        try { Thread.sleep(seconds); }
        catch (InterruptedException e) { e.printStackTrace(); }

        return "OK";
    }

    @Override
    protected void onPostExecute(String result) {
        textView.setText ( result );
    }
}
