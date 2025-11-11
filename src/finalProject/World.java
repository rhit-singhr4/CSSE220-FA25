package finalProject;

import java.awt.Graphics;

public class World {
	
	private int currentLevel = 1;
	private boolean gameOver = false;
	private boolean playerWon = false;

	private final HUD hud = new HUD();
	private final CollectiblesManager collectibles = new CollectiblesManager();
	private final EnemyManager enemies = new EnemyManager();
	private final RockManager rocks = new RockManager();
	private final PlatformManager platforms = new PlatformManager();
	private final Player player = new Player();
	private final LevelManager levels = new LevelManager(platforms, player);
	private final Inputs inputs; 
	private final SpriteManager sprite = new SpriteManager();
	private final CollisionManager collisions = new CollisionManager(hud, player, platforms, enemies, collectibles,
			rocks);
	
	public World() {
		sprite.loadBackground();
		sprite.loadloserImage();
		sprite.loadwinnerImage();
		inputs = new Inputs(player, rocks, this);
		loadLevel(currentLevel);
	}
	
	public Inputs getInputs() {
		return inputs;
	}
	
	public void restartGame() {
		currentLevel = 1;
		gameOver = false;
		playerWon = false;
		hud.setRocks(0);
		hud.setLives(3);
		hud.setRocks(100);
		rocks.setCurrentRocks(100);
		enemies.clearEnemies();
		collectibles.clearCollectibles();
		platforms.clearPlatforms();
		loadLevel(1);
		
	}

	public void update(int width, int height) {
		if(gameOver) {
			return;
		}
		
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
		
		if(collectibles.getCollectibles().isEmpty() && currentLevel == 1) {
			currentLevel = 2;
			loadLevel(currentLevel);
		} else if(collectibles.getCollectibles().isEmpty() && currentLevel == 2) {
			gameOver = true;
			playerWon = true;
			sprite.loadloserImage();
			enemies.clearEnemies();
			collectibles.clearCollectibles();
			platforms.clearPlatforms();
		}
		
		int over = hud.getLives();
		if (over == 0) {
			gameOver = true;
			playerWon = false;
			sprite.loadloserImage();
			enemies.clearEnemies();
			collectibles.clearCollectibles();
			platforms.clearPlatforms();
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
			enemies.addEnemies(platform, 3);
			collectibles.addCollectibles(platform);
		}
	}
	
	public void draw(Graphics g, int width, int height) {
		g.drawImage(sprite.backgroundImage(), 0, 0, width, height, null);
		
		if(gameOver) {
			if(playerWon) {
				g.drawImage(sprite.winnerImage(), 0, 0, width, height, null);
			} else {
				g.drawImage(sprite.loserImage(), 0, 0, width, height, null);

			}
		}
		
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
