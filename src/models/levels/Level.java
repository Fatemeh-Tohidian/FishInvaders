package models.levels;

import java.util.ArrayList;

import controller.levels.fishGroups.CircularContrller;
import controller.levels.fishGroups.FishGroupController;
import controller.levels.fishGroups.RectangularControllr;
import controller.levels.fishGroups.RotationalController;
import controller.levels.fishGroups.SuicideController;
import controller.levels.lastWaves.LastWaveController;
import controller.levels.lastWaves.Mermaid;
import models.levels.items.FishType;

public enum Level {
	Level1 (new RectangularControllr(2,FishType.TYPE1),new CircularContrller(Math.PI/250.0,3,FishType.TYPE1) , new RotationalController(600,Math.PI/250.0,FishType.TYPE1) , new SuicideController (5,15000,FishType.TYPE1), new Mermaid(10,30)),
	Level2 (new RectangularControllr(3 , FishType.TYPE2),new CircularContrller(Math.PI/200.0,4,FishType.TYPE2) , new RotationalController(550,Math.PI/200.0,FishType.TYPE2) , new SuicideController (7,10000,FishType.TYPE2), new Mermaid(15,35)),
	Level3 (new RectangularControllr(4,FishType.TYPE3),new CircularContrller(Math.PI/150.0,5 ,FishType.TYPE3) , new RotationalController(500,Math.PI/150.0,FishType.TYPE3) , new SuicideController (9,5000,FishType.TYPE3), new Mermaid(15,40)),
	Level4 (new RectangularControllr(5,FishType.TYPE4),new CircularContrller(Math.PI/120.0,6,FishType.TYPE4) , new RotationalController(450,Math.PI/120.0,FishType.TYPE4) , new SuicideController (11,4000,FishType.TYPE4), new Mermaid(20,50));
	private static ArrayList<Level> levels = new ArrayList<Level>();
	private ArrayList<FishGroupController> fishGroups =  new ArrayList<FishGroupController>() ;
	private LastWaveController lastWave;
	private boolean inLastWave = false;
	
	private Level(FishGroupController firstWave, FishGroupController secondWave, FishGroupController thirdWave, FishGroupController forthWave, LastWaveController lastWave) {
		fishGroups.add(firstWave);
		fishGroups.add(secondWave);
		fishGroups.add(thirdWave);
		fishGroups.add(forthWave);
		this.setLastWave(lastWave);
	}
	public ArrayList<FishGroupController> getFishGroups() {
		return fishGroups;
	}
	public void setFishGroups(ArrayList<FishGroupController> fishGroups) {
		this.fishGroups = fishGroups;
	}
	public LastWaveController getLastWave() {
		return lastWave;
	}
	public void setLastWave(LastWaveController lastWave) {
		this.lastWave = lastWave;
	}
	public static ArrayList<Level> getLevels() {
		levels.add(Level1);
		levels.add(Level2);
		levels.add(Level3);
		levels.add(Level4);
		return levels;
	}
	public boolean isInLastWave() {
		return inLastWave;
	}
	public void setInLastWave(boolean inLastWave) {
		this.inLastWave = inLastWave;
	}
	
}
