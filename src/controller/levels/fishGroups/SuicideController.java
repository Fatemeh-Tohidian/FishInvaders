package controller.levels.fishGroups;
import java.awt.Point;
import java.util.ArrayList;
import Main.GameFrame;
import models.MainModel;
import models.levels.items.Fish;
import models.levels.items.FishType;
public class SuicideController extends FishGroupController {
	int countOfFishes;
	int siucideRate;
	boolean initial = true;
	long currentTime;
	int crazyFishIndex;
	Point submarineLocation;
	ArrayList<Point> targets = new ArrayList<Point>();
	public SuicideController(int countOfFishes,int siucideRate,FishType fishType ) {
		this.getModel().setFishType(fishType);
		this.countOfFishes= countOfFishes;
		this.siucideRate= siucideRate;
	}
	@Override
	public void initialize() {
		currentTime = System.currentTimeMillis();
		for (int i = 0; i < countOfFishes; i++) {
			ArrayList<Fish> fishes = this.getModel().getFishes();
			Point firstLocation = new Point((int) (Math.random() * GameFrame.getWidth()),(int) (Math.random()  * GameFrame.getHeight()) );
			Point firstTarget = new Point((int) (Math.random() * GameFrame.getWidth()),(int) (Math.random()  * GameFrame.getHeight()));
			Fish fish = new Fish(this.getModel().getFishType(),firstLocation);
			fishes.add(fish);
			targets.add(firstTarget);
		}		
	}
	@Override
	public void move() {
		for (int i = 0; i < countOfFishes; i++) {
			normalMove(i);
			suicideMove();
		}		
	}
	private void finalMode() {
		ArrayList<Fish> fishes = this.getModel().getFishes();
		if (getToTarget(fishes.get(crazyFishIndex), submarineLocation)) {
			ChangeTarget(crazyFishIndex);
			currentTime = System.currentTimeMillis();
			initial = true;
		}
	}
	private void initialMode() {
		if (initial) {
			initial = false;
			RandomFix();
			
			
			submarineLocation = new Point((int)MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getX(),(int)MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getY());
			targets.get(crazyFishIndex).setLocation(submarineLocation);		
		}
	}
	private void RandomFix() {
		if(countOfAliveFishes()==1 || countOfAliveFishes()==0){
			crazyFishIndex = aliveFishIndex();
		}
		else{
			ArrayList<Fish> fishes = this.getModel().getFishes();
		java.util.Random r = new java.util.Random();
		while(!fishes.get(crazyFishIndex).isValid()){
			crazyFishIndex = r.nextInt(countOfFishes-1);}	}	
	}
	
	private int aliveFishIndex() {
		ArrayList<Fish> fishes = this.getModel().getFishes();
		for(int i =0 ; i  <fishes.size() ; i++){
			
			if(fishes.get(i).isValid()){
				return i;
			}
		}
		return 0;
	}
	private void suicideMove() {
		if (System.currentTimeMillis() - currentTime >= siucideRate) {
			initialMode();
			moveTowardTarget(crazyFishIndex, submarineLocation, 10);
			finalMode();
		}
	}
	private void normalMove(int currentIndex) {
		ArrayList<Fish> fishes = this.getModel().getFishes();
		Fish fish = fishes.get(currentIndex);
		Point target = targets.get(currentIndex);
		if (getToTarget(fish , target)){
			ChangeTarget(currentIndex);
		}
		if(!getToTarget(fish , target)){
			moveTowardTarget(currentIndex, target , 3);
		}		
	}
	private void ChangeTarget(int index) {
		Point newTarget = new Point((int) (Math.random() * (GameFrame.getWidth())),(int) (Math.random() * (GameFrame.getHeight() - 100)));
		targets.get(index).setLocation(newTarget);		
	}
	private boolean getToTarget(Fish fish , Point target) {
		return 	fish.getY() <= target.y + 3 && fish.getY() >= target.y - 3 && fish.getX() <= target.x + 3 && fish.getX() >= target.x - 3;
	}
	private void moveTowardTarget(int fishIndex, Point target , int Speed) {
		ArrayList<Fish> fishes = this.getModel().getFishes();
		Fish fish = fishes.get(fishIndex);
		double angle = Math.atan2(((target.y - fish.getY())), ((target.x - fish.getX())));
		fish.setX( (fish.getX() + Speed * Math.cos(angle)));
		fish.setY( (fish.getY() + Speed * Math.sin(angle)));
	}
	
}