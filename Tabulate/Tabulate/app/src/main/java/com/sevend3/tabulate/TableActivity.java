package com.sevend3.tabulate;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class TableActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_table);
    }
    public void onClick(View v)
    {

        ScrollView sv = (ScrollView) findViewById(R.id.sv);
        sv.removeAllViews();
        TableLayout tl = new TableLayout(this);
        sv.addView(tl);
       // TableRow row = new TableRow(this);
      //  row.setGravity(Gravity.CENTER_HORIZONTAL);
       // tl.addView(row);
        EditText numOne = (EditText) findViewById(R.id.one);
        EditText numTwo = (EditText) findViewById(R.id.two);
        String one = numOne.getText().toString();
        String two = numTwo.getText().toString();
        int x = Integer.parseInt(one);
        int y = Integer.parseInt(two);
        String fanswer = "";
        int i;
        for (i = x; i <= y; i++) {
            if (i != y && x < y) {
                int num = i;
                int square = i * i;
                double sqroot = Math.sqrt(num);
                //fanswer += "\n" + num + "\t\t" + square + "\t\t" + sqroot;
                fanswer = String.format("%5d", num) + String.format("%10d", square) + String.format("%12.5f", sqroot);
                TextView tv = new TextView(this);
                tv.setGravity(Gravity.CENTER_HORIZONTAL);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 32);
                tv.setText(fanswer);
                TableRow row = new TableRow(this);
                row.setGravity(Gravity.CENTER_HORIZONTAL);
                row.addView(tv);
                tl.addView(row);
            } else {
                int num = i;
                int square = i * i;
                double sqroot = Math.sqrt(num);
                //fanswer += "\n" + num + "\t\t" + square + "\t\t" + sqroot;
                fanswer = String.format("%5d", num) + String.format("%10d", square) + String.format("%12.5f", sqroot);
                TextView tv = new TextView(this);
                tv.setGravity(Gravity.CENTER_HORIZONTAL);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 32);
                tv.setText(fanswer);
                TableRow row = new TableRow(this);
                row.setGravity(Gravity.CENTER_HORIZONTAL);
                row.addView(tv);
                tl.addView(row);
                hideKeyboard();
            }


        }
    }
    private void hideKeyboard()
    {
        View aa = this.getCurrentFocus();
        if (aa != null)
        {
            InputMethodManager bb = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            bb.hideSoftInputFromWindow(aa.getWindowToken(),0);
        }

    }

}
