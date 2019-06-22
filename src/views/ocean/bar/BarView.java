package views.ocean.bar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JLabel;

import Assets.ImageAsset;
import Main.GameFrame;
import models.MainModel;

public class BarView {
	JLabel bombLable;
	JLabel friedFish;
	JLabel powerLable;
	JLabel heartLable;
	JLabel scoreLable;
	
	public static void paintBars(Graphics2D g2d) throws IOException {
		paintDataBar(g2d);
		paintHeatBar(g2d);
	}
	private static void paintHeatBar(Graphics2D g2d) {
		try {
			g2d.drawImage(ImageAsset.createImageAsset().getUIElements().get("upperBar"), 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		for(int i = 0 ; i < MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getTemperature();i++){
			try {
				g2d.drawImage(ImageAsset.createImageAsset().getUIElements().get("pearl"), 220+25*i, 40, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static void paintDataBar(Graphics2D g2d) {
		try {
			g2d.drawImage(ImageAsset.createImageAsset().getUIElements().get("dataBar"), 0, (int)GameFrame.getHeight()-100, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void removeLabels() {
		removaOldLabel(heartLable);

		removaOldLabel(bombLable);

		removaOldLabel(powerLable);

		removaOldLabel(friedFish);

		removaOldLabel(scoreLable);
	}
	private void removaOldLabel(JLabel label) {
	if(label!= null){
		MainModel.getModel().getOceanView().remove(label);
		MainModel.getModel().getOceanView().revalidate();
		MainModel.getModel().getOceanView().repaint();}		
	}
	private void setLabel(JLabel label , int verticalPosition){
		Color myColor = new Color(63, 72, 204); 
		label.setLocation(verticalPosition,(int)GameFrame.getHeight() -70);
		label.setSize(50, 50);
		label.setForeground(myColor);
		label.setFont(new Font("Courier New", Font.BOLD, 40));
		MainModel.getModel().getOceanView().add(label);
	}
	public void setData(){
		setDataBar();
		setHeatBar();

	}
	private void setHeatBar() {
		Color myColor = new Color(63, 72, 204); 
		scoreLable = new JLabel(Long.toString(MainModel.getModel().getOceanModel().getCurrentPilot().getScore()));
		scoreLable.setLocation(105,30);
		scoreLable.setSize(150, 50);
		scoreLable.setForeground(myColor);
		scoreLable.setFont(new Font("Courier New", Font.BOLD, 40));
		MainModel.getModel().getOceanView().add(scoreLable);		
	}
	private void setDataBar() {
		heartLable = new JLabel(Long.toString(MainModel.getModel().getOceanModel().getCurrentPilot().getHeart()));
		setLabel(heartLable, 100);


		bombLable = new JLabel(Long.toString(MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBomb()));
		setLabel(bombLable , 230);

		powerLable = new JLabel(Long.toString(MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getPower()));
		setLabel(powerLable , 350);

		friedFish =  new JLabel(Long.toString(MainModel.getModel().getOceanModel().getCurrentPilot().getCountOfFriedFish()));
		setLabel(friedFish , 520);		
	}
	

}
