package controller.levels.fishGroups;
import java.awt.Point;
import java.util.ArrayList;

import models.levels.items.Fish;
import models.levels.items.FishType;
import Main.GameFrame;
public class RotationalController extends FishGroupController{
	double initialRadius = 1000;
	int finalRadius;
	double rotationalSpeed;
	Point center = new Point((int)GameFrame.getWidth()/2,(int)GameFrame.getHeight()/2);
	public RotationalController(int finalRadius,double rotationalSpeed,FishType fishType) {
		this.finalRadius = finalRadius;
		this.rotationalSpeed = rotationalSpeed;
		this.getModel().setFishType(fishType);
	}
	@Override
	public void initialize() {
		ArrayList<Fish> fishes = this.getModel().getFishes();
		for(int i =0  ; i < 20 ; i++){
			Point firstLocation = new Point((int) (1000*Math.cos((i*Math.PI)/10.0)+center.getX()),(int)(1000*Math.sin((i*Math.PI)/10.0)+ center.getY())); 
			Fish fish = new Fish(this.getModel().getFishType(),firstLocation ,(i*Math.PI)/10.0);
			fishes.add(fish);
		}
	}
	@Override
	public void move() {
		if(getToTarget()){
			round();
		}
		if(!getToTarget()){
			moveTowardTarget();
		}		
	}
	private boolean getToTarget() {
		return initialRadius<=finalRadius&&initialRadius>=finalRadius-1;
	}
	private void moveTowardTarget() {
		ArrayList<Fish> fishes = this.getModel().getFishes();
		initialRadius=initialRadius-(5); 
		for(int i =0 ; i < fishes.size() ; i++){
			fishes.get(i).setPolarLocation(center,(int) initialRadius);;
		}
	}
	private void round() {
		ArrayList<Fish> fishes = this.getModel().getFishes();
		for(int i =0 ; i < fishes.size() ; i++){
			fishes.get(i).setPolarLocation(center,550, fishes.get(i).getAngel()-(rotationalSpeed));}
	}		
}