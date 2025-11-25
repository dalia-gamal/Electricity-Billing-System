package com.electricity.ui.customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Complaints Panel - For customers to view and submit complaints
 * No logic implementation - UI only
 */
public class ComplaintsPanel extends JPanel {

    // UI Components
    private JPanel headerPanel;
    private JTabbedPane tabbedPane;

    // Submit Complaint Tab
    private JPanel submitComplaintPanel;
    private JLabel complaintTypeLabel;
    private JLabel billIdLabel;
    private JLabel subjectLabel;
    private JLabel descriptionLabel;
    private JLabel priorityLabel;

    private JComboBox<String> complaintTypeComboBox;
    private JTextField billIdField;
    private JTextField subjectField;
    private JTextArea descriptionArea;
    private JComboBox<String> priorityComboBox;

    private JButton submitComplaintButton;
    private JButton clearFormButton;

    // View Complaints Tab
    private JPanel viewComplaintsPanel;
    private JTable complaintsTable;
    private JScrollPane complaintsScrollPane;
    private DefaultTableModel complaintsTableModel;

    private JButton viewDetailsButton;
    private JButton refreshButton;
    private JButton deleteComplaintButton;

    private JLabel titleLabel;

    public ComplaintsPanel() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        // Initialize panels
        headerPanel = new JPanel();
        submitComplaintPanel = new JPanel();
        viewComplaintsPanel = new JPanel();
        tabbedPane = new JTabbedPane();

