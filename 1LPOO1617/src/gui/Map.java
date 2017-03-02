package gui;

import character_subclasses.Game;
import character_subclasses.Hero;
import character_subclasses.Blank;
import character_subclasses.Door;
import character_subclasses.Guard;
import character_subclasses.Lever;
import character_subclasses.Ogre;
import character_subclasses.Wall;
import logic.Character;

public class Map {
	
	int type;
	public Character[][] map = new Character[10][10];
	public Hero hero;
	Game game;
	
	public Map(Game game, int type){
		this.type = type;
		this.game = game;
		
		String[][] map1 =
				 {{" X "," X "," X "," X "," X "," X "," X "," X "," X "," X "},
        		  {" X "," H ","   ","   "," I ","   "," X ","   "," G "," X "},
                  {" X "," X "," X ","   "," X "," X "," X ","   ","   "," X "},
                  {" X ","   "," I ","   "," I ","   "," X ","   ","   "," X "},
                  {" X "," X "," X ","   "," X "," X "," X ","   ","   "," X "},
                  {" I ","   ","   ","   ","   ","   ","   ","   ","   "," X "},
                  {" I ","   ","   ","   ","   ","   ","   ","   ","   "," X "},
                  {" X "," X "," X ","   "," X "," X "," X "," X ","   "," X "},
                  {" X ","   "," I ","   "," I ","   "," X "," k ","   "," X "},
                  {" X "," X "," X "," X "," X "," X "," X "," X "," X "," X "}};
		
		if(type == 1){
			int i = 0;
			while(i < 10){
				int j = 0;
				while(j < 10){
					if(map1[i][j] == " H "){
						Hero h = new Hero(game, i, j);
						map[i][j] = h;
						hero = h;
					}
					else if(map1[i][j] == " G "){
						Guard g = new Guard(game, i, j);
						map[i][j] = g;
					}
					else if(map1[i][j] == " O "){
						Ogre o = new Ogre(game, i, j);
						map[i][j] = o;
					}
					else if(map1[i][j] == " I "){
						Door d = new Door(game, i, j);
						map[i][j] = d;
					}
					else if(map1[i][j] == " X "){
						Wall w = new Wall(game, i, j);
						map[i][j] = w;
					}
					else if(map1[i][j] == " k "){
						Lever k = new Lever(game, i, j);
						map[i][j] = k;
					}
					else if(map1[i][j] == "   "){
						Blank b = new Blank(game, i, j);
						map[i][j] = b;
					}
					else
						System.out.println("Error creating Level 1 Map!(Unrecognised Symbol in map1[]");
					j++;
				}
				i++;
			}
		}
	}
	public void drawMap(){
		
		int i = 0;
		while(i < 10){
			int j = 0;
			while(j < 10){
				System.out.print(map[i][j].symbol);
				j++;
			}
			System.out.println();
			i++;
		}
	}
	
	public Character getCharacter(int x, int y){
		
		return map[x][y];
	}
}
