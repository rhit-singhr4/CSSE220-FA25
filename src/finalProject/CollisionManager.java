package finalProject;

public class CollisionManager {
	
	private Player player = new Player();
	private PlatformManager platformManager = new PlatformManager();
	private Enemy enemy = new Enemy();
	
	public void playerToPlatformsCollision(Player player, PlatformManager platforms) {
	    for(Platform platform : platforms.getPlatforms()) {
	        int playerX = player.getX();
	        int playerY = player.getY();
	        int playerWidth = player.getSpriteWidth();
	        int playerHeight = player.getSpriteHeight();
	        
	        int platformX = platform.getX();
	        int platformY = platform.getY();
	        int platformWidth = platform.getWidth();
	        int platformHeight = platform.getHeight();
	        
	        // Check if player is overlapping platform horizontally and vertically
	        if(playerX + playerWidth > platformX &&
	                playerX < platformX + platformWidth &&
	                playerY + playerHeight > platformY &&
	                playerY < platformY + platformHeight) {
	        
	            // Player is falling onto platform from above
	            if(player.getVelyY() > 0) {
	                int overlap = (playerY + playerHeight) - platformY;
	                
	                if(overlap < 20) {
	                    player.setY(platformY - playerHeight);
	                    player.setVelY(0);
	                    player.setOnGround(true);
	                }
	            }
	        }
	        
	        // ADDED: Check if player is standing on platform (not falling, just resting on top)
	        // This allows jumping while standing still on a platform
	        if(playerX + playerWidth > platformX &&
	                playerX < platformX + platformWidth &&
	                playerY + playerHeight >= platformY &&
	                playerY + playerHeight <= platformY + 5) {  // Within 5 pixels of platform top
	            player.setOnGround(true);
	        }
	    }
	}
}
