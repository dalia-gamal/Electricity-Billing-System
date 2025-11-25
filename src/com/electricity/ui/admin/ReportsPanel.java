package com.electricity.ui.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Reports Panel - For admins to view and generate reports
 * No logic implementation - UI only
 */
public class ReportsPanel extends JPanel {

    // UI Components
    private JPanel headerPanel;
    private JPanel filterPanel;
    private JPanel reportTypePanel;
    private JPanel summaryPanel;
    private JPanel buttonPanel;

    private JLabel titleLabel;

    // Filter components
    private JLabel regionLabel;
    private JComboBox<String> regionComboBox;
    private JLabel monthLabel;
    private JComboBox<String> monthComboBox;
    private JLabel yearLabel;
    private JComboBox<String> yearComboBox;
    private JButton generateButton;

    // Report type
    private JLabel reportTypeLabel;
    private ButtonGroup reportTypeGroup;
    private JRadioButton billsReportRadio;
    private JRadioButton paymentsReportRadio;
    private JRadioButton consumptionReportRadio;
    private JRadioButton customersReportRadio;

    // Summary components
    private JLabel summaryTitleLabel;
    private JLabel totalBillsLabel;
    private JLabel totalBillsValue;
    private JLabel totalRevenueLabel;
    private JLabel totalRevenueValue;
    private JLabel paidBillsLabel;
    private JLabel paidBillsValue;
    private JLabel unpaidBillsLabel;
    private JLabel unpaidBillsValue;
    private JLabel totalConsumptionLabel;
    private JLabel totalConsumptionValue;
    private JLabel averageConsumptionLabel;
    private JLabel averageConsumptionValue;

    // Action buttons
    private JButton exportPDFButton;
    private JButton exportExcelButton;
    private JButton printButton;

    public ReportsPanel() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        // Initialize panels
        headerPanel = new JPanel();
        filterPanel = new JPanel();
        reportTypePanel = new JPanel();
        summaryPanel = new JPanel();
        buttonPanel = new JPanel();

