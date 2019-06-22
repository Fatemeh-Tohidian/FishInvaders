package models.levels.items;

import java.awt.Point;

import models.pilot.submarine.firingSystem.bullet.BulletModel;

public class Fish {
	private FishType type;
	private int life ;
	private double angel;
	private boolean getToTarget = false;
	private boolean alive = true;
	private Point polarLocation;
	private Point firstLocation;
	private double X;
	private double Y ;

	public Fish(FishType fishType,Point firstLocation, double angel) {
		this.angel = angel;
		this.firstLocation = firstLocation;
		this.type = fishType;
		this.life = type.getLife();
	}
	public Fish(FishType fishType,Point firstLocation) {
		this.firstLocation = firstLocation;	
		this.X = firstLocation.x;
		this.Y= firstLocation.y;
		this.type = fishType;
		this.life = type.getLife();
	}
	public FishType getType() {
		return type;
	}
	public void setType(FishType type) {
		this.type = type;
	}
	public double getAngel() {
		return angel;
	}
	public void setAngel(double angel) {
		this.angel = angel;
	}
	public boolean isGetToTarget() {
		return getToTarget;
	}
	public void setGetToTarget(boolean getToTarget) {
		this.getToTarget = getToTarget;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public Point getPolarLocation() {
		return polarLocation;
	}
	public void setPolarLocation(Point center ,  int radius , double angel) {
		this.angel = angel;
		this.X = radius*Math.cos(angel)+center.x;
		this.Y  = radius*Math.sin(angel)+center.y;
	}
	public double getX() {
		return X;
	}
	public void setX(double X) {
		this.X = X;
	}
	public double getY() {
		return Y;
	}
	public void setY(double Y) {
		this.Y = Y;
	}
	public Point getFirstLocation() {
		return firstLocation;
	}
	public void setFirstLocation(Point firstLocation) {
		this.firstLocation = firstLocation;
	}
	public boolean isValid(){
		return this != null && this.alive;
	}
	public void setPolarLocation(Point center, int radius) {
		this.setAngel(this.angel);
		this.X = radius*Math.cos(this.angel)+center.x;
		this.Y  = radius*Math.sin(this.angel)+center.y;
	}
	public void hit(BulletModel bullet) {
		if(bullet.getExtraPower()!=0){
			life-=bullet.getExtraPower();
		}
		else{
			life-=bullet.getBulletType().getDamage();
			
		}
		if(life<=0){
			this.alive = false;
		}
	}
}
