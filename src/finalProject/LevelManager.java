package finalProject;

public class LevelManager {

	private PlatformManager platforms = new PlatformManager();
	private Player player = new Player();
	
	public LevelManager(PlatformManager platforms, Player player) {
		this.platforms = platforms;
		this.player = player;
	}
	//hi
	public void level1() {
		platforms.addPlatforms(700,775,20);
		platforms.addPlatforms(1100,650,8);
		platforms.addPlatforms(900,550,5);
		platforms.addPlatforms(350,550,10);
		platforms.addPlatforms(125,660,5);
		platforms.addPlatforms(175,400,6);
		platforms.addPlatforms(550,325,9);
		platforms.addPlatforms(1050,200,7);
		
		player.setSpawn(50, 840);
	}
	
	public void level2() {
		platforms.addPlatforms(400, 790,5);
		platforms.addPlatforms(1000, 770, 10);
		platforms.addPlatforms(200,500,8);
		platforms.addPlatforms(20,630,3);
		platforms.addPlatforms(150,710,2);
		platforms.addPlatforms(700, 620, 10);
		platforms.addPlatforms(900, 400, 6);
		platforms.addPlatforms(1250, 250, 8);
		platforms.addPlatforms(1250, 500, 3);
		
		player.setSpawn(50, 840);
	}
}
