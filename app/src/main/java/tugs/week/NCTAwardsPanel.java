package tugs.week;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class NCTAwardsPanel extends JPanel {
    public NCTAwardsPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240));

        JLabel titleLabel = new JLabel("NCT Awards", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Contoh Penghargaan
        addAwardItem(contentPanel, "Best Artist.jpeg", "Seoul Music Awards - Best Artist", "2024");
        addAwardItem(contentPanel, "Top 10.jpeg", "Melon Music Awards - Top 10 Artists", "2023");
        addAwardItem(contentPanel, "Album of the Year.jpeg", "Golden Disc Awards - Album of the Year", "2022");
        // ... tambahkan penghargaan lainnya ...

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void addAwardItem(JPanel panel, String imagePath, String awardName, String year) {
        JLabel awardLabel = new JLabel();
        awardLabel.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImageIcon icon = loadImageIcon(imagePath, 50, 50);
        awardLabel.setIcon(icon);
        awardLabel.setText("<html><b>" + awardName + "</b> (" + year + ")</html>");
        awardLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Ubah kursor saat dihover

        // Tambahkan MouseListener untuk menampilkan detail saat diklik
        awardLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showAwardDetails(awardName, year, imagePath);
            }
        });

        panel.add(awardLabel);
        panel.add(Box.createVerticalStrut(10)); // Spasi antar item
    }

    private void showAwardDetails(String awardName, String year, String imagePath) {
        String message = "Penghargaan: " + awardName + "\nTahun: " + year;
        ImageIcon largeIcon = loadImageIcon(imagePath, 200, 200); // Load gambar lebih besar

        if (largeIcon != null) {
            JOptionPane.showMessageDialog(this, message, awardName, JOptionPane.INFORMATION_MESSAGE, largeIcon);
        } else {
            JOptionPane.showMessageDialog(this, message, awardName, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private ImageIcon loadImageIcon(String path, int width, int height) {
        URL imgURL = getClass().getClassLoader().getResource(path);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } else {
            System.err.println("Couldn't find file: " + path);
            return new ImageIcon("error.png"); // Gambar error jika tidak ditemukan
        }
    }
}