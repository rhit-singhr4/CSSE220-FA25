package finalProject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Game extends JComponent implements KeyListener{
	
	Player player = new Player();
	
	public Game() {
		this.setFocusable(true);
		this.addKeyListener(this);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Game game = new Game();
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,400);
		frame.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		player.draw(g);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode())	 {
		case KeyEvent.VK_UP -> player.moveUp();
		case KeyEvent.VK_DOWN -> player.moveDown();
		case KeyEvent.VK_LEFT -> player.moveLeft();
		case KeyEvent.VK_RIGHT -> player.moveRight();
		}
		repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}
