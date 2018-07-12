package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MyGUI {
	public static Border greenBorder = BorderFactory.createLineBorder(Color.decode("#1BBC9B"));
	public static Border margin = new EmptyBorder(0,50,0,50);
	
	//
	static class MyButton extends JButton {
		
		private Color hoverBackgroundColor = (Color.decode("#16A086"));
        private Color pressedBackgroundColor = (Color.decode("#373737"));

        public MyButton() {
            this(null);
        }

        public MyButton(String text) {
            super(text);
            super.setContentAreaFilled(false);
            super.setFocusPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isPressed()) {
                g.setColor(pressedBackgroundColor);
            } else if (getModel().isRollover()) {
                g.setColor(hoverBackgroundColor);
            } else {
                g.setColor(getBackground());
            }
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
        }

        @Override
        public void setContentAreaFilled(boolean b) {
        }

        public Color getHoverBackgroundColor() {
            return hoverBackgroundColor;
        }

        public void setHoverBackgroundColor(Color hoverBackgroundColor) {
            this.hoverBackgroundColor = hoverBackgroundColor;
        }

        public Color getPressedBackgroundColor() {
            return pressedBackgroundColor;
        }

        public void setPressedBackgroundColor(Color pressedBackgroundColor) {
            this.pressedBackgroundColor = pressedBackgroundColor;
        }
    }
}
