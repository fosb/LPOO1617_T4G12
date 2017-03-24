package gui;

import character_subclasses.Hero;
import logic.Character;
import logic.Game;

import java.util.ArrayList;
import java.util.Random;

import character_subclasses.Blank;
import character_subclasses.Door;
import character_subclasses.Guard;
import character_subclasses.Lever;
import character_subclasses.Ogre;
import character_subclasses.Wall;

public class Map {

	private int type;
	private int width;
	public Character[][] map;
	private Hero hero;
	private Guard guard;
	private ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	private Lever lever;
	private ArrayList<Door> doors = new ArrayList<Door>();
	private Game game;
	private Random randomGen = new Random();
	private String[][] map1 =
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

	private String[][] map2 =
		    {{" X "," X "," X "," X "," X "," X "," X "," X "," X "},
		    {" I ","   ","   ","   ","   ","   ","   "," k "," X "},
		    {" X ","   ","   ","   ","   ","   ","   ","   "," X "},
		    {" X ","   ","   ","   ","   ","   ","   ","   "," X "},
		    {" X ","   ","   ","   ","   ","   ","   ","   "," X "},
		    {" X ","   ","   ","   ","   ","   ","   ","   "," X "},
		    {" X ","   ","   ","   ","   ","   ","   ","   "," X "},
		    {" X "," A ","   ","   ","   ","   ","   ","   "," X "},
		    {" X "," X "," X "," X "," X "," X "," X "," X "," X "}};

	private String[][] mapTeste1 =
		    {{" X "," X "," X "," X "," X "},
		    {" X "," H ","   "," G "," X "},
		    {" I ","   ","   ","   "," X "},
		    {" I "," k ","   ","   "," X "},
		    {" X "," X "," X "," X "," X "}};

	private String[][] mapTeste2 =
	        {{" X "," X "," X "," X "," X "},
	        {" X "," H ","   "," O "," X "},
	        {" I ","   ","   ","   "," X "},
	        {" I "," k ","   ","   "," X "},
	        {" X "," X "," X "," X "," X "}};
	
	public Map(Game game, int type){// Basic Constructor, type = Level #
		this.type = type;
		this.game = game;
		

		
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
		else if(type == 3){
			map = new Character[5][5];
			this.width = 5;
			this.convertMap(mapTeste1);
		}
		else if(type == 4){
			map = new Character[5][5];
			this.width = 5;
			this.convertMap(mapTeste2);
		}
	}
	public void drawMap(){// Draws the current game Map
		
		int i = 0;
		while(i < this.width){
			int j = 0;
			while(j < this.width){
				System.out.print(map[i][j].getSymbol());
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
	
	public ArrayList<Door> getDoors(){
		
		return this.doors;
	}
	
	public int getType(){
		
		return this.type;
	}
	
	private void convertMap(String[][] map){// Fills Character's Map with respective positions and characteristics
		
		int i = 0;
		while(i < this.width){
			int j = 0;
			while(j < this.width){
				if(map[i][j] == " H "){
					Hero h = new Hero(game, i, j, false);
					this.map[i][j] = h;
					hero = h;
				}
				else if(map[i][j] == " A "){
					Hero h = new Hero(game, i, j, true);
					this.map[i][j] = h;
					hero = h;
				}
				else if(map[i][j] == " G "){
					Guard g = new Guard(game, i, j);
					this.map[i][j] = g;
					guard = g;
				}
				else if(map[i][j] == " O "){
					Ogre o = new Ogre(game, i, j, true);
					this.map[i][j] = o;
					ogres.add(o);
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
		
		if(type == 2){
			map = new Character[9][9];
			this.setWidth(9);
			this.convertMap(map2);
		}
		
	}
	
	public void setWidth(int w){
		
		this.width = w;
	}
	
	public ArrayList<Ogre> getOgres() {
		
		return this.ogres;
	}
	
	public Lever getLever() {
		
		return this.lever;
	}
	
	public void createOgreArmy(){
		
		int ogreNumber;
		ogreNumber = randomGen.nextInt(3 - 2 + 1) + 2;
		
		while(ogreNumber != 0){
			//random.nextInt(max - min + 1) + min
			int posX = randomGen.nextInt(6 - 2 + 1) + 2;
			int posY = randomGen.nextInt(6 - 2 + 1) + 2;
			if(this.game.getMap().isCellEmpty(posX, posY) && posX <= 4 && posY >=4){
				Ogre o = new Ogre(this.game, posX, posY, true);
				map[posX][posY].setSymbol(" O ");
				ogres.add(o);
				ogreNumber--;
			}
		}
	}
	
	public Boolean isCellEmpty(int x, int y){
		
		if(this.map[x][y].getSymbol() == "   ")
			return true;
		else
			return false;
	}
}
