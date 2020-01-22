package com.d2.mcalc;

        import org.junit.Assert;
        import org.junit.Test;

public class ModelTest
{
    @Test
    public void testPayment()
    {
        MortgageModel obj = new MortgageModel("700000","25","2.75");
        Assert.assertEquals("C1","$3,229.18",obj.computePayment());
    }
}
