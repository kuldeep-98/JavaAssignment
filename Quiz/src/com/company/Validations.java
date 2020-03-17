package com.company;

import javax.swing.*;

public class Validations {

    public static boolean isRequired(JTextField field, JLabel label) {
        if (field.getText().isEmpty()) {
            label.setText(field.getName() + " is required");
            return false;
        } else {
            label.setText("");
            return true;
        }
    }

    public static boolean isValidName(JTextField textField, JLabel label) {
        if (textField.getText().matches("^[a-zA-Z .]*$")) {
            label.setText("");
            return true;
        } else {
            label.setText("Name should be valid");
            return false;
        }
    }

    public static boolean isValidNumber(JTextField textField, JLabel label) {
        if (textField.getText().matches("^[0-9]{10}$")) {
            label.setText("");
            return true;
        } else {
            label.setText("Number should be valid");
            return false;
        }
    }
}
