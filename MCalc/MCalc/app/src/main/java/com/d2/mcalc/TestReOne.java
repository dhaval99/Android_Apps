package com.d2.mcalc;
import ca.roumani.i2c.Stock;
public class TestReOne
{
    public static void main(String[] args)
        {
            final String MSG = "York University Toronto";
            Stock stock = new Stock("HR.S");
            double price = stock.getPrice();
            int cent = (int) Math.rint(price);
            System.out.println(MSG.substring(cent, cent+2).toUpperCase());
        }

}
