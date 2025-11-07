package finalProject;

import java.awt.Graphics;

public class World {
	
	private int currentLevel = 1;

	private final HUD hud = new HUD();
	private final CollectiblesManager collectibles = new CollectiblesManager();
	private final EnemyManager enemies = new EnemyManager();
	private final RockManager rocks = new RockManager();
	private final PlatformManager platforms = new PlatformManager();
	private final Player player = new Player();
	private final LevelManager levels = new LevelManager(platforms);
	private final Inputs inputs = new Inputs(player, rocks);
	private final CollisionManager collisions = new CollisionManager(hud, player, platforms, enemies, collectibles,
			rocks);
	
	public World() {
		loadLevel(currentLevel);
		for (Platform platform : platforms.getPlatforms()) {
			enemies.addEnemies(platform);
			collectibles.addCollectibles(platform);
		}
	}
	
	public Inputs getInputs() {
		return inputs;
	}

	public void update(int width, int height) {
		inputs.update();
		player.update(height, width);
		rocks.update(width);
		hud.setRocks(rocks.getCurrentRocks());
		collisions.playerToPlatformsCollision();
		collisions.playerToEnemyCollision();
		collisions.playerToCollectibles();
		collisions.rockToEnemyCollision();
		player.updatePlayerSprite();
		enemies.update();
		
		int currentScore = hud.getScore();
		if(currentScore >= 42 && currentLevel == 1) {
			currentLevel = 2;
			loadLevel(currentLevel);
		}
	}
	
	public void loadLevel(int level) {
		platforms.clearPlatforms();
		enemies.clearEnemies();
		collectibles.clearCollectibles();
		
		if(level == 1) {
			levels.level1();
		} else if(level == 2) {
			levels.level2();
		}
		
		for (Platform platform : platforms.getPlatforms()) {
			enemies.addEnemies(platform);
			collectibles.addCollectibles(platform);
		}
	}

	public void draw(Graphics g, int width, int height) {
		g.fillRect(0, 0, width, height);
		platforms.draw(g, width, height);
		rocks.draw(g);
		enemies.draw(g);
		player.draw(g);
		collectibles.draw(g);
		hud.draw(g);
	}

	public int getCurrentLevel() {
		return currentLevel;
	}
	
	
}
