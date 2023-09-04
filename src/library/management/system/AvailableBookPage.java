package library.management.system;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AvailableBookPage extends JFrame implements ActionListener {
    private JButton backButton, issueButton;
    private JTable bookTable;
    private DefaultTableModel tableModel;

    public AvailableBookPage(String bookname, String author) {
        // Set JFrame properties
        setTitle("Available Books");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create and set layout manager
        setLayout(new BorderLayout());

        // Create labels, text fields, and buttons
        JLabel titleLabel = new JLabel("Available Books");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        backButton = new JButton("Back");
        issueButton = new JButton("Issue Selected Books");

        // Add action listeners to the buttons
        backButton.addActionListener(this);
        issueButton.addActionListener(this);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);
        buttonPanel.add(issueButton);

        // Create a panel for the "Available Books" page
        JPanel availableBooksPanel = new JPanel(new BorderLayout());
        availableBooksPanel.add(titleLabel, BorderLayout.NORTH);

        // Create a table with a custom model for displaying book details
        String[] columnNames = {"Book Name", "Author", "Serial Number", "Available", "Select"};
        tableModel = new DefaultTableModel(columnNames, 0);
        bookTable = new JTable(tableModel);
        bookTable.getColumnModel().getColumn(4).setCellRenderer(new RadioButtonRenderer());
        bookTable.getColumnModel().getColumn(4).setCellEditor(new RadioButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(bookTable);
        availableBooksPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the button panel to the "Available Books" panel
        availableBooksPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the "Available Books" panel to the frame
        add(availableBooksPanel);
        
        addSampleBookData(bookname, author);

        // Set the frame visible
        setVisible(true);
    }
    private void addSampleBookData(String bookname, String author) {
        // Add sample book data to the table (replace with your data source)
    	String sql = "Select * from books Where BookName = '" + bookname + "' AND Author='" + author
        +"' AND Quantity > 0;";
    	ArrayList<String[]> sampleData = new ArrayList<>();
    	try {
			Conn c = new Conn();
			ResultSet rs = c.stmt.executeQuery(sql);
//			System.out.println(rs);
			while(rs.next()) {
				String[] data = new String[4];
				data[0] = rs.getString("SerialNumber");
				data[1] = rs.getString("BookName");
				data[2] = rs.getString("Author");
				data[3] = rs.getString("Quantity");
				sampleData.add(data);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        

        for (String[] row : sampleData) {
            tableModel.addRow(row);
        }
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
        	
            // Handle "Back" button action
            // You can close this page or navigate to another page as needed
            dispose();
            new BookAvailabilityPage().setVisible(true);// Close the "Available Books" page
        } else if (e.getSource() == issueButton) {
            // Handle "Issue Selected Books" button action
            // Implement logic to process selected books for issuing
            // You can access the selected rows in the table and perform actions
            int rowCount = tableModel.getRowCount();
            for (int row = 0; row < rowCount; row++) {
                Boolean isSelected = (Boolean) tableModel.getValueAt(row, 4);
                if (isSelected) {
                    // Book is selected for issuing, implement the logic here
                    String bookName = (String) tableModel.getValueAt(row, 0);
                    String author = (String) tableModel.getValueAt(row, 1);
                    String serialNumber = (String) tableModel.getValueAt(row, 2);
                    // Perform the issuing operation
                    System.out.println("Issuing Book: " + bookName + " by " + author + " (Serial Number: " + serialNumber + ")");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AvailableBookPage availableBooksPage = new AvailableBookPage("xyz", "abx");
        });
    }

    private class RadioButtonRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value == null)
                return null;
            return (Component) value;
        }
    }

    private class RadioButtonEditor extends DefaultCellEditor implements ActionListener {
        private JRadioButton button;

        public RadioButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value == null)
                return null;
            button = (JRadioButton) value;
            button.addActionListener(this);
            return (Component) value;
        }

        @Override
        public Object getCellEditorValue() {
            button.removeActionListener(this);
            return button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            super.fireEditingStopped();
        }
    }
}

