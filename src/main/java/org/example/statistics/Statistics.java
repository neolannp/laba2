package org.example.statistics;

import javax.swing.*;
import java.util.ArrayList;

public class Statistics {
    ArithmeticMeanCounter arithmeticMeanCounter;
    ConfidenceIntervalCounter confidenceIntervalCounter;
    CoefficientOfCovarianceCounter coefficientOfCovarianceCounter;
    CoefficientOfVariationCounter coefficientOfVariationCounter;
    EstOfStandardDeviationCounter estOfStandardDeviationCounter;
    EstOfVarianceCounter estOfVarianceCounter;
    GeometricMeanCounter geometricMeanCounter;
    MaxMinCounter maxMinCounter;
    NumberOfElementsCounter numberOfElementsCounter;
    SampleSizeCounter sampleSizeCounter;
    ArrayList<String> names=new ArrayList<>();
    ArrayList<ArrayList<?>> totals = new ArrayList<>();
    ArrayList<Counter> counters= new ArrayList<>();
    public Statistics(){
    }
    public void countStatistics(ArrayList<ArrayList<Double>> inf){
        counters.add(arithmeticMeanCounter=new ArithmeticMeanCounter(inf));
        counters.add(confidenceIntervalCounter=new ConfidenceIntervalCounter(inf));
//        counters.add(coefficientOfCovarianceCounter=new CoefficientOfCovarianceCounter(inf));
        counters.add(coefficientOfVariationCounter=new CoefficientOfVariationCounter(inf));
        counters.add(estOfStandardDeviationCounter=new EstOfStandardDeviationCounter(inf));
        counters.add(estOfVarianceCounter=new EstOfVarianceCounter(inf));
        counters.add(geometricMeanCounter=new GeometricMeanCounter(inf));
        counters.add(maxMinCounter=new MaxMinCounter(inf));
        counters.add(numberOfElementsCounter=new NumberOfElementsCounter(inf));
        counters.add(sampleSizeCounter=new SampleSizeCounter(inf));
        coefficientOfCovarianceCounter= new CoefficientOfCovarianceCounter(inf);
        for (Counter counter:counters){
            System.out.println(counter.getTotal());
        }
    }
    public ArrayList<String> fillNames(){
        try {
            for (Counter counter:counters){
                names.add(counter.getName());
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong. There are no calculations");
            throw new RuntimeException(e);
        }
        return names;
    }
    public ArrayList<ArrayList<?>> fillResults() {
        for (Counter counter : counters) {
            totals.add(counter.getTotal());
        }
        return totals;
    }
    public String getCovName(){
        return coefficientOfCovarianceCounter.getName();
    }
    public ArrayList<ArrayList<Double>> getCov(){
        return coefficientOfCovarianceCounter.getTotal();
    }
    public ArrayList<String> getNames(){
        return names;
    }
    public ArrayList<ArrayList<?>> getTotals(){
        return totals;
    }

}
