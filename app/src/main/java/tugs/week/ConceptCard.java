package tugs.week;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class ConceptCard extends JLabel {
    private Concept concept;
    private JFrame parentFrame;

    public ConceptCard(Concept concept, JFrame parentFrame) {
        this.concept = concept;
        this.parentFrame = parentFrame;

        ImageIcon imageIcon = loadImageIcon(concept.getImagePath());
        if (imageIcon != null) {
            setIcon(scaleImageIcon(imageIcon, 150, 150));
        } else {
            setText("Gambar tidak ditemukan");
            setHorizontalAlignment(JLabel.CENTER);
        }
        setToolTipText(concept.getDescription());
        setHorizontalAlignment(JLabel.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(150, 150));
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showConceptDetails();
            }
        });
    }

    private void showConceptDetails() {
        String message = "Nama Konsep: " + concept.getName() + "\n" +
                         "Deskripsi: " + concept.getDescription();

        ImageIcon largeIcon = loadImageIcon(concept.getImagePath());
        if (largeIcon != null) {
            JOptionPane.showMessageDialog(parentFrame, message, concept.getName(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(largeIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        } else {
            JOptionPane.showMessageDialog(parentFrame, message, concept.getName(), JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private ImageIcon loadImageIcon(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            System.err.println("Nama file gambar tidak valid.");
            return null;
        }

        URL imageURL = getClass().getClassLoader().getResource(imagePath); // Langsung menggunakan imagePath
        if (imageURL == null) {
            System.err.println("Gambar tidak ditemukan di: " + imagePath);
            return null;
        }

        return new ImageIcon(imageURL);
    }

    private ImageIcon scaleImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}