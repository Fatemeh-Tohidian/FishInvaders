package views.pilot.submarine.firingSystem.bullet;
import java.awt.Graphics2D;
import java.io.IOException;
import Assets.ImageAsset;
import models.MainModel;
import models.pilot.submarine.firingSystem.bullet.BulletModel;

public class BulletView {

	public static void paintBullet(int index,Graphics2D g2d){

		BulletModel bullet = MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets().get(index);
		try {

			g2d.drawImage( ImageAsset.createImageAsset().getEquipment().get("bullet"),(int)( bullet.getX()), (int)(bullet.getY()),null);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
