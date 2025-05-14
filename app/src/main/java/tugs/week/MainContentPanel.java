package tugs.week;

import javax.swing.*;
import java.awt.*;


public class MainContentPanel extends JPanel {
    CardLayout cardLayout;

    public MainContentPanel() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(new CharacterScrollPanel(), "Home");
        add(new NCT127Panel(), "NCT 127");
        add(new NCTDreamPanel(), "NCT Dream");
        add(new NCTAwardsPanel(), "NCT Awards");
        add(new PhotoConceptsPanel(), "Photo Concepts");
        add(new MerchCollectionPanel(), "Merch Collection");
        add(new SoundOfNCTPanel(), "Sound of NCT");
        add(new GroupVisualsPanel(), "Group Visuals");

    }

    public void showCard(String name) {
        cardLayout.show(this, name);
    }

    private JPanel createSimpleLabelPanel(String text) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.add(new JLabel(text));
        return panel;
    }
}