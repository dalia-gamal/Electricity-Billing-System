package com.electricity.ui.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Manage Users Panel - For admins to manage system users
 * No logic implementation - UI only
 */
public class ManageUsersPanel extends JPanel {

    // UI Components
    private JPanel headerPanel;
    private JPanel filterPanel;
    private JPanel tablePanel;
    private JPanel buttonPanel;

    private JLabel titleLabel;
    private JLabel roleFilterLabel;
    private JComboBox<String> roleFilterComboBox;
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton refreshButton;

    // Table components
    private JTable usersTable;
    private JScrollPane tableScrollPane;
    private DefaultTableModel tableModel;

    // Action buttons
    private JButton addUserButton;
    private JButton editUserButton;
    private JButton deleteUserButton;
    private JButton viewDetailsButton;

    public ManageUsersPanel() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        // Initialize panels
        headerPanel = new JPanel();
        filterPanel = new JPanel();
        tablePanel = new JPanel();
        buttonPanel = new JPanel();

        // Initialize header
        titleLabel = new JLabel("Manage System Users");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(41, 128, 185));

        // Filter components
        roleFilterLabel = new JLabel("Role:");
        roleFilterLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        String[] roles = {"All Users", "Operators", "Admins", "Customers"};
        roleFilterComboBox = new JComboBox<>(roles);
        roleFilterComboBox.setFont(new Font("Arial", Font.PLAIN, 13));

        searchLabel = new JLabel("Search:");
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        searchField = new JTextField(20);
        searchField.setFont(new Font("Arial", Font.PLAIN, 13));

        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.PLAIN, 13));
        searchButton.setBackground(new Color(52, 152, 219));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setBorderPainted(false);
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        refreshButton = new JButton("Refresh");
        refreshButton.setFont(new Font("Arial", Font.PLAIN, 13));
        refreshButton.setBackground(new Color(46, 204, 113));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setFocusPainted(false);
        refreshButton.setBorderPainted(false);
        refreshButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Initialize table
        String[] columnNames = {
            "User ID", "Username", "Full Name", "Email", "Phone", "Role", "Region", "Status"
        };

        Object[][] sampleData = {
            {"OP-001", "ahmed.op", "Ahmed Hassan", "ahmed@ebs.com", "01012345678", "Operator", "Nasr City", "Active"},
            {"OP-002", "sara.op", "Sara Ali", "sara@ebs.com", "01123456789", "Operator", "Maadi", "Active"},
            {"AD-001", "khaled.admin", "Dr. Khaled", "khaled@ebs.com", "01234567890", "Admin", "All", "Active"},
            {"OP-003", "omar.op", "Omar Mostafa", "omar@ebs.com", "01098765432", "Operator", "Zamalek", "Inactive"},
            {"AD-002", "fatima.admin", "Fatima Khaled", "fatima@ebs.com", "01187654321", "Admin", "All", "Active"}
        };

        tableModel = new DefaultTableModel(sampleData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        usersTable = new JTable(tableModel);
        usersTable.setFont(new Font("Arial", Font.PLAIN, 12));
        usersTable.setRowHeight(30);
        usersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        usersTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        usersTable.getTableHeader().setBackground(new Color(52, 73, 94));
        usersTable.getTableHeader().setForeground(Color.WHITE);
        usersTable.setGridColor(new Color(189, 195, 199));
        usersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Set column widths
        usersTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        usersTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        usersTable.getColumnModel().getColumn(2).setPreferredWidth(140);
        usersTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        usersTable.getColumnModel().getColumn(4).setPreferredWidth(110);
        usersTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        usersTable.getColumnModel().getColumn(6).setPreferredWidth(110);
        usersTable.getColumnModel().getColumn(7).setPreferredWidth(90);

        tableScrollPane = new JScrollPane(usersTable);
        tableScrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        // Action buttons
        addUserButton = new JButton("+ Add User");
        addUserButton.setFont(new Font("Arial", Font.BOLD, 14));
        addUserButton.setBackground(new Color(46, 204, 113));
        addUserButton.setForeground(Color.WHITE);
        addUserButton.setFocusPainted(false);
        addUserButton.setBorderPainted(false);
        addUserButton.setPreferredSize(new Dimension(130, 35));
        addUserButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        editUserButton = new JButton("Edit User");
        editUserButton.setFont(new Font("Arial", Font.PLAIN, 13));
        editUserButton.setBackground(new Color(243, 156, 18));
        editUserButton.setForeground(Color.WHITE);
        editUserButton.setFocusPainted(false);
        editUserButton.setBorderPainted(false);
        editUserButton.setPreferredSize(new Dimension(120, 35));
        editUserButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        deleteUserButton = new JButton("Delete User");
        deleteUserButton.setFont(new Font("Arial", Font.PLAIN, 13));
        deleteUserButton.setBackground(new Color(231, 76, 60));
        deleteUserButton.setForeground(Color.WHITE);
        deleteUserButton.setFocusPainted(false);
        deleteUserButton.setBorderPainted(false);
        deleteUserButton.setPreferredSize(new Dimension(120, 35));
        deleteUserButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        viewDetailsButton = new JButton("View Details");
        viewDetailsButton.setFont(new Font("Arial", Font.PLAIN, 13));
        viewDetailsButton.setBackground(new Color(52, 152, 219));
        viewDetailsButton.setForeground(Color.WHITE);
        viewDetailsButton.setFocusPainted(false);
        viewDetailsButton.setBorderPainted(false);
        viewDetailsButton.setPreferredSize(new Dimension(120, 35));
        viewDetailsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

        filterPanel.add(roleFilterLabel);
        filterPanel.add(roleFilterComboBox);
        filterPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        filterPanel.add(searchLabel);
        filterPanel.add(searchField);
        filterPanel.add(searchButton);
        filterPanel.add(refreshButton);

        // Table panel
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(Color.WHITE);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        // Button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(addUserButton);
        buttonPanel.add(editUserButton);
        buttonPanel.add(deleteUserButton);
        buttonPanel.add(viewDetailsButton);

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
    public JComboBox<String> getRoleFilterComboBox() { return roleFilterComboBox; }
    public JTextField getSearchField() { return searchField; }
    public JButton getSearchButton() { return searchButton; }
    public JButton getRefreshButton() { return refreshButton; }
    public JTable getUsersTable() { return usersTable; }
    public DefaultTableModel getTableModel() { return tableModel; }
    public JButton getAddUserButton() { return addUserButton; }
    public JButton getEditUserButton() { return editUserButton; }
    public JButton getDeleteUserButton() { return deleteUserButton; }
    public JButton getViewDetailsButton() { return viewDetailsButton; }
}
