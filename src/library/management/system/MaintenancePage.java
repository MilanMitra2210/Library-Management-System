package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenancePage extends JFrame implements ActionListener {
    private JLabel membershipLabel, booksMoviesLabel, userManagementLabel, houseKeeping;
    private JButton addMembershipButton, updateMembershipButton, addBooksMoviesButton, updateBooksMoviesButton, addUserButton, updateUserButton, backButton;

    public MaintenancePage() {
        setTitle("Housekeeping");
        setSize(700, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create a main panel with a BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        // Create a panel for buttons with a GridBagLayout
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        membershipLabel = new JLabel("Membership:");
        booksMoviesLabel = new JLabel("Books:");
        userManagementLabel = new JLabel("User Management:");
        houseKeeping = new JLabel("Housekeeping");

        addMembershipButton = new JButton("Add");
        updateMembershipButton = new JButton("Update");
        addBooksMoviesButton = new JButton("Add");
        updateBooksMoviesButton = new JButton("Update");
        addUserButton = new JButton("Add");
        updateUserButton = new JButton("Update");
        
        addMembershipButton.addActionListener(this);
        updateMembershipButton.addActionListener(this);
        addBooksMoviesButton.addActionListener(this);
        updateBooksMoviesButton.addActionListener(this);
        addUserButton.addActionListener(this);
        updateUserButton.addActionListener(this);

        // Add labels and buttons to the button panel with GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(membershipLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonPanel.add(addMembershipButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        buttonPanel.add(updateMembershipButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(booksMoviesLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        buttonPanel.add(addBooksMoviesButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        buttonPanel.add(updateBooksMoviesButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanel.add(userManagementLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        buttonPanel.add(addUserButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        buttonPanel.add(updateUserButton, gbc);

        // Create a panel for the back button with a FlowLayout
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        bottomPanel.add(backButton);

        // Add the button panel to the main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add the bottom panel to the main panel
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame
        add(mainPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMembershipButton) {
            System.out.println("Add Membership clicked");
        } else if (e.getSource() == updateMembershipButton) {
            System.out.println("Update Membership clicked");
        } else if (e.getSource() == addBooksMoviesButton) {
            System.out.println("Add Books clicked");
            new BookInventoryApp().setVisible(true);;
        	dispose();
        } else if (e.getSource() == updateBooksMoviesButton) {
            System.out.println("Update Books/Movies clicked");
        } else if (e.getSource() == addUserButton) {
            System.out.println("Add User clicked");
        	
        } else if (e.getSource() == updateUserButton) {
            System.out.println("Update User clicked");
        } else if (e.getSource() == backButton) {
            // Handle the back button action, for example, closing this window
        	new AdminHomePage().setVisible(true);
            this.dispose(); // Close the current window
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MaintenancePage maintenancePage = new MaintenancePage();
        });
    }
}
