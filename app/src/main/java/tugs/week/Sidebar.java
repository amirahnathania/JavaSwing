package tugs.week;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Sidebar extends JPanel {
    public Sidebar(ActionListener listener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(45, 45, 45));
        setPreferredSize(new Dimension(200, 0));
        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        add(Box.createVerticalStrut(8));

        String[] buttonLabels = {
            "NCT Universe", "NCT 127", "NCT Dream", "NCT Awards",
            "Photo Concepts", "Merch Collection", "Sound of NCT", "Group Visuals"
        };        

        for (String label : buttonLabels) {
            SidebarButton button = new SidebarButton(label);
            button.setActionCommand(label);
            button.addActionListener(listener); // delegasi ke MainFrame
            add(button);
            add(Box.createVerticalStrut(8));
        }

        add(Box.createVerticalGlue());
    }
}