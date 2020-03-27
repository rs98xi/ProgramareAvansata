package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
     private final MainFrame frame;
     private JButton saveBtn = new JButton("Save");
     private JButton loadBtn = new JButton("Load");
     private JButton resetBtn = new JButton("Reset");
     private JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

    }


    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.getCanvas().image, "PNG", new File("d:/temp_lab/test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e) {
        try {
            frame.getCanvas().image = ImageIO.read(new File("d:/temp_lab/test.png"));
            frame.getCanvas().graphics = frame.getCanvas().image.createGraphics();
            repaint();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    private void reset(ActionEvent e) {
        frame.getCanvas().reset();
    }
    private void exit(ActionEvent e) {
        System.exit(0);
    }
}
