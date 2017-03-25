package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gamegui {

	private JFrame frame;
	private JTextField numberOfOgresInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gamegui window = new gamegui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gamegui() {
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
		
		JLabel guardPersonality = new JLabel("Guard personality");
		guardPersonality.setBounds(12, 64, 100, 16);
		panel.add(guardPersonality);
		
		JComboBox guardPersonalityInput = new JComboBox();
		guardPersonalityInput.setBounds(122, 61, 116, 22);
		panel.add(guardPersonalityInput);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(297, 25, 97, 25);
		panel.add(btnNewGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(297, 60, 97, 25);
		panel.add(btnExit);
		
		JTextArea textAreaGameMap = new JTextArea();
		textAreaGameMap.setBounds(12, 113, 226, 111);
		panel.add(textAreaGameMap);
		
		JButton btnUp = new JButton("Up");
		btnUp.setBounds(297, 106, 89, 25);
		panel.add(btnUp);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.setBounds(242, 144, 89, 25);
		panel.add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRight.setBounds(343, 144, 89, 25);
		panel.add(btnRight);
		
		JButton btnDown = new JButton("Down");
		btnDown.setBounds(297, 182, 89, 25);
		panel.add(btnDown);
		
		JLabel lblGameStatus = new JLabel("game status");
		lblGameStatus.setBounds(12, 224, 226, 16);
		panel.add(lblGameStatus);
	}
}
