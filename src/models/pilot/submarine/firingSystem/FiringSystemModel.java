package models.pilot.submarine.firingSystem;

import java.util.ArrayList;

import models.pilot.submarine.firingSystem.bomb.BombModel;
import models.pilot.submarine.firingSystem.bullet.BulletModel;
import models.pilot.submarine.firingSystem.bullet.BulletType;

public class FiringSystemModel {
	
	private double temperature;
	private int power;
	private long bomb;
	private int overHeatFrameIndex;
	private int explosionFrameIndex;
	private boolean overHeated;
	private BulletType bulletType;
	private ArrayList<BulletModel> bullets= new ArrayList<>();
	private ArrayList<BombModel> bombs = new ArrayList<>();
	
	public FiringSystemModel(double temperature, int power, long bomb) {
		super();
		this.temperature = temperature;
		this.power = power;
		this.bomb = bomb;
		this.overHeated = false;
		this.bulletType = BulletType.TYPE1;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double d) {
		this.temperature = d;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public boolean isOverHeated() {
		return overHeated;
	}
	public void setOverHeated(boolean overHeated) {
		this.overHeated = overHeated;
	}
	public ArrayList<BulletModel> getBullets() {
		return bullets;
	}
	public void setBullets(ArrayList<BulletModel> bullets) {
		this.bullets = bullets;
	}
	public ArrayList<BombModel> getBombs() {
		return bombs;
	}
	public void setBombs(ArrayList<BombModel> bombs) {
		this.bombs = bombs;
	}
	public long getBomb() {
		return bomb;
	}
	public void setBomb(long bomb) {
		this.bomb = bomb;
	}
	public int getOverHeatFrameIndex() {
		return overHeatFrameIndex;
	}
	public void setOverHeatFrameIndex(int overHeatFrameIndex) {
		this.overHeatFrameIndex = overHeatFrameIndex;
	}
	public int getExplosionFrameIndex() {
		return explosionFrameIndex;
	}
	public void setExplosionFrameIndex(int explosionFrameIndex) {
		this.explosionFrameIndex = explosionFrameIndex;
	}
	public BulletType getBulletType() {
		return bulletType;
	}
	public void setBulletType(BulletType bulletType) {
		this.bulletType = bulletType;
	}
}
