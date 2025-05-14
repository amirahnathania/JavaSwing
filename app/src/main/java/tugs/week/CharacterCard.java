package tugs.week;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.IOException;

public class CharacterCard extends JPanel {

    private String pageName;

    public CharacterCard(String characterName, String imageName, String pageName) {
        this.pageName = pageName;

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

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

        // Mouse listener
        imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (pageName.equalsIgnoreCase("NCT 127") || pageName.equalsIgnoreCase("NCT Dream")) {
                    showBiodataPopup(characterName, imageName);
                } else {
                    showImageOnlyPopup(characterName, imageName);
                }                
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
        containerPanel.setBackground(Color.WHITE);

        add(containerPanel, BorderLayout.CENTER);
    }

    private String getBiodata(String characterName) {
        switch (characterName) {
            case "Mark":
                return "Nama Panggung : Mark (Hangul : 마크)\nNama Lengkap : Mark Lee (Hangul : 마크 리)\nNama Korea: Lee Min-hyung (이민형)\nTanggal Lahir: 2 Agustus 1999\nTempat Lahir : Vancouver, Kanada\nKewarganegaraan : Kanada\nPosisi di NCT: Rapper utama, vokalis, dancer\nSub-unit di NCT : NCT U, NCT 127, NCT Dream, SuperM";
            case "Jaehyun":
                return "Nama Panggung : Jaehyun (Hangul: 재현)\nNama Lengkap : Jeong Jae-hyun (정재현)\nTanggal Lahir: 14 Februari 1997\nKewarganegaraan : Korea\nPosisi di NCT: Singer-songwriter, rapper, actor\nSub-unit di NCT : NCT U, NCT 127, NCT DOJAEJUNG";
            case "Taeyong":
                return "Nama Panggung : Taeyong (태용)\nNama Lengkap : Lee Tae-yong (이태용)\nTanggal Lahir: 1 Juli 1995\nTempat Lahir : Sillim-dong, Gwanak-gu, Seoul, Korea Selatan\nKewarganegaraan : Korea\nPosisi: Leader, Rapper, Dancer, Penyanyi, Penulis Lagu\nSub-unit di NCT : NCT U, NCT 127";
            case "Haechan":
                return "Nama Panggung : Haechan (Hangul: 해찬)\nNama Lengkap : Lee Donghyuck (Hangul: 이동혁)\nTanggal Lahir: 6 Juni 2000\nTempat Lahir : Seoul, South Korea\nKewarganegaraan : Korean\nPosisi: Main Vocalist\nSub-unit di NCT :  NCT U, NCT 127, NCT Dream";
            case "Johnny":
                return "Nama Panggung : Johnny (쟈니)\nNama Lengkap : John Suh\nNama Korea : Suh Young-ho (서영호)\nTanggal Lahir: 9 Februari 1995\nTempat Lahir : Chicago, Illinois, United States\nKewarganegaraan : Korean-American\nPosisi: Rapper, singer, dancer\nSub-unit di NCT : NCT U, NCT 127";
            case "Yuta":
                return "Nama Panggung : Yuta (Hangul: 유타)\nNAma Lengkap : Nakamoto Yuta (Kanji: 中本悠太)\nTanggal Lahir: 26 Oktober 1995\nTempat Lahir : Kadoma, Osaka, Japan\nKewarganegaraan : Japanese\nPosisi: Singer, rapper, dancer\nSub-unit di NCT :  NCT U, NCT 127";
            case "Doyoung":
                return "Nama Panggung : Doyoung (도영)\nNama Lengkap : Kim Doyoung (Hangul: 김동영)\nTanggal Lahir: 1 Februari 1996\nKewarganegaraan : Korean\nPosisi: Singer, actor\nSub-unit di NCT : NCT U, NCT 127, NCT DOJAEJUNG";
            case "Jungwoo":
                return "Nama Panggung : Jungwoo (Hangul: 정우)\nNama Lengkap : Kim Jungwoo (Hangul: 김정우)\nTanggal Lahir: 19 Februari 1998\nKewarganegaraan : Korean\nPosisi: Singer, dancer\nSub-unit di NCT : NCT U, NCT 127, NCT DOJAEJUNG";
            case "Taeil":
                return "Nama Panggung : Taeil (태일)\n Nama Lengkap : Moon Tae-il (문태일)\nTanggal Lahir : 14 Juni 1994\nTempat Lahir : Jangan-dong, Dongdaemun-gu, Seoul, South Korea\n Kewarganegaraan : Korean\nPosisi: Singer\nSub-Unit di NCT : NCT U, NCT 127";
                case "Jeno":
                return "Nama Panggung : Jeno (제노)\nNama Asli : Lee Je-no (이제노)\nTanggal Lahir : 23 April 2000\nTempat Lahir : Incheon, Korea Selatan\nKewarganegaraan : Korea\nPosisi: Lead Dancer, Lead Rapper, Sub Vocalist, Visual\nSub-unit di NCT : NCT Dream";
            case "Jaemin":
                return "Nama Panggung : Jaemin (재민)\nNama Asli : Na Jae-min (나재민)\nTanggal Lahir : 13 Agustus 2000\nTempat Lahir : Jeonju, Korea Selatan\nKewarganegaraan : Korea\nPosisi: Lead Dancer, Sub Vocalist, Sub Rapper, Visual\nSub-unit di NCT : NCT Dream";
            case "Renjun":
                return "Nama Panggung : Renjun (런쥔)\nNama Asli : Huang Renjun (黄仁俊)\nTanggal Lahir : 23 Maret 2000\nTempat Lahir : Jilin, Tiongkok\nKewarganegaraan : Tiongkok\nPosisi: Main Vocalist\nSub-unit di NCT : NCT Dream";
            case "Chenle":
                return "Nama Panggung : Chenle (천러)\nNama Asli : Zhong Chenle (钟辰乐)\nTanggal Lahir : 22 November 2001\nTempat Lahir : Shanghai, Tiongkok\nKewarganegaraan : Tiongkok\nPosisi: Main Vocalist\nSub-unit di NCT : NCT Dream";
            case "Jisung":
                return "Nama Panggung : Jisung (지성)\nNama Asli : Park Ji-sung (박지성)\nTanggal Lahir : 5 Februari 2002\nTempat Lahir : Seoul, Korea Selatan\nKewarganegaraan : Korea\nPosisi: Main Dancer, Sub Vocalist, Sub Rapper, Maknae\nSub-unit di NCT : NCT Dream";
            default:
                return "Biodata tidak ditemukan.";
        }
    }
    

