package views.levels.lastWaves;

import java.awt.Graphics2D;

import models.MainModel;

public class LastWaveView {

	public static void paintLastWave(Graphics2D g2d) {
		g2d.fillOval((int)MainModel.getModel().getOceanModel().getCurrentLevel().getLastWave().getX(),(int) MainModel.getModel().getOceanModel().getCurrentLevel().getLastWave().getY(), 300, 300);		
	}

}
