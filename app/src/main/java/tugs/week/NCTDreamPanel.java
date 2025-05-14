package tugs.week;

import javax.swing.*;
import java.awt.*;

public class NCTDreamPanel extends JPanel {

    public NCTDreamPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("NCT Dream", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(titleLabel, BorderLayout.NORTH);

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(0, 3, 20, 20));
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cardPanel.setBackground(Color.WHITE);

        // Tambahkan semua member NCT Dream
        cardPanel.add(new CharacterCard("Mark", "Mark.jpeg", "NCT Dream"));
        cardPanel.add(new CharacterCard("Renjun", "Renjun.jpeg", "NCT Dream"));
        cardPanel.add(new CharacterCard("Jeno", "Jeno.jpeg", "NCT Dream"));
        cardPanel.add(new CharacterCard("Haechan", "Haechan.jpeg", "NCT Dream"));
        cardPanel.add(new CharacterCard("Jaemin", "Jaemin.jpeg", "NCT Dream"));
        cardPanel.add(new CharacterCard("Chenle", "Chenle.jpeg", "NCT Dream"));
        cardPanel.add(new CharacterCard("Jisung", "Jisung.jpeg", "NCT Dream"));

        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // scroll smooth

        add(scrollPane, BorderLayout.CENTER);
    }
}
