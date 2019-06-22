package views.ocean;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import Assets.ImageAsset;
import Main.GameFrame;
import controller.ocean.listeners.ServerListener;
import models.ocean.OceanModel;
import models.pilot.PilotModel;
import views.levels.lastWaves.LastWaveView;
import views.ocean.bar.BarView;

public class OceanView extends JPanel {

	private OceanModel model;

	public OceanView() {

		setSize(new Dimension((int)GameFrame.getWidth(), (int)GameFrame.getHeight()));
		setCursor(getToolkit().createCustomCursor( new BufferedImage( 1, 1, BufferedImage.TYPE_INT_ARGB ),new Point(),null ));

		ServerListener serverListener = new ServerListener();
		addMouseListener(serverListener);
		addMouseMotionListener(serverListener);
	}

	//	public void setServerOceanView(){
	//		new OceanView();
	//		ServerListener serverListener = new ServerListener();
	//		addMouseListener(serverListener);
	//		addMouseMotionListener(serverListener);
	//	}
	//	
	//	public void setClientOceanView(){
	//		new OceanView();
	//		addMouseListener(clientListener);
	//		addMouseMotionListener(clientListener);
	//	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void paintComponent(Graphics graphics) {

		Graphics2D graphics2d = (Graphics2D) graphics.create();

		try {
			paintOcean(graphics2d);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void paintOcean(Graphics2D graphics2D ) throws IOException{
		paintGameEnvironment(graphics2D);
		paintPilots(graphics2D);
		paintEnemies(graphics2D);
		graphics2D.dispose();
	}
	private void paintEnemies(Graphics2D graphics2D) throws IOException {
		if(model.getCurrentLevel().isInLastWave()){

			LastWaveView.paintLastWave(graphics2D);
		}
		else{
			model.getCurrentWave().getFishGroupsView().paintFishGroup(graphics2D);
		}

	}
	private void paintGameEnvironment(Graphics2D graphics2D) throws IOException {
		paintBackground(graphics2D);
		paintBars(graphics2D);

	}
	private void paintPilots(Graphics2D graphics2D) {

		ArrayList<PilotModel> pilots = model.getCurrentPilots();

		for(PilotModel pilot : pilots){

			pilot.getPilotView().paintPilot(graphics2D);
		}

	}
	private void paintBars(Graphics2D graphics2D) throws IOException {
		BarView.paintBars(graphics2D);
	}

	private void paintBackground(Graphics2D graphics2D) {
		try {
			graphics2D.drawImage(ImageAsset.createImageAsset().getBackgrounds().get("gameBackground"), 0, 0, (int)GameFrame.getWidth() , (int)GameFrame.getHeight(), null);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public OceanModel getModel() {
		return model;
	}
	public void setModel(OceanModel model) {
		this.model = model;
	}
}
