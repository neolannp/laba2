package org.example.gui;

import java.net.URISyntaxException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Frame extends JFrame{
    Panel panel = new Panel();

    public Frame() throws URISyntaxException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(new Dimension(400,400));
        setLocationRelativeTo(null);
        add(panel);
    }
}
