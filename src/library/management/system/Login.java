package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {
    private JLabel titleLabel, usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signUpButton;

    public Login() {
        setTitle("Login Page");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        setLayout(new BorderLayout());

        titleLabel = new JLabel("Login Form");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
//        panel.add(new JLabel());
        panel.add(signUpButton);
        panel.add(loginButton);

        add(titleLabel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
        	String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            if (username.equals("admin") && String.valueOf(password).equals("admin")) {
                new AdminHomePage().setVisible(true);
                dispose();
            } else {
            	String sql = "Select * from user Where name = '" +
            username + "' AND password='" + String.valueOf(password)
                +"';";
                
            	try {
        			Conn c = new Conn();
        			ResultSet rs = c.stmt.executeQuery(sql);
//        			System.out.println(rs);
        			if(rs.next()) {
        				JOptionPane.showMessageDialog(null, "Logined Successfully");
        				new UserHomePage().setVisible(true);
        				dispose();
        			}else {
        				JOptionPane.showMessageDialog(null, "Wrong Username or password");
        			}
        		} catch (Exception e1) {
        			e1.printStackTrace();
        		}
            }

            usernameField.setText("");
            passwordField.setText("");
        }else if(e.getSource() == signUpButton) {
        	String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            // Check if the fields are not empty
            if (username.isEmpty() || String.valueOf(password).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in both username and password fields.");
            } else {
                // Perform sign-up logic here
                String sql = "INSERT INTO user (name, password) VALUES ('" + username + "', '" + String.valueOf(password) + "');";
                try {
                    Conn c = new Conn();
                    int result = c.stmt.executeUpdate(sql);
                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "User registered successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "User registration failed");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login loginApp = new Login();
            loginApp.setVisible(true);
        });
    }
}
