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

	private JFrame frame;
	private JTextField numberOfOgresInput;
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
		numberOfOgres.setBounds(44, 32, 98, 16);
		panel.add(numberOfOgres);
		
		numberOfOgresInput = new JTextField();
		numberOfOgresInput.setBounds(154, 29, 116, 22);
		panel.add(numberOfOgresInput);
		numberOfOgresInput.setColumns(10);
		numberOfOgresInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ogre_input = numberOfOgresInput.getText();
			}
		});
		
		JLabel guardPersonality = new JLabel("Guard personality");
		guardPersonality.setBounds(44, 67, 100, 16);
		panel.add(guardPersonality);
		
		JComboBox<String> guardPersonalityInput = new JComboBox<String>();
		guardPersonalityInput.setBounds(154, 64, 116, 22);
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
		textAreaGameMap.setBounds(12, 113, 305, 210);
		Font font = new Font("Courier New", Font.PLAIN, 16);
		textAreaGameMap.setFont(font);
		textAreaGameMap.setEditable(false);
		panel.add(textAreaGameMap);
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
					g.playGame('w');
					g.getMap().drawMap();
					textAreaGameMap.setText(g.getMap().convertToGui());
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
					g.playGame('a');
					g.getMap().drawMap();
					textAreaGameMap.setText(g.getMap().convertToGui());
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
					g.playGame('d');
					g.getMap().drawMap();
					textAreaGameMap.setText(g.getMap().convertToGui());
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
					g.playGame('s');
					g.getMap().drawMap();
					textAreaGameMap.setText(g.getMap().convertToGui());
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
				textAreaGameMap.setText("Game Over...");
				
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
		
		JLabel lblGameStatus = new JLabel("game status");
		lblGameStatus.setBounds(12, 354, 530, 16);
		panel.add(lblGameStatus);
		
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
						Integer.parseInt(numberOfOgresInput.getText()) <= 0){
					lblGameStatus.setText("Invalid number of Ogres. Must be between 1 and 5!");
					return ;
				}
				}
				catch (NullPointerException | NumberFormatException e2){
					lblGameStatus.setText("Invalid number of Ogres. Must be between 1 and 5!");
					return ;
				}
				String o = numberOfOgresInput.getText();
				g = new Game(i, o);
				g.startGame();
				g.getMap().drawMap();
				textAreaGameMap.setText(g.getMap().convertToGui());
	    		
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


