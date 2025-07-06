package project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddDrugs extends JFrame implements ActionListener {
    private JLabel Add, Name, amount, type, desies, userID;
    private JTextField tname, tamount, ttype, tdesies, tuserID;
    private JButton bAdd;

    public AddDrugs() {
        super("Add Drugs");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel imagePanel = new JPanel() {
            Image img = new ImageIcon(getClass().getResource("/resources/add2.jpg")).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        imagePanel.setPreferredSize(new Dimension(900, 900));
        imagePanel.setMinimumSize(new Dimension(200, 200));
        imagePanel.setBackground(Color.WHITE);

        JPanel formPanel = new JPanel(null);
        formPanel.setBackground(Color.decode("#F5F6FA"));

        Add = new JLabel("Add Drugs");
        Add.setForeground(Color.decode("#2F3C7E"));
        Add.setFont(new Font("Arial", Font.PLAIN, 64));
        Add.setBounds(100, 40, 400, 80);
        formPanel.add(Add);

        Name = new JLabel("Drug Name");
        Name.setForeground(Color.decode("#2F3C7E"));
        Name.setFont(new Font("Arial", Font.PLAIN, 32));
        Name.setBounds(30, 160, 200, 40);
        formPanel.add(Name);

        tname = new JTextField(20);
        tname.setBackground(new Color(252,246,245));
        tname.setFont(new Font("Arial", Font.PLAIN,20));
        tname.setBounds(250, 165, 290, 35);
        formPanel.add(tname);

        amount = new JLabel("Drug Amount");
        amount.setForeground(Color.decode("#2F3C7E"));
        amount.setFont(new Font("Arial", Font.PLAIN, 32));
        amount.setBounds(30, 230, 220, 40);
        formPanel.add(amount);

        tamount = new JTextField(20);
        tamount.setBackground(new Color(252,246,245));
        tamount.setFont(new Font("Arial", Font.PLAIN,20));
        tamount.setBounds(250, 235, 290, 35);
        formPanel.add(tamount);

        type = new JLabel("Drug Type");
        type.setForeground(Color.decode("#2F3C7E"));
        type.setFont(new Font("Arial", Font.PLAIN, 32));
        type.setBounds(30, 300, 200, 40);
        formPanel.add(type);

        ttype = new JTextField(20);
        ttype.setBackground(new Color(252,246,245));
        ttype.setFont(new Font("Arial", Font.PLAIN,20));
        ttype.setBounds(250, 305, 290, 35);
        formPanel.add(ttype);

        desies = new JLabel("Disease");
        desies.setForeground(Color.decode("#2F3C7E"));
        desies.setFont(new Font("Arial", Font.PLAIN, 32));
        desies.setBounds(30, 370, 200, 40);
        formPanel.add(desies);

        tdesies = new JTextField(20);
        tdesies.setBackground(new Color(252,246,245));
        tdesies.setFont(new Font("Arial", Font.PLAIN,20));
        tdesies.setBounds(250, 375, 290, 35);
        formPanel.add(tdesies);

        userID = new JLabel("UserID");
        userID.setForeground(Color.decode("#2F3C7E"));
        userID.setFont(new Font("Arial", Font.PLAIN, 32));
        userID.setBounds(30, 440, 200, 40);
        formPanel.add(userID);

        tuserID = new JTextField(20);
        tuserID.setBackground(new Color(252,246,245));
        tuserID.setFont(new Font("Arial", Font.PLAIN,20));
        tuserID.setBounds(250, 445, 290, 35);
        formPanel.add(tuserID);

        bAdd = new JButton("Add Drug");
        bAdd.setFont(new Font("Arial", Font.PLAIN,26));
        bAdd.setForeground(new Color(252,246,245));
        bAdd.setBackground(Color.decode("#2F3C7E"));
        bAdd.setBounds(200, 520, 180, 45);
        bAdd.addActionListener(this);
        formPanel.add(bAdd);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, imagePanel, formPanel);
        splitPane.setDividerLocation(900);
        splitPane.setResizeWeight(0.5);
        splitPane.setContinuousLayout(true);
        splitPane.setDividerSize(0);
        splitPane.setBorder(null);

        setContentPane(splitPane);
        setSize(1500, 900);
        setMinimumSize(new Dimension(900, 600));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n = 0;
        if (e.getSource() == bAdd) {
            if (tname.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Insert drug name");
            } else n++;
            if (tamount.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Insert drug amount");
            } else n++;
            if (ttype.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Insert drug type");
            } else n++;
            if (tdesies.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Insert Disease name");
            } else n++;
            if (n == 4) {
                try {
                    Connection con = DriverManager.getConnection("jdbc:sqlite:database.db");
                    Statement st = con.createStatement();
                    String name = tname.getText();
                    String amount = tamount.getText();
                    String type = ttype.getText();
                    String disease = tdesies.getText();
                    String userID = tuserID.getText();
                    st.executeUpdate("insert into Drug (UserID, Drugname, Amount, Type, Disease) VALUES ('" + userID + "', '" + name + "', '" + amount + "', '" + type + "', '" + disease + "')");
                    JOptionPane.showMessageDialog(this, "Added successfully");
                    dispose();
                    Drugs drg = new Drugs();
                } catch (Exception r) {
                    JOptionPane.showMessageDialog(this, "Error." + r.getMessage());
                }
            }
        }
    }
}
