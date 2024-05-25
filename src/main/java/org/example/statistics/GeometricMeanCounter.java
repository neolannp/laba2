package org.example.statistics;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;

public class GeometricMeanCounter implements Counter{
    String name;
    ArrayList<ArrayList<Double>> list;
    ArrayList<Double> total= new ArrayList<>();
    public GeometricMeanCounter(ArrayList<ArrayList<Double>> list){
        this.name="geometric mean";
        this.list=list;
        count();
    }

    @Override
    public void count() {
        for (int i = 0; i < list.size(); i++) {
            DescriptiveStatistics stat = new DescriptiveStatistics();
            list.get(i).forEach(stat::addValue);
            total.add(stat.getGeometricMean());
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
