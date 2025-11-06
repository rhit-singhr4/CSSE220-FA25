package finalProject;

public class LevelManager {

	private PlatformManager platforms = new PlatformManager();
	
	public LevelManager(PlatformManager platforms) {
		this.platforms = platforms;
	}
	
	public void level1() {
		platforms.addPlatforms(800,775,20);
		platforms.addPlatforms(1100,650,2);
		platforms.addPlatforms(900,550,3);
		platforms.addPlatforms(350,550,10);
		platforms.addPlatforms(125,660,1);
		platforms.addPlatforms(1300,500,3);
	}
	
	public void level2() {
		platforms.addPlatforms(400, 790,5);
		platforms.addPlatforms(1000, 770, 10);
		platforms.addPlatforms(200,500,8);
		platforms.addPlatforms(20,630,3);
		platforms.addPlatforms(150,710,2);
		platforms.addPlatforms(700, 620, 10);
		platforms.addPlatforms(900, 400, 6);
		platforms.addPlatforms(1250, 250, 10);
		platforms.addPlatforms(1250, 500, 3);
	}
}
