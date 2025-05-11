package tugs.week;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class SidebarButton extends JButton {

    private static final Color DEFAULT_BACKGROUND = new Color(70, 70, 70);
    private static final Color HOVER_BACKGROUND = new Color(90, 90, 90);

    public SidebarButton(String text) {
        super(text);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        setMinimumSize(new Dimension(1, 40));
        setPreferredSize(new Dimension(180, 40));
        setBackground(DEFAULT_BACKGROUND);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorderPainted(false);
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setOpaque(true);
        setHorizontalAlignment(SwingConstants.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(HOVER_BACKGROUND);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(DEFAULT_BACKGROUND);
            }
        });
    }
}