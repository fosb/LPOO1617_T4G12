package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import logic.Game;


public class drawBlock extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
	
	private Map m;

	public drawBlock(Map m){
		this.m = m;
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		repaint();
	}
	
	public void updateGame(Map m){
		this.m = m;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintMap(g);
	}
	
	public void paintMap(Graphics g){
		
		int i = 0;
		int posx = 100;
		int posy = 100;

		while(i < m.getWidth()){
			int j = 0;
			while(j < m.getWidth()){
				resolveSquare(g, posx, posy, m.map[i][j].getSymbol());
				posx += 70;
				j++;
			}
			posx = 100;
			posy += 70;
			i++;
		}
	}
	
	public void resolveSquare(Graphics g, int x, int y, String c){
		
		if(c == "   ")
			paintSquare(g,x,y,"castleCenter");
		else if(c == " * ")
			paintSquare(g,x,y,"tochLit");
		else if(c == " S " || c == " I ")
			paintSquare(g,x,y,"door_closedMid");
		else if(c == " G ")
			paintSquare(g,x,y,"p2_stand");
		else if(c == " H " || c == " A ")
			paintSquare(g,x,y,"p1_stand");
		else if(c == " O ")
			paintSquare(g,x,y,"p3_stand");
		else if(c == " X ")
			paintSquare(g,x,y,"brickWall");
			
		

	}
	
	public void paintSquare(Graphics g, int x, int y, String c){
		
	    ImageIcon image = new ImageIcon("images\\" + c + ".png");
	    g.drawImage(image.getImage(), x, y, this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
