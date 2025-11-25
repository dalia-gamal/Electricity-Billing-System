package com.electricity.ui.customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * View Bills Panel - For customers to view their bills
 * No logic implementation - UI only
 */
public class ViewBillsPanel extends JPanel {

    // UI Components
    private JPanel headerPanel;
    private JPanel filterPanel;
    private JPanel tablePanel;
    private JPanel buttonPanel;

    private JLabel titleLabel;
    private JLabel filterLabel;
    private JLabel monthLabel;
    private JLabel yearLabel;
    private JLabel statusLabel;

    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;
    private JComboBox<String> statusComboBox;

    private JTable billsTable;
    private JScrollPane tableScrollPane;
    private DefaultTableModel tableModel;

    private JButton searchButton;
    private JButton viewDetailsButton;
    private JButton printBillButton;
    private JButton payBillButton;
    private JButton refreshButton;

    public ViewBillsPanel() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        // Initialize panels
        headerPanel = new JPanel();
        filterPanel = new JPanel();
        tablePanel = new JPanel();
        buttonPanel = new JPanel();

        // Initialize labels
        titleLabel = new JLabel("My Bills");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(41, 128, 185));

        filterLabel = new JLabel("Filter Bills:");
        filterLabel.setFont(new Font("Arial", Font.BOLD, 14));

        monthLabel = new JLabel("Month:");
        monthLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        yearLabel = new JLabel("Year:");
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        statusLabel = new JLabel("Status:");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        // Initialize combo boxes
        String[] months = {"All", "January", "February", "March", "April", "May", "June",
                          "July", "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setFont(new Font("Arial", Font.PLAIN, 13));

        String[] years = {"All", "2025", "2024", "2023", "2022"};
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setFont(new Font("Arial", Font.PLAIN, 13));

        String[] statuses = {"All", "Paid", "Unpaid", "Overdue"};
        statusComboBox = new JComboBox<>(statuses);
        statusComboBox.setFont(new Font("Arial", Font.PLAIN, 13));

        // Initialize table
        String[] columnNames = {
            "Bill ID", "Month/Year", "Consumption (kWh)",
            "Amount (EGP)", "Status", "Issue Date", "Due Date"
        };

        Object[][] sampleData = {
            {"BILL-2025-001", "January 2025", "180", "270.00", "Unpaid", "03-01-2025", "03-02-2025"},
            {"BILL-2024-012", "December 2024", "170", "250.00", "Paid", "03-12-2024", "03-01-2025"},
            {"BILL-2024-011", "November 2024", "165", "245.00", "Paid", "03-11-2024", "03-12-2024"},
            {"BILL-2024-010", "October 2024", "175", "260.00", "Paid", "03-10-2024", "03-11-2024"},
            {"BILL-2024-009", "September 2024", "190", "280.00", "Paid", "03-09-2024", "03-10-2024"}
        };

        tableModel = new DefaultTableModel(sampleData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        billsTable = new JTable(tableModel);
        billsTable.setFont(new Font("Arial", Font.PLAIN, 12));
        billsTable.setRowHeight(30);
        billsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        billsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        billsTable.getTableHeader().setBackground(new Color(52, 73, 94));
        billsTable.getTableHeader().setForeground(Color.WHITE);
        billsTable.setGridColor(new Color(189, 195, 199));
        billsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Set column widths
        billsTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        billsTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        billsTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        billsTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        billsTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        billsTable.getColumnModel().getColumn(5).setPreferredWidth(120);
        billsTable.getColumnModel().getColumn(6).setPreferredWidth(120);

        tableScrollPane = new JScrollPane(billsTable);
        tableScrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        // Initialize buttons
        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.BOLD, 13));
        searchButton.setBackground(new Color(52, 152, 219));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setBorderPainted(false);
        searchButton.setPreferredSize(new Dimension(100, 32));
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        viewDetailsButton = new JButton("View Details");
        viewDetailsButton.setFont(new Font("Arial", Font.PLAIN, 13));
        viewDetailsButton.setBackground(new Color(52, 152, 219));
        viewDetailsButton.setForeground(Color.WHITE);
        viewDetailsButton.setFocusPainted(false);
        viewDetailsButton.setBorderPainted(false);
        viewDetailsButton.setPreferredSize(new Dimension(120, 32));
        viewDetailsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        printBillButton = new JButton("Print Bill");
        printBillButton.setFont(new Font("Arial", Font.PLAIN, 13));
        printBillButton.setBackground(new Color(149, 165, 166));
        printBillButton.setForeground(Color.WHITE);
        printBillButton.setFocusPainted(false);
        printBillButton.setBorderPainted(false);
        printBillButton.setPreferredSize(new Dimension(120, 32));
        printBillButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        payBillButton = new JButton("Pay Bill");
        payBillButton.setFont(new Font("Arial", Font.BOLD, 13));
        payBillButton.setBackground(new Color(46, 204, 113));
        payBillButton.setForeground(Color.WHITE);
        payBillButton.setFocusPainted(false);
        payBillButton.setBorderPainted(false);
        payBillButton.setPreferredSize(new Dimension(120, 32));
        payBillButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        refreshButton = new JButton("Refresh");
        refreshButton.setFont(new Font("Arial", Font.PLAIN, 13));
        refreshButton.setBackground(new Color(243, 156, 18));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setFocusPainted(false);
        refreshButton.setBorderPainted(false);
        refreshButton.setPreferredSize(new Dimension(100, 32));
        refreshButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void setupLayout() {
        setLayout(new BorderLayout(0, 15));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

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

        filterPanel.add(filterLabel);
        filterPanel.add(monthLabel);
        filterPanel.add(monthComboBox);
        filterPanel.add(yearLabel);
        filterPanel.add(yearComboBox);
        filterPanel.add(statusLabel);
        filterPanel.add(statusComboBox);
        filterPanel.add(searchButton);
        filterPanel.add(refreshButton);

        // Table panel
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(Color.WHITE);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        // Button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(viewDetailsButton);
        buttonPanel.add(printBillButton);
        buttonPanel.add(payBillButton);

        // Add all panels
        JPanel topPanel = new JPanel(new BorderLayout(0, 10));
        topPanel.setBackground(Color.WHITE);
        topPanel.add(headerPanel, BorderLayout.NORTH);
        topPanel.add(filterPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Getters
    public JComboBox<String> getMonthComboBox() { return monthComboBox; }
    public JComboBox<String> getYearComboBox() { return yearComboBox; }
    public JComboBox<String> getStatusComboBox() { return statusComboBox; }
    public JTable getBillsTable() { return billsTable; }
    public DefaultTableModel getTableModel() { return tableModel; }
    public JButton getSearchButton() { return searchButton; }
    public JButton getViewDetailsButton() { return viewDetailsButton; }
    public JButton getPrintBillButton() { return printBillButton; }
    public JButton getPayBillButton() { return payBillButton; }
    public JButton getRefreshButton() { return refreshButton; }
}
