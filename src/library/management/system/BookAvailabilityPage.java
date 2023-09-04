package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookAvailabilityPage extends JFrame implements ActionListener {
    private JTextField bookNameField, authorField;
    private JButton backButton, searchButton;

    public BookAvailabilityPage() {
        // Set JFrame properties
        setTitle("Book Availability");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create and set layout manager
        setLayout(new BorderLayout());

        // Create labels, text fields, and buttons
        JLabel titleLabel = new JLabel("Book Availability");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel bookNameLabel = new JLabel("Enter Book Name:");
        bookNameField = new JTextField(20);

        JLabel authorLabel = new JLabel("Enter Author:");
        authorField = new JTextField(20);

        backButton = new JButton("Back");
        searchButton = new JButton("Search");

        // Add action listeners to the buttons
        backButton.addActionListener(this);
        searchButton.addActionListener(this);

        // Create a panel for the text fields and buttons
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(bookNameLabel);
        inputPanel.add(bookNameField);
        inputPanel.add(authorLabel);
        inputPanel.add(authorField);
        inputPanel.add(backButton);
        inputPanel.add(searchButton);

        // Create a panel for the "Book Availability" page
        JPanel bookAvailabilityPanel = new JPanel(new BorderLayout());
        bookAvailabilityPanel.add(titleLabel, BorderLayout.NORTH);
        bookAvailabilityPanel.add(inputPanel, BorderLayout.CENTER);

        // Add the "Book Availability" panel to the frame
        add(bookAvailabilityPanel);

        // Set the frame visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            // Handle "Back" button action
            // You can close this page or navigate to another page as needed
            dispose();
            TransactionPage transaction = new TransactionPage();
            transaction.setVisible(true);
        } else if (e.getSource() == searchButton) {
            // Handle "Search" button action
            // Implement your search functionality here
            String bookName = bookNameField.getText();
            String author = authorField.getText();
            
            new AvailableBookPage(bookName, author).setVisible(true);
            dispose();
            // Add code to search for book availability based on the entered criteria
            // Display the search results or perform the desired action
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookAvailabilityPage bookAvailabilityPage = new BookAvailabilityPage();
        });
    }
}

