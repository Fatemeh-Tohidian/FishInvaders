package controller.ocean.bar;
import models.MainModel;
import views.ocean.bar.BarView;

public class BarController {
	BarView barView;
	public BarController(BarView barView) {
		this.barView = barView;
	}
	public void updateBars(){
		updateDataBar();
		updateHeatBar();
	}
	private void updateDataBar() {
		barView.removeLabels();
		barView.setData();
	}
	private void updateHeatBar(){
		//MainModel.getModel().getOceanModel().getCurrentPilot()
	//	gamePanel.getSubmarineTemperature() == mainPilot.getSubmarine().getHeat() && man ino bardashtam
		if( MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getTemperature()>.2){
			MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().setTemperature(MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getTemperature()-0.2);
		}

	}
}
