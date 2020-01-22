package com.sevend3.taxcalc;




public class Calc
{
    double p,q = 10000,tax;
    String loop = "";
    int i;
    String marginalRate;
    final double BRACKET_ONE = 11475,BRACKET_TWO = 33808,BRACKET_THREE = 40895, BRACKET_FOUR = 63823,SUM = 150001
            , B2_RATE = 22.79, B3_RATE = 33.23, B4_RATE = 45.93, REST = 52.75, PERCENTAGE = 0.01;

    /*public Calc(double amt)
    {
        this.p = amt;
    }
*/
    public String answer()
    {
        try
        {
        for (i=1;i<=30;i++)
        {

            this.p = q;
        if (this.p > 0){
           if (this.p <= BRACKET_ONE)
           {
              // System.out.println("fdf");
                this.marginalRate = "0%";
               this.tax = 0;
               this.q += 5000;
           }
           else if (this.p > BRACKET_ONE && this.p <= BRACKET_TWO)
           {
              // System.out.println("d");
               this.marginalRate = "22.79%";
               this.tax = (this.p-BRACKET_ONE)*B2_RATE*PERCENTAGE;
               this.q += 5000;
           }
           else if (this.p <= BRACKET_THREE && this.p > BRACKET_TWO)
           {
               this.marginalRate = "22.79%";
              // System.out.println("h");
               this.tax = (this.p-BRACKET_ONE)*B2_RATE*PERCENTAGE;
               this.q += 5000;
           }
           else if (this.p <= BRACKET_FOUR && this.p > BRACKET_THREE)
           {
               if ((this.p - BRACKET_ONE) <= BRACKET_TWO)
               {
                 // System.out.println("a");
                  this.marginalRate = "22.79%";
                  this.tax = (this.p - BRACKET_ONE) * B2_RATE * PERCENTAGE;
                   this.q += 5000;
               }
               else
               {
                   //System.out.println("v");
                   this.marginalRate = "33.23%";
                   this.tax = ((this.p - BRACKET_ONE)-BRACKET_TWO)*B3_RATE*PERCENTAGE + BRACKET_TWO*B2_RATE*PERCENTAGE;
                   this.q += 5000;
              }
           }
           else if (this.p > BRACKET_FOUR)
           {

               //System.out.println("al");
               double a = (this.p - (BRACKET_ONE+BRACKET_TWO))*B3_RATE*PERCENTAGE + BRACKET_TWO*B2_RATE*PERCENTAGE;
               double b = ((this.p - (BRACKET_ONE+BRACKET_TWO+BRACKET_THREE)) > 0) ? (this.p - (BRACKET_ONE+BRACKET_TWO+BRACKET_THREE))*B4_RATE*PERCENTAGE
                       +BRACKET_THREE*B3_RATE*PERCENTAGE - ((this.p - (BRACKET_ONE+BRACKET_TWO))*B3_RATE*PERCENTAGE) : 0;
               double c = ((this.p - (BRACKET_ONE+BRACKET_TWO+BRACKET_THREE+BRACKET_FOUR)) > 0) ? (this.p - (BRACKET_ONE+BRACKET_TWO+BRACKET_THREE+BRACKET_FOUR))* REST * PERCENTAGE : 0;
               this.tax = a + b + c;
               this.q += 5000;
               if (this.p <= 86178 )
               {
                   this.marginalRate = "33.23%";
               }
               else if (this.p >=86178 && this.p <= SUM)
               {
                   this.marginalRate = "45.93%";
               }
               else
               {
                   this.marginalRate = "52.75%";
               }
           }
       }
        String an = String.format("%.2f",this.tax);
        String ag = getAvgTaxRate();
        String mg = getMarginalRate();
        loop += this.p+"\t\t"+an+"\t\t"+ag+"\t\t"+mg+"\n";
       }}

       catch (Exception e)
       {
           System.out.println(e);

       }return loop;
    }
    public String getAvgTaxRate()
    {
        double answer = (this.tax * 100) / this.p;
        String ans = String.format("%.0f",answer);
        String perAns = ans + "%";
        return perAns;
    }
    public String getMarginalRate()
    {

return this.marginalRate;
    }

    public static void main(String[] args)
    {

        /*Scanner aa = new Scanner(System.in);
        System.out.println("Enter your income:");
        String bb = aa.nextLine();
        Double cc = Double.parseDouble(bb);*/

      Calc a = new Calc();
      String b = a.answer();
     // String c = a.getAvgTaxRate();
     // String d = a.getMarginalRate();
      System.out.println(b);
      //System.out.println(c);
      //System.out.println(d);

    }
}

