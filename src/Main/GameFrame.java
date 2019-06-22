package Main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JFrame;
import controller.ocean.ServerOceanController;
import models.MainModel;
import models.levels.Level;
import models.ocean.OceanModel;
import models.pilot.PilotModel;
import models.pilot.submarine.Submarine;
import models.pilot.submarine.firingSystem.FiringSystemModel;
import views.ocean.OceanView;

public class GameFrame {

	private JFrame frame = new JFrame();
	private static double width ;
	private static double height;

	public GameFrame() throws UnknownHostException, IOException {
		setDimension();
		setGameFrame();
		setServer();
		setClient();
		initializeData();

	}
	private void initializeData() {

		ArrayList<PilotModel> pilots = new ArrayList<PilotModel>();
		MainModel.getModel().getOceanModel().setCurrentPilots(pilots);
		addPlayer();
		MainModel.getModel().getOceanModel().setCurrentLevel(Level.Level1);
		MainModel.getModel().getOceanModel().setCurrentWave(Level.Level1.getFishGroups().get(0).getModel());;		
	}

	private void addPlayer() {
		
		FiringSystemModel firingSystemModel = new FiringSystemModel(0, 1, 3);
		Submarine submarine = new Submarine(700,700,firingSystemModel,"RED");
		PilotModel newPilot = new PilotModel(submarine, 0, 0, 3);
		MainModel.getModel().getOceanModel().getCurrentPilots().add(newPilot);
		MainModel.getModel().getOceanModel().setCurrentPilot(newPilot);
	}

	private void setClient() {
		// TODO Auto-generated method stub

	}
	private void setServer() {
		OceanModel oceanModel = new OceanModel();
		OceanView sreverOceanView = new OceanView();
		frame.add(sreverOceanView);
		MainModel.getModel().setOceanModel(oceanModel);
		MainModel.getModel().setOceanView(sreverOceanView);
		ServerOceanController serverOceanController;
		try {
			serverOceanController = new ServerOceanController(oceanModel, sreverOceanView);
			serverOceanController.run();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private void setGameFrame() {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	private void setDimension() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.getWidth();
		height = screenSize.getHeight();		
	}
	public static double getWidth() {
		return width;
	}

	public static double getHeight() {
		return height;
	}

}
