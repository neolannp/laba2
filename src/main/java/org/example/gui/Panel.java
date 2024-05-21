package org.example.gui;

import org.example.Data;
import org.example.ExcelWriter;
import org.example.statistics.Statistics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Panel extends JPanel {
    JButton chooseFileButton = new JButton("choose file");
    JButton saveFileButton = new JButton("save file");
    JButton countButton = new JButton("count");
    JButton exitButton = new JButton("exit");

    Data data;
    Statistics statistics = new Statistics();
    FileChooserGUI fileChooserGUI = new FileChooserGUI();
    String path;
    ComboBox comboBox;
    ExcelWriter excelWriter;
    ArrayList<ArrayList<Double>> list;
    ArrayList<ArrayList<?>> results = new ArrayList<>();
//    ArrayList<String> names = new ArrayList<>();

    Panel() throws URISyntaxException {
        add(chooseFileButton);
        add(countButton);
        add(saveFileButton);
        add(exitButton);

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fileChooserGUI = new FileChooserGUI();
                } catch (URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
                path = fileChooserGUI.openFile();
                try {
                    comboBox = new ComboBox(path);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        data = new Data(path, comboBox.getIndexSheet());
                    } catch (IOException q) {
                        throw new RuntimeException(q);
                    } catch (NullPointerException w) {
                        JOptionPane.showMessageDialog(null, "choose file!");
                        throw new RuntimeException(w);
                    }
                    list = data.getDataArray();
                    statistics.countStatistics(list);
                    results = statistics.fillResults();
                    JOptionPane.showMessageDialog(null, "success!");
                }
            }
        });

        saveFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    excelWriter = new ExcelWriter(path, results, statistics);
                    JOptionPane.showMessageDialog(null, "file saved");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "save error");
                    throw new RuntimeException(ex);
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
