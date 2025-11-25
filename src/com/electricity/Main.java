package com.electricity;

import javax.swing.*;

/**
 * Main class - Entry point for the Electricity Billing System
 * Opens test screen to view all UI screens
 */
public class Main {

    public static void main(String[] args) {
        // Set look and feel to system default for better appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Launch the test screen to view all screens
        SwingUtilities.invokeLater(() -> {
            TestAllScreens testFrame = new TestAllScreens();
            testFrame.setVisible(true);
        });
    }
}
