package com.electricity.ui.auth;

import javax.swing.*;
import java.awt.*;

/**
 * Login Frame - Main entry point for the application
 * No logic implementation - UI only
 */
public class LoginFrame extends JFrame {

    // UI Components
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel formPanel;
    private JPanel buttonPanel;

    private JLabel titleLabel;
    private JLabel subtitleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel roleLabel;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;

    private JButton loginButton;
    private JButton registerButton;
    private JButton exitButton;

    private JCheckBox rememberMeCheckBox;

    public LoginFrame() {
        initializeComponents();
        setupLayout();
        setupFrame();
    }

    private void initializeComponents() {
        // Initialize panels
        mainPanel = new JPanel();
        headerPanel = new JPanel();
        formPanel = new JPanel();
        buttonPanel = new JPanel();

        // Initialize labels
        titleLabel = new JLabel("⚡ Electricity Billing System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(41, 128, 185));

        subtitleLabel = new JLabel("Please login to continue");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(Color.GRAY);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Initialize input fields
        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        // Initialize buttons
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(new Color(46, 204, 113));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setPreferredSize(new Dimension(120, 35));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        registerButton = new JButton("Register as New Customer");
        registerButton.setFont(new Font("Arial", Font.PLAIN, 12));
        registerButton.setBackground(new Color(52, 152, 219));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setBorderPainted(false);
        registerButton.setPreferredSize(new Dimension(200, 30));
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 12));
        exitButton.setBackground(new Color(231, 76, 60));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);
        exitButton.setBorderPainted(false);
        exitButton.setPreferredSize(new Dimension(100, 30));
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Initialize checkbox
        rememberMeCheckBox = new JCheckBox("Remember Me");
        rememberMeCheckBox.setFont(new Font("Arial", Font.PLAIN, 12));
    }

    private void setupLayout() {
        mainPanel.setLayout(new BorderLayout(0, 20));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        // Header Panel
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        headerPanel.add(subtitleLabel);

        // Form Panel
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Username row
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        formPanel.add(usernameField, gbc);

        // Password row
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        formPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        formPanel.add(passwordField, gbc);

        // Remember me row
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(rememberMeCheckBox, gbc);

        // Button Panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(exitButton);

        // Add all panels to main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupFrame() {
        setTitle("Electricity Billing System - Login");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // Getters for components (to be used when adding logic)
    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JComboBox<String> getRoleComboBox() {
        return roleComboBox;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JCheckBox getRememberMeCheckBox() {
        return rememberMeCheckBox;
    }
}
