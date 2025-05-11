package tugs.week;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private MainContentPanel contentPanel;

    public MainFrame() {
        setTitle("Neo Culture Technology");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        contentPanel = new MainContentPanel();

        add(new Navbar(), BorderLayout.NORTH);
        add(new Sidebar(new SidebarListener()), BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private class SidebarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            String cardName = mapSidebarToCard(command);
            if (cardName != null) {
                contentPanel.showCard(cardName);
            } else {
                System.err.println("Card not found for command: " + command);
            }
        }
    
        private String mapSidebarToCard(String command) {
            switch (command) {
                case "NCT Universe": return "Home";
                case "NCT 127": return "NCT 127";
                case "NCT Dream": return "NCT Dream";
                case "NCT Awards": return "NCT Awards";
                case "Photo Concepts": return "Photo Concepts";
                case "Merch Collection": return "Merch Collection";
                case "Sound of NCT": return "Sound of NCT";
                case "Group Visuals": return "Group Visuals";
                default: return null;
            }
        }
    }
        public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}

