package finalProject;

public class CollisionManager {
	
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
	        
	        if(playerX + playerWidth > platformX &&
	                playerX < platformX + platformWidth &&
	                playerY + playerHeight > platformY &&
	                playerY < platformY + platformHeight) {
	        
	            if(player.getVelyY() > 0) {
	                int overlap = (playerY + playerHeight) - platformY;
	                
	                if(overlap < 20) {
	                    player.setY(platformY - playerHeight);
	                    player.setVelY(0);
	                    player.setOnGround(true);
	                }
	            }
	        }
	        
	        if(playerX + playerWidth > platformX &&
	                playerX < platformX + platformWidth &&
	                playerY + playerHeight >= platformY &&
	                playerY + playerHeight <= platformY + 5) {
	            player.setOnGround(true);
	        }
	    }
	}
}
