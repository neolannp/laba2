package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.statistics.Statistics;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelWriter {
FileInputStream file;
FileOutputStream outFile;
XSSFWorkbook workbook;
XSSFSheet sheet;
String nameCov;
ArrayList<String> names = new ArrayList<>();
ArrayList<ArrayList<?>> totals = new ArrayList<>();
ArrayList<ArrayList<Double>> cov= new ArrayList<>();
FileOutputStream file1 = new FileOutputStream("OutputFile.xlsx");

public ExcelWriter(String filePath, ArrayList<ArrayList<?>> result, Statistics statistics) throws IOException {
    try {
        file = new FileInputStream(filePath);
    } catch (NullPointerException e) {
        JOptionPane.showMessageDialog(null, "choose file and push Count button");
        throw new RuntimeException(e);
    }
    workbook = new XSSFWorkbook();
    sheet = workbook.createSheet("Totals");
    names = statistics.fillNames();
    totals = result;
    cov= statistics.getCov();
    nameCov=statistics.getCovName();
    writeIntoExcel();
}

public void writeIntoExcel() throws IOException {
    for (int i = 0; i < names.size(); i++) {
        Row row = sheet.createRow(i);
        Cell name = row.createCell(0);
        name.setCellValue(names.get(i));
    }

    int rowIndex = 0;
    int colIndex = 1;

    for (ArrayList<?> sublist : totals) {
        for (Object element : sublist) {
            Row row = sheet.getRow(rowIndex);
            if (row == null) {
                row = sheet.createRow(rowIndex);
            }
            Cell cell = row.createCell(colIndex);
            cell.setCellValue(element.toString());
            colIndex++;
        }
        rowIndex++;
        colIndex = 1;
    }

    int rowCov = 16;
    int colCov = 0;
    Row row2 = sheet.createRow(15);
    Cell name = row2.createCell(0);
    name.setCellValue(nameCov);

    for(ArrayList<Double> row : cov) {
        for (Object el : row) {
            Row row1 = sheet.getRow(rowCov);
            if (row1 == null) {
                row1 = sheet.createRow(rowCov);
            }
            Cell cell = row1.createCell(colCov);
            cell.setCellValue(el.toString());
            colCov++;
        }
        rowCov++;
        colCov = 0;
    }
    workbook.write(file1);
    JOptionPane.showMessageDialog(null, "information recorded");
    workbook.close();
    file.close();
}}
