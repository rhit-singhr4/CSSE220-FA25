package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylon
 * The world class puts all the components together. It calls everything and adds it into a single frame.
 * Loading the initial level and deals with the transitions between the levels and the game over and winner screens.
 * This is also where everything is updated like the score, lives, and sprites loaded 
 */

import java.awt.Graphics;

public class World {
	
	// deals with loading the first level and a true or false statement if the game is over or not 
	// And decided which screen to put up at the end of the game.
	private int currentLevel = 1;
	private boolean gameOver = false;
	private boolean playerWon = false;

	// Calls all the components
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
		// Loads the background and the first level
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
		// Creates the restart values when you lose the game or win the game and want to play again
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
		
		// The if statement determines when to switch levels or switch screens if you win or lose the game
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
		// Clears all the old platforms, enemies, and collectibles when there is a transition
		platforms.clearPlatforms();
		enemies.clearEnemies();
		collectibles.clearCollectibles();
		
		// changes the level
		if(level == 1) {
			levels.level1();
		} else if(level == 2) {
			levels.level2();
		}
		
		// adds the collectibles and enemies to the platforms
		for (Platform platform : platforms.getPlatforms()) {
			enemies.addEnemies(platform, 3);
			collectibles.addCollectibles(platform);
		}
	}
	
	public void draw(Graphics g, int width, int height) {
		// Draws everything to the frame
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
