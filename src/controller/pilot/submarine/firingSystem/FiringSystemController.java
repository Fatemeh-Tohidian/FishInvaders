package controller.pilot.submarine.firingSystem;

import controller.pilot.submarine.firingSystem.bomb.BombController;
import controller.pilot.submarine.firingSystem.bullet.BulletController;

public class FiringSystemController {

	public static void updateFiringSystem(int index) {
		updateTemperature(index);
		BulletController.updateBullets(index);
		BombController.updteBombs(index);
		
	}

	private static void updateTemperature(int index) {
		// TODO Auto-generated method stub
		
	}
}
