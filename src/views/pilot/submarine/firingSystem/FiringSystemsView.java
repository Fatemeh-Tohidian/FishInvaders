package views.pilot.submarine.firingSystem;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import Assets.ImageAsset;
import models.MainModel;
import models.pilot.submarine.firingSystem.bomb.BombModel;
import models.pilot.submarine.firingSystem.bullet.BulletModel;
import views.pilot.submarine.firingSystem.bomb.BombView;
import views.pilot.submarine.firingSystem.bullet.BulletView;

public class FiringSystemsView {

	public static void paintFiringSystem(Graphics2D g2d) throws IOException {
		paintBullets(g2d);
		paintBombs(g2d);
		paintOverHeatSituation(g2d);
	}
	private static void paintOverHeatSituation(Graphics2D g2d) throws IOException {
		if(MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().isOverHeated())
			g2d.drawImage((Image) ImageAsset.createImageAsset().getEffects().get("overHeat").get(MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getOverHeatFrameIndex()),(int) MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getX()-50, (int)MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getY()-50, null);
	}
	private static void paintBombs(Graphics2D g2d) {
		ArrayList<BombModel> bombs = MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBombs();
		for (int i = 0; i < bombs.size(); i++) {
			BombModel bomb = MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBombs().get(i);
			BombView.paintMissile(g2d ,bomb);
			if(bomb.isGetToTarget()){
				BombView.paintExplosion(g2d);
			}
		}			
	}
	private static void paintBullets(Graphics2D g2d) {

		ArrayList<BulletModel> bullets = MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets();
		for (int i = 0; i < bullets.size(); i++) {
			if(!bullets.get(i).isCollided()){
				BulletView.paintBullet(i,g2d);}
		}		
	}
}
