package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	
	public double x,y;
	public int WIDTH ;
	public int HEIGHT;
	public int ix,iy;
	
	public int pontoPlayer = 0;
	public int pontoEnemy = 0;
	
	public double dx , dy;
	public double speed = 1.6;
	public Ball(int x, int y) {
		
		ix=x;
		iy=y;
		this.x=x;
		this.y=y;
		this.WIDTH = 4;
		this.HEIGHT = 4;
		
		int angle = new Random().nextInt(359);
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}

	public void tick() {
		
		if(x+(dx*speed) + WIDTH >= Game.WIDTH) {
			
			dx*=-1;
		}
		else if(x+(dx*speed) < 0) {
			
			dx*=-1;
		}
		
		if(y>=Game.HEIGHT) {
			
			//ponto inimigo
			x=ix;
			y=iy;
			pontoEnemy++;
		}
		
		else if(y<0) {
			
			// ponto jogador
			x=ix;
			y=iy;
			pontoPlayer++;
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),WIDTH,HEIGHT);
		
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.WIDTH,Game.player.HEIGHT);
		
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x,(int)Game.enemy.y,Game.enemy.WIDTH,Game.enemy.HEIGHT);
		
		if(bounds.intersects(boundsPlayer)) {
			dy*=-1;
		}
		else if(bounds.intersects(boundsEnemy)) {
			dy*=-1;
		}
		
		x+=dx*speed;
		y+=dy*speed;
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect((int)x,(int) y, WIDTH, HEIGHT);
		
	}
	
}
