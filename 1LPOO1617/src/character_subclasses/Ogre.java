package character_subclasses;

import java.io.IOException;

import java.util.Random;

import logic.Game;
import logic.Character;

public class Ogre extends Character{

	private int randomNum;
	private Random randomGen = new Random();
	private Club club;
	private int stunned_status = 0;
	
	public Ogre(Game g, int x, int y) {// Basic Constructor
		
		super(g, x, y);
		
		this.symbol = " O "; // O - Normal, $ - Guarding Key
	}
	
	public Ogre(Game g, int x, int y, boolean club) {//Constructor Ogres with a Club
		
		super(g, x, y);
		
		if(club)
			this.club = new Club(this.g, this.posx, this.posy);
		
		this.symbol = " O "; // O - Normal, $ - Guarding Key
	}
	

	public void checkForHero(Character hero){// Checks Hero's distance to the Ogre: TRUE if in adjacent tile
		
		int x = hero.getPosX(), y = hero.getPosY();
		
		if(Math.abs(x-this.posx)<=1 && Math.abs(y-this.posy)<=1){
			/*System.out.println("The Ogre caught you!");
			this.g.setState(0);*/
			stunned_status = 2;
		}
	}
	
	public void ogrePatrol() throws IOException{// Moves Ogre in a random valid direction(UP, DOWN, LEFT or RIGHT)
		
		if(stunned_status != 0){
			stunned_status--;
			return;
		}
		else{
			while(true){
				randomNum = randomGen.nextInt(4) + 1;
				
				if(randomNum == 1){
					if(this.moveCharacter('w') == 1)
						break;
				}
				else if(randomNum == 2){
					if(this.moveCharacter('a') == 1)
						break;
				}
				else if(randomNum == 3){
					if(this.moveCharacter('s') == 1)
						break;
				}
				else if(randomNum == 4){
					if(this.moveCharacter('d') == 1)
						break;
				}
				else{
					System.out.println("Error in ogrePatrol(), invalid randomNum generated!");
					break;
				}
			}			
		}

	}
	
	public void checkForKey(Lever key){// Changes Ogre to "guarding the key"(" $ ") if on top of it
		
		if(key.checkKey(this))
			this.symbol = " $ ";
		else
			this.symbol = " O ";
	}
	
	public Club getClub(){
		return this.club;
	}
	
	public void clearClubs(){
		for(int i = 0; i < this.g.getMap().getOgres().size(); i++)
			this.g.getMap().getOgres().get(i).getClub().clearClub();
	}
	
	public int getStunned(){
		return this.stunned_status;
	}
}
