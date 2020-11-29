package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    public static void main(String[] args) {

        final String[] creditsAsString = args[0].split(",");
        final String[] debitsAsString = args[1].split(",");
        final float[] credits = new float[creditsAsString.length];
        final float[] debits = new float[debitsAsString.length];

        for(int i = 0; i < creditsAsString.length; i++){
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }

        for(int i = 0; i < debitsAsString.length; i++){
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

        final SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        float natSavings = calculator.calculate();
        System.out.println("Net Savings = " + natSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));


    }

    private float sumOfCredits() {
        float sum = 0.0f;
        for(float n : credits){
            sum += n;
        }
        return sum;
    }

    private float sumOfDebits() {
        float sum = 0.0f;
        for (float n : debits) {
            sum += n;
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDayInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDayInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    public float calculate(){
        return sumOfCredits() - sumOfDebits();
    }


}
