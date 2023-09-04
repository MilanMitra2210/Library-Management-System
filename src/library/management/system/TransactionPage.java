package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionPage extends JFrame implements ActionListener {
    private JButton isBookAvailableButton, issueBookButton, returnBookButton, payFineButton, logoutButton, homePageButton;

    public TransactionPage() {
        // Set JFrame properties
        setTitle("Transaction Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create and set layout manager
        setLayout(new BorderLayout());

        // Create buttons
        isBookAvailableButton = new JButton("Is Book Available");
        issueBookButton = new JButton("Issue Book");
        returnBookButton = new JButton("Return Book");
        payFineButton = new JButton("Pay Fine");
        logoutButton = new JButton("Logout");
        homePageButton = new JButton("Home Page");

        // Add action listeners to the buttons
        isBookAvailableButton.addActionListener(this);
        issueBookButton.addActionListener(this);
        returnBookButton.addActionListener(this);
        payFineButton.addActionListener(this);
        logoutButton.addActionListener(this);
        homePageButton.addActionListener(this);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
//        buttonPanel.add(homePageButton);
        buttonPanel.add(isBookAvailableButton);
        buttonPanel.add(issueBookButton);
        buttonPanel.add(returnBookButton);
        buttonPanel.add(payFineButton);
//        buttonPanel.add(logoutButton);

        // Add components to the frame
        add(buttonPanel, BorderLayout.NORTH);
        add(logoutButton, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            // Handle logout action here, e.g., return to the login page
            dispose(); // Close the transaction page
            Login loginApp = new Login();
            loginApp.setVisible(true);
        } else if (e.getSource() == homePageButton) {
            // Handle home page button action
            // Add code to return to the admin home page
            dispose(); // Close the transaction page
            AdminHomePage adminHomePage = new AdminHomePage();
            adminHomePage.setVisible(true);
        } else if (e.getSource() == isBookAvailableButton){
        	dispose();
        	new BookAvailabilityPage().setVisible(true);
        } else if(e.getSource() == issueBookButton) {
        	dispose();
        	new BookIssuePage().setVisible(true);
        }else if( e.getSource() == returnBookButton) {
        	dispose();
        	new ReturnBook().setVisible(true);
        }else if( e.getSource() == payFineButton) {
        	new ReturnAndPayFinePage().setVisible(true);
        	dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TransactionPage transactionPage = new TransactionPage();
            transactionPage.setVisible(true);
        });
    }
}
