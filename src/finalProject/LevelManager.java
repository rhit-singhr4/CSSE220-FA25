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
}
