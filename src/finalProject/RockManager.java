package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylon
 * The rock manager class deals with the rock logic and functionality of the rock.
 * The class spawns a rock when the spacebar is pressed and deals with the rock speed and when the rock should 
 * dissapear or not. It also sets the number of rocks the player is allowed to have.
 */

import java.awt.Graphics;
import java.util.ArrayList;

public class RockManager {
	
	private ArrayList<Rock> rocks = new ArrayList<>();
	private SpriteManager sprite = new SpriteManager();
	
	private static final int SPEED = 6;
	
	private int maxRocks = 100;
	private int currentRocks = maxRocks;
	
	public RockManager() {
		sprite.loadRock();
	}
	
	public void addRocks(Player player) {
		// No rocks can be spawned if the player has no more rocks available
		if(currentRocks <= 0) {
			return;
		}
		
		// Sets the spawn location of the rock
		int rockX = player.getX();
		int rockY = player.getY() + 15;
		
		Rock rock = new Rock(rockX, rockY, sprite.rockImage());
		rock.setFacingLeft(player.isFacingLeft());
		rocks.add(rock);
		currentRocks--;
	}
	
	public void update(int screenWidth) {
		// checks if the player has any rocks left and when one is used it gets rid of one of the rocks the player has
		for(int i = rocks.size() - 1; i >= 0; i-- ) {
			Rock rock = rocks.get(i);
			
			if(rock.isFacingLeft()) {
				rock.setX(rock.getX() - SPEED);
			} else {
				rock.setX(rock.getX() + SPEED);
			}
			
			// gets rid of the rock if it moves off the screen so the game doesn't keep loading it
			if(rock.getX() > screenWidth|| rock.getX() < 0) {
				rocks.remove(i);
			}
		}
	}
	
	public void draw(Graphics g) {
		for(Rock rock: rocks) {
			rock.draw(g);
		}
	}
	
	public ArrayList<Rock> getRocks() {
		// adds the rock to the array list
		return rocks;
	}

	public int getCurrentRocks() {
		// gets the value of how many rocks the player has
		return currentRocks;
	}

	public void setCurrentRocks(int currentRocks) {
		// keeps track of how many rocks are left
		this.currentRocks = currentRocks;
	}
	
	
}
