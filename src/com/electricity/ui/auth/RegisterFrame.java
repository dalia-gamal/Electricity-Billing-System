package com.electricity.ui.auth;

import javax.swing.*;
import java.awt.*;

/**
 * Register Frame - For new customer registration
 * No logic implementation - UI only
 */
public class RegisterFrame extends JFrame {

    // UI Components
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel formPanel;
    private JPanel buttonPanel;

    private JLabel titleLabel;
    private JLabel subtitleLabel;

    // Personal Information
    private JLabel fullNameLabel;
    private JLabel nationalIdLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;

    private JTextField fullNameField;
    private JTextField nationalIdField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    // Address Information
    private JLabel addressLabel;
    private JLabel regionLabel;

    private JTextArea addressArea;
    private JComboBox<String> regionComboBox;

    // Contract Document
    private JLabel contractLabel;
    private JTextField contractPathField;
    private JButton browseButton;

    // Action Buttons
    private JButton registerButton;
    private JButton cancelButton;

    private JCheckBox termsCheckBox;

    public RegisterFrame() {
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

        // Initialize header labels
        titleLabel = new JLabel("New Customer Registration");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(41, 128, 185));

        subtitleLabel = new JLabel("Please fill all information to request meter installation");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        subtitleLabel.setForeground(Color.GRAY);

        // Initialize form labels
        fullNameLabel = new JLabel("Full Name: *");
        fullNameLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        nationalIdLabel = new JLabel("National ID: *");
        nationalIdLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        emailLabel = new JLabel("Email: *");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        phoneLabel = new JLabel("Phone Number: *");
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        usernameLabel = new JLabel("Username: *");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        passwordLabel = new JLabel("Password: *");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        confirmPasswordLabel = new JLabel("Confirm Password: *");
        confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        addressLabel = new JLabel("Address: *");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        regionLabel = new JLabel("Region: *");
        regionLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        contractLabel = new JLabel("Contract Document: *");
        contractLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        // Initialize input fields
        fullNameField = new JTextField(25);
        fullNameField.setFont(new Font("Arial", Font.PLAIN, 13));

        nationalIdField = new JTextField(25);
        nationalIdField.setFont(new Font("Arial", Font.PLAIN, 13));

        emailField = new JTextField(25);
        emailField.setFont(new Font("Arial", Font.PLAIN, 13));

        phoneField = new JTextField(25);
        phoneField.setFont(new Font("Arial", Font.PLAIN, 13));

        usernameField = new JTextField(25);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 13));

        passwordField = new JPasswordField(25);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 13));

        confirmPasswordField = new JPasswordField(25);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 13));

        // Address area
        addressArea = new JTextArea(3, 25);
        addressArea.setFont(new Font("Arial", Font.PLAIN, 13));
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
        addressArea.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        // Region combo box
        String[] regions = {"Select Region", "Cairo - Nasr City", "Cairo - Maadi", "Cairo - Zamalek",
                           "Giza - Dokki", "Giza - Mohandessin", "Alexandria - Miami"};
        regionComboBox = new JComboBox<>(regions);
        regionComboBox.setFont(new Font("Arial", Font.PLAIN, 13));

        // Contract document fields
        contractPathField = new JTextField(20);
        contractPathField.setFont(new Font("Arial", Font.PLAIN, 13));
        contractPathField.setEditable(false);

        browseButton = new JButton("Browse...");
        browseButton.setFont(new Font("Arial", Font.PLAIN, 12));
        browseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Initialize buttons
        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setBackground(new Color(46, 204, 113));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setBorderPainted(false);
        registerButton.setPreferredSize(new Dimension(120, 35));
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 14));
        cancelButton.setBackground(new Color(149, 165, 166));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.setBorderPainted(false);
        cancelButton.setPreferredSize(new Dimension(120, 35));
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Terms checkbox
        termsCheckBox = new JCheckBox("I agree to the terms and conditions");
        termsCheckBox.setFont(new Font("Arial", Font.PLAIN, 11));
    }

    private void setupLayout() {
        mainPanel.setLayout(new BorderLayout(0, 15));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Header Panel
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        headerPanel.add(subtitleLabel);

        // Form Panel with GridBagLayout
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // Full Name
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(fullNameLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(fullNameField, gbc);

        // National ID
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(nationalIdLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(nationalIdField, gbc);

        // Email
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(emailField, gbc);

        // Phone
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(phoneField, gbc);

        // Username
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(usernameField, gbc);

        // Password
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(passwordField, gbc);

        // Confirm Password
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(confirmPasswordLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(confirmPasswordField, gbc);

        // Address
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        formPanel.add(addressLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        formPanel.add(new JScrollPane(addressArea), gbc);

        // Region
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(regionLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(regionComboBox, gbc);

        // Contract Document
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(contractLabel, gbc);
        gbc.gridx = 1;
        JPanel contractPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        contractPanel.setBackground(Color.WHITE);
        contractPanel.add(contractPathField);
        contractPanel.add(browseButton);
        formPanel.add(contractPanel, gbc);

        // Terms checkbox
        row++;
        gbc.gridx = 1; gbc.gridy = row;
        formPanel.add(termsCheckBox, gbc);

        // Button Panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(registerButton);
        buttonPanel.add(cancelButton);

        // Add all panels to main panel
        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupFrame() {
        setTitle("New Customer Registration");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // Getters for components (to be used when adding logic)
    public JTextField getFullNameField() { return fullNameField; }
    public JTextField getNationalIdField() { return nationalIdField; }
    public JTextField getEmailField() { return emailField; }
    public JTextField getPhoneField() { return phoneField; }
    public JTextField getUsernameField() { return usernameField; }
    public JPasswordField getPasswordField() { return passwordField; }
    public JPasswordField getConfirmPasswordField() { return confirmPasswordField; }
    public JTextArea getAddressArea() { return addressArea; }
    public JComboBox<String> getRegionComboBox() { return regionComboBox; }
    public JTextField getContractPathField() { return contractPathField; }
    public JButton getBrowseButton() { return browseButton; }
    public JButton getRegisterButton() { return registerButton; }
    public JButton getCancelButton() { return cancelButton; }
    public JCheckBox getTermsCheckBox() { return termsCheckBox; }
}
