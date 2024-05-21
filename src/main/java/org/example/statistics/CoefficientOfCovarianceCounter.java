package org.example.statistics;

import org.apache.commons.math3.stat.correlation.Covariance;

import javax.swing.*;
import java.util.ArrayList;

public class CoefficientOfCovarianceCounter implements Counter{
    String name;
    ArrayList<ArrayList<Double>> list;
    ArrayList<ArrayList<Double>> covarianceMatrix= new ArrayList<>();
    public CoefficientOfCovarianceCounter(ArrayList<ArrayList<Double>> list){
        this.name="coefficient of covariance";
        this.list=list;
        count();
    }

    @Override
    public void count() {
        Covariance covariance = new Covariance();
        for (ArrayList<Double> list1 : list) {
            ArrayList<Double> row = new ArrayList<>();
            for (ArrayList<Double> list2 : list) {
                System.out.println(list1.size()+" "+list2.size());
                if (list1.size() == list2.size()) {
                    row.add(covariance.covariance(list1.stream().mapToDouble(Double::doubleValue).toArray(), list2.stream().mapToDouble(Double::doubleValue).toArray()));
                } else {
                    JOptionPane.showMessageDialog(null,"it is impossible to calculate all covariance coefficients");}
            }
            covarianceMatrix.add(row);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<ArrayList<Double>> getTotal() {
        return covarianceMatrix;
    }
}
