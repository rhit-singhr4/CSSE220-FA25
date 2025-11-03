package finalProject;

public class CollisonManager {
	
	private Player player = new Player();
	private PlatformManager plateformManager = new PlatformManager();
	private Enemy enemy = new Enemy();
	private Collectibles collectibles = new Collectibles();
	
	
	public void playerToPlatformsCollision(Player player, PlatformManager platforms) {
		for(Platform platform : platforms.getPlatforms()) {
		}
	}
}
