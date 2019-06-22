package views.pilot.submarine;

import java.awt.Graphics2D;
import java.io.IOException;

import Assets.ImageAsset;
import models.MainModel;
import views.pilot.submarine.firingSystem.FiringSystemsView;

public class SubmarineView {

	public static void paintSubmarine(Graphics2D g2d) throws IOException {
		paintCurrentSubmarine(g2d);
		FiringSystemsView.paintFiringSystem(g2d);
	}

	private static void paintCurrentSubmarine(Graphics2D g2d) throws IOException {
		g2d.drawImage(ImageAsset.createImageAsset().getSubmarines().get("red").get(MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getAnimatingIndex()),(int) MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getX(),(int) MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getY(),null);
				
	}

	

	}
