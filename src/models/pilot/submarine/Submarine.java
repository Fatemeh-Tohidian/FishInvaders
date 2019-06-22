package models.pilot.submarine;

import models.pilot.submarine.firingSystem.FiringSystemModel;

public class Submarine {
	private double X;
	private double Y;
	private int animatingIndex;
	private FiringSystemModel firingSystem;
	private String color;
	public double getX() {
		return X;
	}
	
	public Submarine(double x, double y, FiringSystemModel firingSystem, String color) {
		super();
		X = x;
		Y = y;
		this.firingSystem = firingSystem;
		this.color = color;
	}

	public void setX(double X) {
		this.X = X;
	}
	public double getY() {
		return Y;
	}
	public void setY(double Y) {
		this.Y = Y;
	}
	public int getAnimatingIndex() {
		return animatingIndex;
	}
	public void setAnimatingIndex(int animatingIndex) {
		this.animatingIndex = animatingIndex;
	}
	public FiringSystemModel getFiringSystem() {
		return firingSystem;
	}
	public void setFiringSystem(FiringSystemModel firingSystem) {
		this.firingSystem = firingSystem;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
