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
        int remainingDays = date.getDayOfMonth() - totalDayInMonth;
        return remainingDays;
    }


}
