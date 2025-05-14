package tugs.week;

import javax.swing.*;
import java.awt.*;

public class CharacterScrollPanel extends JPanel {

    public CharacterScrollPanel() {
        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 4, 10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Nama karakter dan file image (harus sama persis dengan nama file di folder resources)
        String[][] characters = {
            {"Jaemin", "Jaemin.jpeg"},
            {"Jeno", "Jeno.jpeg"},
            {"Jisung", "Jisung.jpeg"},
            {"Jaehyun", "Jaehyun.jpeg"},
            {"Jungwoo", "Jungwoo.jpeg"},
            {"Johnny", "Johnny.jpeg"},
            {"Renjun", "Renjun.jpeg"},
            {"Chenle", "Chenle.jpeg"},
            {"Haechan", "Haechan.jpeg"},
            {"Mark", "Mark.jpeg"},
            {"Taeil", "Taeil.jpeg"},
            {"Yuta", "Yuta.jpeg"},
            {"Doyoung", "Doyoung.jpeg"},
            {"Winwin", "Winwin.jpeg"},
            {"Taeyong", "Taeyong.jpeg"}
        };

        String pageName = "NCT Universe"; 
        for (String[] character : characters) {
            contentPanel.add(new CharacterCard(character[0], character[1], pageName));
        }


        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }
}