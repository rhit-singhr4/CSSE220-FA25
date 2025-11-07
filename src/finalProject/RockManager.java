package finalProject;

import java.awt.Graphics;
import java.util.ArrayList;

public class RockManager {
	
	private ArrayList<Rock> rocks = new ArrayList<>();
	private SpriteManager sprite = new SpriteManager();
	
	private static final int SPEED = 6;
	
	private int maxRocks = 32;
	private int currentRocks = maxRocks;
	
	public RockManager() {
		sprite.loadRock();
	}
	
	public void addRocks(Player player) {
		if(currentRocks <= 0) {
			return;
		}
		
		int rockX = player.getX();
		int rockY = player.getY() + 15;
		
		Rock rock = new Rock(rockX, rockY, sprite.rockImage());
		rock.setFacingLeft(player.isFacingLeft());
		rocks.add(rock);
		currentRocks--;
	}
	
	public void update(int screenWidth) {
		for(int i = rocks.size() - 1; i >= 0; i-- ) {
			Rock rock = rocks.get(i);
			
			if(rock.isFacingLeft()) {
				rock.setX(rock.getX() - SPEED);
			} else {
				rock.setX(rock.getX() + SPEED);
			}
			
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
		return rocks;
	}

	public int getCurrentRocks() {
		return currentRocks;
	}

	public void setCurrentRocks(int currentRocks) {
		this.currentRocks = currentRocks;
	}
	
	
}
