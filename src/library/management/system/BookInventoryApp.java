package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookInventoryApp extends JFrame {
    private JPanel addPanel;
    private JTextField bookNameTextField;
    private JTextField authorTextField;
    private JTextField quantityTextField;

    public BookInventoryApp() {
        super("Book Inventory"); // Set the frame title

        addPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel bookNameLabel = new JLabel("Book Name:");
        JLabel authorLabel = new JLabel("Author:");
        JLabel quantityLabel = new JLabel("Quantity:");

        bookNameTextField = new JTextField();
        authorTextField = new JTextField();
        quantityTextField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton backButton = new JButton("Back");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve values from text fields
                String bookName = bookNameTextField.getText();
                String author = authorTextField.getText();
                String quantityStr = quantityTextField.getText();

                // Perform validation and processing here
                try {
                    int quantity = Integer.parseInt(quantityStr);

                    // You can use the bookName, author, and quantity variables as needed
                    // For example, you can store them in a data structure or database.
                    Conn connection = new Conn();
                    String sql = "INSERT INTO `books`(`BookName`, `Author`, `Quantity`) VALUES ('"+ bookName
                    		+"','"+author +"','"+quantity + "')";
                    try {
        				Conn c = new Conn();
        				c.stmt.executeUpdate(sql);
        				
        			} catch (Exception ae) {
        				ae.printStackTrace();
        			}
                    // Clear the input fields after adding
                    bookNameTextField.setText("");
                    authorTextField.setText("");
                    quantityTextField.setText("");

                    // Display a message or take further action
                    JOptionPane.showMessageDialog(BookInventoryApp.this, "Book added successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BookInventoryApp.this, "Please enter a valid quantity.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to navigate back to the main menu or previous page
                // For now, let's just close the "Add Page" when the back button is clicked.
            	new MaintenancePage().setVisible(true);
                dispose();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        addPanel.add(bookNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(bookNameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        addPanel.add(authorLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(authorTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        addPanel.add(quantityLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(quantityTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        addPanel.add(backButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        addPanel.add(addButton, gbc);

        add(addPanel); // Add the panel to the JFrame

        pack();

        // Make the JFrame wider
        setSize(400, getHeight());

        // Center the JFrame on the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BookInventoryApp();
            }
        });
    }
}
