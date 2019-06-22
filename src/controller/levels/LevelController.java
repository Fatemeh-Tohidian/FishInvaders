package controller.levels;
import controller.levels.fishGroups.FishGroupController;
import models.MainModel;
import models.levels.Level;
public class LevelController {
	Level currentLevel;
	FishGroupController currentWave ;
	int currentLevelIndex = 0;
	int currentWaveIndex = 0;

	public LevelController() {
		currentLevel = Level.getLevels().get(0);
		currentWave = currentLevel.getFishGroups().get(0);
		currentWave.initialize();
	}
	public   void updateCuurentLevel() {
		controllLevel();
		updateCuurentWave();

	}
	private  void controllLevel() {
		if(currentWave.isFinished()){checkEndOfWave();}
		if(currentLevel.getLastWave().isFinished()){
			System.out.println("is finished is working");
			checkEndOfLevel();
			}

	}
	private  void checkEndOfLevel() {
		{
			if(currentLevelIndex==3){
				}	
			else{
				System.out.println("in else");
				currentLevelIndex++;
				System.out.println("current level"+currentLevelIndex);
				System.out.println("current wave"+currentWaveIndex);
				currentLevel = Level.getLevels().get(currentLevelIndex);
				MainModel.getModel().getOceanModel().setCurrentLevel(currentLevel);
				currentWaveIndex = 0;
				System.out.println("must be zero"+currentWaveIndex);
				MainModel.getModel().getOceanModel().setCurrentWave(currentLevel.getFishGroups().get(currentWaveIndex).getModel());
				currentWave = currentLevel.getFishGroups().get(currentWaveIndex);
				currentWave.initialize();
			}
		}

	}
	private  void checkEndOfWave() {
		if(currentWaveIndex==3){
			currentLevel.setInLastWave(true);
		}
		else{
			currentWaveIndex++;
			currentWave = currentLevel.getFishGroups().get(currentWaveIndex);
			MainModel.getModel().getOceanModel().setCurrentWave(currentWave.getModel());
			currentWave.initialize();
		}
	}
	private  void updateCuurentWave() {
		if(currentLevel.isInLastWave()){
			currentLevel.getLastWave().move();
			currentLevel.getLastWave().contact();
		}
		currentWave.controll();
		
		MainModel.getModel().getOceanModel().setCurrentWave(currentWave.getModel());
	}
}
