package org.example.statistics;

import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.ArrayList;
import java.util.List;

public class ConfidenceIntervalCounter implements Counter{
    String name;
    ArrayList<ArrayList<Double>> list;
    ArrayList<String> total= new ArrayList<>();
    public ConfidenceIntervalCounter(ArrayList<ArrayList<Double>> list){
        this.name="confidence interval";
        this.list=list;
        count();
    }

    @Override
    public void count() {
        List<Double> mean = calculateMean(list);
        List<Double> sd = calculateStandardDeviation(list, mean);
        List<Integer> size = calculateSize(list);
        double confidenceLevel = 0.95;
        calculateConfidenceIntervals(mean, sd, size, confidenceLevel);
    }

    private List<Double> calculateMean(ArrayList<ArrayList<Double>> list) {
        List<Double> mean = new ArrayList<>();
        for (List<Double> column : list) {
            mean.add(column.stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN));
        }
        return mean;
    }

    private List<Double> calculateStandardDeviation(ArrayList<ArrayList<Double>> list, List<Double> mean) {
        List<Double> sd = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int finalI = i;
            int finalI1 = i;
            double variance = list.get(i).stream()
                    .mapToDouble(Double::doubleValue)
                    .map(d -> d - mean.get(finalI1))
                    .map(d -> d * d)
                    .average().orElse(Double.NaN);
            sd.add(Math.sqrt(variance));
        }
        return sd;
    }

    private List<Integer> calculateSize(ArrayList<ArrayList<Double>> list) {
        List<Integer> size = new ArrayList<>();
        for (List<Double> column : list) {
            size.add(column.size());
        }
        return size;
    }

    private void calculateConfidenceIntervals(List<Double> mean, List<Double> sd, List<Integer> size, double confidenceLevel) {
        NormalDistribution normalDistribution = new NormalDistribution();
        double quantile = normalDistribution.inverseCumulativeProbability(1 - (1 - confidenceLevel) / 2);
        for (int i = 0; i < list.size(); i++) {
            double marginOfError = quantile * (sd.get(i) / Math.sqrt(size.get(i)));
            double lowerBound = mean.get(i) - marginOfError;
            double upperBound = mean.get(i) + marginOfError;
            String interval = "[" + lowerBound + "; " + upperBound + "]";
            total.add(interval);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<String> getTotal() {
        return total;
    }
}
