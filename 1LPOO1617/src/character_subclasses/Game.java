import java.io.IOException;

public class Game {
	
	static String[][] map;

	public static void main(String args[]) throws IOException{
		
		int game_state = 1;
		Game this_game = new Game();
		Hero this_hero = new Hero(this_game, 1, 1);
		
		this_game.createMap();
		this_game.drawMap();
		
		while(game_state == 1){
			//ask for user input
			System.out.println("Enter a direction:");
			//tries to move character
			if(this_hero.moveCharacter() != 0){
				//draw new map
				
			}
			
			//restart
		}

	}
	
	public void createMap(){
	
		String[][] map = {{" X "," X "," X "," X "," X "," X "," X "," X "," X "," X "},
		          		  {" X "," H ","   ","   "," I ","   "," X ","   "," G "," X "},
		                  {" X "," X "," X ","   "," X "," X "," X ","   ","   "," X "},
		                  {" X ","   "," I ","   "," I ","   "," X ","   ","   "," X "},
		                  {" X "," X "," X ","   "," X "," X "," X ","   ","   "," X "},
		                  {" I ","   ","   ","   ","   ","   ","   ","   ","   "," X "},
		                  {" I ","   ","   ","   ","   ","   ","   ","   ","   "," X "},
		                  {" X "," X "," X ","   "," X "," X "," X "," X ","   "," X "},
		                  {" X ","   "," I ","   "," I ","   "," X "," K ","   "," X "},
		                  {" X "," X "," X "," X "," X "," X "," X "," X "," X "," X "}};
	}
	
	public String[][] getMap(){
		
		return map;
	}
	
	public String getMapCoordinates(int x, int y){
		
		return map[x][y];
	}
	
	public void setMapEmpty(int x, int y){
		
		map[x][y] = "   ";
  	}
	
	public void drawMap(){
		int i = 0;
		while(i < 10){
			int j = 0;
			while(j < 10){
				System.out.print(getMapCoordinates(i,j));
				j++;
			}
			System.out.println();
			i++;
		}
	}
	
	public void updateMap(Character c, int direction){
		
		
		int next_posx = c.returnPosX();
		int next_posy = c.returnPosY();
		
		if(direction == 1){
			setMapEmpty(next_posx + 1, next_posy);
		}
		else if(direction == 2){
			
		}
		
	}
}
