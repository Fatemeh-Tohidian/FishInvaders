package models.pilot.submarine.firingSystem.bullet;

import java.util.ArrayList;

public enum BulletType {

	TYPE1(1,5,200),TYPE2(2, 6,250),TYPE3(3,6,200);

	private int damage;
	private int overHeatedTime;
	private int periodOfShot;
	private static ArrayList<BulletType> bulletTypes = new ArrayList<BulletType>(); 
	private BulletType(int damage, int overHeatedTime,int periodOfShot) {
		this.damage = damage;
		this.overHeatedTime = overHeatedTime;
		this.periodOfShot = periodOfShot;

	}
	public int getDamage() {
		return damage;
	}

	public int getOverHeatedTime() {
		return overHeatedTime;
	}

	public int getPeriodOfShot() {
		return periodOfShot;
	}
	public static ArrayList<BulletType> getBulletTypes() {
		bulletTypes.add(TYPE1);
		bulletTypes.add(TYPE2);
		bulletTypes.add(TYPE3);
		return bulletTypes;
	}
	
}
