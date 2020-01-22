package com.sevend3.taxcalc;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class TaxCalc_Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_taxcalc);
    }
    public void onClick()
    {
        ScrollView sv = (ScrollView) findViewById(R.id.sv);
        sv.removeAllViews();
        LinearLayout output = new LinearLayout(this);
        output.setOrientation(LinearLayout.VERTICAL);
        sv.addView(output);
        EditText amount = (EditText) findViewById(R.id.major);
        String a = amount.getText().toString();
        double b = Double.parseDouble(a);
       // Calc c = new Calc();
//        c.Calc(b);

    }
    private TextView maal()
    {
        TextView tv = new TextView(this);
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 32);
        tv.setTypeface(null,Typeface.BOLD);
        return tv;
    }
}
