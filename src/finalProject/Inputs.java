package finalProject;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Inputs implements KeyListener{
	
	private Player player;
	private boolean leftPressed = false;
	private boolean rightPressed = false;

	public Inputs(Player player) {
		this.player = player;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode())	 {
		case KeyEvent.VK_UP -> player.jump();
		case KeyEvent.VK_LEFT -> leftPressed = true;
		case KeyEvent.VK_RIGHT -> rightPressed = true;
		}
	}
	
	public void update() {
		if(leftPressed) {
			player.moveLeft();
		} else if(rightPressed) {
			player.moveRight();
		} else {
			player.setIdle(true);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT -> leftPressed = false;
		case KeyEvent.VK_RIGHT -> rightPressed = false;
		}
	}	
}
