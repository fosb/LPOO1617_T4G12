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
	
	public Guard(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.symbol = " G "; // O - Normal, $ - Guarding Key
		int randomNum = randomGen.nextInt(3) + 1;
		
		if(randomNum == 1){
			this.personality = "Rookie";
			System.out.println("This guard is a Rookie!");
		}
		else if(randomNum == 2){
			this.personality = "Drunken";
			System.out.println("This guard is a Drunkard!");
		}			
		else if(randomNum == 3){
			this.personality = "Suspicious";
			System.out.println("This guard is Suspicious!");
		}
	}
	
	public boolean checkForHero(Character hero){
		
		int x = hero.getPosX(), y = hero.getPosY();
		
		if(Math.abs(x-this.posx)<=1 && Math.abs(y-this.posy)<=1 && this.symbol != " g ")
			return true;
		
		else
			return false;
	}
	
	private void checkPersonality(){
		if(this.personality == "Rookie"){
			
		}
		else if(this.personality == "Drunken"){
			int randomNum = randomGen.nextInt(6) + 1;
			
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
				this.stun = 2;
			}
		}
		else if(this.personality == "Suspicious"){
			int randomNum = randomGen.nextInt(4) + 1;
			
			if(randomNum == 1){
				this.reverse = !this.reverse;
				this.i = 26-this.i;
			}
		}
	}
	
	public void guardPatrol() throws IOException{
		this.checkPersonality();
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
