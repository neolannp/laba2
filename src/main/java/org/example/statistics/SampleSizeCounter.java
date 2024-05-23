package org.example.statistics;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;

public class SampleSizeCounter implements Counter{
    String name;
    ArrayList<ArrayList<Double>> list;
    ArrayList<Double> total= new ArrayList<>();
    public SampleSizeCounter(ArrayList<ArrayList<Double>> list){
        this.name="sample range";
        this.list=list;
        count();
    }

    @Override
    public void count() {
        DescriptiveStatistics stat = new DescriptiveStatistics();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).forEach(stat::addValue);
            total.add(stat.getMax() - stat.getMin());
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
