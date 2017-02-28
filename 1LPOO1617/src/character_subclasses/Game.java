package character_subclasses;
import java.io.IOException;

import gui.Map;
import logic.Character;

public class Game {
	
	public Character[][] map;

	public static void main(String args[]) throws IOException{
		
		int game_state = 1;
		Game this_game = new Game();
		Map map = new Map(this_game, 1);
		map.drawMap();
		
		while(game_state == 1){
			//ask for user input
			System.out.println("Enter a direction:");
			//tries to move character
			if(map.hero.moveCharacter() != 0)
				map.drawMap();
			else
				System.out.println("You can't go there...");
			//restart
		}

	}
	
	public String getMapCoordinates(int x, int y){
		
		return this.map[x][y].getSymbol();
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
