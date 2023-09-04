package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenancePage extends JFrame implements ActionListener {
    private JLabel membershipLabel, booksMoviesLabel, userManagementLabel, houseKeeping;
    private JButton addMembershipButton, updateMembershipButton, addBooksMoviesButton, updateBooksMoviesButton, addUserButton, updateUserButton;

    public MaintenancePage() {
        setTitle("Housekeeping");
        setSize(700, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        setLayout(new GridLayout(4, 2, 10, 10));

        membershipLabel = new JLabel("Membership:");
        booksMoviesLabel = new JLabel("Books/Movies:");
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

        add(membershipLabel);
        add(addMembershipButton);
        add(updateMembershipButton);
        add(booksMoviesLabel);
        add(addBooksMoviesButton);
        add(updateBooksMoviesButton);
        add(userManagementLabel);
        add(addUserButton);
        add(updateUserButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMembershipButton) {
        	
            System.out.println("Add Membership clicked");
        } else if (e.getSource() == updateMembershipButton) {
        	
            System.out.println("Update Membership clicked");
        } else if (e.getSource() == addBooksMoviesButton) {

        	System.out.println("Add Books/Movies clicked");
        } else if (e.getSource() == updateBooksMoviesButton) {

        	System.out.println("Update Books/Movies clicked");
        } else if (e.getSource() == addUserButton) {

        	System.out.println("Add User clicked");
        } else if (e.getSource() == updateUserButton) {

        	System.out.println("Update User clicked");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MaintenancePage maintenancePage = new MaintenancePage();
        });
    }
}

