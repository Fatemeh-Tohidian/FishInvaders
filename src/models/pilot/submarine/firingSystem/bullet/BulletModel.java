package models.pilot.submarine.firingSystem.bullet;

import java.awt.Point;
import models.Model;

public class BulletModel implements Model{
	private int radius;
	private double angel = Math.PI/2.0;
	private boolean collided;
	private Point firstLocation;
	private BulletType bulletType;
	private double extraPower;
	public BulletModel(double angle, Point firstLocation, BulletType bulletType) {
		super();
		this.angel = angle;
		this.firstLocation = firstLocation;

		this.bulletType = bulletType;
		this.collided = false;
	}
	public BulletModel(double angle, Point firstLocation, BulletType bulletType ,double extraPower) {
		super();
		this.angel = angle;
		this.firstLocation = firstLocation;
		this.extraPower = extraPower;
		this.bulletType = bulletType;
		this.collided = false;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;

	}
	public double getAngel() {
		return angel;
	}
	public void setAngel(double angel) {
		this.angel = angel;

	}
	public double getX() {
		return firstLocation.getX()+radius*Math.cos(angel);
	}

	public double getY() {
		return firstLocation.getY()+radius*Math.sin(angel);
	}

	public boolean isCollided() {
		return collided;
	}
	public void setCollided(boolean collided) {
		this.collided = collided;
	}
	public BulletType getBulletType() {
		return bulletType;
	}
	public void setBulletType(BulletType bulletType) {
		this.bulletType = bulletType;
	}
	public boolean isInOcean(){
		return radius*(Math.sin(angel))+ firstLocation.y<-500;
	}
	public Point getFirstLocation() {
		return firstLocation;
	}
	public void setFirstLocation(Point firstLocation) {
		this.firstLocation = firstLocation;
	}
	public double getExtraPower() {
		return extraPower;
	}
	public void setExtraPower(double extraPower) {
		this.extraPower = extraPower;
	}
}
