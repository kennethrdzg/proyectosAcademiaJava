package com.kennethrdzg.mockito;

public interface WeightPredictor {
    double predictWeight(double currentWeight, int minutesDailyExercies, int days);
}