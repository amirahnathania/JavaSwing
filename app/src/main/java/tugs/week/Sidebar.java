package tugs.week;

import javax.swing.*;
import java.awt.*;

public class Sidebar extends JPanel {

    public Sidebar() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(45, 45, 45));
        setPreferredSize(new Dimension(180, 0));
        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        add(Box.createVerticalStrut(20));

        String[] buttonLabels = {
                "NCT Universe", "NCT 127", "NCT Dream", "NCT Awards",
                "Photo Concepts", "Merch Collection", "Sound of NCT", "Group Visuals"
        };

        for (String label : buttonLabels) {
            add(new SidebarButton(label));
            add(Box.createVerticalStrut(10)); // Jarak vertikal
        }

        add(Box.createVerticalGlue());
    }
}