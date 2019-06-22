package item;

import models.MainModel;

public class BulletCountMultiplier extends EmpowerItem {

	@Override
	public void influence() {
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().setPower(MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getPower()+1);		
	}

}
