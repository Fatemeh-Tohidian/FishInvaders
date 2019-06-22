package controller.pilot.submarine.firingSystem.bomb;

import java.util.ArrayList;
import models.pilot.submarine.firingSystem.bomb.BombModel;
import views.pilot.submarine.firingSystem.bomb.BombView;

public class BombController {
	private BombModel bombModel;
	private BombView bombView;

	public void bombControll(){
		ArrayList<BombModel> bombs = bombModel.getFiringSystemModel().getBombs();
		for(int i = 0; i < bombs.size() ; i++){
			checkExplosion(bombs.get(i));
			updateBombsList(bombs, i);
		}
	}
	public void checkExplosion(BombModel  bombModel){
		if(bombModel.isGetToTarget()){
			
//			if(OptionsPanel.getExplosionSound() == null || OptionsPanel.getExplosionSound().isSelected()){
//				new SoundPlayer(SoundAsset.create().getExplosionSound());}
			//	bombs.get(i).

		}

	}
	public void updateBombsList(ArrayList<BombModel> bombs , int index){
		bombs.remove(index);
		bombModel.getFiringSystemModel().setBombs(bombs);
	}
	public void move() {

//		if(((BombModel)bombModel).getVerticalLocation() <=GameFrame.getHeight()/2.0 && ((BombModel)bombModel).getHorizontalLocation() >=GameFrame.getWidth()/2.0){
//			
//			((BombModel)bombModel).setHorizontalLocation(17*Math.cos(((BombModel)bombModel).getAngel()));
//			((BombModel)bombModel).setVerticalLocation(17*Math.sin(((BombModel)bombModel).getAngel()));
//			if(point.y >=GameFrame.getHeight()/2.0 && point.x <=GameFrame.getWidth()/2.0){
//				explosion(i);}
//		}
	}
	public static void updteBombs(int index) {
		// TODO Auto-generated method stub
		
	}
	public void animat() {
		if(bombModel.getAnimatingIndex()<61){
			bombModel.setAnimatingIndex(bombModel.getAnimatingIndex()+1);
		}
	}

	public BombModel getBombModel() {
		return bombModel;
	}

	public void setBombModel(BombModel bombModel) {
		this.bombModel = bombModel;
	}

	public BombView getBombView() {
		return bombView;
	}

	public void setBombView(BombView bombView) {
		this.bombView = bombView;
	}
	

}
