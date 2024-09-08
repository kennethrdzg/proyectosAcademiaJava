package com.kennethrdzg.mockito;

public class WeightLossTracker{
    private WeightPredictor wp;

    public WeightLossTracker(WeightPredictor wp){
        this.wp = wp;
    }

    double predictWeight(double currentWeight, int minutesDailyExercies, int days){
        return wp.predictWeight(currentWeight, minutesDailyExercies, days);
    }
}