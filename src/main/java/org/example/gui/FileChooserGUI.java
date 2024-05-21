package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;

public class FileChooserGUI extends Component {
    private JFileChooser fileChooser;

    public FileChooserGUI() throws URISyntaxException {
        try {
            File currentDirectory = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile();
            fileChooser = new JFileChooser(currentDirectory);} catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public String openFile() {
        fileChooser.setDialogTitle("Choose file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(FileChooserGUI.this);
        if (result == JFileChooser.APPROVE_OPTION )
            JOptionPane.showMessageDialog(null, fileChooser.getSelectedFile());

        return fileChooser.getSelectedFile().getAbsolutePath();
    }
}
