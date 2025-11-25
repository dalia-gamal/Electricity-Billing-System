package com.electricity.ui.customer;

import javax.swing.*;
import java.awt.*;

/**
 * Pay Bill Panel - For customers to pay their bills
 * No logic implementation - UI only
 */
public class PayBillPanel extends JPanel {

    // UI Components
    private JPanel headerPanel;
    private JPanel billSelectionPanel;
    private JPanel billDetailsPanel;
    private JPanel paymentMethodPanel;
    private JPanel buttonPanel;

    private JLabel titleLabel;
    private JLabel selectBillLabel;
    private JComboBox<String> billComboBox;

    // Bill details labels
    private JLabel billIdLabel;
    private JLabel billIdValue;
    private JLabel monthLabel;
    private JLabel monthValue;
    private JLabel consumptionLabel;
    private JLabel consumptionValue;
    private JLabel baseAmountLabel;
    private JLabel baseAmountValue;
    private JLabel lateFeeLabel;
    private JLabel lateFeeValue;
    private JLabel totalAmountLabel;
    private JLabel totalAmountValue;
    private JLabel dueDateLabel;
    private JLabel dueDateValue;
    private JLabel statusLabel;
    private JLabel statusValue;

    // Payment method
    private JLabel paymentMethodLabel;
    private ButtonGroup paymentMethodGroup;
    private JRadioButton onlinePaymentRadio;
    private JRadioButton cashPaymentRadio;
    private JRadioButton cardPaymentRadio;

    // Action buttons
    private JButton loadBillButton;
    private JButton payNowButton;
    private JButton cancelButton;

    public PayBillPanel() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        // Initialize panels
        headerPanel = new JPanel();
        billSelectionPanel = new JPanel();
        billDetailsPanel = new JPanel();
        paymentMethodPanel = new JPanel();
        buttonPanel = new JPanel();

