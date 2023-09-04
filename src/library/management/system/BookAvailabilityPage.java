package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookAvailabilityPage extends JFrame implements ActionListener {
    private JTextField bookNameField, authorField;
    private JButton backButton, searchButton;

    public BookAvailabilityPage() {
        setTitle("Book Availability");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Book Availability");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel bookNameLabel = new JLabel("Enter Book Name:");
        bookNameField = new JTextField(20);

        JLabel authorLabel = new JLabel("Enter Author:");
        authorField = new JTextField(20);

        backButton = new JButton("Back");
        searchButton = new JButton("Search");

        backButton.addActionListener(this);
        searchButton.addActionListener(this);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(bookNameLabel);
        inputPanel.add(bookNameField);
        inputPanel.add(authorLabel);
        inputPanel.add(authorField);
        inputPanel.add(backButton);
        inputPanel.add(searchButton);

        JPanel bookAvailabilityPanel = new JPanel(new BorderLayout());
        bookAvailabilityPanel.add(titleLabel, BorderLayout.NORTH);
        bookAvailabilityPanel.add(inputPanel, BorderLayout.CENTER);

        add(bookAvailabilityPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            TransactionPage transaction = new TransactionPage();
            transaction.setVisible(true);
        } else if (e.getSource() == searchButton) {
            String bookName = bookNameField.getText();
            String author = authorField.getText();
            
            new AvailableBookPage(bookName, author).setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookAvailabilityPage bookAvailabilityPage = new BookAvailabilityPage();
        });
    }
}

