package gui;

import java.awt.*;
import java.io.File;

import javax.swing.*;

public class drawBlock extends JPanel{

	public drawBlock(){
		
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	    ImageIcon image = new ImageIcon("images\\castle.png");
	    g.drawImage(image.getImage(), 50, 100, this);
	}
}
