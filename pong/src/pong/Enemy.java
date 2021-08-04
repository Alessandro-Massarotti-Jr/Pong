package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {
	
	public double x,y;
	public int WIDTH = 40;
	public int HEIGHT = 5;
	
	public Enemy(int x, int y) {
		
		this.x=x;
		this.y=y;
		
	}
	
	public void tick() {
		x += (Game.ball.x - x - 6) *0.2;		
		if(x + WIDTH > Game.WIDTH) {
			x = Game.WIDTH - WIDTH;
			System.out.println("Enemy Direita");
			
		}
		else if(x<0) {
			x=0;
			System.out.println("Enemy esquerda");
		}
		
		
	}	

	
	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect((int)x,(int) y, WIDTH, HEIGHT);
		
	}
	
}
