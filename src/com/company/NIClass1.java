package com.company;

public class NIClass1 {
    private final float lowerAnnualThreshold = 9_568F;
    private final float primaryAnnualThreshold = 50_270F;
    private final float primaryPercent = 0.12F;
    private final float upperPercent = 0.02F;

    private final float annualIncome;
    private float totalNILiability = 0;

    public NIClass1(float annualIncome) {
        this.annualIncome = annualIncome;
    }

    public float calculateNI() {
        if (annualIncome < lowerAnnualThreshold)
            return totalNILiability;
        else if (annualIncome < primaryAnnualThreshold)
            totalNILiability = (annualIncome - lowerAnnualThreshold) * primaryPercent;
        else if (annualIncome >= primaryAnnualThreshold)
            totalNILiability = ((annualIncome - primaryAnnualThreshold) * upperPercent) +
                    ((primaryAnnualThreshold - lowerAnnualThreshold) * primaryPercent);
        return totalNILiability;
    }
}
