package com.electricity.ui.operator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Collect Payment Panel - For operators to collect cash payments from customers
 * No logic implementation - UI only
 */
public class CollectPaymentPanel extends JPanel {

    // UI Components
    private JPanel headerPanel;
    private JPanel searchPanel;
    private JPanel customerInfoPanel;
    private JPanel billsPanel;
    private JPanel paymentPanel;
    private JPanel buttonPanel;

    private JLabel titleLabel;

    // Search components
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;

    // Customer info
    private JLabel customerNameLabel;
    private JLabel customerNameValue;
    private JLabel meterCodeLabel;
    private JLabel meterCodeValue;
    private JLabel phoneLabel;
    private JLabel phoneValue;

    // Bills table
    private JLabel unpaidBillsLabel;
    private JTable billsTable;
    private JScrollPane billsScrollPane;
    private DefaultTableModel billsTableModel;

    // Payment details
    private JLabel selectedBillLabel;
    private JLabel selectedBillValue;
    private JLabel amountDueLabel;
    private JLabel amountDueValue;
    private JLabel amountPaidLabel;
    private JTextField amountPaidField;
    private JLabel changeLabel;
    private JLabel changeValue;

    // Action buttons
    private JButton collectPaymentButton;
    private JButton printReceiptButton;
    private JButton clearButton;

    public CollectPaymentPanel() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        // Initialize panels
        headerPanel = new JPanel();
        searchPanel = new JPanel();
        customerInfoPanel = new JPanel();
        billsPanel = new JPanel();
        paymentPanel = new JPanel();
        buttonPanel = new JPanel();

