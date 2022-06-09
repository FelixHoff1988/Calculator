package gui;
import java.awt.*;

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
     *
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
        int labelDrawPosX= getSize().width/2 - g.getFontMetrics().stringWidth(buttonLabel)/2;
        int labelDrawPosY = getSize().height/2 + (getFont().getSize())/2-2;
        if(getSize().width < getSize().height) {
            g.setFont(new Font("Arial", Font.BOLD, (getSize().width)/3));
        } else {
            g.setFont(new Font("Arial", Font.BOLD, (getSize().height)/3));
        }

        g.drawString(buttonLabel,labelDrawPosX,labelDrawPosY);
        if(buttonLabel.charAt(0) == '\u221A'){
            Graphics2D g2d = (Graphics2D) g.create();
            String text = "    ";
            FontMetrics fm = g2d.getFontMetrics();

            int textHeight = fm.getHeight();
            int textWidth = fm.stringWidth(text);

            int xPos = (labelDrawPosX+10);
            int yPos = ((getHeight() - textHeight) / 2) + fm.getAscent();

            g2d.setColor(Color.BLACK);
            g2d.drawString(text, xPos, yPos);

            g2d.drawLine(xPos, yPos - fm.getAscent(), xPos + textWidth, yPos - fm.getAscent());

            g2d.dispose();
        }


    }

    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width += size.height;
        return size;
    }
}
