package tugs.week;

import javax.swing.*;
import java.awt.*;

public class Navbar extends JPanel {

    public Navbar() {
        setLayout(new BorderLayout());
        setBackground(new Color(33, 33, 33));
        setPreferredSize(new Dimension(0, 50));

        JLabel title = new JLabel("Explore the Visuals of NCT 127 & DREAM");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 16));
        title.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Transparent background
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton discordButton = new JButton("Join Discord");
        discordButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        discordButton.setBackground(Color.blue);
        discordButton.setForeground(Color.WHITE);
        discordButton.setOpaque(true);

        JButton koFiButton = new JButton("Buy us a Photocard");
        koFiButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        koFiButton.setBackground(Color.RED);
        koFiButton.setForeground(Color.WHITE);
        koFiButton.setOpaque(true);

        buttonPanel.add(discordButton);
        buttonPanel.add(koFiButton);

        add(title, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.EAST);
    }
}