        // Initialize header
        titleLabel = new JLabel("Pay Bill");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(41, 128, 185));

        // Bill selection
        selectBillLabel = new JLabel("Select Bill:");
        selectBillLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        String[] bills = {"BILL-2025-001 - January 2025 - 270.00 EGP (Unpaid)",
                         "BILL-2024-012 - December 2024 - 250.00 EGP (Paid)",
                         "BILL-2024-011 - November 2024 - 245.00 EGP (Paid)"};
        billComboBox = new JComboBox<>(bills);
        billComboBox.setFont(new Font("Arial", Font.PLAIN, 13));
        billComboBox.setPreferredSize(new Dimension(400, 30));

        loadBillButton = new JButton("Load Bill");
        loadBillButton.setFont(new Font("Arial", Font.PLAIN, 13));
        loadBillButton.setBackground(new Color(52, 152, 219));
        loadBillButton.setForeground(Color.WHITE);
        loadBillButton.setFocusPainted(false);
        loadBillButton.setBorderPainted(false);
        loadBillButton.setPreferredSize(new Dimension(100, 30));
        loadBillButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Bill details labels
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        Font valueFont = new Font("Arial", Font.BOLD, 14);

        billIdLabel = new JLabel("Bill ID:");
        billIdLabel.setFont(labelFont);
        billIdValue = new JLabel("BILL-2025-001");
        billIdValue.setFont(valueFont);

        monthLabel = new JLabel("Billing Month:");
        monthLabel.setFont(labelFont);
        monthValue = new JLabel("January 2025");
        monthValue.setFont(valueFont);

        consumptionLabel = new JLabel("Consumption:");
        consumptionLabel.setFont(labelFont);
        consumptionValue = new JLabel("180 kWh");
        consumptionValue.setFont(valueFont);

        baseAmountLabel = new JLabel("Base Amount:");
        baseAmountLabel.setFont(labelFont);
        baseAmountValue = new JLabel("270.00 EGP");
        baseAmountValue.setFont(valueFont);

        lateFeeLabel = new JLabel("Late Fee:");
        lateFeeLabel.setFont(labelFont);
        lateFeeValue = new JLabel("0.00 EGP");
        lateFeeValue.setFont(valueFont);
        lateFeeValue.setForeground(Color.RED);

        totalAmountLabel = new JLabel("Total Amount:");
        totalAmountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalAmountValue = new JLabel("270.00 EGP");
        totalAmountValue.setFont(new Font("Arial", Font.BOLD, 18));
        totalAmountValue.setForeground(new Color(46, 204, 113));

        dueDateLabel = new JLabel("Due Date:");
        dueDateLabel.setFont(labelFont);
        dueDateValue = new JLabel("03-02-2025");
        dueDateValue.setFont(valueFont);

        statusLabel = new JLabel("Status:");
        statusLabel.setFont(labelFont);
        statusValue = new JLabel("Unpaid");
        statusValue.setFont(valueFont);
        statusValue.setForeground(Color.RED);

        // Payment method
        paymentMethodLabel = new JLabel("Select Payment Method:");
        paymentMethodLabel.setFont(new Font("Arial", Font.BOLD, 14));

        onlinePaymentRadio = new JRadioButton("Online Payment (Fake Payment)");
        onlinePaymentRadio.setFont(new Font("Arial", Font.PLAIN, 13));
        onlinePaymentRadio.setBackground(Color.WHITE);
        onlinePaymentRadio.setSelected(true);

        cashPaymentRadio = new JRadioButton("Cash Payment (At Operator Office)");
        cashPaymentRadio.setFont(new Font("Arial", Font.PLAIN, 13));
        cashPaymentRadio.setBackground(Color.WHITE);

        cardPaymentRadio = new JRadioButton("Credit/Debit Card (Fake Payment)");
        cardPaymentRadio.setFont(new Font("Arial", Font.PLAIN, 13));
        cardPaymentRadio.setBackground(Color.WHITE);

        paymentMethodGroup = new ButtonGroup();
        paymentMethodGroup.add(onlinePaymentRadio);
        paymentMethodGroup.add(cashPaymentRadio);
        paymentMethodGroup.add(cardPaymentRadio);

        // Action buttons
        payNowButton = new JButton("Pay Now");
        payNowButton.setFont(new Font("Arial", Font.BOLD, 15));
        payNowButton.setBackground(new Color(46, 204, 113));
        payNowButton.setForeground(Color.WHITE);
        payNowButton.setFocusPainted(false);
        payNowButton.setBorderPainted(false);
        payNowButton.setPreferredSize(new Dimension(150, 40));
        payNowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 14));
        cancelButton.setBackground(new Color(149, 165, 166));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.setBorderPainted(false);
        cancelButton.setPreferredSize(new Dimension(120, 40));
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void setupLayout() {
        setLayout(new BorderLayout(0, 20));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Header panel
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(titleLabel);

        // Bill selection panel
        billSelectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        billSelectionPanel.setBackground(Color.WHITE);
        billSelectionPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199)),
                "Select Bill to Pay",
                0, 0,
                new Font("Arial", Font.BOLD, 13),
                new Color(52, 73, 94)
            ),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        billSelectionPanel.add(selectBillLabel);
        billSelectionPanel.add(billComboBox);
        billSelectionPanel.add(loadBillButton);

        // Bill details panel
        billDetailsPanel.setLayout(new GridBagLayout());
        billDetailsPanel.setBackground(Color.WHITE);
        billDetailsPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199)),
                "Bill Details",
                0, 0,
                new Font("Arial", Font.BOLD, 13),
                new Color(52, 73, 94)
            ),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Add bill details
        int row = 0;
        addDetailRow(billDetailsPanel, gbc, row++, billIdLabel, billIdValue);
        addDetailRow(billDetailsPanel, gbc, row++, monthLabel, monthValue);
        addDetailRow(billDetailsPanel, gbc, row++, consumptionLabel, consumptionValue);
        addDetailRow(billDetailsPanel, gbc, row++, baseAmountLabel, baseAmountValue);
        addDetailRow(billDetailsPanel, gbc, row++, lateFeeLabel, lateFeeValue);

        // Separator
        gbc.gridx = 0; gbc.gridy = row++; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        billDetailsPanel.add(new JSeparator(), gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        addDetailRow(billDetailsPanel, gbc, row++, totalAmountLabel, totalAmountValue);
        addDetailRow(billDetailsPanel, gbc, row++, dueDateLabel, dueDateValue);
        addDetailRow(billDetailsPanel, gbc, row++, statusLabel, statusValue);

        // Payment method panel
        paymentMethodPanel.setLayout(new BoxLayout(paymentMethodPanel, BoxLayout.Y_AXIS));
        paymentMethodPanel.setBackground(Color.WHITE);
        paymentMethodPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199)),
                "Payment Method",
                0, 0,
                new Font("Arial", Font.BOLD, 13),
                new Color(52, 73, 94)
            ),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));

        paymentMethodPanel.add(onlinePaymentRadio);
        paymentMethodPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        paymentMethodPanel.add(cashPaymentRadio);
        paymentMethodPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        paymentMethodPanel.add(cardPaymentRadio);

        // Button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(payNowButton);
        buttonPanel.add(cancelButton);

        // Create center container
        JPanel centerContainer = new JPanel(new GridLayout(3, 1, 0, 15));
        centerContainer.setBackground(Color.WHITE);
        centerContainer.add(billSelectionPanel);
        centerContainer.add(billDetailsPanel);
        centerContainer.add(paymentMethodPanel);

        // Add all panels
        add(headerPanel, BorderLayout.NORTH);
        add(centerContainer, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addDetailRow(JPanel panel, GridBagConstraints gbc, int row, JLabel label, JLabel value) {
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(value, gbc);
    }

    // Getters
    public JComboBox<String> getBillComboBox() { return billComboBox; }
    public JButton getLoadBillButton() { return loadBillButton; }
    public JButton getPayNowButton() { return payNowButton; }
    public JButton getCancelButton() { return cancelButton; }
    public JRadioButton getOnlinePaymentRadio() { return onlinePaymentRadio; }
    public JRadioButton getCashPaymentRadio() { return cashPaymentRadio; }
    public JRadioButton getCardPaymentRadio() { return cardPaymentRadio; }
    public JLabel getBillIdValue() { return billIdValue; }
    public JLabel getMonthValue() { return monthValue; }
    public JLabel getConsumptionValue() { return consumptionValue; }
    public JLabel getBaseAmountValue() { return baseAmountValue; }
    public JLabel getLateFeeValue() { return lateFeeValue; }
    public JLabel getTotalAmountValue() { return totalAmountValue; }
    public JLabel getDueDateValue() { return dueDateValue; }
    public JLabel getStatusValue() { return statusValue; }
}
