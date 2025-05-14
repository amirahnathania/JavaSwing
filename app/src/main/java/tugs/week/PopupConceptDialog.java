package tugs.week;

import javax.swing.*;
import java.awt.*;

public class PopupConceptDialog extends JDialog {
    public PopupConceptDialog(JFrame parent, Concept concept) {
        super(parent, concept.getName(), true);
        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/" + concept.getImagePath()));
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        JTextArea descriptionArea = new JTextArea(concept.getDescription());
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setBackground(Color.WHITE);

        add(imageLabel, BorderLayout.CENTER);
        add(new JScrollPane(descriptionArea), BorderLayout.SOUTH);

        setSize(400, 500);
        setLocationRelativeTo(parent);
    }
}
