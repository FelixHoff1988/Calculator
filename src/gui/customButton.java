package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.*;


public class customButton extends JButton {

    int radius = 15;
    private Color circleColor = Color.BLACK;
    private Color buttonColor = new Color(255,200,0);
    private Color buttonColorPressed = new Color(255,170,10);
    private Color buttonColorSelected = new Color(255,210,10);
    private Color invisibleColor = new Color(238,238,238);
    private Color textColor = Color.BLACK;

    private String buttonLabel = "test";
    public customButton(String label) {
        super(label);
        buttonLabel = label;
        this.setContentAreaFilled(false);
        this.setBackground(invisibleColor);
        this.setBorder(BorderFactory.createEmptyBorder());

    }

    /**
     * Dies ist ein erster Kommentar in VR. Der Plan ist in Zukunft ausschlieslich in VR zu Coden ;-*
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(getModel().isPressed()) {
            g.setColor(buttonColorPressed);
        } else if (getModel().isRollover()) {
            g.setColor(buttonColorSelected);
        } else {
            g.setColor(buttonColor);
        }
        g.fillRoundRect(2, 2, getSize().width-5, getSize().height-5, radius, radius);

        g.setColor(textColor);
        int labelDrawPosY = getSize().height/2 + (getFont().getSize())/2-2;
        g.drawString(buttonLabel,getSize().width/2,labelDrawPosY);

    }

    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width += size.height;
        return size;
    }
}
