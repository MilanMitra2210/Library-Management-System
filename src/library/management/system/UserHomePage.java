package library.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserHomePage extends JFrame implements ActionListener {
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton maintenanceButton,  transactionButton, logoutButton;
    private JLabel productDetailsLabel;

    public UserHomePage() {
        setTitle("Home Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        setLayout(new BorderLayout());

        maintenanceButton = new JButton("Reports");
//        reportsButton = new JButton("Reports");
        transactionButton = new JButton("Transaction");
        logoutButton = new JButton("Logout");

        maintenanceButton.addActionListener(this);
        transactionButton.addActionListener(this);
        logoutButton.addActionListener(this);

        tableModel = new DefaultTableModel(new String[]{"Code No From", " Code No To", " Category"}, 0);
        table = new JTable(tableModel);

        tableModel.addRow(new String[]{"SC(B/M)000001", "SC(B/M)000004", "Science"});
        tableModel.addRow(new String[]{"EC(B/M)000001", "EC(B/M)000004", "Economics"});
        tableModel.addRow(new String[]{"FC(B/M)000001", "FC(B/M)000004", "Fiction"});
        tableModel.addRow(new String[]{"CH(B/M)000001", "CH(B/M)000004", "Children"});
        tableModel.addRow(new String[]{"PD(B/M)000001", "PD(B/M)000004", "Personal Development"});
        
        productDetailsLabel = new JLabel("Product Details");
        productDetailsLabel.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel labelPanel = new JPanel();
        labelPanel.add(productDetailsLabel);
        
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(maintenanceButton);
        buttonPanel.add(transactionButton);

        add(labelPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(logoutButton, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            dispose();
            Login loginApp = new Login();
            loginApp.setVisible(true);
        } else if (e.getSource() == maintenanceButton) {
        	new AvailableReportsPage().setVisible(true);
        	dispose();
        } else if (e.getSource() == transactionButton) {
        	new TransactionPage().setVisible(true);
        	dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserHomePage adminHomePage = new UserHomePage();
            adminHomePage.setVisible(true);
        });
    }
}
