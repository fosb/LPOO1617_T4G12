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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel numberOfOgres = new JLabel("Number of Ogres");
		numberOfOgres.setBounds(12, 29, 98, 16);
		panel.add(numberOfOgres);
		
		numberOfOgresInput = new JTextField();
		numberOfOgresInput.setBounds(122, 26, 116, 22);
		panel.add(numberOfOgresInput);
		numberOfOgresInput.setColumns(10);
		numberOfOgresInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ogre_input = numberOfOgresInput.getText();
			}
		});
		
		JLabel guardPersonality = new JLabel("Guard personality");
		guardPersonality.setBounds(12, 64, 100, 16);
		panel.add(guardPersonality);
		
		JComboBox<String> guardPersonalityInput = new JComboBox<String>();
		guardPersonalityInput.setBounds(122, 61, 116, 22);
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
				
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(297, 60, 97, 25);
		panel.add(btnExit);
		
		JTextArea textAreaGameMap = new JTextArea();
		textAreaGameMap.setBounds(12, 113, 226, 111);
		Font font = new Font("Courier New", Font.PLAIN, 16);
		textAreaGameMap.setFont(font);
		textAreaGameMap.setEditable(false);
		panel.add(textAreaGameMap);
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
					g.playGame('w');
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUp.setBounds(297, 106, 89, 25);
		panel.add(btnUp);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
					g.playGame('a');
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLeft.setBounds(242, 144, 89, 25);
		panel.add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
					g.playGame('d');
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRight.setBounds(343, 144, 89, 25);
		panel.add(btnRight);
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
					g.playGame('s');
				} catch (StringIndexOutOfBoundsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDown.setBounds(297, 182, 89, 25);
		panel.add(btnDown);
			
		JLabel lblGameStatus = new JLabel("game status");
		lblGameStatus.setBounds(12, 224, 226, 16);
		panel.add(lblGameStatus);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = guardPersonalityInput.getSelectedIndex();
				String o = numberOfOgresInput.getText();
				g = new Game(i, o);
				g.startGame();
				g.getMap().drawMap();
				textAreaGameMap.append(g.getMap().convertToGui());
	    		
				try {
					g.getMap().drawMap();						
					
				} catch (StringIndexOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewGame.setBounds(297, 25, 97, 25);
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


