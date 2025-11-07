 package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylo
 * The inputs class deals with all the controls for the player. This is where all the keys are set up.
 * where holding the right arrow moves right, holding the left arrow moves left, and pressing the up arrow jumps
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Inputs implements KeyListener{
	
	private Player player;
	private RockManager rocks;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private boolean spacePressed = false;

	public Inputs(Player player, RockManager rocks) {
		this.player = player;
		this.rocks = rocks;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode())	 {
		case KeyEvent.VK_UP -> player.jump();
		case KeyEvent.VK_LEFT -> leftPressed = true;
		case KeyEvent.VK_RIGHT -> rightPressed = true;
		case KeyEvent.VK_SPACE -> spacePressed = true;
		}
	}
	
	public void update() {
		if(leftPressed) {
			player.moveLeft();
		} else if(rightPressed) {
			player.moveRight();
		} else {
			player.setIdle(true);
		}
		
		if(spacePressed) {
			rocks.addRocks(player);
			spacePressed = false;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT -> leftPressed = false;
		case KeyEvent.VK_RIGHT -> rightPressed = false;
		case KeyEvent.VK_SPACE -> spacePressed = false;
		}
	}	
}
