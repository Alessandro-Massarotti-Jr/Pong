package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	public boolean right,left;
	
	public int x , y;
	
	public int WIDTH = 40;
	public int HEIGHT = 5;
	
	

	
	public Player(int x, int y) {
		
		this.x=x;
		this.y=y;
	}
	
	
	public void tick() {
		if(right) {
			
		x++;
		//System.out.println("direita");		
		}
		else if (left) {
			x--;
			//System.out.println("esquerda");
		}
		
		if(x + WIDTH > Game.WIDTH) {
			x = Game.WIDTH - WIDTH;
			
		}
		else if(x<0) {
			x=0;
			
		}
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}
	
}
