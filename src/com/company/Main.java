package com.company;

public class Main {

    public static void main(String[] args) {
	 float annualIncome = ReadIn.readValue("What is your Gross Annual Income?");

                PAYECalculator payeCalc = new PAYECalculator(annualIncome);
                NIClass1 nIClass1Calculator = new NIClass1(annualIncome);
                TaxReport report = new TaxReport(payeCalc,nIClass1Calculator);

                report.printGrossPay();
                report.printNIClass1();
                report.printPAYE();
                report.printTakeHomePay();
    }
}
