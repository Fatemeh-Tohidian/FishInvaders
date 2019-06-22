package controller.pilot;

import java.util.ArrayList;
import controller.pilot.submarine.SubmarineController;
import models.MainModel;
import models.pilot.PilotModel;

public class PilotController {
	
	private PilotModel pilotModel;
	
	public static void updatePilots() {
		
		ArrayList<PilotModel> pilots = MainModel.getModel().getOceanModel().getCurrentPilots();
		for(int i = 0 ;i < pilots.size() ; i++){
			SubmarineController.updateSubmarine(i);
		}

	}
	public PilotModel getPilotModel() {
		return pilotModel;
	}
	public void setPilotModel(PilotModel pilotModel) {
		this.pilotModel = pilotModel;
	}


}
