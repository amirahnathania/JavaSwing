package tugs.week;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class SoundOfNCTPanel extends JPanel {

    public SoundOfNCTPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Sound of NCT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(titleLabel, BorderLayout.NORTH);

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(0, 3, 20, 20));
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cardPanel.setBackground(Color.white);

        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        List<Concept> tracksOrAlbums = Arrays.asList(
            new Concept("Hello Future", "Hello Future.jpeg", "Single 'Hello Future' oleh NCT Dream."),
            new Concept("Broken Melodies", "Broken Melodies.jpeg", "Single 'Broken Melodies' oleh NCT Dream."),
            new Concept("Chewing Gum", "Chewing Gum.jpeg", "Single debut NCT Dream."),
            new Concept("Hot Sauce", "Hot Sauce.jpeg", "Judul lagu dari album 'Hot Sauce' oleh NCT Dream."),
            new Concept("ISTJ", "ISTJ.jpeg", "Judul lagu dari album 'ISTJ' oleh NCT Dream."),
            new Concept("Glitch Mode", "Glitch Mode.jpeg", "Judul lagu dari album 'Glitch Mode' oleh NCT Dream."),
            new Concept("Sticker", "Sticker.jpeg", "Judul lagu dari album 'Sticker' oleh NCT 127."),
            new Concept("Favorite", "Favorite.jpeg", "Judul lagu dari repackage album NCT 127."),
            new Concept("Cherry Bomb", "Cherry Bomb.jpeg", "Judul lagu dari mini album NCT 127.")
        );

        for (Concept item : tracksOrAlbums) {
            cardPanel.add(new ConceptCard(item, parentFrame));
        }

        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }
}