package library.management.system;

import javax.swing.*;

import com.mysql.cj.xdevapi.Statement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookIssuePage extends JFrame implements ActionListener {
    private JLabel bookNameLabel, authorLabel, issueDateLabel, returnDateLabel, remarksLabel;
    private JComboBox<String> bookNameDropdown;
    private JTextField authorField, issueDateField, returnDateField;
    private JTextArea remarksTextArea;
    private JButton issueButton, cancelButton;

    public BookIssuePage() {
        // Set JFrame properties
        setTitle("Book Issue");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create and set layout manager
        setLayout(new BorderLayout());

        // Create labels
        bookNameLabel = new JLabel("Enter Book Name:");
        authorLabel = new JLabel("Enter Author:");
        issueDateLabel = new JLabel("Issue Date:");
        returnDateLabel = new JLabel("Return Date:");
        remarksLabel = new JLabel("Remarks:");

        // Create a dropdown for book names
        
        ArrayList<String> books = new ArrayList<>();
        try {
			Conn c = new Conn();
			ResultSet rs = c.stmt.executeQuery
					("SELECT BookName FROM books WHERE Quantity > 0;");
			while(rs.next()) {
				books.add(rs.getString("BookName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        String[] bookNames = new String[books.size()];
        for(int i = 0; i < books.size();i++) {
        	bookNames[i] = books.get(i);
        }
        bookNameDropdown = new JComboBox<>(bookNames);

        // Create text fields
        authorField = new JTextField(20);
        issueDateField = new JTextField(10);
        returnDateField = new JTextField(10);

        // Create a text area for remarks
        remarksTextArea = new JTextArea(4, 20);
        JScrollPane remarksScrollPane = new JScrollPane(remarksTextArea);

        // Create buttons
        issueButton = new JButton("Issue");
        cancelButton = new JButton("Back");

        // Add action listeners to the buttons
        issueButton.addActionListener(this);
        cancelButton.addActionListener(this);

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
        inputPanel.add(issueDateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(issueDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(returnDateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        inputPanel.add(returnDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        inputPanel.add(remarksLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        inputPanel.add(remarksTextArea, gbc);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(issueButton);
        buttonPanel.add(cancelButton);

        // Add the input panel and button panel to the frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set the frame visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == issueButton) {
            // Handle "Issue" button action
            // Implement logic to process the book issue
            String selectedBook = (String) bookNameDropdown.getSelectedItem();
            String author = authorField.getText();
            String issueDate = issueDateField.getText();
            String returnDate = returnDateField.getText();
            String remarks = remarksTextArea.getText();

            // Perform the book issuing operation or validation
            System.out.println("Book Name: " + selectedBook);
            System.out.println("Author: " + author);
            System.out.println("Issue Date: " + issueDate);
            System.out.println("Return Date: " + returnDate);
            System.out.println("Remarks: " + remarks);
            
            
            Conn connection = new Conn();
            String sql = "INSERT INTO booksissued (BookName, Author, Issuedate, returndate, remark) VALUES('" + selectedBook +
					"', '"+ author + "' ,'" + issueDate + "', '" + returnDate +"' , '"+remarks +"');";
            String update = "UPDATE books SET Quantity= Quantity -1 WHERE BookName='" + selectedBook + "'";
            try {
				Conn c = new Conn();
				c.stmt.executeUpdate(sql);
				c.stmt.executeUpdate(update);
				
				JOptionPane.showMessageDialog(null, "Book Issued Successfully");
//				new Dashboard(username).setVisible(true);
			} catch (Exception ae) {
				ae.printStackTrace();
			}
            
            
        } else if (e.getSource() == cancelButton) {
            // Handle "Cancel" button action
            // Close the "Book Issue" page
        	new TransactionPage().setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookIssuePage bookIssuePage = new BookIssuePage();
        });
    }
}

