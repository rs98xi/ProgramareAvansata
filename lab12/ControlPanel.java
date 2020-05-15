package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {

    DesignPanel designPanel;

    JButton button;

    JTextField numeForma;
    JTextField text;

    JPanel metadata;
    JPanel actualPanel;


    public ControlPanel(DesignPanel designPanel) {
        this.designPanel = designPanel;

        this.button = new JButton("Forma noua");

        numeForma = new JTextField(10);
        text = new JTextField(15);

        metadata = new JPanel();
        metadata.setVisible(true);
        metadata.setLayout(new FlowLayout());

        metadata.add(new JLabel("Text"));
        metadata.add(text);

        button.addActionListener(this::action);

        actualPanel = new JPanel();
        actualPanel.setVisible(true);
        actualPanel.setLayout(new FlowLayout());

        actualPanel.add(metadata, BorderLayout.NORTH);
        actualPanel.add(new JLabel("Numele clasei"), BorderLayout.SOUTH);
        actualPanel.add(numeForma, BorderLayout.SOUTH);
        actualPanel.add(this.button, BorderLayout.SOUTH);

        this.setVisible(true);

        add(actualPanel);
    }

    private void action(ActionEvent actionEvent) {

        System.out.println("Buton apasat!");

        String text = numeForma.getText();

        try {
            String path = "javax.swing.";
            Class newClass = Class.forName(path + text);

            Component newComponent;
            newComponent = (Component) newClass.newInstance();

            int lungime = 100;
            int inaltime = 30;

            try {
                Method method = newClass.getMethod("setText", String.class);

                method.invoke(newComponent, this.text.getText());
            } catch (Exception ignored) {
            }


            newComponent.setSize(lungime, inaltime);

            designPanel.setComponent(newComponent);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ignored) {

        }
    }
}
