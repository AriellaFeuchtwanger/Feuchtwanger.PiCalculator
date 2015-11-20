package feuchtwanger.feuchtwangerpicalculator;

import android.widget.TextView;

/**
 * Created by student1 on 11/19/2015.
 */
public class PiCalculationThread extends Thread {

    private TextView calculate;

    public PiCalculationThread(TextView calculate) {
        this.calculate = calculate;
    }

    public void run() {
        PiCalculator calc = new PiCalculator();
        double pi = calc.calculate(1000000L);
        calculate.setText(String.valueOf(pi));
    }
}
