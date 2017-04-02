package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

import logic.Game;

public class truegui extends JPanel{

	private JFrame frame;
	private JPanel panel;
	private JTextField numberOfOgresInput;
	private JTextField levelInput;
	private String ogre_input;
	private String guard_personality;
	private Game g;
	private ImageIcon image;
	
	public truegui() {
		initialize();
	}
	
	Timer timer = new Timer(10,new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  if(panel != null)
	    		  ((drawBlock) panel).updateGame(g.getMap());
	          repaint();
	      }
	    });
	    
	  
   
	
	private void initialize() {
		g = new Game();
		timer.start();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setPreferredSize(new Dimension(1500, 1000)); 
		JPanel panel = new drawBlock(g.getMap()); 
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		frame.pack();
		
		JLabel numberOfOgres = new JLabel("Number of Ogres");
		numberOfOgres.setBounds(252, 13, 98, 16);
		panel.add(numberOfOgres);
		
		numberOfOgresInput = new JTextField();
		numberOfOgresInput.setBounds(362, 10, 116, 22);
		panel.add(numberOfOgresInput);
		numberOfOgresInput.setColumns(10);
		numberOfOgresInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblGameStatus = new JLabel("game status");
		lblGameStatus.setBounds(12, 901, 530, 16);
		panel.add(lblGameStatus);
		
		JLabel guardPersonality = new JLabel("Guard personality");
		guardPersonality.setBounds(12, 13, 100, 16);
		panel.add(guardPersonality);
		
		JComboBox<String> guardPersonalityInput = new JComboBox<String>();
		guardPersonalityInput.setBounds(124, 10, 116, 22);
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
		
		JTextArea textAreaGameMap = new JTextArea();
		textAreaGameMap.setBounds(1063, 609, 305, 210);
		Font font = new Font("Courier New", Font.PLAIN, 16);
		textAreaGameMap.setFont(font);
		textAreaGameMap.setEditable(false);
		panel.add(textAreaGameMap);		
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
					if(!g.playGame('w'))
						lblGameStatus.setText("You can't go there...");
					else
						lblGameStatus.setText("Next move?");
					g.getMap().drawMap();
					textAreaGameMap.setText(g.getMap().convertToGui());
					checkState(lblGameStatus, textAreaGameMap);
					if(g.getLevel() == 2)
						g.getMap().getOgres().get(0).clearClubs();
					repaint();
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUp.setBounds(1153, 333, 89, 25);
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
					textAreaGameMap.setText(g.getMap().convertToGui());
					checkState(lblGameStatus, textAreaGameMap);
					if(g.getLevel() == 2)
						g.getMap().getOgres().get(0).clearClubs();
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLeft.setBounds(1015, 414, 89, 25);
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
					textAreaGameMap.setText(g.getMap().convertToGui());
					checkState(lblGameStatus, textAreaGameMap);
					if(g.getLevel() == 2)
						g.getMap().getOgres().get(0).clearClubs();
					((drawBlock) panel).updateGame(g.getMap());
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRight.setBounds(1304, 414, 89, 25);
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
					textAreaGameMap.setText(g.getMap().convertToGui());
					checkState(lblGameStatus, textAreaGameMap);
					if(g.getLevel() == 2)
						g.getMap().getOgres().get(0).clearClubs();
					((drawBlock) panel).updateGame(g.getMap());
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDown.setBounds(1153, 493, 89, 25);
		panel.add(btnDown);
		btnDown.setEnabled(false);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				g.setState(0);
				g.checkState();
				textAreaGameMap.setText("Game Over... Try Again? \nHit \"New Game\"!");
				lblGameStatus.setText("Game Over...");
				
				btnUp.setEnabled(false);
				btnLeft.setEnabled(false);
				btnDown.setEnabled(false);
				btnRight.setEnabled(false);
				btnExit.setEnabled(false);
			}
		});
		btnExit.setBounds(1165, 93, 97, 25);
		panel.add(btnExit);
		btnExit.setEnabled(false);
		
		JLabel Level = new JLabel("Level");
		Level.setBounds(490, 13, 29, 16);
		panel.add(Level);
		
		levelInput = new JTextField();
		levelInput.setBounds(531, 10, 116, 22);
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
				textAreaGameMap.setText(g.getMap().convertToGui());
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
		btnNewGame.setBounds(1165, 39, 97, 25);
		panel.add(btnNewGame);	
		frame.setVisible(true);
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


