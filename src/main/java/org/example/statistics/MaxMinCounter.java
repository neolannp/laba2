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
        DescriptiveStatistics stat = new DescriptiveStatistics();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).forEach(stat::addValue);
            String maxmin = "[" + stat.getMax() + "; " + stat.getMin() + "]";
            total.add(maxmin);
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