    private void showBiodataPopup(String characterName, String imageName) {
        JFrame popupFrame = new JFrame(characterName + " - Biodata");
        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popupFrame.setSize(350, 500);
        popupFrame.setLocationRelativeTo(null);
    
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    
        try {
            InputStream imgStream = getClass().getClassLoader().getResourceAsStream(imageName);
            if (imgStream != null) {
                Image image = ImageIO.read(imgStream).getScaledInstance(250, 250, Image.SCALE_SMOOTH);
                JLabel imageLabel = new JLabel(new ImageIcon(image));
                imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(imageLabel);
            }
        } catch (IOException e) {
            System.err.println("Failed to load image in popup: " + e.getMessage());
        }
    
        panel.add(Box.createRigidArea(new Dimension(0, 15))); // spacer
    
        String biodata = getBiodata(characterName);
        JLabel biodataLabel = new JLabel("<html>" + biodata.replaceAll("\n", "<br>") + "</html>");
        biodataLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        biodataLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        biodataLabel.setForeground(Color.DARK_GRAY);
    
        panel.add(biodataLabel);
    
        popupFrame.add(panel);
        popupFrame.setVisible(true);
    }    

    private void showImageOnlyPopup(String characterName, String imageName) {
        try {
            InputStream imgStream = getClass().getClassLoader().getResourceAsStream(imageName);
            if (imgStream != null) {
                Image img = ImageIO.read(imgStream).getScaledInstance(300, 400, Image.SCALE_SMOOTH); // Ukuran popup seperti screenshot
                ImageIcon icon = new ImageIcon(img);
                JLabel imageLabel = new JLabel(icon);
    
                // Panel utama
                JPanel imagePanel = new JPanel();
                imagePanel.setBackground(Color.WHITE);
                imagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                imagePanel.add(imageLabel);
    
                // Dialog kustom
                JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), characterName, true);
                dialog.getContentPane().add(imagePanel);
                dialog.pack();
                dialog.setLocationRelativeTo(null); // Tampil di tengah layar
                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Gambar tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat gambar.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    
}
