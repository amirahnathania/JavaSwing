package tugs.week;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SidebarButton extends JButton {

    public SidebarButton(String text) {
        super(text);
        setAlignmentX(Component.CENTER_ALIGNMENT); // Agar tetap di tengah secara vertikal
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // Lebar maksimal
        setMinimumSize(new Dimension(1, 40)); // Lebar minimal
        setPreferredSize(new Dimension(180, 40)); // Lebar preferred
        // setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(70, 70, 70));
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorderPainted(false);
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setOpaque(true);
        setHorizontalAlignment(SwingConstants.CENTER);
        

        // Mengatur agar tombol mengisi lebar container (Sidebar dengan BoxLayout)
        setAlignmentX(Component.LEFT_ALIGNMENT);

        addMouseListener(new MouseAdapter() {
            private Color originalBackground = getBackground();

            @Override
            public void mouseEntered(MouseEvent e) {
                originalBackground = getBackground();
                setBackground(new Color(90, 90, 90));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(originalBackground);
            }
        });
    }
}