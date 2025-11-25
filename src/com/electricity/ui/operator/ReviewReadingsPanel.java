package com.electricity.ui.operator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Review Readings Panel - For operators to review and approve/reject customer readings
 * No logic implementation - UI only
 */
public class ReviewReadingsPanel extends JPanel {

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
    private JTable readingsTable;
    private JScrollPane tableScrollPane;
    private DefaultTableModel tableModel;

    // Details panel components
    private JLabel detailsTitleLabel;
    private JLabel meterCodeLabel;
    private JLabel meterCodeValue;
    private JLabel customerNameLabel;
    private JLabel customerNameValue;
    private JLabel previousReadingLabel;
    private JLabel previousReadingValue;
    private JLabel currentReadingLabel;
    private JLabel currentReadingValue;
    private JLabel consumptionLabel;
    private JLabel consumptionValue;
    private JLabel readingDateLabel;
    private JLabel readingDateValue;
    private JLabel notesLabel;
    private JTextArea notesArea;

    // Action buttons
    private JButton approveButton;
    private JButton rejectButton;
    private JLabel rejectionReasonLabel;
    private JTextArea rejectionReasonArea;

    public ReviewReadingsPanel() {
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
        titleLabel = new JLabel("Review Customer Readings");
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
            "Reading ID", "Meter Code", "Customer Name", "Previous", "Current",
            "Consumption", "Date", "Status"
        };

        Object[][] sampleData = {
            {"READ-2025-001", "123456", "Mohamed Ahmed", "1500", "1680", "180 kWh", "01-02-2025", "Pending"},
            {"READ-2025-002", "123457", "Sara Ali", "2000", "2250", "250 kWh", "01-02-2025", "Pending"},
            {"READ-2025-003", "123458", "Ahmed Hassan", "1800", "5200", "3400 kWh", "31-01-2025", "Pending"},
            {"READ-2025-004", "123459", "Fatima Khaled", "1300", "1450", "150 kWh", "31-01-2025", "Approved"},
            {"READ-2025-005", "123460", "Omar Mostafa", "1700", "1850", "150 kWh", "30-01-2025", "Approved"}
        };

