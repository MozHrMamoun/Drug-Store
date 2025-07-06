package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Drugs extends JFrame implements ActionListener{

  private JLabel Drugs,delete,search,background;
  private JTextField tdelete,tsearch;
  private JButton addDrug,UpdateDurgs,ShowDrug,deleteb,searchb,home,upper,sum,join,subqueries,union;    
    
    
     Drugs(){
        super("Drugs");

        JPanel imagePanel = new JPanel() {
            Image img = new ImageIcon(getClass().getResource("/resources/drug2.jpg")).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        imagePanel.setPreferredSize(new Dimension(1150, 1050));
        imagePanel.setMinimumSize(new Dimension(200, 200));
        imagePanel.setBackground(Color.WHITE);

        
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.decode("#FBEAEB"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        Drugs = new JLabel("Drugs");
        Drugs.setForeground(Color.decode("#2F3C7E"));
        Drugs.setFont(new Font("Arial", Font.PLAIN, 64));
        Drugs.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 4;
        contentPanel.add(Drugs, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        // Delete Drug
        delete = new JLabel("Delete Drug");
        delete.setForeground(Color.decode("#2F3C7E"));
        delete.setFont(new Font("Arial", Font.PLAIN, 32));
        gbc.gridx = 0;
        contentPanel.add(delete, gbc);

        tdelete = new JTextField(20);
        tdelete.setBackground(new Color(252,246,245));
        tdelete.setFont(new Font("Arial", Font.PLAIN,20));
        gbc.gridx = 1;
        contentPanel.add(tdelete, gbc);

        deleteb = new JButton("Delete");
        deleteb.setFont(new Font("Arial", Font.PLAIN,26 ));
        deleteb.setForeground(new Color(252,246,245));
        deleteb.setBackground(Color.decode("#2F3C7E"));
        deleteb.addActionListener(this);
        gbc.gridx = 2;
        contentPanel.add(deleteb, gbc);

        // Spacer
        gbc.gridx = 3;
        contentPanel.add(Box.createHorizontalStrut(20), gbc);

        // Search Type
        gbc.gridy++;
        gbc.gridx = 0;
        search = new JLabel("Search Type");
        search.setForeground(Color.decode("#2F3C7E"));
        search.setFont(new Font("Arial", Font.PLAIN,32 ));
        contentPanel.add(search, gbc);

        tsearch = new JTextField(20);
        tsearch.setBackground(new Color(252,246,245));
        tsearch.setFont(new Font("Arial", Font.PLAIN,20));
        gbc.gridx = 1;
        contentPanel.add(tsearch, gbc);

        searchb = new JButton("Search");
        searchb.setFont(new Font("Arial", Font.PLAIN,26 ));
        searchb.setForeground(new Color(252,246,245));
        searchb.setBackground(Color.decode("#2F3C7E"));
        searchb.addActionListener(this);
        gbc.gridx = 2;
        contentPanel.add(searchb, gbc);

        // Spacer
        gbc.gridx = 3;
        contentPanel.add(Box.createHorizontalStrut(20), gbc);

        // Buttons Row 1
        gbc.gridy++;
        gbc.gridx = 0;
        addDrug = new JButton("Add Drug");
        addDrug.setFont(new Font("Arial", Font.PLAIN,26 ));
        addDrug.setForeground(new Color(252,246,245));
        addDrug.setBackground(Color.decode("#2F3C7E"));
        addDrug.addActionListener(this);
        contentPanel.add(addDrug, gbc);

        gbc.gridx = 1;
        UpdateDurgs = new JButton("Update Durg");
        UpdateDurgs.setFont(new Font("Arial", Font.PLAIN,26 ));
        UpdateDurgs.setForeground(new Color(252,246,245));
        UpdateDurgs.setBackground(Color.decode("#2F3C7E"));
        UpdateDurgs.addActionListener(this);
        contentPanel.add(UpdateDurgs, gbc);

        gbc.gridx = 2;
        ShowDrug = new JButton("Show Drug");
        ShowDrug.setFont(new Font("Arial", Font.PLAIN,26 ));
        ShowDrug.setForeground(new Color(252,246,245));
        ShowDrug.setBackground(Color.decode("#2F3C7E"));
        ShowDrug.addActionListener(this);
        contentPanel.add(ShowDrug, gbc);

        // Buttons Row 2
        gbc.gridy++;
        gbc.gridx = 0;
        upper = new JButton("Upper Case");
        upper.setFont(new Font("Arial", Font.PLAIN,26 ));
        upper.setForeground(new Color(252,246,245));
        upper.setBackground(Color.decode("#2F3C7E"));
        upper.addActionListener(this);
        contentPanel.add(upper, gbc);

        gbc.gridx = 1;
        sum = new JButton("Sum Total");
        sum.setFont(new Font("Arial", Font.PLAIN,26 ));
        sum.setForeground(new Color(252,246,245));
        sum.setBackground(Color.decode("#2F3C7E"));
        sum.addActionListener(this);
        contentPanel.add(sum, gbc);

        gbc.gridx = 2;
        join = new JButton("Join Table");
        join.setFont(new Font("Arial", Font.PLAIN,26 ));
        join.setForeground(new Color(252,246,245));
        join.setBackground(Color.decode("#2F3C7E"));
        join.addActionListener(this);
        contentPanel.add(join, gbc);

        // Buttons Row 3
        gbc.gridy++;
        gbc.gridx = 0;
        subqueries = new JButton("Use subquery");
        subqueries.setFont(new Font("Arial", Font.PLAIN,26 ));
        subqueries.setForeground(new Color(252,246,245));
        subqueries.setBackground(Color.decode("#2F3C7E"));
        subqueries.addActionListener(this);
        contentPanel.add(subqueries, gbc);

        gbc.gridx = 2;
        union = new JButton("Use Union");
        union.setFont(new Font("Arial", Font.PLAIN,26 ));
        union.setForeground(new Color(252,246,245));
        union.setBackground(Color.decode("#2F3C7E"));
        union.addActionListener(this);
        contentPanel.add(union, gbc);

        // Home button (centered)
        gbc.gridy++;
        gbc.gridx = 1;
        home = new JButton("HomePage");
        home.setFont(new Font("Arial", Font.PLAIN,26 ));
        home.setForeground(new Color(252,246,245));
        home.setBackground(Color.decode("#2F3C7E"));
        home.addActionListener(this);
        contentPanel.add(home, gbc);

        // Split pane for resizable layout, no divider line
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, imagePanel, contentPanel);
        splitPane.setDividerLocation(900);
        splitPane.setResizeWeight(0.5);
        splitPane.setContinuousLayout(true);
        splitPane.setDividerSize(0); // Remove the line between panels
        splitPane.setBorder(null);

        setContentPane(splitPane);
        setSize(1600, 900);
        setMinimumSize(new Dimension(900, 600));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==addDrug)
       {
           dispose();
           AddDrugs add=new AddDrugs();
       }
       if(e.getSource()==UpdateDurgs)
       {
           dispose();
           UpdateDrugs update=new UpdateDrugs();
       }
       
       if(e.getSource()==home)
       {
           dispose();
           HomePage home=new HomePage();
       }
       if(e.getSource()==searchb)
       {
           if(tsearch.getText().length()==0)
               JOptionPane.showMessageDialog(this,"Enter Drug Type");
               
           else
           {
            try
            {
               
               Connection con=DriverManager.getConnection("jdbc:sqlite:database.db");
               Statement st=con.createStatement();
               String name=tsearch.getText();
               
              ResultSet res=st.executeQuery("select * from Drug Where Type ='"+ name +"' ORDER BY Amount DESC");
              String output="DrugID   \t UserID   \t Drugname   \t Amount   \t Type   \t   Disease";
              while(res.next())
               {
                   output+="\n  "+res.getString(1)+"            "+res.getString(2)+"          "+res.getString(3)+"              "+res.getString(4)+"        "+res.getString(5)+"        "+res.getString(6);
               }
               
               JOptionPane.showMessageDialog(this,output);
            }
           
            catch(Exception r)
            {
               JOptionPane.showMessageDialog(this,"Drug not found.");
            }
           }
       }
       
       if(e.getSource()==deleteb)
       {
           if(tdelete.getText().length()==0)
               JOptionPane.showMessageDialog(this,"Enter Drug name");
               
           else
           {
            try
            {
               
               Connection con=DriverManager.getConnection("jdbc:sqlite:database.db");
               Statement st=con.createStatement();
               String name=tdelete.getText();
               
               st.executeUpdate("delete from Drug where Drugname="+"'"+name+"'");
               JOptionPane.showMessageDialog(this,"Deleted successfully");
            }
           
            catch(Exception r)
            {
               JOptionPane.showMessageDialog(this,"Drug not found.");
            }
           }
       }
       
       if(e.getSource()==ShowDrug)
       {
           try
            {
               
               Connection con=DriverManager.getConnection("jdbc:sqlite:database.db");
               Statement st=con.createStatement();
               
               ResultSet res=st.executeQuery("select * from Drug");
               String output="DrugID"+"       "+"UserID"+"       "+"Drugname"+"       "+" Amount"+"       "+" Type"+"       "+"Disease";
               
               while(res.next())
               {
                   output+="\n    "+res.getString(1)+"               "+res.getString(2)+"               "+res.getString(3)+"                 "+res.getString(4)+"           "+res.getString(5)
                           +"          "+res.getString(6);
               }
               
               JOptionPane.showMessageDialog(null,output,"Show Drugs",JOptionPane.INFORMATION_MESSAGE);
            }
           
            catch(Exception r)
            {
               JOptionPane.showMessageDialog(this,"Error."+r.getMessage());
            }
       }
       
       if(e.getSource()==upper)
       {
           try
            {
               
               Connection con=DriverManager.getConnection("jdbc:sqlite:database.db");
               Statement st=con.createStatement();
               
               ResultSet res=st.executeQuery("select DrugID, UserID, UPPER(Drugname), Amount, Type, Disease from Drug ORDER BY Type DESC");
               String output="DrugID"+"       "+"UserID"+"       "+"Drugname"+"                  "+" Amount"+"       "+" Type"+"       "+"Disease";
               
               while(res.next())
               {
                   output+="\n    "+res.getString(1)+"               "+res.getString(2)+"               "+res.getString(3)+"                 "+res.getString(4)+"           "+res.getString(5)
                           +"          "+res.getString(6);
               }
               
               JOptionPane.showMessageDialog(null,output,"Show Drugs UpperCase",JOptionPane.INFORMATION_MESSAGE);
            }
           
            catch(Exception r)
            {
               JOptionPane.showMessageDialog(this,"Error."+r.getMessage());
            }
       }
       
       if(e.getSource()==sum)
       {
           try
            {
               
               Connection con=DriverManager.getConnection("jdbc:sqlite:database.db");
               Statement st=con.createStatement();
               
               ResultSet res=st.executeQuery("SELECT SUM(Amount) AS TotalAmount FROM Drug");
               String output = "Total Drug Amount";

                if (res.next()) 
                {
                    output += "\n" + res.getString("TotalAmount");
                }
               
               JOptionPane.showMessageDialog(null,output,"Show Amount Sum",JOptionPane.INFORMATION_MESSAGE);
            }
           
            catch(Exception r)
            {
               JOptionPane.showMessageDialog(this,"Error."+r.getMessage());
            }
       }
       
       if(e.getSource()==join)
       {
           try
            {
               
               Connection con=DriverManager.getConnection("jdbc:sqlite:database.db");
               Statement st=con.createStatement();
               
               ResultSet res=st.executeQuery("SELECT Users.UserName, Drug.DrugName, Drug.Type from Drug JOIN Users ON Drug.UserID = Users.UserID; ");
               String output="UserName"+"                 "+"Drugname"+"             "+"Type";
               
               while(res.next())
               {
                   output+="\n"+res.getString(1)+"                   "+res.getString(2)+"          "+res.getString(3);
               }
               
               JOptionPane.showMessageDialog(null,output,"Join user and drug tables",JOptionPane.INFORMATION_MESSAGE);
            }
           
            catch(Exception r)
            {
               JOptionPane.showMessageDialog(this,"Error."+r.getMessage());
            }
       }
       
       if(e.getSource()==subqueries)
       {
           try
            {
               
               Connection con=DriverManager.getConnection("jdbc:sqlite:database.db");
               Statement st=con.createStatement();
               
               ResultSet res=st.executeQuery("select Drugname from drug where Amount < (select AVG(Amount) from drug)");
               String output="Drugname";
               
               while(res.next())
               {
                   output+="\n"+res.getString(1);
               }
               
               JOptionPane.showMessageDialog(null,output,"SubQueries",JOptionPane.INFORMATION_MESSAGE);
            }
           
            catch(Exception r)
            {
               JOptionPane.showMessageDialog(this,"Error."+r.getMessage());
            }
       }
       
       if(e.getSource()==union)
       {
           try
            {
               
               Connection con=DriverManager.getConnection("jdbc:sqlite:database.db");
               Statement st=con.createStatement();
               
               ResultSet res=st.executeQuery("SELECT Drugname from drug where Type = 'Pill' UNION select Drugname from drug where Disease = 'Diabetes'");
               String output="Drugname";
               
               while(res.next())
               {
                   output+="\n"+res.getString(1);
               }
               
               JOptionPane.showMessageDialog(null,output,"Union Table",JOptionPane.INFORMATION_MESSAGE);
            }
           
            catch(Exception r)
            {
               JOptionPane.showMessageDialog(this,"Error."+r.getMessage());
            }
       }
           
    }
    
}
