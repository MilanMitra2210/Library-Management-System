package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvailableReportsPage extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JTextField booksReportField, moviesReportField, membershipsReportField, activeIssuesField, overdueReturnsField, pendingIssueRequestsField;
    private JButton logoutButton;

    public AvailableReportsPage() {
        // Set JFrame properties
        setTitle("Available Reports");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create and set layout manager
        setLayout(new BorderLayout());

        // Create labels
        titleLabel = new JLabel("Available Reports");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create text fields for report types
        booksReportField = new JTextField("Master List of Books");
        moviesReportField = new JTextField("Master List of Movies");
        membershipsReportField = new JTextField("Master List of Memberships");
        activeIssuesField = new JTextField("Active Issues");
        overdueReturnsField = new JTextField("Overdue Returns");
        pendingIssueRequestsField = new JTextField("Pending Issue Requests");

        // Disable text fields (read-only)
        booksReportField.setEditable(false);
        moviesReportField.setEditable(false);
        membershipsReportField.setEditable(false);
        activeIssuesField.setEditable(false);
        overdueReturnsField.setEditable(false);
        pendingIssueRequestsField.setEditable(false);

        // Create a panel for the report fields
        JPanel reportPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        reportPanel.add(booksReportField);
        reportPanel.add(moviesReportField);
        reportPanel.add(membershipsReportField);
        reportPanel.add(activeIssuesField);
        reportPanel.add(overdueReturnsField);
        reportPanel.add(pendingIssueRequestsField);

        // Create a button for logout
        logoutButton = new JButton("Back");

        // Add action listener to the logout button
        logoutButton.addActionListener(this);

        // Create a panel for the logout button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(logoutButton);

        // Create a panel for the title, report fields, and button
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(reportPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame
        add(mainPanel);

        // Set the frame visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            // Handle "Logout" button action
            // Implement logout logic (e.g., return to the login page)
            dispose(); // Close the "Available Reports" page
            new TransactionPage().setVisible(true);
            // Add code to navigate to the login page or perform other logout actions as needed
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AvailableReportsPage availableReportsPage = new AvailableReportsPage();
        });
    }
}

