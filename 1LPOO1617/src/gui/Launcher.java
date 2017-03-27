package gui;

import java.io.IOException;

public class Launcher {
	public static void main(String[] args) throws IOException {
		truegui window = new truegui();
		window.setVisible(true);
		if(window.getGame().checkState())
			return;
	}
}