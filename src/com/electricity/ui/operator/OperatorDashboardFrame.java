package com.electricity.ui.operator;

import javax.swing.*;
import java.awt.*;

/**
 * Operator Dashboard Frame - Main dashboard for operators
 * No logic implementation - UI only
 */
public class OperatorDashboardFrame extends JFrame {

    // UI Components
    private JPanel mainPanel;
    private JPanel sidebarPanel;
    private JPanel contentPanel;
    private JPanel headerPanel;

    // Sidebar buttons
    private JButton dashboardButton;
    private JButton reviewReadingsButton;
    private JButton collectPaymentButton;
    private JButton printBillButton;
    private JButton viewBillsButton;
    private JButton manageTariffButton;
    private JButton manageMeterButton;
    private JButton profileButton;
    private JButton logoutButton;

    // Header components
    private JLabel welcomeLabel;
    private JLabel dateTimeLabel;
    private JLabel regionLabel;

    // Dashboard content cards
    private JPanel cardsPanel;
    private JPanel pendingReadingsCard;
    private JPanel todayCollectionCard;
    private JPanel totalMetersCard;
    private JPanel complaintsCard;

    public OperatorDashboardFrame() {
        initializeComponents();
        setupLayout();
        addButtonListeners();
        setupFrame();
    }

    private void initializeComponents() {
        // Initialize panels
        mainPanel = new JPanel(new BorderLayout());
        sidebarPanel = new JPanel();
        contentPanel = new JPanel(new BorderLayout());
        headerPanel = new JPanel(new BorderLayout());
        cardsPanel = new JPanel(new GridLayout(2, 2, 20, 20));

        // Initialize sidebar buttons
        dashboardButton = createSidebarButton("Dashboard");
        reviewReadingsButton = createSidebarButton("Review Readings");
        collectPaymentButton = createSidebarButton("Collect Payment");
        printBillButton = createSidebarButton("Print Bill");
        viewBillsButton = createSidebarButton("View Bills");
        manageTariffButton = createSidebarButton("Manage Tariff");
        manageMeterButton = createSidebarButton("Manage Meters");
        profileButton = createSidebarButton("Profile");
        logoutButton = createSidebarButton("Logout");

        // Initialize header labels
        welcomeLabel = new JLabel("Welcome, Operator Name");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(41, 128, 185));

        dateTimeLabel = new JLabel("Date: 24-11-2025");
        dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        regionLabel = new JLabel("Region: Cairo - Nasr City");
        regionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        regionLabel.setForeground(new Color(52, 73, 94));

        // Initialize dashboard cards
        pendingReadingsCard = createDashboardCard(
            "Pending Readings",
            "15",
            "Waiting for approval",
            new Color(231, 76, 60)
        );

        todayCollectionCard = createDashboardCard(
            "Today's Collection",
            "12,500 EGP",
            "From 25 payments",
            new Color(46, 204, 113)
        );

        totalMetersCard = createDashboardCard(
            "Total Meters",
            "350",
            "Active in region",
            new Color(52, 152, 219)
        );

        complaintsCard = createDashboardCard(
            "Active Complaints",
            "8",
            "Require attention",
            new Color(243, 156, 18)
        );
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(52, 73, 94));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setPreferredSize(new Dimension(220, 45));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setMargin(new Insets(10, 20, 10, 20));
        return button;
    }

    private JPanel createDashboardCard(String title, String mainValue, String subValue, Color accentColor) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        titleLabel.setForeground(Color.GRAY);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel valueLabel = new JLabel(mainValue);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 28));
        valueLabel.setForeground(accentColor);
        valueLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subLabel = new JLabel(subValue);
        subLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        subLabel.setForeground(Color.GRAY);
        subLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(titleLabel);
        card.add(Box.createRigidArea(new Dimension(0, 10)));
        card.add(valueLabel);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(subLabel);

        return card;
    }

    private void setupLayout() {
        // Sidebar setup
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(new Color(52, 73, 94));
        sidebarPanel.setPreferredSize(new Dimension(240, 600));
        sidebarPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Add logo/title to sidebar
        JLabel logoLabel = new JLabel("EBS Operator");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 22));
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebarPanel.add(logoLabel);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Add buttons to sidebar
        sidebarPanel.add(dashboardButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(reviewReadingsButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(collectPaymentButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(printBillButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(viewBillsButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(manageTariffButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(manageMeterButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(profileButton);
        sidebarPanel.add(Box.createVerticalGlue());
        sidebarPanel.add(logoutButton);

        // Header setup
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(236, 240, 241)),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        JPanel leftHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftHeader.setBackground(Color.WHITE);
        leftHeader.add(welcomeLabel);

        JPanel rightHeader = new JPanel(new GridLayout(2, 1));
        rightHeader.setBackground(Color.WHITE);
        rightHeader.add(dateTimeLabel);
        rightHeader.add(regionLabel);

        headerPanel.add(leftHeader, BorderLayout.WEST);
        headerPanel.add(rightHeader, BorderLayout.EAST);

        // Cards panel setup
        cardsPanel.setBackground(Color.WHITE);
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        cardsPanel.add(pendingReadingsCard);
        cardsPanel.add(todayCollectionCard);
        cardsPanel.add(totalMetersCard);
        cardsPanel.add(complaintsCard);

        // Content panel setup
        contentPanel.setBackground(Color.WHITE);
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(cardsPanel, BorderLayout.CENTER);

        // Main panel setup
        mainPanel.add(sidebarPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
    }

    private void addButtonListeners() {
        reviewReadingsButton.addActionListener(e -> showPanel(new ReviewReadingsPanel()));
        collectPaymentButton.addActionListener(e -> showPanel(new CollectPaymentPanel()));
        dashboardButton.addActionListener(e -> resetToDefaultView());
        logoutButton.addActionListener(e -> dispose());
    }

    private void showPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void resetToDefaultView() {
        contentPanel.removeAll();
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(cardsPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void setupFrame() {
        setTitle("Operator Dashboard - Electricity Billing System");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1150, 700);
        setLocationRelativeTo(null);
    }

    // Getters for components
    public JButton getDashboardButton() { return dashboardButton; }
    public JButton getReviewReadingsButton() { return reviewReadingsButton; }
    public JButton getCollectPaymentButton() { return collectPaymentButton; }
    public JButton getPrintBillButton() { return printBillButton; }
    public JButton getViewBillsButton() { return viewBillsButton; }
    public JButton getManageTariffButton() { return manageTariffButton; }
    public JButton getManageMeterButton() { return manageMeterButton; }
    public JButton getProfileButton() { return profileButton; }
    public JButton getLogoutButton() { return logoutButton; }
    public JPanel getContentPanel() { return contentPanel; }
    public JLabel getWelcomeLabel() { return welcomeLabel; }
    public JLabel getRegionLabel() { return regionLabel; }
}
