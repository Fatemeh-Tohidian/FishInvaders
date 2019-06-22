package controller.pilot.submarine;

import controller.pilot.submarine.firingSystem.FiringSystemController;
import models.MainModel;

public class SubmarineController {

	public static void updateSubmarine(int index) {
		animateSubmarine(index);
		FiringSystemController.updateFiringSystem(index);
	}

	private static void animateSubmarine(int index) {
		
		if(MainModel.getModel().getOceanModel().getCurrentPilots().get(index).getSubmarine().getAnimatingIndex()<=6){
			MainModel.getModel().getOceanModel().getCurrentPilots().get(index).getSubmarine().setAnimatingIndex(MainModel.getModel().getOceanModel().getCurrentPilots().get(index).getSubmarine().getAnimatingIndex()+1);;
		}
		else{
			MainModel.getModel().getOceanModel().getCurrentPilots().get(index).getSubmarine().setAnimatingIndex(0);
		}		
	}

	
}
