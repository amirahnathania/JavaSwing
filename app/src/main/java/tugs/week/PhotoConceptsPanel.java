package tugs.week;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PhotoConceptsPanel extends JPanel {

    public PhotoConceptsPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("NCT Photo Concepts", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(titleLabel, BorderLayout.NORTH);

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(0, 3, 20, 20));
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cardPanel.setBackground(Color.white);

        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        List<Concept> concepts = Arrays.asList(
            new Concept("Hello Future", "Hello Future.jpeg", "Concept dari album 'Hello Future'."),
            new Concept("Chewing Gum", "Chewing Gum.jpeg", "Concept dari debut NCT Dream."),
            new Concept("Hot Sauce", "Hot Sauce.jpeg", "Concept dari album 'Hot Sauce'."),
            new Concept("ISTJ", "ISTJ.jpeg", "Concept dari album ISTJ."),
            new Concept("Sticker", "Sticker.jpeg", "Concept futuristik dari NCT 127."),
            new Concept("Favorite", "Favorite.jpeg", "Vampire-themed concept."),
            new Concept("Cherry Bomb", "Cherry Bomb.jpeg", "Explosive and bold visual concept."),
            new Concept("Broken Melodies", "Broken Melodies.jpeg", "Soft, emotional theme."),
            new Concept("Glitch Mode", "Glitch Mode.jpeg", "Futuristic glitch effect style.")
        );

        for (Concept concept : concepts) {
            cardPanel.add(new ConceptCard(concept, parentFrame)); 
        }

        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }
}