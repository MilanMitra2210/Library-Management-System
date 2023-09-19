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
        setTitle("Available Reports");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        setLayout(new BorderLayout());

        titleLabel = new JLabel("Available Reports");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        booksReportField = new JTextField("Master List of Books");
        moviesReportField = new JTextField("Master List of Movies");
        membershipsReportField = new JTextField("Master List of Memberships");
        activeIssuesField = new JTextField("Active Issues");
        overdueReturnsField = new JTextField("Overdue Returns");
        pendingIssueRequestsField = new JTextField("Pending Issue Requests");

        booksReportField.setEditable(false);
        moviesReportField.setEditable(false);
        membershipsReportField.setEditable(false);
        activeIssuesField.setEditable(false);
        overdueReturnsField.setEditable(false);
        pendingIssueRequestsField.setEditable(false);

        JPanel reportPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        reportPanel.add(booksReportField);
        reportPanel.add(moviesReportField);
        reportPanel.add(membershipsReportField);
        reportPanel.add(activeIssuesField);
        reportPanel.add(overdueReturnsField);
        reportPanel.add(pendingIssueRequestsField);

        logoutButton = new JButton("Back");

        logoutButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(logoutButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(reportPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            
            new UserHomePage().setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AvailableReportsPage availableReportsPage = new AvailableReportsPage();
        });
    }
}