        tableModel = new DefaultTableModel(sampleData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        readingsTable = new JTable(tableModel);
        readingsTable.setFont(new Font("Arial", Font.PLAIN, 12));
        readingsTable.setRowHeight(28);
        readingsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        readingsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        readingsTable.getTableHeader().setBackground(new Color(52, 73, 94));
        readingsTable.getTableHeader().setForeground(Color.WHITE);
        readingsTable.setGridColor(new Color(189, 195, 199));
        readingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Set column widths
        readingsTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        readingsTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        readingsTable.getColumnModel().getColumn(2).setPreferredWidth(140);
        readingsTable.getColumnModel().getColumn(3).setPreferredWidth(90);
        readingsTable.getColumnModel().getColumn(4).setPreferredWidth(90);
        readingsTable.getColumnModel().getColumn(5).setPreferredWidth(120);
        readingsTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        readingsTable.getColumnModel().getColumn(7).setPreferredWidth(90);

        tableScrollPane = new JScrollPane(readingsTable);
        tableScrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        // Initialize details panel components
        Font labelFont = new Font("Arial", Font.PLAIN, 13);
        Font valueFont = new Font("Arial", Font.BOLD, 14);

        detailsTitleLabel = new JLabel("Reading Details");
        detailsTitleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        detailsTitleLabel.setForeground(new Color(52, 73, 94));

        meterCodeLabel = new JLabel("Meter Code:");
        meterCodeLabel.setFont(labelFont);
        meterCodeValue = new JLabel("123456");
        meterCodeValue.setFont(valueFont);

        customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setFont(labelFont);
        customerNameValue = new JLabel("Mohamed Ahmed");
        customerNameValue.setFont(valueFont);

        previousReadingLabel = new JLabel("Previous Reading:");
        previousReadingLabel.setFont(labelFont);
        previousReadingValue = new JLabel("1500");
        previousReadingValue.setFont(valueFont);

        currentReadingLabel = new JLabel("Current Reading:");
        currentReadingLabel.setFont(labelFont);
        currentReadingValue = new JLabel("1680");
        currentReadingValue.setFont(valueFont);
        currentReadingValue.setForeground(new Color(52, 152, 219));

        consumptionLabel = new JLabel("Consumption:");
        consumptionLabel.setFont(labelFont);
        consumptionValue = new JLabel("180 kWh");
        consumptionValue.setFont(new Font("Arial", Font.BOLD, 16));
        consumptionValue.setForeground(new Color(46, 204, 113));

        readingDateLabel = new JLabel("Reading Date:");
        readingDateLabel.setFont(labelFont);
        readingDateValue = new JLabel("01-02-2025");
        readingDateValue.setFont(valueFont);

        notesLabel = new JLabel("Customer Notes:");
        notesLabel.setFont(labelFont);
        notesArea = new JTextArea(2, 20);
        notesArea.setFont(new Font("Arial", Font.PLAIN, 12));
        notesArea.setLineWrap(true);
        notesArea.setWrapStyleWord(true);
        notesArea.setEditable(false);
        notesArea.setBackground(new Color(236, 240, 241));
        notesArea.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));
        notesArea.setText("Normal reading, no issues.");

        // Rejection reason
        rejectionReasonLabel = new JLabel("Rejection Reason:");
        rejectionReasonLabel.setFont(labelFont);
        rejectionReasonArea = new JTextArea(3, 20);
        rejectionReasonArea.setFont(new Font("Arial", Font.PLAIN, 12));
        rejectionReasonArea.setLineWrap(true);
        rejectionReasonArea.setWrapStyleWord(true);
        rejectionReasonArea.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        // Action buttons
        approveButton = new JButton("✓ Approve Reading");
        approveButton.setFont(new Font("Arial", Font.BOLD, 14));
        approveButton.setBackground(new Color(46, 204, 113));
        approveButton.setForeground(Color.WHITE);
        approveButton.setFocusPainted(false);
        approveButton.setBorderPainted(false);
        approveButton.setPreferredSize(new Dimension(160, 38));
        approveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        rejectButton = new JButton("✗ Reject Reading");
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
        splitPane.setResizeWeight(0.6);

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
        addDetailRow(detailsContent, gbc, row++, meterCodeLabel, meterCodeValue);
        addDetailRow(detailsContent, gbc, row++, customerNameLabel, customerNameValue);
        addDetailRow(detailsContent, gbc, row++, previousReadingLabel, previousReadingValue);
        addDetailRow(detailsContent, gbc, row++, currentReadingLabel, currentReadingValue);
        addDetailRow(detailsContent, gbc, row++, consumptionLabel, consumptionValue);
        addDetailRow(detailsContent, gbc, row++, readingDateLabel, readingDateValue);

        // Notes
        gbc.gridx = 0; gbc.gridy = row;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        detailsContent.add(notesLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        detailsContent.add(new JScrollPane(notesArea), gbc);
        row++;

        // Rejection reason
        gbc.gridx = 0; gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
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
    public JTable getReadingsTable() { return readingsTable; }
    public DefaultTableModel getTableModel() { return tableModel; }
    public JButton getApproveButton() { return approveButton; }
    public JButton getRejectButton() { return rejectButton; }
    public JTextArea getRejectionReasonArea() { return rejectionReasonArea; }
    public JLabel getMeterCodeValue() { return meterCodeValue; }
    public JLabel getCustomerNameValue() { return customerNameValue; }
    public JLabel getPreviousReadingValue() { return previousReadingValue; }
    public JLabel getCurrentReadingValue() { return currentReadingValue; }
    public JLabel getConsumptionValue() { return consumptionValue; }
    public JLabel getReadingDateValue() { return readingDateValue; }
    public JTextArea getNotesArea() { return notesArea; }
}
