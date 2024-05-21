package org.example;

import java.io.IOException;
import java.util.ArrayList;

public class Data {
    ExcelReader excelReader;
    ArrayList<ArrayList<Double>> dataArray = new ArrayList<>();

    public Data(String path, int index) throws IOException {
        excelReader = new ExcelReader(path, index);
        this.dataArray = excelReader.readExcel();
    }

    public ArrayList<ArrayList<Double>> getDataArray() {
        return dataArray;
    }
}
