package com.company;

public class PAYECalculator {
    public float grossPay;
    public float payeLiability;

    private final float defaultPersAllowance = 12_579;
    public float adjustedPersAllowance;
    private final float basicRateBand = 50_270;
    private final float higherRateBand = 150_000;
    private final float basePercent = 0.2F;
    private final float higherPercent = 0.4F;
    private final float additionalPercent = 0.45F;
    private final float persAllowanceTaperStart = 100_000;
    private final float persAllowanceTaperEnd = persAllowanceTaperStart + (defaultPersAllowance * 2);

    public PAYECalculator(float grossPay) {
        this.grossPay = grossPay;
    }


    public void setAdjustedPersAllowance() {
        float adjustment = 0;
        if (grossPay <= persAllowanceTaperStart)
            adjustment = defaultPersAllowance;
        else if (grossPay > persAllowanceTaperStart && grossPay < persAllowanceTaperEnd)
            adjustment = defaultPersAllowance - ((grossPay - persAllowanceTaperStart) / 2);
        else if (grossPay >= persAllowanceTaperEnd)
            adjustment = 0;
        this.adjustedPersAllowance = adjustment;
    }


    public float calculatePAYE(float grossPay) {
        setAdjustedPersAllowance();
        if (grossPay < adjustedPersAllowance)
            payeLiability = 0;
        else if (grossPay < basicRateBand)
            payeLiability = (grossPay - adjustedPersAllowance) * basePercent;
        else if (grossPay <= higherRateBand)
            payeLiability = ((basicRateBand - (adjustedPersAllowance + 9)) * basePercent) +
                    ((defaultPersAllowance - adjustedPersAllowance) * basePercent) +
                    ((grossPay - basicRateBand) * higherPercent);
        else payeLiability = ((basicRateBand - (adjustedPersAllowance + 9)) * basePercent) +
                    ((defaultPersAllowance - adjustedPersAllowance) * basePercent) +
                    ((higherRateBand - basicRateBand) * higherPercent) +
                    (grossPay - higherRateBand) * additionalPercent;
        return payeLiability;
    }
}
