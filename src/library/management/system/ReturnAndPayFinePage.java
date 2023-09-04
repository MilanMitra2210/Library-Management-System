package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnAndPayFinePage extends JFrame implements ActionListener {
    private JLabel bookNameLabel, authorLabel, serialNumberLabel, issueDateLabel, returnDateLabel, actualReturnDateLabel, fineCalculatedLabel, finePaidLabel, remarksLabel;
    private JComboBox<String> bookNameDropdown;
    private JTextField authorField, serialNumberField, issueDateField, returnDateField, actualReturnDateField, fineCalculatedField, finePaidField;
    private JTextArea remarksTextArea;
    private JButton confirmButton, backButton;

    public ReturnAndPayFinePage() {
        // Set JFrame properties
        setTitle("Return and Pay Fine");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create and set layout manager
        setLayout(new BorderLayout());

        // Create labels
        bookNameLabel = new JLabel("Enter Book Name:");
        authorLabel = new JLabel("Enter Author:");
        serialNumberLabel = new JLabel("Serial Number:");
        issueDateLabel = new JLabel("Issue Date:");
        returnDateLabel = new JLabel("Return Date:");
        actualReturnDateLabel = new JLabel("Actual Return Date:");
        fineCalculatedLabel = new JLabel("Fine Calculated:");
        finePaidLabel = new JLabel("Fine Paid:");
        remarksLabel = new JLabel("Remarks:");

        // Create a dropdown for book names
        String[] bookNames = {"Book 1", "Book 2", "Book 3"}; // Replace with your book names
        bookNameDropdown = new JComboBox<>(bookNames);

        // Create text fields
        authorField = new JTextField(20);
        serialNumberField = new JTextField(10);
        issueDateField = new JTextField(10);
        returnDateField = new JTextField(10);
        actualReturnDateField = new JTextField(10);
        fineCalculatedField = new JTextField(10);
        finePaidField = new JTextField(10);

        // Create a text area for remarks
        remarksTextArea = new JTextArea(4, 20);
        JScrollPane remarksScrollPane = new JScrollPane(remarksTextArea);

        // Create buttons
        confirmButton = new JButton("Confirm");
        backButton = new JButton("Back");

        // Add action listeners to the buttons
        confirmButton.addActionListener(this);
        backButton.addActionListener(this);

        // Create a panel for input components
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(bookNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(bookNameDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(authorLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(authorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(serialNumberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(serialNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(issueDateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        inputPanel.add(issueDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(returnDateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        inputPanel.add(returnDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(actualReturnDateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        inputPanel.add(actualReturnDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        inputPanel.add(fineCalculatedLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        inputPanel.add(fineCalculatedField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        inputPanel.add(finePaidLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        inputPanel.add(finePaidField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        inputPanel.add(remarksLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        inputPanel.add(remarksScrollPane, gbc);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(confirmButton);
        buttonPanel.add(backButton);

        // Add the input panel and button panel to the frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set the frame visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            // Handle "Confirm" button action
            // Implement logic to process the return and payment of fine
            String selectedBook = (String) bookNameDropdown.getSelectedItem();
            String author = authorField.getText();
            String serialNumber = serialNumberField.getText();
            String issueDate = issueDateField.getText();
            String returnDate = returnDateField.getText();
            String actualReturnDate = actualReturnDateField.getText();
            String fineCalculated = fineCalculatedField.getText();
            String finePaid = finePaidField.getText();
            String remarks = remarksTextArea.getText();

            // Perform the return and payment of fine operation or validation
            System.out.println("Book Name: " + selectedBook);
            System.out.println("Author: " + author);
            System.out.println("Serial Number: " + serialNumber);
            System.out.println("Issue Date: " + issueDate);
            System.out.println("Return Date: " + returnDate);
            System.out.println("Actual Return Date: " + actualReturnDate);
            System.out.println("Fine Calculated: " + fineCalculated);
            System.out.println("Fine Paid: " + finePaid);
            System.out.println("Remarks: " + remarks);

            // You can add further logic here, such as updating book status and fine in a database.
        } else if (e.getSource() == backButton) {
            // Handle "Back" button action
            // Close the "Return and Pay Fine" page
        	new TransactionPage().setVisible(true);;
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReturnAndPayFinePage returnAndPayFinePage = new ReturnAndPayFinePage();
        });
    }
}

