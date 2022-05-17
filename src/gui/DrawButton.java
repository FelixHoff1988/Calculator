package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DrawButton extends JButton implements Border {

    private int radius;
    int len = 0;
    char [] chara = new char[len];

    public void setLen(int len) {
        this.len = len;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isSelected()) {
            setBorder(BorderFactory.createEmptyBorder());
        } else {
            setBorder(BorderFactory.createLoweredBevelBorder());
        }
    }
    public void setChara(char[] character) {
        setLen(character.length);
        chara = character;
    }

    DrawButton(int radius, char[] character) {
        setChara(character);
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.orange);
        g.fillRoundRect(x,y,width-1,height-1,radius,radius);
        g.setColor(Color.black);

        g.drawChars(chara, 0, chara.length, (width/2)-5, (height/2)+5);

        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
