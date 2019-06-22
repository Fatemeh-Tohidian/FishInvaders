package controller.levels.fishGroups;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import item.BulletCountMultiplier;
import item.BulletOverHeatedMultiplier;
import item.BulletTypeChanger;
import item.EmpowerItem;
import models.MainModel;
import models.levels.fishGroups.FishGroupModel;
import models.levels.items.Fish;
import models.pilot.submarine.Submarine;
import models.pilot.submarine.firingSystem.bullet.BulletModel;

public abstract class FishGroupController {
	
	private FishGroupModel model = new FishGroupModel();
	
	public abstract void initialize();
	public abstract void move();
	public void controll(){
		move();
		controllEmpowerItemes();
		controllFriedFishes();
		controllUrchins();
		contact();
	}
	public void controllFriedFishes(){
		moveFriedFishes();
	}
	private void moveFriedFishes() {
		ArrayList<Point> friedFishes = model.getFriedFishes();
		for(int i =0 ; i < friedFishes.size() ; i++){
			friedFishes.set(i, new Point((int)friedFishes.get(i).getX(),(int)friedFishes.get(i).getY()+10));
		}
	}
	private void addNewFriedFish(Fish fish) {
		double p = Math.random();
		if(p>=0 &&p<=0.06){
			model.getFriedFishes().add(new Point((int)fish.getX() , (int)fish.getY()));}
	}
	public void controllEmpowerItemes(){
		ArrayList<EmpowerItem> empowerItems = model.getEmpowerItems();
		for(int i = 0 ;i < empowerItems.size() ; i++){
			empowerItems.get(i).move();
		}
		submarine_empowerItemContact();
	}

	public void controllUrchins(){
		addNewUrchins();
		moveUrchins();

	}
	private void moveUrchins() {
		ArrayList< Point> urchins = model.getUrchins();
		for(int i =0 ; i < urchins.size() ; i++){
			urchins.set(i, new Point((int)urchins.get(i).getX(),(int)urchins.get(i).getY()+model.getFishType().getUrchinSpeed()));
		}
	}
	private void addNewUrchins() {
		ArrayList<Fish> fishes = model.getFishes();
		ArrayList<Point> urchins = model.getUrchins();
		for(int i = 0 ; i < fishes.size() ;i++ ){
			if(fishes.get(i).isAlive()){
				double p =  (Math.random()*100);
				if(p > 0 && p < model.getFishType().getUrchinProbility()){
					urchins.add(new Point((int)fishes.get(i).getX()+50,(int) fishes.get(i).getY()+100));}
			}
		}		
	}

	public boolean isFinished() {
		ArrayList<Fish> fishes = model.getFishes();
		for(int i = 0 ; i < fishes.size() ; i++){
			if(fishes.get(i).isAlive())return false;
		}
		return true;
	}

