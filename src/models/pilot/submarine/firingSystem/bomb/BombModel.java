package models.pilot.submarine.firingSystem.bomb;

import models.Model;
import models.pilot.submarine.firingSystem.FiringSystemModel;

public class BombModel implements Model {
	private int animatingIndex;
	private double HorizontalLocation;
	private double VerticalLocation;
	private double angel;
	private boolean getToTarget;
	private boolean exploded;
	private FiringSystemModel firingSystemModel;
	public BombModel (double HorizontalLocation , double VerticalLocation , FiringSystemModel firingSystemModel){
		
		this.HorizontalLocation = HorizontalLocation;
		this.VerticalLocation = VerticalLocation;
		this.firingSystemModel = firingSystemModel;
		this.getToTarget = false;
		this.exploded = false;
	}
	public double getHorizontalLocation() {
		return HorizontalLocation;
	}
	public void setHorizontalLocation(double horizontalLocation) {
		HorizontalLocation = horizontalLocation;
	}
	public double getVerticalLocation() {
		return VerticalLocation;
	}
	public void setVerticalLocation(double verticalLocation) {
		VerticalLocation = verticalLocation;
	}
	public boolean isGetToTarget() {
		return getToTarget;
	}
	public void setGetToTarget(boolean getToTarget) {
		this.getToTarget = getToTarget;
	}
	public int getAnimatingIndex() {
		return animatingIndex;
	}
	public void setAnimatingIndex(int animatingIndex) {
		this.animatingIndex = animatingIndex;
	}
	public boolean isExploded() {
		return exploded;
	}
	public void setExploded(boolean exploded) {
		this.exploded = exploded;
	}
	public double getAngel() {
		return angel;
	}
	public void setAngel(double angel) {
		this.angel = angel;
	}
	public FiringSystemModel getFiringSystemModel() {
		return firingSystemModel;
	}
	public void setFiringSystemModel(FiringSystemModel firingSystemModel) {
		this.firingSystemModel = firingSystemModel;
	}
	}
