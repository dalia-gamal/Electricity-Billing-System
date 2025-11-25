package com.electricity.ui.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Approve Customers Panel - For admins to approve new customer requests
 * No logic implementation - UI only
 */
public class ApproveCustomersPanel extends JPanel {

    // UI Components
    private JPanel headerPanel;
    private JPanel filterPanel;
    private JPanel tablePanel;
    private JPanel detailsPanel;
    private JPanel buttonPanel;

    private JLabel titleLabel;
    private JLabel statusFilterLabel;
    private JComboBox<String> statusFilterComboBox;
    private JButton filterButton;
    private JButton refreshButton;

    // Table components
    private JTable requestsTable;
    private JScrollPane tableScrollPane;
    private DefaultTableModel tableModel;

    // Details panel components
    private JLabel detailsTitleLabel;
    private JLabel requestIdLabel;
    private JLabel requestIdValue;
    private JLabel customerNameLabel;
    private JLabel customerNameValue;
    private JLabel nationalIdLabel;
    private JLabel nationalIdValue;
    private JLabel emailLabel;
    private JLabel emailValue;
    private JLabel phoneLabel;
    private JLabel phoneValue;
    private JLabel addressLabel;
    private JTextArea addressArea;
    private JLabel regionLabel;
    private JLabel regionValue;
    private JLabel contractLabel;
    private JButton viewContractButton;
    private JLabel requestDateLabel;
    private JLabel requestDateValue;

    // Action buttons
    private JButton approveButton;
    private JButton rejectButton;
    private JLabel rejectionReasonLabel;
    private JTextArea rejectionReasonArea;

    public ApproveCustomersPanel() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        // Initialize panels
        headerPanel = new JPanel();
        filterPanel = new JPanel();
        tablePanel = new JPanel();
        detailsPanel = new JPanel();
        buttonPanel = new JPanel();

