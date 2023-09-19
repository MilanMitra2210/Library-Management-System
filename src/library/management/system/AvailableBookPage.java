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
        setTitle("Available Books");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Available Books");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        backButton = new JButton("Back");
        issueButton = new JButton("Issue Selected Books");

        backButton.addActionListener(this);
        issueButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);
//        buttonPanel.add(issueButton);

        JPanel availableBooksPanel = new JPanel(new BorderLayout());
        availableBooksPanel.add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = {"Book Name", "Author", "Serial Number", "Available", "Select"};
        tableModel = new DefaultTableModel(columnNames, 0);
        bookTable = new JTable(tableModel);
        bookTable.getColumnModel().getColumn(4).setCellRenderer(new RadioButtonRenderer());
        bookTable.getColumnModel().getColumn(4).setCellEditor(new RadioButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(bookTable);
        availableBooksPanel.add(scrollPane, BorderLayout.CENTER);

        availableBooksPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(availableBooksPanel);
        
        addSampleBookData(bookname, author);

        setVisible(true);
    }
    private void addSampleBookData(String bookname, String author) {
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
        	
            dispose();
            new BookAvailabilityPage().setVisible(true);// Close the "Available Books" page
        } else if (e.getSource() == issueButton) {
            int rowCount = tableModel.getRowCount();
            for (int row = 0; row < rowCount; row++) {
                Boolean isSelected = (Boolean) tableModel.getValueAt(row, 3);
                if (isSelected) {
                    String bookName = (String) tableModel.getValueAt(row, 0);
                    String author = (String) tableModel.getValueAt(row, 1);
                    String serialNumber = (String) tableModel.getValueAt(row, 2);
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

