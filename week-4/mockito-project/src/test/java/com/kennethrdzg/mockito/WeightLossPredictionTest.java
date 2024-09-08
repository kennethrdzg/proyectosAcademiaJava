package com.kennethrdzg.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class WeightLossPredictionTest{
    @Mock
    WeightPredictor wp;
    WeightLossTracker tracker;

    @BeforeEach
    public void setUp(){
        wp = mock(WeightPredictor.class);
        tracker = new WeightLossTracker(wp);
    }

    @Test
    void testWeightPrediction(){
        when(wp.predictWeight(80, 60, 60))
            .thenReturn(75.8);
        
        double resultado = tracker.predictWeight(80, 60, 60);

        assertEquals(resultado, 75.8, 0.1, "ERROR");
        verify(wp).predictWeight(80, 60, 60);
    }
}