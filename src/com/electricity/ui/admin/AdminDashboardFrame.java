package com.electricity.ui.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Admin Dashboard Frame - Main dashboard for administrators
 * No logic implementation - UI only
 */
public class AdminDashboardFrame extends JFrame {

    // UI Components
    private JPanel mainPanel;
    private JPanel sidebarPanel;
    private JPanel contentPanel;
    private JPanel headerPanel;

    // Sidebar buttons
    private JButton dashboardButton;
    private JButton viewAllBillsButton;
    private JButton reportsButton;
    private JButton statisticsButton;
    private JButton approveCustomersButton;
    private JButton manageUsersButton;
    private JButton manageComplaintsButton;
    private JButton settingsButton;
    private JButton logoutButton;

    // Header components
    private JLabel welcomeLabel;
    private JLabel dateTimeLabel;
    private JLabel roleLabel;

    // Dashboard content cards
    private JPanel cardsPanel;
    private JPanel totalRevenueCard;
    private JPanel totalCustomersCard;
    private JPanel pendingApprovalsCard;
    private JPanel activeComplaintsCard;

    public AdminDashboardFrame() {
        initializeComponents();
        setupLayout();
        setupFrame();
        addButtonListeners();
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
        viewAllBillsButton = createSidebarButton("View All Bills");
        reportsButton = createSidebarButton("Reports");
        statisticsButton = createSidebarButton("Statistics");
        approveCustomersButton = createSidebarButton("Approve Customers");
        manageUsersButton = createSidebarButton("Manage Users");
        manageComplaintsButton = createSidebarButton("Manage Complaints");
        settingsButton = createSidebarButton("Settings");
        logoutButton = createSidebarButton("Logout");

        // Initialize header labels
        welcomeLabel = new JLabel("Welcome, Administrator");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(41, 128, 185));

        dateTimeLabel = new JLabel("Date: 24-11-2025");
        dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        roleLabel = new JLabel("Role: System Administrator");
        roleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        roleLabel.setForeground(new Color(52, 73, 94));

        // Initialize dashboard cards
        totalRevenueCard = createDashboardCard(
            "Total Revenue (This Month)",
            "187,500 EGP",
            "From 1,100 payments",
            new Color(46, 204, 113)
        );

        totalCustomersCard = createDashboardCard(
            "Total Active Customers",
            "1,200",
            "Across all regions",
            new Color(52, 152, 219)
        );

        pendingApprovalsCard = createDashboardCard(
            "Pending Approvals",
            "12",
            "New customer requests",
            new Color(243, 156, 18)
        );

        activeComplaintsCard = createDashboardCard(
            "Active Complaints",
            "25",
            "Require attention",
            new Color(231, 76, 60)
        );
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(44, 62, 80));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setPreferredSize(new Dimension(240, 45));
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
        sidebarPanel.setBackground(new Color(44, 62, 80));
        sidebarPanel.setPreferredSize(new Dimension(260, 600));
        sidebarPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Add logo/title to sidebar
        JLabel logoLabel = new JLabel("EBS Admin");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebarPanel.add(logoLabel);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Add buttons to sidebar
        sidebarPanel.add(dashboardButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(viewAllBillsButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(reportsButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(statisticsButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(approveCustomersButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(manageUsersButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(manageComplaintsButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        sidebarPanel.add(settingsButton);
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
        rightHeader.add(roleLabel);

        headerPanel.add(leftHeader, BorderLayout.WEST);
        headerPanel.add(rightHeader, BorderLayout.EAST);

        // Cards panel setup
        cardsPanel.setBackground(Color.WHITE);
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        cardsPanel.add(totalRevenueCard);
        cardsPanel.add(totalCustomersCard);
        cardsPanel.add(pendingApprovalsCard);
        cardsPanel.add(activeComplaintsCard);

        // Content panel setup
        contentPanel.setBackground(Color.WHITE);
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(cardsPanel, BorderLayout.CENTER);

        // Main panel setup
        mainPanel.add(sidebarPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
    }

    private void addButtonListeners() {
        approveCustomersButton.addActionListener(e -> showPanel(new ApproveCustomersPanel()));
        manageUsersButton.addActionListener(e -> showPanel(new ManageUsersPanel()));
        reportsButton.addActionListener(e -> showPanel(new ReportsPanel()));
        dashboardButton.addActionListener(e -> resetToDefaultView());
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
        setTitle("Admin Dashboard - Electricity Billing System");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
    }

    // Getters for components
    public JButton getDashboardButton() { return dashboardButton; }
    public JButton getViewAllBillsButton() { return viewAllBillsButton; }
    public JButton getReportsButton() { return reportsButton; }
    public JButton getStatisticsButton() { return statisticsButton; }
    public JButton getApproveCustomersButton() { return approveCustomersButton; }
    public JButton getManageUsersButton() { return manageUsersButton; }
    public JButton getManageComplaintsButton() { return manageComplaintsButton; }
    public JButton getSettingsButton() { return settingsButton; }
    public JButton getLogoutButton() { return logoutButton; }
    public JPanel getContentPanel() { return contentPanel; }
    public JLabel getWelcomeLabel() { return welcomeLabel; }
}
