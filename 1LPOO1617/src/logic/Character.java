package logic;
import java.io.IOException;
import java.util.Scanner;

import character_subclasses.Blank;
import logic.Game;

public class Character {
	
	//pode ser Hero Ogre Guard Wall Lever OpenDoor ClosedDoor Blank
	protected int posx, posy;
	protected Game g;
	protected String symbol;
	protected boolean skipTurn = false;
	
	public Character(Game game, int x, int y){
		g = game;
		posx = x;
		posy = y;
	}
	
	public int getPosX(){
		
		return posx;
	}
	
	public int getPosY(){
		
		
		return posy;
	}
	
	public char checkDirection() throws StringIndexOutOfBoundsException{
		
		//char c = (char) System.in.read();
		Scanner in = new Scanner(System.in);
		String move = null;
		char e = '\0';
		
		move = in.nextLine();
		try{
			e = move.charAt(0);
		}
		catch(StringIndexOutOfBoundsException ola){
			System.out.println("Please insert a valid direction!");
		}
		return e;
	}
	
	public int moveCharacter(char e) throws IOException{
		
		//char e = move.charAt(0);
		
		switch (e){
		//UP
		case 'w':	if(canCharacterMove(e)){
			
						Character chr = new Blank(g, posx, posy);
						g.setMap(posx, posy, chr);
						g.setMap(posx-1, posy, this);
						posx--;
						return 1;
					}
					break;
		//DOWN			
		case 's':	if(canCharacterMove(e)){
						Character chr = new Blank(g, posx, posy);
						g.setMap(posx, posy, chr);
						g.setMap(posx+1, posy, this);
						posx++;
						return 1;
					}
					break;
		//LEFT
		case 'a':	if(canCharacterMove(e)){
						Character chr = new Blank(g, posx, posy);
						g.setMap(posx, posy, chr);
						g.setMap(posx, posy-1, this);
						posy--;
						return 1;
					}

					else if(this.skipTurn){
						this.skipTurn = false;
						return 1;
					}
					break;
		//RIGHT
		case 'd':	if(canCharacterMove(e)){
						Character chr = new Blank(g, posx, posy);
						g.setMap(posx, posy, chr);
						g.setMap(posx, posy+1, this);
						posy++;
						return 1;
					}
					break;
		}
		return 0;
	}
	
	public boolean canCharacterMove(char e){
		
		switch (e){
		
		case 'w':	if(g.getMapCoordinates(this.posx-1,this.posy) == "   " || 
						g.getMapCoordinates(this.posx-1,this.posy) == " k " ||
						g.getMapCoordinates(this.posx-1,this.posy) == " S " ||
						g.getMapCoordinates(this.posx-1,this.posy) == " * ")
						return true;
					break;
					
		case 's':	if(g.getMapCoordinates(this.posx+1,this.posy) == "   " || 
						g.getMapCoordinates(this.posx+1,this.posy) == " k " ||
						g.getMapCoordinates(this.posx+1,this.posy) == " S " ||
						g.getMapCoordinates(this.posx+1,this.posy) == " * ")
						return true;
					break;
		
		case 'a':	if(g.getMapCoordinates(this.posx,this.posy-1) == "   " || 
						g.getMapCoordinates(this.posx,this.posy-1) == " k " ||
						g.getMapCoordinates(this.posx,this.posy-1) == " S " ||
						g.getMapCoordinates(this.posx,this.posy-1) == " * ")
						return true;
					else if(this.symbol == " K " && g.getMapCoordinates(this.posx,this.posy-1) == " I "){
						this.g.getMap().getDoors().get(0).setSymbol(" S ");
						this.skipTurn = true;
					}
					break;
			
		case 'd':	if(g.getMapCoordinates(this.posx,this.posy+1) == "   " || 
						g.getMapCoordinates(this.posx,this.posy+1) == " k " ||
						g.getMapCoordinates(this.posx,this.posy+1) == " S " ||
						g.getMapCoordinates(this.posx,this.posy+1) == " * ")
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

	public void setSymbol(String string) {		
		this.symbol = string;
	}
	
	public void setPosX(int x){
		this.posx = x;
	}
	
	public void setPosY(int y){
		this.posy = y;
	}
	
	/*public void setSymbol(String s){
		
		this.symbol = s;
	}*/
	/*public String getCaracter(){
		
		//return this.caracter;
	}*/
}
