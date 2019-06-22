package models.levels.fishGroups;

import java.awt.Point;
import java.util.ArrayList;

import item.EmpowerItem;
import models.levels.items.Fish;
import models.levels.items.FishType;
import views.levels.fishGroups.FishGroupsView;

public class FishGroupModel {
	
	private ArrayList<Fish> fishes = new ArrayList<Fish>(); 
	private ArrayList<Point> urchins = new ArrayList<Point>();
	private ArrayList<Point> friedFishes = new ArrayList<Point>();
	private ArrayList<EmpowerItem> empowerItems = new ArrayList<EmpowerItem>();
	private FishType fishType;
	private FishGroupsView fishGroupsView ;
	public FishGroupModel() {
		
		fishGroupsView = new FishGroupsView(this);
	}
	
	public ArrayList<Fish> getFishes() {
		return fishes;
	}
	public void setFishes(ArrayList<Fish> fishes) {
		this.fishes = fishes;
	}
	public ArrayList<Point> getUrchins() {
		return urchins;
	}
	public void setUrchins(ArrayList<Point> urchins) {
		this.urchins = urchins;
	}
	public ArrayList<Point> getFriedFishes() {
		return friedFishes;
	}
	public void setFriedFishes(ArrayList<Point> friedFishes) {
		this.friedFishes = friedFishes;
	}
	public ArrayList<EmpowerItem> getEmpowerItems() {
		return empowerItems;
	}
	public void setEmpowerItems(ArrayList<EmpowerItem> empowerItems) {
		this.empowerItems = empowerItems;
	}
	public FishType getFishType() {
		return fishType;
	}
	public void setFishType(FishType fishType) {
		this.fishType = fishType;
	}
	public FishGroupsView getFishGroupsView() {
		return fishGroupsView;
	}
	public void setFishGroupsView(FishGroupsView fishGroupsView) {
		this.fishGroupsView = fishGroupsView;
	}
}
