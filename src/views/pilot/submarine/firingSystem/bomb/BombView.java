package views.pilot.submarine.firingSystem.bomb;

import java.awt.Graphics2D;
import java.io.IOException;
import Assets.ImageAsset;
import Main.GameFrame;
import models.MainModel;
import models.pilot.submarine.firingSystem.bomb.BombModel;

public class BombView {
	
	public static void paintExplosion(Graphics2D g2d){
		try {
			g2d.drawImage(ImageAsset.createImageAsset().getEffects().get("explosion").get(MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getExplosionFrameIndex()),((int)GameFrame.getWidth()/2)-500,((int) GameFrame.getHeight()/2)-500, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void paintMissile(Graphics2D g2d , BombModel bombModel){
		try {
			g2d.drawImage( ImageAsset.createImageAsset().getEquipment().get("missile"),(int) bombModel.getHorizontalLocation(),(int) bombModel.getVerticalLocation(),null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
