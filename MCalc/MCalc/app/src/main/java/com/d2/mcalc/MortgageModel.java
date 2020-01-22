package com.d2.mcalc;

public class MortgageModel
{
    private double principle;
    private int numOfYears;
    private double rate;
    private double use;
 public MortgageModel (String p, String a, String i)
 {
     double sparseOne = Double.parseDouble(p);
     this.principle = sparseOne;
     int sparseTwo = Integer.parseInt(a);
     this.numOfYears = sparseTwo;
     double sparseThree = Double.parseDouble(i);
     this.rate = sparseThree;


 }
 public String computePayment()
 {
     double calcConOne = (this.numOfYears)*12;
     double calcConTwo = (this.rate)/(12*100);
     double answer = (calcConTwo*principle)/(1-Math.pow(1+calcConTwo,-calcConOne));
     String answerFormat = "$"+String.format("%.0f",answer);
     this.use = answer;
     return answerFormat;
 }

 public String outStandingAfter(int x)
    {

        double b = this.rate/1200;
        double c = this.principle;
        double d = this.use;

        double g = (double)x*12;
        double e = c -(((d/b) - c )*((Math.pow(1+b,g))-1));
        String f = String.format("%,.0f",e);
        return f;
    }
    public static void main(String[] args)
    {
       MortgageModel obj = new MortgageModel("700000","25","2.75");
        String process = obj.computePayment();

        String outs = obj.outStandingAfter(5);
        System.out.println("$"+outs);
        System.out.println(process);

    }

}
