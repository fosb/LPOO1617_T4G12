package character_subclasses;

import java.io.IOException;

import java.util.Random;

import logic.Game;
import logic.Character;

public class Ogre extends Character{

	public int randomNum;
	private Random randomGen = new Random();
	private Club club;
	private int stunned_status = 0;
	
	public Ogre(Game g, int x, int y) {// Basic Constructor
		
		super(g, x, y);
		
		this.symbol = " O "; // O - Normal, $ - Guarding Key
	}
	
	public Ogre(Game g, int x, int y, boolean club) {//Constructor Ogres with a Club
		
		super(g, x, y);
		
		if(club){
			this.club = new Club(this.g, this.posx, this.posy);
			this.club.setSymbol(" * ");
		}
		
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
		
		this.club.clearClub();
		
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
	
	public boolean canCharacterMove(char e){// Checks if there are no obstacles in the way of the movement
		
		switch (e){
		
		case 'w':	if(g.getMapCoordinates(this.posx-1,this.posy) == "   " || 
						g.getMapCoordinates(this.posx-1,this.posy) == " k " ||
						g.getMapCoordinates(this.posx-1,this.posy) == " S " ||
						g.getMapCoordinates(this.posx-1,this.posy) == " * " ||
						g.getMapCoordinates(this.posx-1,this.posy) == " O ")
						return true;
					break;
					
		case 's':	if(g.getMapCoordinates(this.posx+1,this.posy) == "   " || 
						g.getMapCoordinates(this.posx+1,this.posy) == " k " ||
						g.getMapCoordinates(this.posx+1,this.posy) == " S " ||
						g.getMapCoordinates(this.posx+1,this.posy) == " * "||
						g.getMapCoordinates(this.posx+1,this.posy) == " O ")
						return true;
					break;
		
		case 'a':	if(g.getMapCoordinates(this.posx,this.posy-1) == "   " || 
						g.getMapCoordinates(this.posx,this.posy-1) == " k " ||
						g.getMapCoordinates(this.posx,this.posy-1) == " S " ||
						g.getMapCoordinates(this.posx,this.posy-1) == " * "||
						g.getMapCoordinates(this.posx,this.posy-1) == " O ")
						return true;
					else if(this.symbol == " K " && g.getMapCoordinates(this.posx,this.posy-1) == " I "){
						this.g.getMap().getCharacter(this.posx, this.posy-1).setSymbol(" S ");
						this.skipTurn = true;
					}
					break;
			
		case 'd':	if(g.getMapCoordinates(this.posx,this.posy+1) == "   " || 
						g.getMapCoordinates(this.posx,this.posy+1) == " k " ||
						g.getMapCoordinates(this.posx,this.posy+1) == " S " ||
						g.getMapCoordinates(this.posx,this.posy+1) == " * "||
						g.getMapCoordinates(this.posx,this.posy+1) == " O ")
						return true;
		
		break;
		}
		
		return false;
	}
}
