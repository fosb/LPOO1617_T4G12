package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import logic.Game;

public class truegui extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnUp = new JButton("Up");
	private JButton btnLeft = new JButton("Left");
	private JButton btnRight = new JButton("Right");
	private JButton btnDown = new JButton("Down");
	private JButton btnNewGame = new JButton("New Game");
	private JButton btnExit = new JButton("Exit");
	private JFrame frame;
	private JTextField numberOfOgresInput;
	private JTextField levelInput;
	private String ogre_input;
	private String guard_personality;
	private Game g;
	
	/**
	 * Create the panel.
	 */
	public truegui() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
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
		
		JTextArea textAreaGameMap = new JTextArea();
		textAreaGameMap.setWrapStyleWord(true);
		textAreaGameMap.setLineWrap(true);
		textAreaGameMap.setBounds(12, 113, 305, 210);
		Font font = new Font("Courier New", Font.PLAIN, 16);
		textAreaGameMap.setFont(font);
		textAreaGameMap.setEditable(false);
		panel.add(textAreaGameMap);
		
		//Button Up
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if(g.getState() == 0 || g.getState() == 3)
					return;
				try {
					if(g.getLevel() == 2)
						g.getMap().getOgres().get(0).clearClubs();
					if(!g.playGame('w'))
						lblGameStatus.setText("You can't go there...");
					else
						lblGameStatus.setText("Next move?");
					g.getMap().drawMap();
					textAreaGameMap.setText(g.getMap().convertToGui());
					if(!checkState(lblGameStatus, textAreaGameMap))
						return;
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUp.setBounds(407, 185, 89, 25);
		panel.add(btnUp);
		btnUp.setEnabled(false);
		
		//Button Left
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if(g.getState() == 0 || g.getState() == 3)
					return;
				try {
					if(g.getLevel() == 2)
						g.getMap().getOgres().get(0).clearClubs();
					if(!g.playGame('a'))
						lblGameStatus.setText("You can't go there...");
					else 
						lblGameStatus.setText("Next move?");
					g.getMap().drawMap();
					textAreaGameMap.setText(g.getMap().convertToGui());
					if(!checkState(lblGameStatus, textAreaGameMap))
						return;
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLeft.setBounds(352, 223, 89, 25);
		panel.add(btnLeft);
		btnLeft.setEnabled(false);
		
		//Button Right
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if(g.getState() == 0 || g.getState() == 3)
					return;
				try {
					if(g.getLevel() == 2)
						g.getMap().getOgres().get(0).clearClubs();
					if(!g.playGame('d'))
						lblGameStatus.setText("You can't go there...");
					else 
						lblGameStatus.setText("Next move?");
					g.getMap().drawMap();
					textAreaGameMap.setText(g.getMap().convertToGui());
					if(!checkState(lblGameStatus, textAreaGameMap))
						return;
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRight.setBounds(453, 223, 89, 25);
		panel.add(btnRight);
		btnRight.setEnabled(false);
		
		//Button Down
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
					if(g.getLevel() == 2)
						g.getMap().getOgres().get(0).clearClubs();
					if(!g.playGame('s'))
						lblGameStatus.setText("You can't go there...");
					else
						lblGameStatus.setText("Next move?");
					g.getMap().drawMap();
					textAreaGameMap.setText(g.getMap().convertToGui());
					if(!checkState(lblGameStatus, textAreaGameMap))
						return;
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDown.setBounds(407, 261, 89, 25);
		panel.add(btnDown);
		btnDown.setEnabled(false);
		
		//Button Exit
		btnExit.addActionListener(new ActionListener(){
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
		
		
		//Button New Game
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				if(guardPersonalityInput.getSelectedIndex() == 0 && Integer.parseInt(levelInput.getText()) == 1){
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
		btnNewGame.setBounds(399, 29, 97, 25);
		panel.add(btnNewGame);

        frame.setVisible(true);
	}
	
	private boolean checkState(JLabel x, JTextArea y){
		if(g.getLevel() == 1 && g.getState() == 2){
			x.setText("Congratulations!");
			y.setText("And just when you thought your captivity had ended, you realise you still have another "
					+ "challenge to overcome...go through the Keep's Crazy Ogre.\n(Choose any direction)");
			return true;
		}
		else if(g.getState() == 3){
			y.setText("Congratulations! Try Again? \nHit \"New Game\"!\n");
			x.setText("You escaped!");
			btnUp.setEnabled(false);
			btnLeft.setEnabled(false);
			btnDown.setEnabled(false);
			btnRight.setEnabled(false);
			btnExit.setEnabled(false);
			return false;
		}			
		else if(g.getState() == 0){
			x.setText("Game over");
			y.setText("You lost... Try Again? \nHit \"New Game\"!\n");
			y.append(g.getMap().convertToGui());
			return false;
		}
		else
			return true;
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


