package controller.levels.fishGroups;
import java.awt.Point;
import java.util.ArrayList;

import Main.GameFrame;
import models.levels.items.Fish;
import models.levels.items.FishType;
public class CircularContrller extends FishGroupController{
	
	int linearSpeed;
	double rotationalSpeed;
	Point center = new Point(0,0);
	Point newCenter = new Point((int)(Math.random()*GameFrame.getWidth()) , (int)(Math.random()*GameFrame.getHeight()));
	public CircularContrller(double rotationalSpeed,int linearSpeed ,FishType fishType) {
		this.getModel().setFishType(fishType);
		this.linearSpeed =linearSpeed;
		this.rotationalSpeed =rotationalSpeed;
	}
	@Override
	public void initialize() {
		ArrayList<Fish> fishes = this.getModel().getFishes();
		for(int i =0  ; i < 20 ; i++){
			Point p = new Point((int) (400*Math.cos((i*Math.PI)/10.0)+center.getX()),(int)(400*Math.sin((i*Math.PI)/10.0)+ center.getY())); 
			Fish fish = new Fish(this.getModel().getFishType(),p,(i*Math.PI)/10.0);
			fishes.add(fish);
		}		
	}
	@Override
	public void move() {
		round();
		if(getToCenter()) {
			ChangeCenter();
		}
		else{ 
			moveTowardCenter(Math.atan2(((newCenter.y-center.y)), ((newCenter.x-center.x))));
		}
	}
	private void round() {
		ArrayList<Fish> fishes = this.getModel().getFishes();
		for(int i =0  ; i < 20 ; i++){
			fishes.get(i).setPolarLocation(center,400, fishes.get(i).getAngel()+rotationalSpeed);
		}	
	}
	private boolean getToCenter(){
		return center.y <=newCenter.y+3 && center.y >=newCenter.y-3 &&  center.x <=newCenter.x+3 && center.x >=newCenter.x-3;  
	}
	public void ChangeCenter(){
		center = newCenter;
		newCenter = new Point((int)(Math.random()*GameFrame.getWidth()) , (int)(Math.random()*GameFrame.getHeight()));
	}
	private void moveTowardCenter(double angel) {
		center.x+=linearSpeed*Math.cos(angel);
		center.y+=linearSpeed*Math.sin(angel);

	}
}