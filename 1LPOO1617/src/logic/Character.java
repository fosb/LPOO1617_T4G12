package logic;
import java.io.IOException;
import java.util.Scanner;

import character_subclasses.Game;

public class Character {
	
	//pode ser Hero Ogre Guard Wall Lever OpenDoor ClosedDoor Blank
	public int posx, posy;
	public Game g;
	public String symbol;
	
	public Character(Game game, int x, int y){
		g = game;
		posx = x;
		posy = y;
	}
	
	public int returnPosX(){
		
		return posx;
	}
	
	public int returnPosY(){
		
		
		return posy;
	}
	
	public int moveCharacter() throws IOException{
		
		System.out.println("moveCharacter()");
		//char c = (char) System.in.read();
		Scanner in = new Scanner(System.in);
		String move;
		move = in.nextLine();
		char e = move.charAt(0);
		
		switch (e){
		//UP
		case 'w':	if(canCharacterMove(e)){
						posx-=1;
						return 1;
					}
					break;
		//DOWN			
		case 's':	if(canCharacterMove(e)){
						posx+=1;
						return 1;
					}
					break;
		//LEFT
		case 'a':	if(canCharacterMove(e)){
						posy-=1;
						return 1;
					}
					break;
		//RIGHT
		case 'd':	if(canCharacterMove(e)){
						posy+=1;
						return 1;
					}
					break;
		}
		
		return 0;
	}
	
	public boolean canCharacterMove(char e){
		
		System.out.println("canCharacterMove()");
		switch (e){
		
		case 'w':	if(g.getMapCoordinates(this.posx-1,this.posy) == "   ")
						return true;
					break;
					
		case 's':	if(g.getMapCoordinates(this.posx+1,this.posy+1) == "   ")
						return true;
					break;
		
		case 'a':	if(g.getMapCoordinates(this.posx,this.posy-1) == "   ")
						return true;
					break;
			
		case 'd':	if(g.getMapCoordinates(this.posx,this.posy+1) == "   ")
						return true;
					break;
		}
		
		return false;
	}

	public Character getCharacter(){
		
		return this;
	}
	
	public String getSymbol(){
		
		return this.symbol;
	}
	
	/*public void setSymbol(String s){
		
		this.symbol = s;
	}*/
	/*public String getCaracter(){
		
		//return this.caracter;
	}*/
}
