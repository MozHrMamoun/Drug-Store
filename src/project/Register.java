package project;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Register extends JFrame implements ActionListener {
    private JLabel reg, Name, email, Password, conPassword, word;
    private JTextField tname, temail;
    private JPasswordField tpassword, tconPassword;
    private JButton Register, Login;

    public Register() {
        super("Register");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        JPanel imagePanel = new JPanel() {
            Image img = new ImageIcon(getClass().getResource("/resources/R1.jpg")).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        imagePanel.setPreferredSize(new Dimension(600, 600));
        imagePanel.setMinimumSize(new Dimension(200, 200));
        imagePanel.setBackground(Color.WHITE);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.decode("#FBEAEB"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(18, 18, 18, 18);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        reg = new JLabel("Registeration");
        reg.setForeground(Color.decode("#2F3C7E"));
        reg.setFont(new Font("Arial", Font.PLAIN, 38));
        reg.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        formPanel.add(reg, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        Name = new JLabel("Name");
        Name.setForeground(Color.decode("#2F3C7E"));
        Name.setFont(new Font("Arial", Font.PLAIN, 22));
        formPanel.add(Name, gbc);

        gbc.gridx = 1;
        tname = new JTextField(18);
        tname.setBackground(new Color(252,246,245));
        tname.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(tname, gbc);

        gbc.gridy++; gbc.gridx = 0;
        email = new JLabel("Email");
        email.setForeground(Color.decode("#2F3C7E"));
        email.setFont(new Font("Arial", Font.PLAIN, 22));
        formPanel.add(email, gbc);

        gbc.gridx = 1;
        temail = new JTextField(18);
        temail.setBackground(new Color(252,246,245));
        temail.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(temail, gbc);

        gbc.gridy++; gbc.gridx = 0;
        Password = new JLabel("Password");
        Password.setForeground(Color.decode("#2F3C7E"));
        Password.setFont(new Font("Arial", Font.PLAIN, 22));
        formPanel.add(Password, gbc);

        gbc.gridx = 1;
        tpassword = new JPasswordField(18);
        tpassword.setBackground(new Color(252,246,245));
        tpassword.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(tpassword, gbc);

        gbc.gridy++; gbc.gridx = 0;
        conPassword = new JLabel("Confirm Password");
        conPassword.setForeground(Color.decode("#2F3C7E"));
        conPassword.setFont(new Font("Arial", Font.PLAIN, 22));
        formPanel.add(conPassword, gbc);

        gbc.gridx = 1;
        tconPassword = new JPasswordField(18);
        tconPassword.setBackground(new Color(252,246,245));
        tconPassword.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(tconPassword, gbc);

        
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        btnPanel.setOpaque(false);

        Register = new JButton("Register");
        Register.setFont(new Font("Arial", Font.PLAIN, 18));
        Register.setForeground(new Color(252,246,245));
        Register.setBackground(Color.decode("#2F3C7E"));
        Register.setAlignmentX(Component.CENTER_ALIGNMENT);
        Register.setMaximumSize(new Dimension(160, 35));
        Register.setPreferredSize(new Dimension(160, 35));
        Register.addActionListener(this);
        btnPanel.add(Register);

        btnPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.X_AXIS));

        word = new JLabel("Already have Account?");
        word.setForeground(Color.decode("#2F3C7E"));
        word.setFont(new Font("Arial", Font.PLAIN, 18));
        word.setHorizontalAlignment(SwingConstants.RIGHT);
        loginPanel.add(word);

        loginPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        Login = new JButton("Login");
        Login.setFont(new Font("Arial", Font.PLAIN, 18));
        Login.setForeground(new Color(252,246,245));
        Login.setBackground(Color.decode("#2F3C7E"));
        Login.setMaximumSize(new Dimension(160, 35));
        Login.setPreferredSize(new Dimension(160, 35));
        Login.addActionListener(this);
        loginPanel.add(Login);

        btnPanel.add(loginPanel);

        formPanel.add(btnPanel, gbc);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, imagePanel, formPanel);
        splitPane.setDividerLocation(600);
        splitPane.setResizeWeight(0.5);
        splitPane.setContinuousLayout(true);
        splitPane.setDividerSize(0);
        splitPane.setBorder(null);

        setContentPane(splitPane);
        setMinimumSize(new Dimension(800, 500));
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n = 0;

        if (e.getSource() == Login) {
            dispose();
            Login log = new Login();
        }
        if (e.getSource() == Register) {
            if (tname.getText().length() < 6) {
                JOptionPane.showMessageDialog(this, "Enter name more than 10 letters");
                tname.setText("");
            } else
                n++;

            if (tpassword.getText().length() < 8) {
                JOptionPane.showMessageDialog(this, "Enter Password more than 8 letters");
                tpassword.setText("");
            } else
                n++;

            if (!tpassword.getText().equals(tconPassword.getText())) {
                JOptionPane.showMessageDialog(this, "The Password and its confomation not the same.");
                tconPassword.setText("");
            } else
                n++;

            for (int i = 0; i < temail.getText().length(); i++) {
                char r = temail.getText().charAt(i);
                if (r == '@') {
                    n++;
                    break;
                } else if (i == temail.getText().length() - 1) {
                    JOptionPane.showMessageDialog(this, "The email must contain @");
                    temail.setText("");
                }
            }
            if (n == 4) {
                JOptionPane.showMessageDialog(this, "Welcome");
                dispose();
                Login log = new Login();

                try {
                    Connection con = DriverManager.getConnection("jdbc:sqlite:database.db");
                    Statement st = con.createStatement();
                    String name = tname.getText();
                    String password = tpassword.getText();
                    String email1 = temail.getText();

                    st.executeUpdate("insert into Users (Username, Password, Email) values('" + name + "','" + password + "','" + email1 + "')");

                } catch (Exception r) {
                    JOptionPane.showMessageDialog(this, "Error." + r.getMessage());
                }
            }
        }
    }
}




