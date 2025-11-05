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

	public CollisionManager(HUD hud) {
		this.hud = hud;
	}

	private boolean checkCollision(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2) {
		return x1 + width1 > x2 && x1 < x2 + width2 && y1 + height1 > y2 && y1 < y2 + height2;
	}

	public void playerToPlatformsCollision(Player player, PlatformManager platforms) {
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

	public void playerToEnemyCollision(Player player, EnemyManager enemies) {
		int shrink = 10;
		for (Enemy enemy : enemies.getEnemies()) {
			if (checkCollision(player.getX() + shrink, player.getY() + shrink, player.getSpriteWidth() - shrink,
					player.getSpriteHeight() - shrink, enemy.getX() + shrink, enemy.getY() + shrink,
					enemy.getSpriteWidth() - shrink, enemy.getSpriteHeight() - shrink)) {
				hud.setLives(hud.getLives() - 1);
			}
		}
	}

	public void playerToCollectibles(Player player, CollectiblesManager collectibles) {
		int shrink = 10;
		for (Collectible collectible : collectibles.getCollectibles()) {
			if (checkCollision(player.getX() + shrink, player.getY() + shrink, player.getSpriteWidth() - shrink,
					player.getSpriteHeight() - shrink, collectible.getX() + shrink, collectible.getY() + shrink,
					collectible.getSpriteWidth() - shrink, collectible.getSpriteHeight() - shrink)) {
				hud.setScore(hud.getScore() + 1);
			}

		}
	}
}
