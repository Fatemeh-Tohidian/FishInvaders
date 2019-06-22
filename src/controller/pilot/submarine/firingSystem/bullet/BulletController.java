package controller.pilot.submarine.firingSystem.bullet;

import static java.lang.Math.sin;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import models.MainModel;
import models.pilot.submarine.firingSystem.bullet.BulletModel;
public class BulletController {
	static int pilotIndex;
	static int bulletIndex;

	public static void updateBullets(int currentPilotIndex) {
		pilotIndex = currentPilotIndex;
		ArrayList<BulletModel> bullets = MainModel.getModel().getOceanModel().getCurrentPilots().get(pilotIndex).getSubmarine().getFiringSystem().getBullets();
		for(int i = 0; i< bullets.size() ; i++){
			bulletIndex = i;
			moveBullet();
			removeOutOfRangeBullet();
		}		
	}
	public static void moveBullet(){

		MainModel.getModel().getOceanModel().getCurrentPilots().get(pilotIndex).getSubmarine().getFiringSystem().getBullets().get(bulletIndex).setRadius(	MainModel.getModel().getOceanModel().getCurrentPilots().get(pilotIndex).getSubmarine().getFiringSystem().getBullets().get(bulletIndex).getRadius()-20);

	}	
	private static void removeOutOfRangeBullet() {
		MainModel.getModel().getOceanModel().getCurrentPilots().get(pilotIndex).getSubmarine().getFiringSystem().getBullets().get(bulletIndex).getRadius();
		MainModel.getModel().getOceanModel().getCurrentPilots().get(pilotIndex).getSubmarine().getFiringSystem().getBullets().get(bulletIndex).getAngel();
		MainModel.getModel().getOceanModel().getCurrentPilots().get(pilotIndex).getSubmarine().getFiringSystem().getBullets().get(bulletIndex).getFirstLocation().getY();
		if(MainModel.getModel().getOceanModel().getCurrentPilots().get(pilotIndex).getSubmarine().getFiringSystem().getBullets().get(bulletIndex).getRadius()*(sin(MainModel.getModel().getOceanModel().getCurrentPilots().get(pilotIndex).getSubmarine().getFiringSystem().getBullets().get(bulletIndex).getAngel()))+ MainModel.getModel().getOceanModel().getCurrentPilots().get(pilotIndex).getSubmarine().getFiringSystem().getBullets().get(bulletIndex).getFirstLocation().getY()<-500){
			MainModel.getModel().getOceanModel().getCurrentPilots().get(pilotIndex).getSubmarine().getFiringSystem().getBullets().remove(pilotIndex);
		}
	}
	public static void addBullet(MouseEvent e) {

		int power = MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getPower();

		switch (power) {

		case 0: addSingelBullet(e);	

		break;
		case 1: addDoubelBullet(e);

		break;
		case 2: addTriplexBullet(e);

		break;
		case 3: addFoursomeBullet(e);

		break;

		default: addMoreBullet(e,power);
		break;
		}		
	}
	private static void addMoreBullet(MouseEvent e,int power) {
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI*(75.0/180.0), new Point (e.getX(),e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType(),(5.0/4.0)*(power-4)));
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI/2.0, new Point (e.getX()+35,e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType(),(5.0/4.0)*(power-4)));
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI/2.0, new Point (e.getX(),e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType(),(5.0/4.0)*(power-4)));
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI*(105.0/180.0), new Point (e.getX(),e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType(),(5.0/4.0)*(power-4)));

	}
	private static void addFoursomeBullet(MouseEvent e) {
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI*(75.0/180.0), new Point (e.getX(),e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType()));
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI/2.0, new Point (e.getX()+35,e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType()));
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI/2.0, new Point (e.getX(),e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType()));
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI*(105.0/180.0), new Point (e.getX(),e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType()));

	}
	private static void addTriplexBullet(MouseEvent e) {
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI*(75.0/180.0), new Point (e.getX(),e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType()));
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI/2.0, new Point (e.getX(),e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType()));
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI*(105.0/180.0), new Point (e.getX(),e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType()));

	}
	private static void addDoubelBullet(MouseEvent e) {
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI/2.0, new Point (e.getX(),e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType()));
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI/2.0, new Point (e.getX()+35,e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType()));

	}
	private static void addSingelBullet(MouseEvent e) {
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().add(new BulletModel(Math.PI/2.0, new Point (e.getX(),e.getY()), MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBulletType()));

	}


}
