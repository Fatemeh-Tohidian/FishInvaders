package item;

import java.util.Random;

import models.MainModel;
import models.pilot.submarine.firingSystem.bullet.BulletType;

public class BulletTypeChanger extends EmpowerItem{
	Random random = new  Random();
	
	@Override
	public void influence() {
		
		BulletType newBulletType = BulletType.getBulletTypes().get(random.nextInt(3));
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().setBulletType(newBulletType);
	}

}
