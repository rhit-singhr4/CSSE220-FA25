 package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylon
 * The inputs class deals with all the controls for the player. This is where all the keys are set up.
 * where holding the right arrow moves right, holding the left arrow moves left, and pressing the up arrow jumps
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Inputs implements KeyListener{
	
	private Player player;
	private World world;
	private RockManager rocks;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private boolean spacePressed = false;

	public Inputs(Player player, RockManager rocks, World world) {
		this.player = player;
		this.rocks = rocks;
		this.world = world;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// Controls the players movements with a shoot, jump, move left, and move right
		switch(e.getKeyCode())	 {
		case KeyEvent.VK_R -> world.restartGame();
		case KeyEvent.VK_Q -> System.exit(0);
		case KeyEvent.VK_UP -> player.jump();
		case KeyEvent.VK_LEFT -> leftPressed = true;
		case KeyEvent.VK_RIGHT -> rightPressed = true;
		case KeyEvent.VK_SPACE -> spacePressed = true;
		}
	}
	
	public void update() {
		// updates the movement to switch the sprite being displayed based on the key pressed
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
	
	
	// This is so the action can only occur when the key is activly being pressed or held
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
