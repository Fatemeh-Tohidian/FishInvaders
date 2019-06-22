package controller.ocean;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.Timer;
import com.google.gson.Gson;
import controller.levels.LevelController;
import controller.pilot.PilotController;
import models.ocean.OceanModel;
import views.ocean.OceanView;

public class ServerOceanController implements Runnable {
	private OceanModel oceanModel;
	private OceanView oceanView;
	ServerSocket serverSocket;;
	Socket socket ;
	Scanner sc;
	OutputStream outputStream;
	Gson gson = new Gson();
	public ServerOceanController(OceanModel oceanModel, OceanView oceanView) throws IOException {
		this.oceanModel = oceanModel;
		this.oceanView = oceanView;
		serverSocket = new ServerSocket(2117);
	}
	@Override
	public void run() {

		LevelController  levelController = new LevelController();
		Timer timer = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				PilotController.updatePilots();
				levelController.updateCuurentLevel();
				//sendModel();
				oceanView.revalidate();
				oceanView.repaint();
				
			}


		});
		timer.start();
	}
	public OceanModel getOceanModel() {
		return oceanModel;
	}
	public void setOceanModel(OceanModel oceanModel) {
		this.oceanModel = oceanModel;
	}
//	private void getCommand() {
//		
//		String command = sc.nextLine();
//		switch (command) {
//		case "move":
//			// bayad vase har pilot id besazim be ja get current ba id sh get konim
//			MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().setX(sc.nextInt());
//			MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().setY(sc.nextInt());
//			// check she
//			sc.nextLine();
//			break;
//		case "shootBullet":
//
//			break;
//		case "shootBomb":
//
//			break;
//
//		default:
//			break;
//		}
//
//	}
	private void sendModel() {
		String model = gson.toJson(oceanModel);
		System.out.println(model);
	}
}
