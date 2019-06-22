package controller.levels.fishGroups;
import java.awt.Point;
import java.util.ArrayList;

import Main.GameFrame;
import models.levels.items.Fish;
import models.levels.items.FishType;
public class RectangularControllr extends FishGroupController{
	boolean begening = true;
	int speed;
	int leftCorner = -1680;
	int rightCorner = -320; 
	public RectangularControllr(int speed , FishType fishType) {
		this.getModel().setFishType(fishType);
		this.speed = speed;
	}
	@Override
	public void initialize() {
		ArrayList<Fish> fishes = this.getModel().getFishes();
		for(int i =0  ; i < 45 ; i++){
			Point location = new Point(170*(i/5)-1680,120*(i%5)+100);
			Fish fish = new Fish(this.getModel().getFishType(),location);
			fishes.add(fish);
		}			
	}
	@Override
	public void move() {
		arrival();
		setDirection();
		goLeftAndRight();
	}
	private void goLeftAndRight() {
		ArrayList<Fish> fishes = this.getModel().getFishes();
		for(int i =0  ; i < 45 ; i++){
			if(fishes.get(i).isValid()){
				Fish fish = fishes.get(i);
				fish.setX((int)fish.getX()+speed);
			}
		}
		leftCorner += speed ;
		rightCorner += speed;		
	}
	private void setDirection() {
		if(leftCorner<0){ speed = +3;}
		if(rightCorner>GameFrame.getWidth()-100){speed = -3;}		
	}
	public void arrival(){
		if(begening){
			goLeftAndRight();
			if(rightCorner > GameFrame.getWidth()-100){begening = false;}}
	}
}