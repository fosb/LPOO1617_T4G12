package character_subclasses;

import java.io.IOException;

import java.util.Random;

import logic.Game;
import logic.Character;

public class Guard extends Character{

	private int i = 1, stun = 0;
	private boolean reverse = false;
	private Random randomGen = new Random();
	private String personality;
	
	public Guard(Game g, int x, int y, int personality) {// Basic Constructor, sets random Personality of the Guard
		
		super(g, x, y);
		
		this.symbol = " G "; // O - Normal, $ - Guarding Key
		//int randomNum = randomGen.nextInt(3) + 1;
		
		if(personality == 1){
			this.personality = "Rookie";
			System.out.println("This guard is a Rookie!");
		}
		else if(personality == 2){
			this.personality = "Drunken";
			System.out.println("This guard is a Drunkard!");
		}			
		else if(personality == 3){
			this.personality = "Suspicious";
			System.out.println("This guard is Suspicious!");
		}
	}
	
	public void checkForHero(Character hero){// Checks Hero's distance to the Guard: TRUE if adjacent
												// Ignores if Guard is "Passed out"(" g ")
		int x = hero.getPosX(), y = hero.getPosY();
		
		if(Math.abs(x-this.posx)<=1 && Math.abs(y-this.posy)<=1 && this.symbol != " g "){
			System.out.println("The Guard caught you!");
			this.g.setState(0);
		}
	}
	
	private void checkPersonality(){// Updates Guard's attributes according to it's personality
		if(this.personality == "Rookie"){				// Rookie: No special attributes
			
		}
		else if(this.personality == "Drunken"){			// Drunken: 1/6 chance to "Pass out"(stun) for 2 turns,
			int randomNum = randomGen.nextInt(6) + 1;	// 			Decrements "stun timer" every turn, 50% chance
														//          to reverse patrol pattern when "Waking up"
			if(this.stun != 0){
				this.stun--;
				if(this.stun == 0)
					this.symbol = " G ";
					if(randomNum > 3){
						this.reverse = !this.reverse;
						this.i = 26-this.i;
					}
			}		
			if(randomNum == 6){
				this.symbol = " g ";
				this.stun = 3;
			}
		}
		else if(this.personality == "Suspicious"){// Suspicious: 25% chance to reverse patrol pattern every turn
			int randomNum = randomGen.nextInt(4) + 1;
			
			if(randomNum == 1){
				this.reverse = !this.reverse;
				this.i = 26-this.i;
			}
		}
	}
	
	public void guardPatrol() throws IOException{// Moves Guard according to it's patrol pattern & Personality's
		this.checkPersonality();				 // attributes
		if(!this.reverse && this.stun == 0){
			if(this.i < 25){
				if(i == 1){
					this.moveCharacter('a');
					i++;
				}
				else if(i >= 2 && i <= 5){
					this.moveCharacter('s');
					i++;
				}
				else if(i >= 6 && i <= 11){
					this.moveCharacter('a');
					i++;
				}
				else if(i == 12){
					this.moveCharacter('s');
					i++;
				}
				else if(i >= 13 && i <= 19){
					this.moveCharacter('d');
					i++;
				}
				else if(i >= 20){
					this.moveCharacter('w');
					i++;
				}
			}
			else
				this.i = 1;
		}
		else if(this.stun == 0){
			if(this.i < 25){
				if(i == 24){
					this.moveCharacter('d');
					i++;
				}	
				else if(i >= 20){
					this.moveCharacter('w');
					i++;
				}
				else if(i >= 14 && i <= 19){
					this.moveCharacter('d');
					i++;
				}
				else if(i == 13){
					this.moveCharacter('w');
					i++;
				}
				else if(i >= 6 && i <= 12){
					this.moveCharacter('a');
					i++;
				}	
				else if(i >= 1 && i <= 5){
					this.moveCharacter('s');
					i++;
				}	
			}
			else
				this.i = 1;
		}
		
	}
}
