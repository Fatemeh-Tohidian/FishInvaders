package views.pilot;
import java.awt.Graphics2D;
import java.io.IOException;

import models.pilot.PilotModel;
import views.pilot.submarine.SubmarineView;

public class PilotView {
	
	PilotModel pilotModel ;
	
	public PilotView(PilotModel pilotModel){
		
		this.pilotModel = pilotModel;	
	}
	public  void paintPilot(Graphics2D g2d) {

		try {
			SubmarineView.paintSubmarine(g2d);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