        // Initialize header
        titleLabel = new JLabel("Approve New Customer Requests");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(41, 128, 185));

        // Filter components
        statusFilterLabel = new JLabel("Filter by Status:");
        statusFilterLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        String[] statuses = {"All", "Pending", "Approved", "Rejected"};
        statusFilterComboBox = new JComboBox<>(statuses);
        statusFilterComboBox.setFont(new Font("Arial", Font.PLAIN, 13));

        filterButton = new JButton("Filter");
        filterButton.setFont(new Font("Arial", Font.PLAIN, 13));
        filterButton.setBackground(new Color(52, 152, 219));
        filterButton.setForeground(Color.WHITE);
        filterButton.setFocusPainted(false);
        filterButton.setBorderPainted(false);
        filterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        refreshButton = new JButton("Refresh");
        refreshButton.setFont(new Font("Arial", Font.PLAIN, 13));
        refreshButton.setBackground(new Color(46, 204, 113));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setFocusPainted(false);
        refreshButton.setBorderPainted(false);
        refreshButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Initialize table
        String[] columnNames = {
            "Request ID", "Customer Name", "National ID", "Phone", "Region", "Request Date", "Status"
        };

        Object[][] sampleData = {
            {"REQ-2025-001", "Mohamed Ahmed", "29501011234567", "01012345678", "Nasr City", "20-01-2025", "Pending"},
            {"REQ-2025-002", "Sara Ali", "29601021234567", "01123456789", "Maadi", "22-01-2025", "Pending"},
            {"REQ-2025-003", "Ahmed Hassan", "29501031234567", "01234567890", "Zamalek", "23-01-2025", "Pending"},
            {"REQ-2025-004", "Fatima Khaled", "29601041234567", "01098765432", "Dokki", "15-01-2025", "Approved"},
            {"REQ-2025-005", "Omar Mostafa", "29501051234567", "01187654321", "Mohandessin", "10-01-2025", "Approved"}
        };

        tableModel = new DefaultTableModel(sampleData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        requestsTable = new JTable(tableModel);
        requestsTable.setFont(new Font("Arial", Font.PLAIN, 12));
        requestsTable.setRowHeight(28);
        requestsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        requestsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        requestsTable.getTableHeader().setBackground(new Color(52, 73, 94));
        requestsTable.getTableHeader().setForeground(Color.WHITE);
        requestsTable.setGridColor(new Color(189, 195, 199));
        requestsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Set column widths
        requestsTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        requestsTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        requestsTable.getColumnModel().getColumn(2).setPreferredWidth(140);
        requestsTable.getColumnModel().getColumn(3).setPreferredWidth(110);
        requestsTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        requestsTable.getColumnModel().getColumn(5).setPreferredWidth(120);
        requestsTable.getColumnModel().getColumn(6).setPreferredWidth(100);

        tableScrollPane = new JScrollPane(requestsTable);
        tableScrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        // Initialize details panel components
        Font labelFont = new Font("Arial", Font.PLAIN, 13);
        Font valueFont = new Font("Arial", Font.BOLD, 14);

        detailsTitleLabel = new JLabel("Customer Request Details");
        detailsTitleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        detailsTitleLabel.setForeground(new Color(52, 73, 94));

        requestIdLabel = new JLabel("Request ID:");
        requestIdLabel.setFont(labelFont);
        requestIdValue = new JLabel("REQ-2025-001");
        requestIdValue.setFont(valueFont);

        customerNameLabel = new JLabel("Full Name:");
        customerNameLabel.setFont(labelFont);
        customerNameValue = new JLabel("Mohamed Ahmed Ali");
        customerNameValue.setFont(valueFont);

        nationalIdLabel = new JLabel("National ID:");
        nationalIdLabel.setFont(labelFont);
        nationalIdValue = new JLabel("29501011234567");
        nationalIdValue.setFont(valueFont);

        emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        emailValue = new JLabel("mohamed@email.com");
        emailValue.setFont(valueFont);

        phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(labelFont);
        phoneValue = new JLabel("01012345678");
        phoneValue.setFont(valueFont);

        addressLabel = new JLabel("Address:");
        addressLabel.setFont(labelFont);
        addressArea = new JTextArea(2, 20);
        addressArea.setFont(new Font("Arial", Font.PLAIN, 12));
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
        addressArea.setEditable(false);
        addressArea.setBackground(new Color(236, 240, 241));
        addressArea.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));
        addressArea.setText("Street 123, Building 45, Nasr City, Cairo");

        regionLabel = new JLabel("Region:");
        regionLabel.setFont(labelFont);
        regionValue = new JLabel("Cairo - Nasr City");
        regionValue.setFont(valueFont);

        contractLabel = new JLabel("Contract Document:");
        contractLabel.setFont(labelFont);
        viewContractButton = new JButton("View Document");
        viewContractButton.setFont(new Font("Arial", Font.PLAIN, 12));
        viewContractButton.setBackground(new Color(52, 152, 219));
        viewContractButton.setForeground(Color.WHITE);
        viewContractButton.setFocusPainted(false);
        viewContractButton.setBorderPainted(false);
        viewContractButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        requestDateLabel = new JLabel("Request Date:");
        requestDateLabel.setFont(labelFont);
        requestDateValue = new JLabel("20-01-2025");
        requestDateValue.setFont(valueFont);

        // Rejection reason
        rejectionReasonLabel = new JLabel("Rejection Reason:");
        rejectionReasonLabel.setFont(labelFont);
        rejectionReasonArea = new JTextArea(3, 20);
        rejectionReasonArea.setFont(new Font("Arial", Font.PLAIN, 12));
        rejectionReasonArea.setLineWrap(true);
        rejectionReasonArea.setWrapStyleWord(true);
        rejectionReasonArea.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        // Action buttons
        approveButton = new JButton("✓ Approve Request");
        approveButton.setFont(new Font("Arial", Font.BOLD, 14));
        approveButton.setBackground(new Color(46, 204, 113));
        approveButton.setForeground(Color.WHITE);
        approveButton.setFocusPainted(false);
        approveButton.setBorderPainted(false);
        approveButton.setPreferredSize(new Dimension(170, 38));
        approveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        rejectButton = new JButton("✗ Reject Request");
        rejectButton.setFont(new Font("Arial", Font.BOLD, 14));
        rejectButton.setBackground(new Color(231, 76, 60));
        rejectButton.setForeground(Color.WHITE);
        rejectButton.setFocusPainted(false);
        rejectButton.setBorderPainted(false);
        rejectButton.setPreferredSize(new Dimension(160, 38));
        rejectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void setupLayout() {
        setLayout(new BorderLayout(0, 10));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Header panel
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(titleLabel);

        // Filter panel
        filterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        filterPanel.setBackground(Color.WHITE);
        filterPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        filterPanel.add(statusFilterLabel);
        filterPanel.add(statusFilterComboBox);
        filterPanel.add(filterButton);
        filterPanel.add(refreshButton);

        // Table panel
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(Color.WHITE);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        // Details panel
        setupDetailsPanel();

        // Create split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tablePanel, detailsPanel);
        splitPane.setDividerLocation(600);
        splitPane.setResizeWeight(0.55);

        // Top panel
        JPanel topPanel = new JPanel(new BorderLayout(0, 10));
        topPanel.setBackground(Color.WHITE);
        topPanel.add(headerPanel, BorderLayout.NORTH);
        topPanel.add(filterPanel, BorderLayout.CENTER);

        // Add all to main panel
        add(topPanel, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);
    }

    private void setupDetailsPanel() {
        detailsPanel.setLayout(new BorderLayout(0, 10));
        detailsPanel.setBackground(Color.WHITE);
        detailsPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // Details content
        JPanel detailsContent = new JPanel(new GridBagLayout());
        detailsContent.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // Title
        gbc.gridx = 0; gbc.gridy = row++; gbc.gridwidth = 2;
        detailsContent.add(detailsTitleLabel, gbc);
        gbc.gridwidth = 1;

        // Add separator
        gbc.gridy = row++; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        detailsContent.add(new JSeparator(), gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        // Details rows
        addDetailRow(detailsContent, gbc, row++, requestIdLabel, requestIdValue);
        addDetailRow(detailsContent, gbc, row++, customerNameLabel, customerNameValue);
        addDetailRow(detailsContent, gbc, row++, nationalIdLabel, nationalIdValue);
        addDetailRow(detailsContent, gbc, row++, emailLabel, emailValue);
        addDetailRow(detailsContent, gbc, row++, phoneLabel, phoneValue);

        // Address
        gbc.gridx = 0; gbc.gridy = row;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        detailsContent.add(addressLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        detailsContent.add(new JScrollPane(addressArea), gbc);
        row++;

        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        addDetailRow(detailsContent, gbc, row++, regionLabel, regionValue);
        addDetailRow(detailsContent, gbc, row++, requestDateLabel, requestDateValue);

        // Contract
        gbc.gridx = 0; gbc.gridy = row;
        detailsContent.add(contractLabel, gbc);
        gbc.gridx = 1;
        detailsContent.add(viewContractButton, gbc);
        row++;

        // Rejection reason
        gbc.gridx = 0; gbc.gridy = row;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        detailsContent.add(rejectionReasonLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        detailsContent.add(new JScrollPane(rejectionReasonArea), gbc);

        // Button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);

        detailsPanel.add(new JScrollPane(detailsContent), BorderLayout.CENTER);
        detailsPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addDetailRow(JPanel panel, GridBagConstraints gbc, int row, JLabel label, JLabel value) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(value, gbc);
    }

    // Getters
    public JComboBox<String> getStatusFilterComboBox() { return statusFilterComboBox; }
    public JButton getFilterButton() { return filterButton; }
    public JButton getRefreshButton() { return refreshButton; }
    public JTable getRequestsTable() { return requestsTable; }
    public DefaultTableModel getTableModel() { return tableModel; }
    public JButton getApproveButton() { return approveButton; }
    public JButton getRejectButton() { return rejectButton; }
    public JButton getViewContractButton() { return viewContractButton; }
    public JTextArea getRejectionReasonArea() { return rejectionReasonArea; }
    public JLabel getRequestIdValue() { return requestIdValue; }
    public JLabel getCustomerNameValue() { return customerNameValue; }
    public JLabel getNationalIdValue() { return nationalIdValue; }
    public JLabel getEmailValue() { return emailValue; }
    public JLabel getPhoneValue() { return phoneValue; }
    public JTextArea getAddressArea() { return addressArea; }
    public JLabel getRegionValue() { return regionValue; }
    public JLabel getRequestDateValue() { return requestDateValue; }
}
