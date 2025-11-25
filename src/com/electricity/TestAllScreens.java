package com.electricity;

import com.electricity.ui.auth.LoginFrame;
import com.electricity.ui.auth.RegisterFrame;
import com.electricity.ui.customer.*;
import com.electricity.ui.operator.*;
import com.electricity.ui.admin.*;

import javax.swing.*;
import java.awt.*;

/**
 * Test Frame - For testing and viewing all screens
 */
public class TestAllScreens extends JFrame {

    private JPanel mainPanel;
    private JLabel titleLabel;

    public TestAllScreens() {
        initializeComponents();
        setupLayout();
        setupFrame();
    }

    private void initializeComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 20, 20));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        titleLabel = new JLabel("Test All Screens", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(41, 128, 185));

        // Authentication Screens
        addScreenButton("Login Screen", () -> showFrame(new LoginFrame()));
        addScreenButton("Register Screen", () -> showFrame(new RegisterFrame()));

        // Customer Screens
        addScreenButton("Customer Dashboard", () -> showFrame(new CustomerDashboardFrame()));
        addScreenButton("Enter Reading", () -> showPanel(new EnterReadingPanel()));
        addScreenButton("View Bills", () -> showPanel(new ViewBillsPanel()));
        addScreenButton("Pay Bill", () -> showPanel(new PayBillPanel()));
        addScreenButton("Complaints", () -> showPanel(new ComplaintsPanel()));

        // Operator Screens
        addScreenButton("Operator Dashboard", () -> showFrame(new OperatorDashboardFrame()));
        addScreenButton("Review Readings", () -> showPanel(new ReviewReadingsPanel()));
        addScreenButton("Collect Payment", () -> showPanel(new CollectPaymentPanel()));

        // Admin Screens
        addScreenButton("Admin Dashboard", () -> showFrame(new AdminDashboardFrame()));
        addScreenButton("Approve Customers", () -> showPanel(new ApproveCustomersPanel()));
        addScreenButton("Manage Users", () -> showPanel(new ManageUsersPanel()));
        addScreenButton("Reports", () -> showPanel(new ReportsPanel()));
    }

    private void addScreenButton(String buttonText, Runnable action) {
        JButton button = new JButton(buttonText);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(52, 152, 219));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(250, 70));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addActionListener(e -> action.run());

        mainPanel.add(button);
    }

    private void showFrame(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void showPanel(JPanel panel) {
        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void setupLayout() {
        setLayout(new BorderLayout(0, 20));

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(titleLabel);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Close button
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setBackground(new Color(231, 76, 60));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setPreferredSize(new Dimension(150, 40));
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(e -> System.exit(0));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.add(closeButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void setupFrame() {
        setTitle("Test All Screens");
        setSize(800, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            TestAllScreens testFrame = new TestAllScreens();
            testFrame.setVisible(true);
        });
    }
}
