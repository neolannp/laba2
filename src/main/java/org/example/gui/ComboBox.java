package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ComboBox extends JFrame {
    JComboBox comboBox;

    public ComboBox(String filePath) throws IOException {
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(new Dimension(250,200));
        setLocationRelativeTo(null);

        comboBox =  new JComboBox(new Sheets(filePath).namesNumbers());

        add(comboBox);
    }

    public int getIndexSheet() {
        return comboBox.getSelectedIndex();
    }
}
