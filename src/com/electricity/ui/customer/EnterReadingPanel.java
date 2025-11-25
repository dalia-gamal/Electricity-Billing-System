package com.electricity.ui.customer;

import javax.swing.*;
import java.awt.*;

/**
 * Enter Reading Panel - For customers to submit meter readings
 * No logic implementation - UI only
 */
public class EnterReadingPanel extends JPanel {

    // UI Components
    private JPanel headerPanel;
    private JPanel formPanel;
    private JPanel buttonPanel;
    private JPanel infoPanel;

    private JLabel titleLabel;
    private JLabel meterCodeLabel;
    private JLabel previousReadingLabel;
    private JLabel currentReadingLabel;
    private JLabel readingDateLabel;
    private JLabel notesLabel;

    private JTextField meterCodeField;
    private JTextField previousReadingField;
    private JTextField currentReadingField;
    private JTextField readingDateField;
    private JTextArea notesArea;

    private JButton submitButton;
    private JButton clearButton;
    private JButton cancelButton;

    // Info panel components
    private JLabel infoTitleLabel;
    private JTextArea infoTextArea;

    public EnterReadingPanel() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        // Initialize panels
        headerPanel = new JPanel();
        formPanel = new JPanel();
        buttonPanel = new JPanel();
        infoPanel = new JPanel();

        // Initialize labels
        titleLabel = new JLabel("Enter Monthly Meter Reading");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(41, 128, 185));

        meterCodeLabel = new JLabel("Meter Code:");
        meterCodeLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        previousReadingLabel = new JLabel("Previous Reading:");
        previousReadingLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        currentReadingLabel = new JLabel("Current Reading: *");
        currentReadingLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        readingDateLabel = new JLabel("Reading Date:");
        readingDateLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        notesLabel = new JLabel("Notes (Optional):");
        notesLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Initialize input fields
        meterCodeField = new JTextField(20);
        meterCodeField.setFont(new Font("Arial", Font.PLAIN, 14));
        meterCodeField.setEditable(false);
        meterCodeField.setBackground(new Color(236, 240, 241));

        previousReadingField = new JTextField(20);
        previousReadingField.setFont(new Font("Arial", Font.PLAIN, 14));
        previousReadingField.setEditable(false);
        previousReadingField.setBackground(new Color(236, 240, 241));

        currentReadingField = new JTextField(20);
        currentReadingField.setFont(new Font("Arial", Font.PLAIN, 14));

        readingDateField = new JTextField(20);
        readingDateField.setFont(new Font("Arial", Font.PLAIN, 14));
        readingDateField.setEditable(false);
        readingDateField.setBackground(new Color(236, 240, 241));

        notesArea = new JTextArea(3, 20);
        notesArea.setFont(new Font("Arial", Font.PLAIN, 13));
        notesArea.setLineWrap(true);
        notesArea.setWrapStyleWord(true);
        notesArea.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        // Initialize buttons
        submitButton = new JButton("Submit Reading");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(46, 204, 113));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setBorderPainted(false);
        submitButton.setPreferredSize(new Dimension(150, 35));
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 14));
        clearButton.setBackground(new Color(243, 156, 18));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        clearButton.setBorderPainted(false);
        clearButton.setPreferredSize(new Dimension(100, 35));
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 14));
        cancelButton.setBackground(new Color(149, 165, 166));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.setBorderPainted(false);
        cancelButton.setPreferredSize(new Dimension(100, 35));
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Initialize info panel components
        infoTitleLabel = new JLabel("📋 Important Information");
        infoTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        infoTitleLabel.setForeground(new Color(52, 73, 94));

        infoTextArea = new JTextArea(
            "• Please ensure you enter the correct meter reading\n" +
            "• The reading will be verified by an operator\n" +
            "• You will be notified once approved\n" +
            "• If rejected, you will need to re-enter the reading\n" +
            "• Bill will be generated after approval"
        );
        infoTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        infoTextArea.setEditable(false);
        infoTextArea.setBackground(new Color(236, 240, 241));
        infoTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void setupLayout() {
        setLayout(new BorderLayout(0, 20));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Header panel
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(titleLabel);

        // Form panel with GridBagLayout
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199)),
                "Reading Details",
                0,
                0,
                new Font("Arial", Font.BOLD, 14),
                new Color(52, 73, 94)
            ),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Meter Code
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(meterCodeLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(meterCodeField, gbc);

        // Previous Reading
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(previousReadingLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(previousReadingField, gbc);

        // Current Reading
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(currentReadingLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(currentReadingField, gbc);

        // Reading Date
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(readingDateLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(readingDateField, gbc);

        // Notes
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        formPanel.add(notesLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        formPanel.add(new JScrollPane(notesArea), gbc);

        // Info panel
        infoPanel.setLayout(new BorderLayout(0, 10));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(52, 152, 219), 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        infoPanel.add(infoTitleLabel, BorderLayout.NORTH);
        infoPanel.add(infoTextArea, BorderLayout.CENTER);

        // Button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(cancelButton);

        // Create center container
        JPanel centerContainer = new JPanel(new BorderLayout(0, 20));
        centerContainer.setBackground(Color.WHITE);
        centerContainer.add(formPanel, BorderLayout.NORTH);
        centerContainer.add(infoPanel, BorderLayout.CENTER);

        // Add all panels
        add(headerPanel, BorderLayout.NORTH);
        add(centerContainer, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Getters
    public JTextField getMeterCodeField() { return meterCodeField; }
    public JTextField getPreviousReadingField() { return previousReadingField; }
    public JTextField getCurrentReadingField() { return currentReadingField; }
    public JTextField getReadingDateField() { return readingDateField; }
    public JTextArea getNotesArea() { return notesArea; }
    public JButton getSubmitButton() { return submitButton; }
    public JButton getClearButton() { return clearButton; }
    public JButton getCancelButton() { return cancelButton; }
}
