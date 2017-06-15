package com.example.admin.androidtp15;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by admin on 15/06/2017.
 */

class MyAsyncTask extends AsyncTask<Void, Integer, String> {

    ProgressBar bar;
    TextView text;
    int max;

    public MyAsyncTask(ProgressBar bar, TextView text){
        this.bar = bar;
        this.text = text;
        this.max = bar.getMax();
    }


    @Override
    protected String doInBackground(Void... result) {
        for (int i = 0; i < max; i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            publishProgress(i);
        }

        return null;
    }

    @Override
    protected void onCancelled(String result) {

    }

    @Override
    protected void onPostExecute(String result) {

        // UI Thread
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        //Cette méthode sera déclenchée uniquement en utilisant publishProgress() depuis le code de la méthode doInBackground().
        bar.setProgress(values[0]);
        text.setText(values[0] + " /" + max);
        super.onProgressUpdate(values);

    }
}