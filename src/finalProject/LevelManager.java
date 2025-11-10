package finalProject;


/*
 * @Authors: Raj, Andrew, and Braylon
 * The level Manager class creates the different levels to be loaded in the game.
 * This class sets the spawn location of the platforms and depending on the platform location and size
 * it sets the location of the collectibles and enemies to be spawned on the platforms.
 */

public class LevelManager {

	private PlatformManager platforms = new PlatformManager();
	
	public LevelManager(PlatformManager platforms) {
		this.platforms = platforms;
	}
	
	public void level1() {
		// Set the x and y locations then sets the length of the platforms
		platforms.addPlatforms(700,775,20);
		platforms.addPlatforms(1100,650,8);
		platforms.addPlatforms(900,550,5);
		platforms.addPlatforms(350,550,10);
		platforms.addPlatforms(125,660,5);
		platforms.addPlatforms(175,400,6);
		platforms.addPlatforms(550,325,9);
		platforms.addPlatforms(1050,200,7);
	}
	
	public void level2() {
		// spawns level 2 setting new platform locations and sizes
		platforms.addPlatforms(400, 790,5);
		platforms.addPlatforms(1000, 770, 10);
		platforms.addPlatforms(200,500,8);
		platforms.addPlatforms(20,630,3);
		platforms.addPlatforms(150,710,2);
		platforms.addPlatforms(700, 620, 10);
		platforms.addPlatforms(900, 400, 6);
		platforms.addPlatforms(1250, 250, 8);
		platforms.addPlatforms(1250, 500, 3);
	}
}
