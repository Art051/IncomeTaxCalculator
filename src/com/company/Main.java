package com.company;

public class Main {

    public static void main(String[] args) {
	 float grossPay = ReadIn.readValue("What is your Gross Annual Income?");

                PAYECalculator payeCalc = new PAYECalculator(grossPay);
                NIClass1ACalculator nIClass1Calculator = new NIClass1ACalculator(grossPay);
                TaxReport report = new TaxReport(payeCalc,nIClass1Calculator,grossPay);

                report.printGrossPay();
                report.printNIClass1();
                report.printPAYE();
                report.printTakeHomePay();
    }
}
