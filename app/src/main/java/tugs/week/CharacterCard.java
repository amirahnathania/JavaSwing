package tugs.week;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.IOException;

class CharacterCard extends JPanel {
    public CharacterCard(String characterName, String imageName) {

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // Load image from resources folder
        JLabel imageLabel;
        ImageIcon icon = null;
        try {
            InputStream imgStream = getClass().getClassLoader().getResourceAsStream(imageName);
            if (imgStream != null) {
                Image img = ImageIO.read(imgStream).getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                icon = new ImageIcon(img);
                imageLabel = new JLabel(icon);
                imageLabel.setOpaque(true); 
                imageLabel.setBackground(Color.WHITE); 
            } else {
                System.err.println("Image not found: " + imageName + " for " + characterName);
                imageLabel = new JLabel("No Image", SwingConstants.CENTER);
                imageLabel.setOpaque(true);
                imageLabel.setBackground(Color.LIGHT_GRAY);
            }
        } catch (IOException e) {
            System.err.println("Error loading image: " + imageName + " for " + characterName + ": " + e.getMessage());
            imageLabel = new JLabel("Error", SwingConstants.CENTER);
            imageLabel.setOpaque(true);
            imageLabel.setBackground(Color.RED);
        }

        imageLabel.setPreferredSize(new Dimension(180, 180));
        imageLabel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 220)));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        // ini untuk mouse click listener untuk membuka popup gambar
        imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showImagePopup(characterName, imageName);
            }
        });

        JLabel nameLabel = new JLabel(characterName, SwingConstants.CENTER);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        namePanel.setBackground(Color.WHITE);
        namePanel.add(nameLabel);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.add(imageLabel);
        containerPanel.add(namePanel);
        containerPanel.setBackground(Color.WHITE); // pastikan background putih

        add(containerPanel, BorderLayout.CENTER);
    }

    // ✅ Tambahkan method ini di luar konstruktor
    private void showImagePopup(String characterName, String imageName) {
        JDialog popup = new JDialog();
        popup.setTitle(characterName);
        popup.setModal(true);
        popup.setLayout(new BorderLayout());

        try {
            InputStream imgStream = getClass().getClassLoader().getResourceAsStream(imageName);
            if (imgStream != null) {
                Image img = ImageIO.read(imgStream).getScaledInstance(400, 400, Image.SCALE_SMOOTH);
                JLabel imgLabel = new JLabel(new ImageIcon(img));
                imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
                popup.add(imgLabel, BorderLayout.CENTER);
            } else {
                popup.add(new JLabel("Image not found"), BorderLayout.CENTER);
            }
        } catch (IOException e) {
            popup.add(new JLabel("Error loading image"), BorderLayout.CENTER);
        }

        popup.setSize(420, 440);
        popup.setLocationRelativeTo(null); // center
        popup.setVisible(true);
    }
}
