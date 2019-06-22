package controller.ocean;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.Timer;
import com.google.gson.Gson;
import controller.ocean.listeners.ClientListener;
import views.ocean.OceanView;

public class ClientOceanController implements  Runnable {
	
	Gson gson = new Gson();
	Socket socket;
	PrintWriter writer;
	Scanner scanner;
	OceanView oceanView ;
	ClientListener clientListener;
	
	public  ClientOceanController() throws UnknownHostException, IOException{
		
		socket = new Socket("127.0.0.1", 2117);
		writer = new PrintWriter(socket.getOutputStream(),true);
		scanner = new Scanner (socket.getInputStream());
		oceanView = new OceanView();
		clientListener = new ClientListener();
		oceanView.addMouseListener(clientListener);
		oceanView.addMouseMotionListener(clientListener);

	}
	@Override
	public void run() {
		Timer timer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//hala felan
				sendCommand();
				updateView();
			}


		});
		timer.start();
	}
	
	
	private void sendCommand() {
		if(clientListener.isMove()){
			clientListener.setMove(false);
			writer.println("move");
			System.out.println("move");
			 System.exit(0);
			writer.println(clientListener.getSubmarineX());
			writer.println(clientListener.getSubmarineY());
			writer.flush();
		}
		if(clientListener.isShootBullet()){
			writer.println("shootBullet");
			writer.println(clientListener.getBulletFirsLocationX());
			writer.println(clientListener.getBulletFirsLocationY());
			writer.flush();
		}
		if(clientListener.isShootBomb()){
			writer.println("shootBomb");
			writer.println(clientListener.getBombFirsLocationX());
			writer.println(clientListener.getBombFirsLocationY());
			writer.flush();
		}

	}
	private void updateView() {
		// TODO Auto-generated method stub
	// hala fellan	oceanModel = new OceanModel();
		// inja gharare begim ke az scanner model ro begir
		oceanView.repaint();
	}
}
