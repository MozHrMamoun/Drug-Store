package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    private JLabel log, Name, Password;
    private JTextField tname;
    private JPasswordField tpassword;
    private JButton Login;

    public Login() {
        super("Login Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel imagePanel = new JPanel() {
            Image img = new ImageIcon(getClass().getResource("/resources/L1.jpg")).getImage();
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

        log = new JLabel("Login");
        log.setForeground(Color.decode("#2F3C7E"));
        log.setFont(new Font("Arial", Font.PLAIN, 38));
        log.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        formPanel.add(log, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        Name = new JLabel("Username");
        Name.setForeground(Color.decode("#2F3C7E"));
        Name.setFont(new Font("Arial", Font.PLAIN, 22));
        formPanel.add(Name, gbc);

        gbc.gridx = 1;
        tname = new JTextField(18);
        tname.setBackground(new Color(252,246,245));
        tname.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(tname, gbc);

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

        gbc.gridy++; gbc.gridx = 0; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        Login = new JButton("Login");
        Login.setFont(new Font("Arial", Font.PLAIN, 18));
        Login.setForeground(new Color(252,246,245));
        Login.setBackground(Color.decode("#2F3C7E"));
        Login.setPreferredSize(new Dimension(120, 35));
        Login.addActionListener(this);
        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);
        btnPanel.add(Login);
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
        if(e.getSource()==Login)
        {
           try
           {
               Connection con=DriverManager.getConnection("jdbc:sqlite:database.db");
               Statement st=con.createStatement();
               String username=tname.getText();
               String password=tpassword.getText();

               String sql ="Select * from Users where Username='"+username+"'and Password='"+password+"'";
               ResultSet rs=st.executeQuery(sql);
               if(rs.next())
               {
                   dispose();
                   HomePage home=new HomePage();
              }
               else
                   JOptionPane.showMessageDialog(this,"Username or Password is wrong.");
           }

           catch(Exception r)
           {
               JOptionPane.showMessageDialog(this,"Error"+r.getMessage());
           }
        }
    }
}
