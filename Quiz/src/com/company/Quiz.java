package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quiz {
    private JFrame f = new JFrame("Quiz");
    private JPanel mainPanel;
    private JTextField txtName;
    private JTextField txtPhone;
    private JTextField txtQuesOne;
    private JRadioButton radioTrue;
    private JRadioButton radioFalse;
    private JComboBox comboBox1;
    private JCheckBox checkBoxA;
    private JCheckBox checkBoxB;
    private JCheckBox checkBoxC;
    private JCheckBox checkBoxD;
    private JButton submitButton;
    private JLabel phoneNo;
    private JLabel name;
    private JLabel quesOne;
    private JLabel quesTwo;
    private JLabel quesFour;
    private JLabel errorLabelForName;
    private JLabel errorLabelForQuesOne;
    private JLabel errorLabelForPhone;
    private ButtonGroup buttonGroup1;

    public Quiz() {
        txtName.setName("Name");
        txtPhone.setName("Phone No");
        txtQuesOne.setName("Question 1");

        txtName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (Validations.isRequired(txtName, errorLabelForName)) {
                    Validations.isValidName(txtName, errorLabelForName);
                }
            }
        });

        txtPhone.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (Validations.isRequired(txtPhone, errorLabelForPhone)) {
                    Validations.isValidNumber(txtPhone, errorLabelForPhone);
                }
            }
        });

        txtQuesOne.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                Validations.isRequired(txtQuesOne, errorLabelForQuesOne);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String dbQuesOne = "";
                String dbQuesTwo = "";
                String dbQuesThree = "";
                int score = 0;
                int flag = 0;
                List<String> dbQuesFour = new ArrayList<>();

                //checking validation before submitting
                if (Validations.isRequired(txtName, errorLabelForName) &&
                        Validations.isRequired(txtPhone, errorLabelForPhone) &&
                        Validations.isRequired(txtQuesOne, errorLabelForQuesOne)) {
                    if (Validations.isValidName(txtName,errorLabelForName) &&
                            Validations.isValidNumber(txtPhone,errorLabelForPhone)) {

                        //Db connectivity
                        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
                             Statement cmd = conn.createStatement()) {
                            ResultSet rs = cmd.executeQuery("select * from quiz");
                            while (rs.next()) {
                                dbQuesOne = rs.getString(1);
                                dbQuesTwo = rs.getString(2);
                                dbQuesThree = rs.getString(3);
                                dbQuesFour.addAll(0, Arrays.asList(rs.getString(4).split(",")));
                            }
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }

                        // Calculating Score
                        if (dbQuesOne.equalsIgnoreCase(txtQuesOne.getText())) score++;
                        if (radioTrue.isSelected()) {
                            if (dbQuesTwo.equalsIgnoreCase(radioTrue.getText())) score++;
                        } else if (radioFalse.isSelected()) {
                            if (dbQuesTwo.equalsIgnoreCase(radioFalse.getText())) score++;
                        }
                        if (dbQuesThree.equalsIgnoreCase(comboBox1.getSelectedItem().toString())) score++;
                        if (checkBoxA.isSelected()){
                            if (dbQuesFour.contains(checkBoxA.getText().toLowerCase())) flag++;
                            else flag --;
                        }if (checkBoxB.isSelected()){
                            if (dbQuesFour.contains(checkBoxB.getText().toLowerCase())) flag++;
                            else flag --;
                        }if (checkBoxC.isSelected()){
                            if (dbQuesFour.contains(checkBoxC.getText().toLowerCase())) flag++;
                            else flag --;
                        }if (checkBoxD.isSelected()){
                            if (dbQuesFour.contains(checkBoxD.getText().toLowerCase())) flag++;
                            else flag --;
                        }
                        if (flag==dbQuesFour.size()) score++;
                        JOptionPane.showMessageDialog(f,txtName.getText()+" your Score is "+ score+" out 4");
                    }
                }
            }
        });
        f.add(mainPanel);
        f.setSize(550,450);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Quiz();
    }
}
