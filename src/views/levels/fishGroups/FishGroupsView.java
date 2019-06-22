package views.levels.fishGroups;

import java.awt.Graphics2D;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import Assets.ImageAsset;
import item.EmpowerItem;
import models.levels.fishGroups.FishGroupModel;
import models.levels.items.Fish;

public class FishGroupsView {
	static int fishIndex;
	private FishGroupModel fishGroupModel;
	public FishGroupsView(FishGroupModel fishGroupModel) {
		this.fishGroupModel = fishGroupModel;
	}

	public  void  paintFishGroup(Graphics2D g2d) throws IOException{

		paintFishes(g2d);
		paintUrchins(g2d);
		paintFriedFishes(g2d);
		paintFriedFishes(g2d);
		paintImpoweringItems(g2d);
	}
	private  void paintFishes(Graphics2D g2d) throws IOException{
		ArrayList<Fish> fishes = fishGroupModel.getFishes();
		for(int  i = 0 ;i < fishes.size(); i++){
			if(fishes.get(i).isValid()){
				animateFish();
				g2d.drawImage(ImageAsset.createImageAsset().getFishes().get(fishGroupModel.getFishType().getImageCode()+"Fish").get(fishIndex), (int)fishes.get(i).getX(), (int)fishes.get(i).getY(), null);
			}}
	}
	private  void paintUrchins(Graphics2D g2d) throws IOException {
		ArrayList<Point> urchins =fishGroupModel.getUrchins();
		for(int  i = 0 ;i < urchins.size(); i++){
			g2d.drawImage(((ImageAsset) ImageAsset.createImageAsset()).getUrchins().get("urchin").get(0),(int)urchins.get(i).x,(int)urchins.get(i).y, 68, 68 , null);
		}
	}
	private  void paintFriedFishes(Graphics2D g2d) throws IOException{
		ArrayList<Point> friedFishes = fishGroupModel.getFriedFishes();
		for(int  i = 0 ;i < friedFishes.size(); i++){
			g2d.drawImage(ImageAsset.createImageAsset().getItems().get("friedFish"), friedFishes.get(i).x, friedFishes.get(i).y, null);
		}
	}
	private  void paintImpoweringItems(Graphics2D g2d) throws IOException{

		ArrayList<EmpowerItem> empowerItems = fishGroupModel.getEmpowerItems();
		for(int  i = 0 ;i < empowerItems.size(); i++){
			g2d.drawImage(ImageAsset.createImageAsset().getItems().get("greenGem"), (int)empowerItems.get(i).getX(), (int)empowerItems.get(i).getY(), null);
		}
	}
	private  void animateFish() {
		if(fishIndex < fishGroupModel.getFishType().getCountOfImages()-1){fishIndex++;}
		else{fishIndex =0 ;		
		}
	}
}
