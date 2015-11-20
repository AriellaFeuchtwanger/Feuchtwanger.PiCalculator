package feuchtwanger.feuchtwangerpicalculator;

import android.os.AsyncTask;
import android.widget.TextView;


public class PiCalculationAsyncTask extends AsyncTask<Long, String, String> {

    private TextView textView;

    public PiCalculationAsyncTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Long... params) {
        double pi = calculate(1000000000L);
        return String.valueOf(pi);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        textView.setText(result);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        textView.setText(values[0]);
    }

    public double calculate(long iterations) {
        double pi = 0;

        double numerator = 4;
        double denominator = 1;
        boolean positive = true;

        for (int i = 0; i < iterations; i++) {
            if (positive) {
                pi += (numerator / denominator);
            } else {
                pi -= (numerator / denominator);
            }

            denominator += 2;
            positive = !positive;
            if (i % 10000 == 0) {
                publishProgress(String.valueOf(pi));
            }
        }
        return pi;
    }

}
