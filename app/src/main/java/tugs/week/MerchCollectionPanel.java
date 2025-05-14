package tugs.week;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MerchCollectionPanel extends JPanel {

    public MerchCollectionPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("NCT Merch Collection", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(titleLabel, BorderLayout.NORTH);

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(0, 3, 20, 20));
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cardPanel.setBackground(Color.white);

        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        List<Concept> merchItems = Arrays.asList(
            new Concept("NCT Lightstick Ver. 3", "Lightstick Ver. 3.jpeg", "Official NCT Lightstick Version 3."),
            new Concept("NCT Album - Resonance Pt. 1", "Album-Resonance.jpeg", "NCT 2020 Resonance Pt. 1 album."),
            new Concept("NCT Dream - We Boom Kit", "We Boom Kit.jpeg", "NCT Dream We Boom Kihno Kit.")
        );

        for (Concept merchItem : merchItems) {
            cardPanel.add(new ConceptCard(merchItem, parentFrame));
        }

        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }
}