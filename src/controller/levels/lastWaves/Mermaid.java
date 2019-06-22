package controller.levels.lastWaves;

import java.util.ArrayList;
import Main.GameFrame;
import models.MainModel;
import models.pilot.submarine.firingSystem.bullet.BulletModel;

public class Mermaid extends LastWaveController {
	int speed;
	public Mermaid(int speed , int life) {
		this.speed = speed;	
		this.life = life;
		this.setY(300);
	}
	@Override
	public  void move() {
		setDirection();
		goLeftAndRight();
	}

	private void setDirection() {
		if(this.getX()<0){
			speed =Math.abs(speed);
			
		}
		if(this.getX()>GameFrame.getWidth()-100){
			speed =speed*(-1);
		}			
	}
	private void goLeftAndRight() {
		setX(getX() + speed);
	}
	@Override
	public void damage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void contact() {
		
		ArrayList<BulletModel> bullets = MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets();
		for(int i =  0 ; i < bullets.size() ; i++ ){
			if(isColided(bullets.get(i))){
				bullets.get(i).setCollided(true) ;
				System.out.println(life);
				life--;
			}
		}
	}
	private boolean isColided(BulletModel  bulletModel) {
		return bulletModel.getX()<= getX()+300 && bulletModel.getX() >= getX() -300 && bulletModel.getY() <= getY()+300 && bulletModel.getY()>= getY()-300;
	}

}
