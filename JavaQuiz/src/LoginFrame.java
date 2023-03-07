import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 
public class LoginFrame extends JFrame implements ActionListener {
 

	private static final long serialVersionUID = 1L;
	Container login = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
 
 
    public LoginFrame() { // pozitionarea componentelor si adaugarea acestora in frame
    	
 
        login.setLayout(null);

        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
 
        login.add(userLabel);
        login.add(passwordLabel);
        login.add(userTextField);
        login.add(passwordField);
        login.add(showPassword);
        login.add(loginButton);
        login.add(resetButton);

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);

    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        // setam username-ul si parola si verificam daca datele scrise de user sunt aceleasi
        if (e.getSource() == loginButton) {
            String userText = userTextField.getText();
            String pwdText = new String(passwordField.getPassword());
            	if(userText.equals("Universitate") && pwdText.equals("craiova")){
                JOptionPane.showMessageDialog(this, "Login Successful"); // message dialog in cazul in care userul si parola sunt corecte
                MainMenu newFrame = new MainMenu();
                newFrame.setVisible(true);
                loginButton.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password"); // message dialog in cazul in care userul si parola sunt incorecte
            }
 
        }
        // butonul ce reseteaza datele din field-ul de parola si user
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       // check box-ul ce face parola vizibila
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
 
 
        }
    }
 
}
 