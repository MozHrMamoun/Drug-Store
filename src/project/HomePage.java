package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener {

    private JLabel logo, icons, back, info;
    private JButton home, regster, login, durgs;

    HomePage() {
        super("Home Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#FBEAEB"));

        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.decode("#FBEAEB"));
        topBar.setBorder(BorderFactory.createEmptyBorder(20, 40, 0, 40));

        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        logoPanel.setOpaque(false);
        logo = new JLabel();
        java.net.URL logoUrl = getClass().getResource("/resources/logo.png");
        if (logoUrl != null) {
            logo.setIcon(new ImageIcon(logoUrl));
        } else {
            logo.setText("Logo");
        }
        logoPanel.add(logo);

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 0));
        navPanel.setOpaque(false);

        home = new JButton("HOME");
        regster = new JButton("REGISTER");
        login = new JButton("LOGIN");
        durgs = new JButton("DRUGS");
        JButton[] navButtons = {home, regster, login, durgs};
        for (JButton btn : navButtons) {
            btn.setBackground(Color.decode("#FBEAEB"));
            btn.setFont(new Font("Arial", Font.PLAIN, 20));
            btn.setForeground(Color.decode("#2F3C7E"));
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setContentAreaFilled(false);
            btn.addActionListener(this);
            navPanel.add(btn);
        }

        topBar.add(logoPanel, BorderLayout.WEST);
        topBar.add(navPanel, BorderLayout.CENTER);

        back = new JLabel();
        java.net.URL backUrl = getClass().getResource("/resources/h1.jpg");
        if (backUrl != null) {
            back.setIcon(new ImageIcon(backUrl));
        } else {
            back.setText("Main Image");
        }
        back.setHorizontalAlignment(SwingConstants.CENTER);
        back.setVerticalAlignment(SwingConstants.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 0));
        bottomPanel.setBackground(Color.decode("#FBEAEB"));
        info = new JLabel("Our Social Media");
        info.setFont(new Font("Arial", Font.PLAIN, 18));
        info.setForeground(Color.decode("#2F3C7E"));
        bottomPanel.add(info);

        icons = new JLabel();
        java.net.URL iconUrl = getClass().getResource("/resources/icons.png");
        if (iconUrl != null) {
            icons.setIcon(new ImageIcon(iconUrl));
        } else {
            icons.setText("icon");
        }
        icons.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        bottomPanel.add(icons);

        mainPanel.add(topBar, BorderLayout.NORTH);
        mainPanel.add(back, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        setMinimumSize(new Dimension(900, 600));
        setSize(1300, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regster) {
            dispose();
            Register regs = new Register();
        }
        if (e.getSource() == login) {
            dispose();
            Login log = new Login();
        }
        if (e.getSource() == durgs) {
            dispose();
            Drugs drg = new Drugs();
        }
    }
}