	private boolean bullet_fishIsContacted(BulletModel bullet , Fish fish){
		return !bullet.isCollided() && fish.isValid() &&  bullet.getX()>= fish.getX() && bullet.getX()<= fish.getX()+65 && bullet.getY() <= fish.getY()+100 && bullet.getY() >=  fish.getY();
	}
	private boolean submarine_urchinIsContacted(Submarine submarine , Point urchinLoaction){
		return    urchinLoaction.getX()>= submarine.getX() && urchinLoaction.getX()<= submarine.getX()+65 && submarine.getY() <= urchinLoaction.getY();
	}
	private boolean bullet_friedfishIsContacted(BulletModel bullet, Point friedFishLocation) {
		return    bullet.getX()>= friedFishLocation.getX() && bullet.getX()<= friedFishLocation.getX()+65 && friedFishLocation.getY()+30 <= bullet.getY();
	}
	private boolean submarine_friedFishIsContacted(Submarine submarine, Point friedFishLocation) {
		return friedFishLocation.getX()>= submarine.getX() && friedFishLocation.getX()<= submarine.getX()+30 && friedFishLocation.getY()+30 <= submarine.getY();
	}
	private boolean submarine_fishIsContacted(Submarine submarine, Fish fish) {
		return submarine.getX()>= fish.getX() && submarine.getX()<= fish.getX()+50 && submarine.getY() <= fish.getY()+30;
	}
	private boolean submarine_empowerItemIsContacted(Submarine submarine, EmpowerItem empowerItem) {
		return empowerItem.getX()>= submarine.getX() && empowerItem.getX()<= submarine.getX()+70 && submarine.getY() <= empowerItem.getY()+10;
	}
	public int countOfAliveFishes() {
		int ans =0 ;
		ArrayList<Fish> fishes = model.getFishes();
		for(int i= 0 ; i < fishes.size() ;i++){
			if(fishes.get(i).isValid()){
				ans++;
			}
		}
		return ans;
	}
	public void contact(){

		bullet_fishContact();
		bullet_friedfishContact();
		submarine_empowerItemContact();
		submarine_fishContact();
		submarine_friedfishContact();
		submarine_urchinContact();

	}
	public void bullet_fishContact(){
		ArrayList<BulletModel> bullets = MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets();
		ArrayList<Fish> fishes = model.getFishes();
		synchronized (bullets) {
			
			for(int k = 0 ; k  < bullets.size() ; k++){
				BulletModel  bullet = bullets.get(k);
				for(int i = 0 ; i < fishes.size() ; i++){
					Fish fish = fishes.get(i);
					if (bullet_fishIsContacted(bullet, fish)){
						addNewFriedFish(fish);
						addNewEmpowerItem(fish);
						fish.hit(bullet);
						bullet.setCollided(true);}
				}
			}
		}
	}
	private void addNewEmpowerItem(Fish fish) {

		double probility = Math.random();
		if(probility>=0 && probility<=0.03){
			Random random = new Random();
			int epowerItemIndex = random.nextInt(3);
			switch (epowerItemIndex) {
			case 0:
				BulletOverHeatedMultiplier bulletOverHeatedMultiplier = new BulletOverHeatedMultiplier();
				bulletOverHeatedMultiplier.setX(fish.getX());
				bulletOverHeatedMultiplier.setY(fish.getY());
				model.getEmpowerItems().add(bulletOverHeatedMultiplier);

				break;
			case 1:
				BulletTypeChanger bulletTypeChanger = new BulletTypeChanger();
				bulletTypeChanger.setX(fish.getX());
				bulletTypeChanger.setY(fish.getY());
				model.getEmpowerItems().add(bulletTypeChanger);

				break;
			case 2:
				BulletCountMultiplier bulletCountMultiplier = new BulletCountMultiplier();
				bulletCountMultiplier.setX(fish.getX());
				bulletCountMultiplier.setY(fish.getY());
				model.getEmpowerItems().add(bulletCountMultiplier);

				break;

			default:
				break;
			}
		}

	}

	private void submarine_urchinContact() {
		Submarine submarine = MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine();	
		ArrayList<Point> urchins = model.getUrchins();
		for(int i = 0 ; i < urchins.size() ; i++){

			if(submarine_urchinIsContacted(submarine, urchins.get(i))){

				MainModel.getModel().getOceanModel().getCurrentPilot().setHeart(MainModel.getModel().getOceanModel().getCurrentPilot().getHeart()-1);
			}
		}
	}
	private void bullet_friedfishContact() {
		ArrayList<BulletModel> bullets = MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().getBullets();
		ArrayList<Point> friedFishes = model.getFriedFishes();
		synchronized (friedFishes) {
			for(int i = 0 ; i < bullets.size() ; i ++){
				BulletModel bullet = bullets.get(i);
				if(!bullet.isCollided()){
					for(int j =0 ; j < friedFishes.size() ; j++){
						if(bullet_friedfishIsContacted(bullet,friedFishes.get(j))){
							friedFishes.remove(j);
							bullet.setCollided(true);
						}
					}
				}
			}
		}

	}
	private void submarine_friedfishContact() {
		Submarine submarine = MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine();
		ArrayList<Point> friedFishes = model.getFriedFishes();
		for(int i = 0 ; i < friedFishes.size() ;i++){
			if(submarine_friedFishIsContacted(submarine , friedFishes.get(i))){
				MainModel.getModel().getOceanModel().getCurrentPilot().setCountOfFriedFish(MainModel.getModel().getOceanModel().getCurrentPilot().getCountOfFriedFish()+1);
				friedFishes.remove(i);
			}
		}
	}

	private void submarine_fishContact() {
		Submarine submarine = MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine();
		ArrayList<Fish> fishes = model.getFishes(); 
		for(int i =0 ; i < fishes.size() ; i++){
			if(submarine_fishIsContacted(submarine , fishes.get(i))){
				MainModel.getModel().getOceanModel().getCurrentPilot().setHeart(MainModel.getModel().getOceanModel().getCurrentPilot().getHeart()-1);
				fishes.get(i).setAlive(false);
			}
		}
	}

	private void submarine_empowerItemContact() {
		Submarine submarine = MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine();
		ArrayList<EmpowerItem> empowerItems = model.getEmpowerItems();
		for(int i =0 ; i < empowerItems.size() ; i++){
			if(submarine_empowerItemIsContacted(submarine , empowerItems.get(i))){
				empowerItems.get(i).influence();
				empowerItems.remove(i);
			}

		}
	}
	public FishGroupModel getModel() {
		return model;
	}
	public void setModel(FishGroupModel model) {
		this.model = model;
	}
}
