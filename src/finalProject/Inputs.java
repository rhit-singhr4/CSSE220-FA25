package finalProject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Inputs implements KeyListener{
	
	private Player player;
	private Game game;
	
	
	public Inputs(Player player, Game game) {
		this.player = player;
		this.game = game;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode())	 {
//		case KeyEvent.VK_UP -> player.jump();
		case KeyEvent.VK_LEFT -> player.moveLeft();
		case KeyEvent.VK_RIGHT -> player.moveRight();
		}
		game.repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		player.update();
		game.repaint();
	}
}
