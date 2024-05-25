package org.example.statistics;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;

public class EstOfStandardDeviationCounter implements Counter{
    String name;
    ArrayList<ArrayList<Double>> list;
    ArrayList<Double> total= new ArrayList<>();
    public EstOfStandardDeviationCounter(ArrayList<ArrayList<Double>> list){
        this.name="estimation of the standard deviation";
        this.list=list;
        count();
    }

    @Override
    public void count() {
        for (int i = 0; i < list.size(); i++) {
            DescriptiveStatistics stat = new DescriptiveStatistics();
            list.get(i).forEach(stat::addValue);
            total.add(stat.getStandardDeviation());
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Double> getTotal() {
        return total;
    }
}
