package com.company;

public class NIClass1ACalculator {
    private final float lowerAnnualThreshold = 9_564F;
    private final float primaryAnnualThreshold = 50_268F;
    private final float primaryPercent = 0.12F;
    private final float upperPercent = 0.02F;

    private final float grossPay;
    private float totalNILiability = 0;

    public NIClass1ACalculator(float grossPay) {
        this.grossPay = grossPay;
    }

    public float calculateNI(float grossPay) {
        if (grossPay < lowerAnnualThreshold)
            return totalNILiability;
        else if (grossPay <= primaryAnnualThreshold)
            totalNILiability = (grossPay - lowerAnnualThreshold) * primaryPercent;
        else if (grossPay > primaryAnnualThreshold)
            totalNILiability = ((grossPay - primaryAnnualThreshold) * upperPercent) +
                    ((primaryAnnualThreshold - lowerAnnualThreshold) * primaryPercent);
        return totalNILiability;
    }
}
