package project;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class UpdateDrugs extends JFrame implements ActionListener {

    private JLabel Add, Name, amount, type, desies;
    private JTextField tname, tamount, ttype, tdesies;
    private JButton update;

    UpdateDrugs() {
        super("Update Drug");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Left: Image panel
        JPanel imagePanel = new JPanel() {
            Image img = new ImageIcon(getClass().getResource("/resources/up2.jpg")).getImage();
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
        formPanel.setBackground(Color.decode("#F5F7FA"));

        Add = new JLabel("Update drug");
        Add.setForeground(Color.decode("#2F3C7E"));
        Add.setFont(new Font("Arial", Font.PLAIN, 64));
        Add.setBounds(100, 40, 400, 80);
        formPanel.add(Add);

        Name = new JLabel("Update Name");
        Name.setForeground(Color.decode("#2F3C7E"));
        Name.setFont(new Font("Arial", Font.PLAIN, 28));
        Name.setBounds(30, 160, 200, 40);
        formPanel.add(Name);

        tname = new JTextField(20);
        tname.setBackground(new Color(252,246,245));
        tname.setFont(new Font("Arial", Font.PLAIN,20));
        tname.setBounds(250, 165, 290, 35);
        formPanel.add(tname);

        amount = new JLabel("Update Amount");
        amount.setForeground(Color.decode("#2F3C7E"));
        amount.setFont(new Font("Arial", Font.PLAIN, 28));
        amount.setBounds(30, 230, 220, 40);
        formPanel.add(amount);

        tamount = new JTextField(20);
        tamount.setBackground(new Color(252,246,245));
        tamount.setFont(new Font("Arial", Font.PLAIN,20));
        tamount.setBounds(250, 235, 290, 35);
        formPanel.add(tamount);

        type = new JLabel("Update Type");
        type.setForeground(Color.decode("#2F3C7E"));
        type.setFont(new Font("Arial", Font.PLAIN, 28));
        type.setBounds(30, 300, 200, 40);
        formPanel.add(type);

        ttype = new JTextField(20);
        ttype.setBackground(new Color(252,246,245));
        ttype.setFont(new Font("Arial", Font.PLAIN,20));
        ttype.setBounds(250, 305, 290, 35);
        formPanel.add(ttype);

        desies = new JLabel("Update Disease");
        desies.setForeground(Color.decode("#2F3C7E"));
        desies.setFont(new Font("Arial", Font.PLAIN, 28));
        desies.setBounds(30, 370, 200, 40);
        formPanel.add(desies);

        tdesies = new JTextField(20);
        tdesies.setBackground(new Color(252,246,245));
        tdesies.setFont(new Font("Arial", Font.PLAIN,20));
        tdesies.setBounds(250, 375, 290, 35);
        formPanel.add(tdesies);

        

        update = new JButton("Update Drug");
        update.setFont(new Font("Arial", Font.PLAIN,26));
        update.setForeground(new Color(252,246,245));
        update.setBackground(Color.decode("#2F3C7E"));
        update.setBounds(200, 520, 180, 45);
        update.addActionListener(this);
        formPanel.add(update);

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
        int n=0;
        if(e.getSource()==update)
        {
            if(tname.getText().length()==0)
            {
                JOptionPane.showMessageDialog(this,"Insert drug name");
            }
            else n++;

            if(tamount.getText().length()==0)
            {
                JOptionPane.showMessageDialog(this,"Insert drug amount");
            }
            else n++;

            if(ttype.getText().length()==0)
            {
                JOptionPane.showMessageDialog(this,"Insert drug type");
            }
            else n++;

            if(tdesies.getText().length()==0)
            {
                JOptionPane.showMessageDialog(this,"Insert Disease name");
            }
            else n++;
        }
        if(n==4)
        {
                        try {
                            Connection con=DriverManager.getConnection("jdbc:sqlite:database.db");
                            Statement st=con.createStatement();
                            String name=tname.getText();
                            String amount=tamount.getText();
                            String type=ttype.getText();
                            String disease=tdesies.getText();
                            st.executeUpdate("update Drug set Amount='"+amount+"' where Drugname="+"'"+name+"'");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
                        }
                    } // close if(n==4)
                } // close actionPerformed
            } // close class