        // Header
        titleLabel = new JLabel("Collect Payment");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(41, 128, 185));

        // Search components
        searchLabel = new JLabel("Search by Meter Code:");
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        searchField = new JTextField(20);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));

        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.BOLD, 13));
        searchButton.setBackground(new Color(52, 152, 219));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setBorderPainted(false);
        searchButton.setPreferredSize(new Dimension(100, 32));
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Customer info
        Font labelFont = new Font("Arial", Font.PLAIN, 13);
        Font valueFont = new Font("Arial", Font.BOLD, 14);

        customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setFont(labelFont);
        customerNameValue = new JLabel("Mohamed Ahmed Ali");
        customerNameValue.setFont(valueFont);

        meterCodeLabel = new JLabel("Meter Code:");
        meterCodeLabel.setFont(labelFont);
        meterCodeValue = new JLabel("123456");
        meterCodeValue.setFont(valueFont);

        phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(labelFont);
        phoneValue = new JLabel("01012345678");
        phoneValue.setFont(valueFont);

        // Bills table
        unpaidBillsLabel = new JLabel("Unpaid Bills:");
        unpaidBillsLabel.setFont(new Font("Arial", Font.BOLD, 14));

        String[] columnNames = {"Select", "Bill ID", "Month/Year", "Amount (EGP)", "Due Date", "Status"};
        Object[][] sampleData = {
            {false, "BILL-2025-001", "January 2025", "270.00", "03-02-2025", "Unpaid"},
            {false, "BILL-2024-012", "December 2024", "250.00", "03-01-2025", "Overdue"}
        };

        billsTableModel = new DefaultTableModel(sampleData, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 0 ? Boolean.class : String.class;
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };

        billsTable = new JTable(billsTableModel);
        billsTable.setFont(new Font("Arial", Font.PLAIN, 12));
        billsTable.setRowHeight(28);
        billsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        billsTable.getTableHeader().setBackground(new Color(52, 73, 94));
        billsTable.getTableHeader().setForeground(Color.WHITE);
        billsTable.setGridColor(new Color(189, 195, 199));
        billsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Set column widths
        billsTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        billsTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        billsTable.getColumnModel().getColumn(2).setPreferredWidth(130);
        billsTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        billsTable.getColumnModel().getColumn(4).setPreferredWidth(110);
        billsTable.getColumnModel().getColumn(5).setPreferredWidth(90);

        billsScrollPane = new JScrollPane(billsTable);
        billsScrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        // Payment details
        selectedBillLabel = new JLabel("Selected Bill:");
        selectedBillLabel.setFont(labelFont);
        selectedBillValue = new JLabel("BILL-2025-001");
        selectedBillValue.setFont(valueFont);
        selectedBillValue.setForeground(new Color(52, 152, 219));

        amountDueLabel = new JLabel("Amount Due:");
        amountDueLabel.setFont(new Font("Arial", Font.BOLD, 15));
        amountDueValue = new JLabel("270.00 EGP");
        amountDueValue.setFont(new Font("Arial", Font.BOLD, 20));
        amountDueValue.setForeground(new Color(231, 76, 60));

        amountPaidLabel = new JLabel("Amount Paid:");
        amountPaidLabel.setFont(new Font("Arial", Font.BOLD, 15));
        amountPaidField = new JTextField(15);
        amountPaidField.setFont(new Font("Arial", Font.PLAIN, 16));

        changeLabel = new JLabel("Change:");
        changeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        changeValue = new JLabel("0.00 EGP");
        changeValue.setFont(new Font("Arial", Font.BOLD, 18));
        changeValue.setForeground(new Color(46, 204, 113));

        // Action buttons
        collectPaymentButton = new JButton("Collect Payment");
        collectPaymentButton.setFont(new Font("Arial", Font.BOLD, 15));
        collectPaymentButton.setBackground(new Color(46, 204, 113));
        collectPaymentButton.setForeground(Color.WHITE);
        collectPaymentButton.setFocusPainted(false);
        collectPaymentButton.setBorderPainted(false);
        collectPaymentButton.setPreferredSize(new Dimension(170, 40));
        collectPaymentButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        printReceiptButton = new JButton("Print Receipt");
        printReceiptButton.setFont(new Font("Arial", Font.PLAIN, 14));
        printReceiptButton.setBackground(new Color(52, 152, 219));
        printReceiptButton.setForeground(Color.WHITE);
        printReceiptButton.setFocusPainted(false);
        printReceiptButton.setBorderPainted(false);
        printReceiptButton.setPreferredSize(new Dimension(140, 40));
        printReceiptButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 14));
        clearButton.setBackground(new Color(149, 165, 166));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        clearButton.setBorderPainted(false);
        clearButton.setPreferredSize(new Dimension(100, 40));
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void setupLayout() {
        setLayout(new BorderLayout(0, 15));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Header panel
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(titleLabel);

        // Search panel
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        searchPanel.setBackground(Color.WHITE);
        searchPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199)),
                "Customer Search",
                0, 0,
                new Font("Arial", Font.BOLD, 13),
                new Color(52, 73, 94)
            ),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Customer info panel
        customerInfoPanel.setLayout(new GridBagLayout());
        customerInfoPanel.setBackground(Color.WHITE);
        customerInfoPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199)),
                "Customer Information",
                0, 0,
                new Font("Arial", Font.BOLD, 13),
                new Color(52, 73, 94)
            ),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;
        addInfoRow(customerInfoPanel, gbc, row++, customerNameLabel, customerNameValue);
        addInfoRow(customerInfoPanel, gbc, row++, meterCodeLabel, meterCodeValue);
        addInfoRow(customerInfoPanel, gbc, row++, phoneLabel, phoneValue);

        // Bills panel
        billsPanel.setLayout(new BorderLayout(0, 10));
        billsPanel.setBackground(Color.WHITE);
        billsPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199)),
                "Select Bill to Pay",
                0, 0,
                new Font("Arial", Font.BOLD, 13),
                new Color(52, 73, 94)
            ),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        billsPanel.add(billsScrollPane, BorderLayout.CENTER);

        // Payment panel
        paymentPanel.setLayout(new GridBagLayout());
        paymentPanel.setBackground(Color.WHITE);
        paymentPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199)),
                "Payment Details",
                0, 0,
                new Font("Arial", Font.BOLD, 13),
                new Color(52, 73, 94)
            ),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        row = 0;
        addInfoRow(paymentPanel, gbc, row++, selectedBillLabel, selectedBillValue);
        addInfoRow(paymentPanel, gbc, row++, amountDueLabel, amountDueValue);

        // Amount paid
        gbc.gridx = 0; gbc.gridy = row;
        paymentPanel.add(amountPaidLabel, gbc);
        gbc.gridx = 1;
        paymentPanel.add(amountPaidField, gbc);
        row++;

        addInfoRow(paymentPanel, gbc, row++, changeLabel, changeValue);

        // Button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(collectPaymentButton);
        buttonPanel.add(printReceiptButton);
        buttonPanel.add(clearButton);

        // Create center container
        JPanel centerContainer = new JPanel(new GridLayout(4, 1, 0, 10));
        centerContainer.setBackground(Color.WHITE);
        centerContainer.add(searchPanel);
        centerContainer.add(customerInfoPanel);
        centerContainer.add(billsPanel);
        centerContainer.add(paymentPanel);

        // Add all panels
        add(headerPanel, BorderLayout.NORTH);
        add(centerContainer, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addInfoRow(JPanel panel, GridBagConstraints gbc, int row, JLabel label, JLabel value) {
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(value, gbc);
    }

    // Getters
    public JTextField getSearchField() { return searchField; }
    public JButton getSearchButton() { return searchButton; }
    public JLabel getCustomerNameValue() { return customerNameValue; }
    public JLabel getMeterCodeValue() { return meterCodeValue; }
    public JLabel getPhoneValue() { return phoneValue; }
    public JTable getBillsTable() { return billsTable; }
    public DefaultTableModel getBillsTableModel() { return billsTableModel; }
    public JLabel getSelectedBillValue() { return selectedBillValue; }
    public JLabel getAmountDueValue() { return amountDueValue; }
    public JTextField getAmountPaidField() { return amountPaidField; }
    public JLabel getChangeValue() { return changeValue; }
    public JButton getCollectPaymentButton() { return collectPaymentButton; }
    public JButton getPrintReceiptButton() { return printReceiptButton; }
    public JButton getClearButton() { return clearButton; }
}
