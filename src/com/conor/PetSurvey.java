package com.conor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by conor on 3/31/16.
 */
public class PetSurvey extends JFrame{
    private JCheckBox dogCheckBox;
    private JCheckBox catCheckBox;
    private JCheckBox fishCheckBox;
    private JButton submitButton;
    private JPanel rootPanel;
    private JLabel surveyResultsLabel;
    private JButton quitButton;

    boolean hasDog;
    boolean hasCat;
    boolean hasFish;

    PetSurvey() {
        super("Pet survey application");
        setContentPane(rootPanel); //Contains the root panel

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exits when you click the 'X' to kill program

        setPreferredSize(new Dimension(400, 500)); //Set size of panel
        pack(); //Bring in the elements
        setVisible(true); //Show the panel

        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                hasDog = dogCheckBox.isSelected();
            }
        });
        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                hasCat = catCheckBox.isSelected();
            }
        });
        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                hasFish = fishCheckBox.isSelected();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dog = (hasDog) ? "a dog" : "no dog";
                String cat = (hasCat) ? "a cat" : "no cat";
                String fish = (fishCheckBox.isSelected()) ? "a fish" : "no fish";
                /* This statement is the same as below, but much more concise
                    if(hasDog == true) {
                    dog = "a dog";
                    } else {
                        dog = "no dog";
                     }
                 */

                surveyResultsLabel.setText("User has " + dog + " and " + cat + " and " + fish);
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