        // Header
        titleLabel = new JLabel("Reports & Analytics");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(41, 128, 185));

        // Filter components
        Font labelFont = new Font("Arial", Font.PLAIN, 14);

        regionLabel = new JLabel("Region:");
        regionLabel.setFont(labelFont);

        String[] regions = {"All Regions", "Cairo - Nasr City", "Cairo - Maadi", "Cairo - Zamalek",
                           "Giza - Dokki", "Giza - Mohandessin", "Alexandria - Miami"};
        regionComboBox = new JComboBox<>(regions);
        regionComboBox.setFont(new Font("Arial", Font.PLAIN, 13));

        monthLabel = new JLabel("Month:");
        monthLabel.setFont(labelFont);

        String[] months = {"All", "January", "February", "March", "April", "May", "June",
                          "July", "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setFont(new Font("Arial", Font.PLAIN, 13));

        yearLabel = new JLabel("Year:");
        yearLabel.setFont(labelFont);

        String[] years = {"2025", "2024", "2023", "2022"};
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setFont(new Font("Arial", Font.PLAIN, 13));

        generateButton = new JButton("Generate Report");
        generateButton.setFont(new Font("Arial", Font.BOLD, 14));
        generateButton.setBackground(new Color(52, 152, 219));
        generateButton.setForeground(Color.WHITE);
        generateButton.setFocusPainted(false);
        generateButton.setBorderPainted(false);
        generateButton.setPreferredSize(new Dimension(150, 35));
        generateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Report type
        reportTypeLabel = new JLabel("Select Report Type:");
        reportTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));

        billsReportRadio = new JRadioButton("Bills Report (All bills with details)");
        billsReportRadio.setFont(new Font("Arial", Font.PLAIN, 13));
        billsReportRadio.setBackground(Color.WHITE);
        billsReportRadio.setSelected(true);

        paymentsReportRadio = new JRadioButton("Payments Report (Collection details)");
        paymentsReportRadio.setFont(new Font("Arial", Font.PLAIN, 13));
        paymentsReportRadio.setBackground(Color.WHITE);

        consumptionReportRadio = new JRadioButton("Consumption Statistics (Usage analysis)");
        consumptionReportRadio.setFont(new Font("Arial", Font.PLAIN, 13));
        consumptionReportRadio.setBackground(Color.WHITE);

        customersReportRadio = new JRadioButton("Customers Report (Active/Inactive)");
        customersReportRadio.setFont(new Font("Arial", Font.PLAIN, 13));
        customersReportRadio.setBackground(Color.WHITE);

        reportTypeGroup = new ButtonGroup();
        reportTypeGroup.add(billsReportRadio);
        reportTypeGroup.add(paymentsReportRadio);
        reportTypeGroup.add(consumptionReportRadio);
        reportTypeGroup.add(customersReportRadio);

        // Summary components
        summaryTitleLabel = new JLabel("Report Summary");
        summaryTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        summaryTitleLabel.setForeground(new Color(52, 73, 94));

        Font summaryLabelFont = new Font("Arial", Font.PLAIN, 14);
        Font summaryValueFont = new Font("Arial", Font.BOLD, 16);

        totalBillsLabel = new JLabel("Total Bills:");
        totalBillsLabel.setFont(summaryLabelFont);
        totalBillsValue = new JLabel("1,250");
        totalBillsValue.setFont(summaryValueFont);
        totalBillsValue.setForeground(new Color(52, 152, 219));

        totalRevenueLabel = new JLabel("Total Revenue:");
        totalRevenueLabel.setFont(summaryLabelFont);
        totalRevenueValue = new JLabel("187,500 EGP");
        totalRevenueValue.setFont(new Font("Arial", Font.BOLD, 18));
        totalRevenueValue.setForeground(new Color(46, 204, 113));

        paidBillsLabel = new JLabel("Paid Bills:");
        paidBillsLabel.setFont(summaryLabelFont);
        paidBillsValue = new JLabel("1,100 (88%)");
        paidBillsValue.setFont(summaryValueFont);
        paidBillsValue.setForeground(new Color(46, 204, 113));

        unpaidBillsLabel = new JLabel("Unpaid Bills:");
        unpaidBillsLabel.setFont(summaryLabelFont);
        unpaidBillsValue = new JLabel("150 (12%)");
        unpaidBillsValue.setFont(summaryValueFont);
        unpaidBillsValue.setForeground(new Color(231, 76, 60));

        totalConsumptionLabel = new JLabel("Total Consumption:");
        totalConsumptionLabel.setFont(summaryLabelFont);
        totalConsumptionValue = new JLabel("310,000 kWh");
        totalConsumptionValue.setFont(summaryValueFont);
        totalConsumptionValue.setForeground(new Color(155, 89, 182));

        averageConsumptionLabel = new JLabel("Average per Customer:");
        averageConsumptionLabel.setFont(summaryLabelFont);
        averageConsumptionValue = new JLabel("180 kWh");
        averageConsumptionValue.setFont(summaryValueFont);
        averageConsumptionValue.setForeground(new Color(243, 156, 18));

        // Action buttons
        exportPDFButton = new JButton("Export as PDF");
        exportPDFButton.setFont(new Font("Arial", Font.BOLD, 14));
        exportPDFButton.setBackground(new Color(231, 76, 60));
        exportPDFButton.setForeground(Color.WHITE);
        exportPDFButton.setFocusPainted(false);
        exportPDFButton.setBorderPainted(false);
        exportPDFButton.setPreferredSize(new Dimension(150, 38));
        exportPDFButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        exportExcelButton = new JButton("Export as Excel");
        exportExcelButton.setFont(new Font("Arial", Font.BOLD, 14));
        exportExcelButton.setBackground(new Color(46, 204, 113));
        exportExcelButton.setForeground(Color.WHITE);
        exportExcelButton.setFocusPainted(false);
        exportExcelButton.setBorderPainted(false);
        exportExcelButton.setPreferredSize(new Dimension(150, 38));
        exportExcelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        printButton = new JButton("Print Report");
        printButton.setFont(new Font("Arial", Font.PLAIN, 14));
        printButton.setBackground(new Color(149, 165, 166));
        printButton.setForeground(Color.WHITE);
        printButton.setFocusPainted(false);
        printButton.setBorderPainted(false);
        printButton.setPreferredSize(new Dimension(130, 38));
        printButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void setupLayout() {
        setLayout(new BorderLayout(0, 20));
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
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199)),
                "Report Filters",
                0, 0,
                new Font("Arial", Font.BOLD, 13),
                new Color(52, 73, 94)
            ),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        filterPanel.add(regionLabel);
        filterPanel.add(regionComboBox);
        filterPanel.add(monthLabel);
        filterPanel.add(monthComboBox);
        filterPanel.add(yearLabel);
        filterPanel.add(yearComboBox);
        filterPanel.add(generateButton);

        // Report type panel
        reportTypePanel.setLayout(new BoxLayout(reportTypePanel, BoxLayout.Y_AXIS));
        reportTypePanel.setBackground(Color.WHITE);
        reportTypePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199)),
                "Report Type",
                0, 0,
                new Font("Arial", Font.BOLD, 13),
                new Color(52, 73, 94)
            ),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));

        reportTypePanel.add(billsReportRadio);
        reportTypePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        reportTypePanel.add(paymentsReportRadio);
        reportTypePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        reportTypePanel.add(consumptionReportRadio);
        reportTypePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        reportTypePanel.add(customersReportRadio);

        // Summary panel
        summaryPanel.setLayout(new GridBagLayout());
        summaryPanel.setBackground(Color.WHITE);
        summaryPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199)),
                "Report Summary",
                0, 0,
                new Font("Arial", Font.BOLD, 13),
                new Color(52, 73, 94)
            ),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;
        addSummaryRow(summaryPanel, gbc, row++, totalBillsLabel, totalBillsValue);
        addSummaryRow(summaryPanel, gbc, row++, totalRevenueLabel, totalRevenueValue);
        addSummaryRow(summaryPanel, gbc, row++, paidBillsLabel, paidBillsValue);
        addSummaryRow(summaryPanel, gbc, row++, unpaidBillsLabel, unpaidBillsValue);
        addSummaryRow(summaryPanel, gbc, row++, totalConsumptionLabel, totalConsumptionValue);
        addSummaryRow(summaryPanel, gbc, row++, averageConsumptionLabel, averageConsumptionValue);

        // Button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(exportPDFButton);
        buttonPanel.add(exportExcelButton);
        buttonPanel.add(printButton);

        // Create center container
        JPanel centerContainer = new JPanel(new GridLayout(3, 1, 0, 15));
        centerContainer.setBackground(Color.WHITE);
        centerContainer.add(filterPanel);
        centerContainer.add(reportTypePanel);
        centerContainer.add(summaryPanel);

        // Add all panels
        add(headerPanel, BorderLayout.NORTH);
        add(centerContainer, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addSummaryRow(JPanel panel, GridBagConstraints gbc, int row, JLabel label, JLabel value) {
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(value, gbc);
    }

    // Getters
    public JComboBox<String> getRegionComboBox() { return regionComboBox; }
    public JComboBox<String> getMonthComboBox() { return monthComboBox; }
    public JComboBox<String> getYearComboBox() { return yearComboBox; }
    public JButton getGenerateButton() { return generateButton; }
    public JRadioButton getBillsReportRadio() { return billsReportRadio; }
    public JRadioButton getPaymentsReportRadio() { return paymentsReportRadio; }
    public JRadioButton getConsumptionReportRadio() { return consumptionReportRadio; }
    public JRadioButton getCustomersReportRadio() { return customersReportRadio; }
    public JButton getExportPDFButton() { return exportPDFButton; }
    public JButton getExportExcelButton() { return exportExcelButton; }
    public JButton getPrintButton() { return printButton; }
    public JLabel getTotalBillsValue() { return totalBillsValue; }
    public JLabel getTotalRevenueValue() { return totalRevenueValue; }
    public JLabel getPaidBillsValue() { return paidBillsValue; }
    public JLabel getUnpaidBillsValue() { return unpaidBillsValue; }
    public JLabel getTotalConsumptionValue() { return totalConsumptionValue; }
    public JLabel getAverageConsumptionValue() { return averageConsumptionValue; }
}
