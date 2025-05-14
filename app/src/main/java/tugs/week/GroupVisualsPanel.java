package tugs.week;

import javax.swing.*;
import java.awt.*;

public class GroupVisualsPanel extends JPanel {

    public GroupVisualsPanel() {
        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 4, 10, 10)); // Atur layout grid, sesuaikan jumlah kolom
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Array berisi nama foto grup dan nama file (pastikan nama file sesuai)
        String[][] groupPhotos = {
            {"NCT Gambar 1", "NCT Dream 1.jpeg"},
            {"NCT Gambar 2", "NCT Dream 2.jpeg"},
            {"NCT Gambar 3", "NCT Dream 3.jpeg"},
            {"NCT Gambar 4", "NCT Dream 4.jpeg"},
            {"NCT Gambar 5", "NCT Dream 5.jpeg"},
            {"NCT Gambar 6", "NCT 127 1.jpeg"},
            {"NCT Gambar 7", "NCT 127 2.jpeg"},
            {"NCT Gambar 8", "NCT 127 3.jpeg"},
            {"NCT Gambar 9", "NCT 127 4.jpeg"},
        };

        String pageName = "NCT Group Visuals"; // Nama halaman
        for (String[] groupPhoto : groupPhotos) {
            contentPanel.add(new CharacterCard(groupPhoto[0], groupPhoto[1], pageName)); // Gunakan CharacterCard untuk menampilkan gambar
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }
}