        // Initialize header
        titleLabel = new JLabel("Complaints & Support");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(41, 128, 185));

        // === Submit Complaint Tab Components ===
        Font labelFont = new Font("Arial", Font.PLAIN, 14);

        complaintTypeLabel = new JLabel("Complaint Type: *");
        complaintTypeLabel.setFont(labelFont);

        billIdLabel = new JLabel("Bill ID (Optional):");
        billIdLabel.setFont(labelFont);

        subjectLabel = new JLabel("Subject: *");
        subjectLabel.setFont(labelFont);

        descriptionLabel = new JLabel("Description: *");
        descriptionLabel.setFont(labelFont);

        priorityLabel = new JLabel("Priority: *");
        priorityLabel.setFont(labelFont);

        // Combo boxes
        String[] complaintTypes = {"Select Type", "Incorrect Bill", "Meter Issue",
                                  "Payment Problem", "Service Quality", "Other"};
        complaintTypeComboBox = new JComboBox<>(complaintTypes);
        complaintTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 13));

        String[] priorities = {"Normal", "High", "Urgent"};
        priorityComboBox = new JComboBox<>(priorities);
        priorityComboBox.setFont(new Font("Arial", Font.PLAIN, 13));

        // Text fields
        billIdField = new JTextField(25);
        billIdField.setFont(new Font("Arial", Font.PLAIN, 13));

        subjectField = new JTextField(25);
        subjectField.setFont(new Font("Arial", Font.PLAIN, 13));

        descriptionArea = new JTextArea(6, 25);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 13));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        // Submit complaint buttons
        submitComplaintButton = new JButton("Submit Complaint");
        submitComplaintButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitComplaintButton.setBackground(new Color(231, 76, 60));
        submitComplaintButton.setForeground(Color.WHITE);
        submitComplaintButton.setFocusPainted(false);
        submitComplaintButton.setBorderPainted(false);
        submitComplaintButton.setPreferredSize(new Dimension(160, 35));
        submitComplaintButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        clearFormButton = new JButton("Clear Form");
        clearFormButton.setFont(new Font("Arial", Font.PLAIN, 13));
        clearFormButton.setBackground(new Color(149, 165, 166));
        clearFormButton.setForeground(Color.WHITE);
        clearFormButton.setFocusPainted(false);
        clearFormButton.setBorderPainted(false);
        clearFormButton.setPreferredSize(new Dimension(120, 35));
        clearFormButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // === View Complaints Tab Components ===
        String[] columnNames = {
            "Complaint ID", "Type", "Subject", "Status", "Priority", "Submitted Date", "Response"
        };

        Object[][] sampleData = {
            {"COMP-2025-001", "Incorrect Bill", "Bill amount too high", "Under Review", "Normal", "05-02-2025", "Pending"},
            {"COMP-2024-005", "Meter Issue", "Meter not working", "Resolved", "High", "15-12-2024", "Issue fixed"},
            {"COMP-2024-003", "Payment Problem", "Payment not reflected", "Resolved", "Normal", "10-11-2024", "Payment confirmed"}
        };

        complaintsTableModel = new DefaultTableModel(sampleData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        complaintsTable = new JTable(complaintsTableModel);
        complaintsTable.setFont(new Font("Arial", Font.PLAIN, 12));
        complaintsTable.setRowHeight(28);
        complaintsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        complaintsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        complaintsTable.getTableHeader().setBackground(new Color(52, 73, 94));
        complaintsTable.getTableHeader().setForeground(Color.WHITE);
        complaintsTable.setGridColor(new Color(189, 195, 199));

        complaintsScrollPane = new JScrollPane(complaintsTable);
        complaintsScrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        // View complaints buttons
        viewDetailsButton = new JButton("View Details");
        viewDetailsButton.setFont(new Font("Arial", Font.PLAIN, 13));
        viewDetailsButton.setBackground(new Color(52, 152, 219));
        viewDetailsButton.setForeground(Color.WHITE);
        viewDetailsButton.setFocusPainted(false);
        viewDetailsButton.setBorderPainted(false);
        viewDetailsButton.setPreferredSize(new Dimension(120, 32));
        viewDetailsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        refreshButton = new JButton("Refresh");
        refreshButton.setFont(new Font("Arial", Font.PLAIN, 13));
        refreshButton.setBackground(new Color(46, 204, 113));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setFocusPainted(false);
        refreshButton.setBorderPainted(false);
        refreshButton.setPreferredSize(new Dimension(100, 32));
        refreshButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        deleteComplaintButton = new JButton("Delete");
        deleteComplaintButton.setFont(new Font("Arial", Font.PLAIN, 13));
        deleteComplaintButton.setBackground(new Color(231, 76, 60));
        deleteComplaintButton.setForeground(Color.WHITE);
        deleteComplaintButton.setFocusPainted(false);
        deleteComplaintButton.setBorderPainted(false);
        deleteComplaintButton.setPreferredSize(new Dimension(100, 32));
        deleteComplaintButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void setupLayout() {
        setLayout(new BorderLayout(0, 15));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Header panel
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(titleLabel);

        // === Setup Submit Complaint Panel ===
        setupSubmitComplaintPanel();

        // === Setup View Complaints Panel ===
        setupViewComplaintsPanel();

        // Add tabs
        tabbedPane.addTab("Submit Complaint", submitComplaintPanel);
        tabbedPane.addTab("My Complaints", viewComplaintsPanel);
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 13));
        tabbedPane.setBackground(Color.WHITE);

        // Add all to main panel
        add(headerPanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
    }

    private void setupSubmitComplaintPanel() {
        submitComplaintPanel.setLayout(new BorderLayout(0, 15));
        submitComplaintPanel.setBackground(Color.WHITE);
        submitComplaintPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199)),
                "Complaint Details",
                0, 0,
                new Font("Arial", Font.BOLD, 13),
                new Color(52, 73, 94)
            ),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // Complaint Type
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(complaintTypeLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(complaintTypeComboBox, gbc);

        // Bill ID
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(billIdLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(billIdField, gbc);

        // Subject
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(subjectLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(subjectField, gbc);

        // Description
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        formPanel.add(descriptionLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        formPanel.add(new JScrollPane(descriptionArea), gbc);

        // Priority
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(priorityLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(priorityComboBox, gbc);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(submitComplaintButton);
        buttonPanel.add(clearFormButton);

        submitComplaintPanel.add(formPanel, BorderLayout.CENTER);
        submitComplaintPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupViewComplaintsPanel() {
        viewComplaintsPanel.setLayout(new BorderLayout(0, 10));
        viewComplaintsPanel.setBackground(Color.WHITE);
        viewComplaintsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(viewDetailsButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(deleteComplaintButton);

        viewComplaintsPanel.add(complaintsScrollPane, BorderLayout.CENTER);
        viewComplaintsPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    // Getters
    public JComboBox<String> getComplaintTypeComboBox() { return complaintTypeComboBox; }
    public JTextField getBillIdField() { return billIdField; }
    public JTextField getSubjectField() { return subjectField; }
    public JTextArea getDescriptionArea() { return descriptionArea; }
    public JComboBox<String> getPriorityComboBox() { return priorityComboBox; }
    public JButton getSubmitComplaintButton() { return submitComplaintButton; }
    public JButton getClearFormButton() { return clearFormButton; }
    public JTable getComplaintsTable() { return complaintsTable; }
    public DefaultTableModel getComplaintsTableModel() { return complaintsTableModel; }
    public JButton getViewDetailsButton() { return viewDetailsButton; }
    public JButton getRefreshButton() { return refreshButton; }
    public JButton getDeleteComplaintButton() { return deleteComplaintButton; }
    public JTabbedPane getTabbedPane() { return tabbedPane; }
}
