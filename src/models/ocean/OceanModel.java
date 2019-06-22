package models.ocean;
import java.util.ArrayList;

import models.levels.Level;
import models.levels.fishGroups.FishGroupModel;
import models.pilot.PilotModel;

public class OceanModel {
	
	private ArrayList<PilotModel> currentPilots;
	private PilotModel currentPilot;
	private Level currentLevel;
	private FishGroupModel currentWave;
	
	public ArrayList<PilotModel> getCurrentPilots() {
		return currentPilots;
	}
	public void setCurrentPilots(ArrayList<PilotModel> currentPilots) {
		this.currentPilots = currentPilots;
	}
	public PilotModel getCurrentPilot() {
		return currentPilot;
	}
	public void setCurrentPilot(PilotModel currentPilot) {
		this.currentPilot = currentPilot;
	}
	public Level getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}
	public FishGroupModel getCurrentWave() {
		return currentWave;
	}
	public void setCurrentWave(FishGroupModel currentWave) {
		this.currentWave = currentWave;
	}
	
}
