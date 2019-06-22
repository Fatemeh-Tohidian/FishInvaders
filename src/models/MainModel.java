package models;
import controller.ocean.ClientOceanController;
import models.ocean.OceanModel;
import views.ocean.OceanView;

public class MainModel {
	private OceanView oceanView;
	private OceanModel oceanModel;
	private ClientOceanController clientOceanController;
	public static MainModel model;
	
	public static MainModel getModel() {
		if(model==null){
			model = new MainModel();
		}
		return model;
	}
	public OceanView getOceanView() {
		return oceanView;
	}
	public void setOceanView(OceanView oceanView) {
		this.oceanView = oceanView;
	}
	public OceanModel getOceanModel() {
		return oceanModel;
	}
	public void setOceanModel(OceanModel oceanModel) {
		this.oceanModel = oceanModel;
	}
	public ClientOceanController getClientOceanController() {
		return clientOceanController;
	}
	public void setClientOceanController(ClientOceanController clientOceanController) {
		this.clientOceanController = clientOceanController;
	}
}
