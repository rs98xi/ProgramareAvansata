package com.company;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    private final MainFrame frame;
    private JLabel label;         // we’re drawing regular polygons
    private JSpinner sidesField;  // number of sides
    private JComboBox<String> colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        label = new JLabel("Number of sides:");

        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides

        colorCombo = new JComboBox<String>();
        colorCombo.addItem("Random");
        colorCombo.addItem("Black");

        add(label); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
    }

    public MainFrame getFrame() {
        return frame;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public Integer getSidesField() {
        return (Integer)sidesField.getValue();
    }

    public void setSidesField(JSpinner sidesField) {
        this.sidesField = sidesField;
    }

    public JComboBox getColorCombo() {
        return colorCombo;
    }

    public void setColorCombo(JComboBox colorCombo) {
        this.colorCombo = colorCombo;
    }
}

