package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionPage extends JFrame implements ActionListener {
    private JButton isBookAvailableButton, issueBookButton, returnBookButton, payFineButton, logoutButton, homePageButton;

    public TransactionPage() {
        setTitle("Transaction Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        isBookAvailableButton = new JButton("Is Book Available");
        issueBookButton = new JButton("Issue Book");
        returnBookButton = new JButton("Return Book");
        payFineButton = new JButton("Pay Fine");
        logoutButton = new JButton("Logout");
        homePageButton = new JButton("Home Page");

        isBookAvailableButton.addActionListener(this);
        issueBookButton.addActionListener(this);
        returnBookButton.addActionListener(this);
        payFineButton.addActionListener(this);
        logoutButton.addActionListener(this);
        homePageButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(isBookAvailableButton);
        buttonPanel.add(issueBookButton);
        buttonPanel.add(returnBookButton);
        buttonPanel.add(payFineButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(logoutButton, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            dispose(); 
            Login loginApp = new Login();
            loginApp.setVisible(true);
        } else if (e.getSource() == homePageButton) {
            dispose();
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
