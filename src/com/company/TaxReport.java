package com.company;

import java.text.NumberFormat;

public class TaxReport {

    private final PAYECalculator payeCalculator;
    private final NIClass1 nIClass1Calculator;


    public TaxReport(PAYECalculator payeCalculator, NIClass1 nIClass1Calculator) {
        this.payeCalculator = payeCalculator;
        this.nIClass1Calculator = nIClass1Calculator;
    }

    public void printGrossPay() {
        System.out.println("Your PAYE liability for the year is: ");
        System.out.print(NumberFormat.getCurrencyInstance().format(payeCalculator.grossPay) + "\n");
    }

    public void printPAYE() {
        float payeLiability = payeCalculator.calculatePAYE(payeCalculator.grossPay);
        System.out.println("Your personal allowance is: \n" +
                NumberFormat.getCurrencyInstance().format(payeCalculator.adjustedPersAllowance));
        System.out.println("Your PAYE liability for the year is: ");
        System.out.print(NumberFormat.getCurrencyInstance().format(payeLiability) + "\n");
    }

    public void printNIClass1() {
        float nIClass1Liability = nIClass1Calculator.calculateNI();
        System.out.println("Your Class 1 NI liability for the year is: ");
        System.out.print(NumberFormat.getCurrencyInstance().format(nIClass1Liability) + "\n");
    }

    public void printTakeHomePay() {
        float annualIncome = payeCalculator.grossPay;
        float payeLiability = payeCalculator.calculatePAYE(payeCalculator.grossPay);
        float nIClass1Liability = nIClass1Calculator.calculateNI();
        System.out.println("Your take home pay for the year is: ");
        System.out.print(NumberFormat.getCurrencyInstance().format(
                annualIncome - payeLiability - nIClass1Liability) + "\n");
    }
}
