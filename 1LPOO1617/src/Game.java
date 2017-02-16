
public class Game {
	
	static String[][] map;

	public static void main(String args[]){
		
		Game this_game = new Game();
		
		createMap();
		
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
	
	public static void createMap(){
	
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
	
	public static String getMapCoordinates(int x, int y){
		
		return map[x][y];
	}
}
