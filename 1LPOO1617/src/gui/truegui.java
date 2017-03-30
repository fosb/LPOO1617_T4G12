package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

import logic.Game;

public class truegui extends JPanel {

	private JFrame frame;
	private JTextField numberOfOgresInput;
	private JTextField levelInput;
	private String ogre_input;
	private String guard_personality;
	private Game g;
	private ImageIcon image;
	
	public truegui() {
		initialize();
	}
	
	private void initialize() {
		g = new Game();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setPreferredSize(new Dimension(750, 650)); 
		JPanel panel = new drawBlock(); 
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true); 
		
		JLabel numberOfOgres = new JLabel("Number of Ogres");
		numberOfOgres.setBounds(46, 49, 98, 16);
		panel.add(numberOfOgres);
		
		numberOfOgresInput = new JTextField();
		numberOfOgresInput.setBounds(156, 46, 116, 22);
		panel.add(numberOfOgresInput);
		numberOfOgresInput.setColumns(10);
		numberOfOgresInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ogre_input = numberOfOgresInput.getText();
			}
		});
		
		JLabel lblGameStatus = new JLabel("game status");
		lblGameStatus.setBounds(12, 354, 530, 16);
		panel.add(lblGameStatus);
		
		JLabel guardPersonality = new JLabel("Guard personality");
		guardPersonality.setBounds(46, 81, 100, 16);
		panel.add(guardPersonality);
		
		JComboBox<String> guardPersonalityInput = new JComboBox<String>();
		guardPersonalityInput.setBounds(156, 78, 116, 22);
		panel.add(guardPersonalityInput);
		guardPersonalityInput.addItem(" ");
		guardPersonalityInput.addItem("Rookie");
		guardPersonalityInput.addItem("Drunken");
		guardPersonalityInput.addItem("Suspicious");
		
		guardPersonalityInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				guard_personality = (String) guardPersonalityInput.getSelectedItem();
			}
		});
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
					if(!g.playGame('w'))
						lblGameStatus.setText("You can't go there...");
					else
						lblGameStatus.setText("Next move?");
					g.getMap().drawMap();
					if(g.getLevel() == 2)
						g.getMap().getOgres().get(0).clearClubs();
					g.checkState();
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUp.setBounds(407, 185, 89, 25);
		panel.add(btnUp);
		btnUp.setEnabled(false);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
					if(!g.playGame('a'))
						lblGameStatus.setText("You can't go there...");
					else 
						lblGameStatus.setText("Next move?");
					g.getMap().drawMap();
					g.checkState();
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLeft.setBounds(352, 223, 89, 25);
		panel.add(btnLeft);
		btnLeft.setEnabled(false);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
					if(!g.playGame('d'))
						lblGameStatus.setText("You can't go there...");
					else 
						lblGameStatus.setText("Next move?");
					g.getMap().drawMap();
					g.checkState();
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRight.setBounds(453, 223, 89, 25);
		panel.add(btnRight);
		btnRight.setEnabled(false);
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
					if(!g.playGame('s'))
						lblGameStatus.setText("You can't go there...");
					else
						lblGameStatus.setText("Next move?");
					g.getMap().drawMap();
					g.checkState();
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDown.setBounds(407, 261, 89, 25);
		panel.add(btnDown);
		btnDown.setEnabled(false);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				g.setState(0);
				g.checkState();

				
				btnUp.setEnabled(false);
				btnLeft.setEnabled(false);
				btnDown.setEnabled(false);
				btnRight.setEnabled(false);
				btnExit.setEnabled(false);
			}
		});
		btnExit.setBounds(399, 64, 97, 25);
		panel.add(btnExit);
		btnExit.setEnabled(false);
		
		JLabel Level = new JLabel("Level");
		Level.setBounds(46, 16, 98, 16);
		panel.add(Level);
		
		levelInput = new JTextField();
		levelInput.setBounds(156, 13, 116, 22);
		panel.add(levelInput);
		levelInput.setColumns(10);
		levelInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ogre_input = numberOfOgresInput.getText();
			}
		});
		
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
				if(guardPersonalityInput.getSelectedIndex() == 0){
					lblGameStatus.setText("You need to choose a Guard Personality!");
					return ;
				}
				int i = guardPersonalityInput.getSelectedIndex();
				try{
				if(Integer.parseInt(numberOfOgresInput.getText()) > 5 || 
						Integer.parseInt(numberOfOgresInput.getText()) < 1){
					lblGameStatus.setText("Invalid number of Ogres. Must be between 1 and 5!");
					return ;
				}
				}
				catch (NullPointerException | NumberFormatException e2){
					lblGameStatus.setText("Invalid number of Ogres. Must be between 1 and 5!");
					return ;
				}
				try{
					if(Integer.parseInt(levelInput.getText()) > 2 || 
							Integer.parseInt(levelInput.getText()) < 1){
						lblGameStatus.setText("Invalid Level number. Must be between 1 and 2!");
						return ;
					}
				}
				catch (NullPointerException | NumberFormatException e2){
					lblGameStatus.setText("Invalid Level number. Must be between 1 and 2!");
					return ;
				}
				String l = levelInput.getText();
				String o = numberOfOgresInput.getText();
				g = new Game(i, o, l);
				g.startGame();
				g.getMap().drawMap();
				lblGameStatus.setText("Next move?");

	    		
				try {
					g.getMap().drawMap();						
					
				} catch (StringIndexOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				btnUp.setEnabled(true);
				btnLeft.setEnabled(true);
				btnDown.setEnabled(true);
				btnRight.setEnabled(true);
				btnExit.setEnabled(true);
			}
		});
		btnNewGame.setBounds(399, 29, 97, 25);
		panel.add(btnNewGame);	
		
		
	}
	
	private void checkState(JLabel x, JTextArea y){
		if(g.getLevel() == 1 && g.getState() == 2){
			x.setText("Congratulations");
			y.setText("And just when you thought your captivity had ended, you realise you still have another challenge to overcome...go through the Keep's Crazy Ogre.");
		}
		else if(g.getLevel() == 2 && g.getState() == 2){
			x.setText("Congratulations! Try Again? \nHit \"New Game\"!\n");
			y.setText("You escaped!");
		}			
		else if(g.getState() == 0){
			x.setText("Game over");
			y.setText("You lost... Try Again? \nHit \"New Game\"!\n");
			y.append(g.getMap().convertToGui());
		}
	}
	
	public int getNumberOfOgres(){
		
		int foo = Integer.parseInt(this.ogre_input);
		return foo;
	}
	
	public int getGuardPersonality(){
		
		switch(this.guard_personality){
		
		case "Rookie":
			return 1;
		case "Drunken":
			return 2;
		case "Suspicious":
			return 3;
		}
		
		return 0;
	}
	
	public Game getGame(){
		
		return this.g;
	}

}


