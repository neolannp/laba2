package org.example.statistics;

import java.util.ArrayList;

public class NumberOfElementsCounter implements Counter{
    String name;
    ArrayList<ArrayList<Double>> list;
    ArrayList<Integer> total= new ArrayList<>();
    public NumberOfElementsCounter(ArrayList<ArrayList<Double>> list){
        this.name="number of elements";
        this.list=list;
        count();
    }

    @Override
    public void count() {
        for (int i=0;i<list.size();i++){
            Integer number = list.get(i).size();
            total.add(number);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Integer> getTotal() {
        return total;
    }
}
