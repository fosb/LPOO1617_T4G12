package gui;

import character_subclasses.Game;

public class Map {
	
	int type;
	Character[][] map;
	Game game;
	
	public Map(Game game, int type){
		this.type = type;
		this.game = game;
		
		String[][] map1 = {{" X "," X "," X "," X "," X "," X "," X "," X "," X "," X "},
        		  {" X "," H ","   ","   "," I ","   "," X ","   "," G "," X "},
                  {" X "," X "," X ","   "," X "," X "," X ","   ","   "," X "},
                  {" X ","   "," I ","   "," I ","   "," X ","   ","   "," X "},
                  {" X "," X "," X ","   "," X "," X "," X ","   ","   "," X "},
                  {" I ","   ","   ","   ","   ","   ","   ","   ","   "," X "},
                  {" I ","   ","   ","   ","   ","   ","   ","   ","   "," X "},
                  {" X "," X "," X ","   "," X "," X "," X "," X ","   "," X "},
                  {" X ","   "," I ","   "," I ","   "," X "," K ","   "," X "},
                  {" X "," X "," X "," X "," X "," X "," X "," X "," X "," X "}};
		
		if(type == 1){
			int i = 0;
			while(i < 10){
				int j = 0;
				while(j < 10){
					if(map1[i][j] == " H "){
						
					}
					j++;
				}
				
				i++;
		}
	}
	
	
	/*public void drawMap(){
		
		int i = 0;
		while(i < 10){
			int j = 0;
			while(j < 10){
				System.out.print(map(i,j));
				j++;
			}
			System.out.println();
			i++;
		}
	}*/

}
