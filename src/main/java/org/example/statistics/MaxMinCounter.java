package org.example.statistics;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;

public class MaxMinCounter implements Counter{
    String name;
    ArrayList<ArrayList<Double>> list;
    ArrayList<String> total= new ArrayList<>();
    public MaxMinCounter(ArrayList<ArrayList<Double>> list){
        this.name="maximum and minimum";
        this.list=list;
        count();
    }

    @Override
    public void count() {
        for (ArrayList<Double> doubles : list) {
            DescriptiveStatistics stat = new DescriptiveStatistics();
            doubles.forEach(stat::addValue);
            total.add("[" + stat.getMax() + "; " + stat.getMin() + "]");
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
