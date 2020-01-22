package com.d2.mcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EntryForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mortgage_layout);
    }
    public void usageClick(View v)
    {
        EditText amt = (EditText) findViewById(R.id.pamount);
        String totalAmount = String.valueOf(amt.getText());
        EditText yrs = (EditText) findViewById(R.id.years);
        String totalYears = String.valueOf(yrs.getText());
        EditText rt = (EditText) findViewById(R.id.irate);
        String totalRate = String.valueOf(rt.getText());
        MortgageModel call = new MortgageModel(totalAmount,totalYears,totalRate);
        String calc = call.computePayment();
        TextView ans = (TextView) findViewById(R.id.Result);
        ans.setText(calc);
    }
}
