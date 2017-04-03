package gui;

import java.io.IOException;

public class Launcher {
	public static void main(String[] args) throws IOException {
		
		truegui mywindow = new truegui();
		if(mywindow.getGame().checkState())
			return;
		
	}
}