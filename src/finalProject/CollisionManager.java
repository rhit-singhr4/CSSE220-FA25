package finalProject;

/*
 * @Authors: Raj, Andrew, and Braylo The collision class creates the collisions
 * between everything. This includes player and platform (MileStone 1 what is
 * currently present). Then will later include a collision between the player
 * and enemy, and the player and the collectibles. This collision class allows
 * the player to stand on the platforms and not fall through the platforms
 */

public class CollisionManager {
	
	private HUD hud;
	private Player player;
	private PlatformManager platforms;
	private EnemyManager enemies;
	private CollectiblesManager collectibles;
	private RockManager rocks;
	
	private int shrink = 10;

	public CollisionManager(HUD hud, Player player, PlatformManager platforms, EnemyManager enemies, CollectiblesManager collectibles, RockManager rocks) {
		this.hud = hud;
		this.player = player;
		this.platforms = platforms;
		this.enemies = enemies;
		this.collectibles = collectibles;
		this.rocks = rocks;
	}

	private boolean checkCollision(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2) {
		return x1 + width1 > x2 && x1 < x2 + width2 && y1 + height1 > y2 && y1 < y2 + height2;
	}

	public void playerToPlatformsCollision() {
		for (Platform platform : platforms.getPlatforms()) {
			if (checkCollision(player.getX(), player.getY(), player.getSpriteWidth(), player.getSpriteHeight(),
					platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight()))

				if (player.getVelyY() > 0) {
					int overlap = (player.getY() + player.getSpriteHeight()) - platform.getY();

					if (overlap < 20) {
						player.setY(platform.getY() - player.getSpriteHeight());
						player.setVelY(0);
						player.setOnGround(true);
					}
				}

			if (player.getX() + player.getSpriteWidth() > platform.getX()
					&& player.getX() < platform.getX() + platform.getWidth()
					&& player.getY() + player.getSpriteHeight() >= platform.getY()
					&& player.getY() + player.getSpriteHeight() <= platform.getY() + 5) {
				player.setOnGround(true);
			}
		}
	}

	public void playerToEnemyCollision() {
		for (Enemy enemy : enemies.getEnemies()) {
			if (checkCollision(player.getX() + shrink, player.getY() + shrink, player.getSpriteWidth() - shrink,
					player.getSpriteHeight() - shrink, enemy.getX() + shrink, enemy.getY() + shrink,
					enemy.getSpriteWidth() - shrink, enemy.getSpriteHeight() - shrink)) {
				hud.setLives(hud.getLives() - 1);
				player.respawnPlayer();
				break;
			}
		}
	}

	public void playerToCollectibles() {
		for (int i = collectibles.getCollectibles().size() - 1; i >= 0; i--) {
			Collectible collectible = collectibles.getCollectibles().get(i);
			if (checkCollision(player.getX() + shrink, player.getY() + shrink, player.getSpriteWidth() - shrink,
					player.getSpriteHeight() - shrink, collectible.getX() + shrink, collectible.getY() + shrink,
					collectible.getSpriteWidth() - shrink, collectible.getSpriteHeight() - shrink)) {
				hud.setScore(hud.getScore() + 1);
				collectibles.getCollectibles().remove(i);
			}

		}
	}
	
	public void rockToEnemyCollision() {
		for(int i = rocks.getRocks().size() - 1; i >= 0; i--) {
			Rock rock = rocks.getRocks().get(i);
			for(int j = enemies.getEnemies().size() - 1; j >= 0; j--) {
				Enemy enemy = enemies.getEnemies().get(j);
				if (checkCollision(rock.getX() + shrink, rock.getY() + shrink, rock.getSpriteWidth() - shrink,
						rock.getSpriteHeight() - shrink, enemy.getX() + shrink, enemy.getY() + shrink,
						enemy.getSpriteWidth() - shrink, enemy.getSpriteHeight() - shrink)) {
					rocks.getRocks().remove(i);
					enemies.getEnemies().remove(j);
					break;
				}
			}
		}
	}
}
 