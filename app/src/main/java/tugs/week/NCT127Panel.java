package tugs.week;

import javax.swing.*;
import java.awt.*;

public class NCT127Panel extends JPanel {
    public NCT127Panel() {
        setLayout(new BorderLayout());
        setBackground(new Color(200, 200, 200)); // Contoh warna abu-abu muda, sesuaikan sesuai keinginan

        // Judul
        JLabel titleLabel = new JLabel("NCT 127", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(titleLabel, BorderLayout.NORTH);

        // Panel isi grid member
        JPanel cardPanel = new JPanel(new GridLayout(0, 3, 15, 15)); 
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        // Tambahkan member NCT 127
        cardPanel.add(new CharacterCard("Mark", "Mark.jpeg", "NCT 127"));
        cardPanel.add(new CharacterCard("Taeyong", "Taeyong.jpeg", "NCT 127"));
        cardPanel.add(new CharacterCard("Jaehyun", "Jaehyun.jpeg", "NCT 127"));
        cardPanel.add(new CharacterCard("Jungwoo", "Jungwoo.jpeg", "NCT 127"));
        cardPanel.add(new CharacterCard("Haechan", "Haechan.jpeg", "NCT 127"));
        cardPanel.add(new CharacterCard("Doyoung", "Doyoung.jpeg", "NCT 127"));
        cardPanel.add(new CharacterCard("Taeil", "Taeil.jpeg", "NCT 127"));
        cardPanel.add(new CharacterCard("Yuta", "Yuta.jpeg", "NCT 127"));
        cardPanel.add(new CharacterCard("Johnny", "Johnny.jpeg", "NCT 127"));

        // Scroll pane
        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // smooth scroll
        add(scrollPane, BorderLayout.CENTER);
    }
}
