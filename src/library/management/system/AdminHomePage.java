package library.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHomePage extends JFrame implements ActionListener {
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton maintenanceButton, reportsButton, transactionButton, logoutButton;

    public AdminHomePage() {
        // Set JFrame properties
        setTitle("Admin Home Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create and set layout manager
        setLayout(new BorderLayout());

        // Create buttons
        maintenanceButton = new JButton("Maintenance");
        reportsButton = new JButton("Reports");
        transactionButton = new JButton("Transaction");
        logoutButton = new JButton("Logout");

        // Add action listeners to the buttons
        maintenanceButton.addActionListener(this);
        reportsButton.addActionListener(this);
        transactionButton.addActionListener(this);
        logoutButton.addActionListener(this);

        // Create table model and table
        tableModel = new DefaultTableModel(new String[]{"Code No From", " Code No To", " Category"}, 0);
        table = new JTable(tableModel);

        // Create a sample table with three rows
        tableModel.addRow(new String[]{"SC(B/M)000001", "SC(B/M)000004", "Science"});
        tableModel.addRow(new String[]{"EC(B/M)000001", "EC(B/M)000004", "Economics"});
        tableModel.addRow(new String[]{"FC(B/M)000001", "FC(B/M)000004", "Fiction"});
        tableModel.addRow(new String[]{"CH(B/M)000001", "CH(B/M)000004", "Children"});
        tableModel.addRow(new String[]{"PD(B/M)000001", "PD(B/M)000004", "Personal Development"});

        // Add table to JScrollPane to enable scrolling
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(maintenanceButton);
        buttonPanel.add(reportsButton);
        buttonPanel.add(transactionButton);

        // Add components to the frame
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(logoutButton, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            // Handle logout action here, e.g., return to the login page
            dispose(); // Close the admin home page
            Login loginApp = new Login();
            loginApp.setVisible(true);
        } else if (e.getSource() == maintenanceButton) {
            // Handle maintenance button action
            // Add code to open the maintenance page
        } else if (e.getSource() == reportsButton) {
            new AvailableReportsPage().setVisible(true);
        } else if (e.getSource() == transactionButton) {
            // Handle transaction button action
            // Add code to open the transaction page
        	new TransactionPage().setVisible(true);
        	dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminHomePage adminHomePage = new AdminHomePage();
            adminHomePage.setVisible(true);
        });
    }
}
