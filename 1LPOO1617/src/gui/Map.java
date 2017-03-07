package gui;

import character_subclasses.Game;
import character_subclasses.Hero;

import java.util.ArrayList;

import character_subclasses.Blank;
import character_subclasses.Door;
import character_subclasses.Guard;
import character_subclasses.Lever;
import character_subclasses.Ogre;
import character_subclasses.Wall;
import logic.Character;

public class Map {

	private int type;
	private int width;
	public Character[][] map;
	private Hero hero;
	private Guard guard;
	private Ogre ogre;
	private Lever lever;
	private ArrayList<Door> doors = new ArrayList<Door>();
	
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
		
		String[][] map2 =
				 {{" X "," X "," X "," X "," X "," X "," X "," X "," X "},
				  {" I ","   ","   ","   "," O ","   ","   "," k "," X "},
				  {" X ","   ","   ","   ","   ","   ","   ","   "," X "},
				  {" X ","   ","   ","   ","   ","   ","   ","   "," X "},
				  {" X ","   ","   ","   ","   ","   ","   ","   "," X "},
				  {" X ","   ","   ","   ","   ","   ","   ","   "," X "},
				  {" X ","   ","   ","   ","   ","   ","   ","   "," X "},
				  {" X "," H ","   ","   ","   ","   ","   ","   "," X "},
				  {" X "," X "," X "," X "," X "," X "," X "," X "," X "}};
		
		if(type == 1){
			map = new Character[10][10];
			this.width = 10;
			this.convertMap(map1);
		}
		else if(type == 2){
			map = new Character[9][9];
			this.width = 9;
			this.convertMap(map2);
		}
	}
	public void drawMap(){
		
		int i = 0;
		while(i < this.width){
			int j = 0;
			while(j < this.width){
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
	
	public Hero getHero(){
		
		return this.hero;
	}
	
	public Guard getGuard(){
		
		return this.guard;
	}
	
	public Lever getLever(){
		
		return this.lever;
	}
	
	public ArrayList<Door> getDoors(){
		
		return this.doors;
	}
	
	public int getType(){
		
		return this.type;
	}
	
	private void convertMap(String[][] map){
		
		int i = 0;
		while(i < this.width){
			int j = 0;
			while(j < this.width){
				if(map[i][j] == " H "){
					Hero h = new Hero(game, i, j);
					this.map[i][j] = h;
					hero = h;
				}
				else if(map[i][j] == " G "){
					Guard g = new Guard(game, i, j);
					this.map[i][j] = g;
					guard = g;
				}
				else if(map[i][j] == " O "){
					Ogre o = new Ogre(game, i, j);
					this.map[i][j] = o;
					ogre = o;
				}
				else if(map[i][j] == " I "){
					if(i == 0 || j == 0){
						Door d = new Door(game, i, j, true);
						this.map[i][j] = d;
						doors.add(d);
					}
					else{
						Door d = new Door(game, i, j);
						this.map[i][j] = d;
						doors.add(d);
					}
				}
				else if(map[i][j] == " X "){
					Wall w = new Wall(game, i, j);
					this.map[i][j] = w;
				}
				else if(map[i][j] == " k "){
					Lever k = new Lever(game, i, j);
					this.map[i][j] = k;
					lever = k;
				}
				else if(map[i][j] == "   "){
					Blank b = new Blank(game, i, j);
					this.map[i][j] = b;
				}
				else
					System.out.println("Error creating Level " + this.type + " Map!(Unrecognised Symbol in map[]");
				j++;
			}
			i++;
		}
	}
	
	public void setType(int type){
		
		this.type = type;
	}
	public Ogre getOgre() {
		// TODO Auto-generated method stub
		return this.ogre;
	}
}
