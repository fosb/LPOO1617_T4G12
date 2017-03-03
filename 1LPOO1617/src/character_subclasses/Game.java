package character_subclasses;
import java.io.IOException;

import gui.Map;
import logic.Character;

public class Game {
	
	public Map map;

	public static void main(String args[]) throws IOException{
		
		int game_state = 1;
		Game this_game = new Game();
		this_game.getMap().drawMap();
		
		while(game_state == 1){
			//ask for user input
			System.out.println("Enter a direction:");
			//tries to move character
			System.out.print(this_game.getMap().hero.posx);
			System.out.print(" ");
			System.out.println(this_game.getMap().hero.posy);
			
			if(this_game.getMap().hero.moveCharacter() != 0){
				System.out.println("TEST BREAK 2");
				this_game.getMap().drawMap();
			}
			else
				System.out.println("You can't go there...");
			//restart
		}

	}
	
	public Game(){
		
		map = new Map(this, 1);
	}
	
	public String getMapCoordinates(int x, int y){
		
			return this.map.getCharacter(x, y).getSymbol();
		
	}
	
	public Map getMap(){
		
		return map;
	}
	
	public void setMap(int posx, int posy, Character chr){
		
		this.getMap().map[posx][posy] = chr;
	}
	/*
	public void setMapEmpty(int x, int y){
		
		map[x][y] = "   ";
  	}
	
	public void updateMap(Character c, int direction){
		
		
		int next_posx = c.returnPosX();
		int next_posy = c.returnPosY();
		
		if(direction == 1){
			setMapEmpty(next_posx + 1, next_posy);
		}
		else if(direction == 2){
			
		}
		
	}*/
}
