package tugs.week;

import javax.swing.*;
import java.awt.*;

public class MainContentPanel extends JPanel {
    CardLayout cardLayout;

    public MainContentPanel() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(new CharacterScrollPanel(), "Home");
        add(createSimpleLabelPanel("Gambar Member NCT 127"), "NCT 127");
        add(createSimpleLabelPanel("Gambar Member NCT Dream"), "NCT Dream");
        add(createSimpleLabelPanel("Penghargaan NCT"), "NCT Awards");
        add(createSimpleLabelPanel("Konsep Foto NCT"), "Photo Concepts");
        add(createSimpleLabelPanel("Koleksi Barang NCT"), "Merch Collection");
        add(createSimpleLabelPanel("Lagu NCT"), "Sound of NCT");
        add(createSimpleLabelPanel("Kumpulan Foto Grup"), "Group Visuals");

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