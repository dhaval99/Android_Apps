package com.sevend3.tabulate;



public class Pra
{
    public String answer(int x,int y)
    {
        String fanswer = "";
        int i;
        for (i=x;i<=y;i++)
        {
            double num = i;
            double square = Math.pow(i,2);
            double sqroot = Math.sqrt(num);
            fanswer += "\n"+num+"\t\t"+square+"\t\t"+sqroot;
        }
        return fanswer;
    }
}
