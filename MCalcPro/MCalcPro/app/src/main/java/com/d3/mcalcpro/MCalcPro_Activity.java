package com.d3.mcalcpro;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import ca.roumani.i2c.MPro;



public class MCalcPro_Activity extends AppCompatActivity implements TextToSpeech.OnInitListener, SensorEventListener
    {
    private TextToSpeech tts;
    private double da;
    private double ra;
    private double la;
    public void onInit(int initStatus)
    {
        this.tts.setLanguage(Locale.US);
    }
    public void onAccuracyChanged(Sensor arg0, int arg1)
    {

    }
    public void onSensorChanged(SensorEvent event)
    {
        double x = event.values[0];
        double y = event.values[1];
        double z = event.values[2];
        this.da = x;
        this.ra = y;
        this.la = z;
        double result = (x*x + y*y + z*z);
        double acc = Math.sqrt(result);

         if (acc > 20)
         {
             EditText p = (EditText) findViewById(R.id.pBox);
             p.setText(" ");
             EditText m = (EditText) findViewById(R.id.aBox);
             m.setText(" ");
             EditText i = (EditText) findViewById(R.id.iBox);
             i.setText(" ");
             TextView output = (TextView) findViewById(R.id.output);
             output.setText(" ");
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.mcalcpro_layout);
    this.tts = new TextToSpeech(this,this);
    SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
    sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
}



        public void onClick (View v)
        {
            try {

            MPro mp = new MPro();

            EditText principle = (EditText) findViewById(R.id.pBox);
            EditText amortization = (EditText) findViewById(R.id.aBox);
            EditText interest = (EditText) findViewById(R.id.iBox);

            String convertPrinciple = principle.getText().toString();
            String convertAmortization = amortization.getText().toString();
            String convertInterest = interest.getText().toString();

            mp.setPrinciple(convertPrinciple);
            mp.setAmortization(convertAmortization);
            mp.setInterest(convertInterest);

            String mPayment = mp.computePayment("%,.2f");
            String result = "Monthly Payment = " + mPayment;
             //   tts.speak(result, TextToSpeech.QUEUE_FLUSH, null);
            result += "\n\n";
            result += "By making this payments monthly for 20 years, the mortgage will be paid " +
                    "in full. But if you terminate the mortgage on its nth anniversary, the balance " +
                    "still owing depends on n as shown below:";

            result += "\n\n\n";
            result += "       n"+"         Balance";
            result += "\n\n";
            //****************************************************************************************************************
                int i;

                for (i=0;i<=5;i++)
                {
                    if (i != 5)
                    {
                        result += String.format("%8d", i) + mp.outstandingAfter(i, "%,16.0f");
                        result += "\n\n";
                    }
                    else if (i == 5)
                    {
                        int j;
                        for (j=1;j<=4;j++)
                        {
                            int a = i*j;
                            if (j!=4)
                            {
                                result += String.format("%8d", a) + mp.outstandingAfter(a, "%,16.0f");
                            result += "\n\n";}
                            else
                            {
                                result += String.format("%8d", a) + mp.outstandingAfter(a, "%,16.0f");
                            }
                        }
                    }
                }

            /*result += String.format("%8d", 1) + mp.outstandingAfter(1, "%,16.0f");
            result += "\n\n";
            result += String.format("%8d", 2) + mp.outstandingAfter(2, "%,16.0f");
            result += "\n\n";
            result += String.format("%8d", 3) + mp.outstandingAfter(3, "%,16.0f");
            result += "\n\n";
            result += String.format("%8d", 4) + mp.outstandingAfter(4, "%,16.0f");
            result += "\n\n";
            result += String.format("%8d", 5) + mp.outstandingAfter(5, "%,16.0f");
            result += "\n\n";
            result += String.format("%8d", 10) + mp.outstandingAfter(10, "%,16.0f");
            result += "\n\n";
            result += String.format("%8d", 15) + mp.outstandingAfter(15, "%,16.0f");
            result += "\n\n";
            result += String.format("%8d", 20) + mp.outstandingAfter(20, "%,16.0f");*/
            //****************************************************************************************************************
                result += "\n"+"x:"+this.da+"\n"+"y:"+this.ra+"\n"+"z:"+this.la;
            TextView show = (TextView) findViewById(R.id.output);
            show.setText(result);
            hideKeyboard();
            }

            catch (Exception e)
            {
                Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
                label.setMargin(0,100);
                label.show();
            }

        }
    }



