package models.pilot;

import models.pilot.submarine.Submarine;
import views.pilot.PilotView;

public class PilotModel {
private Submarine submarine;
private long score;
private long heart;
private long countOfFriedFish;
private PilotView pilotView;
public PilotModel(Submarine submarine, long score, long countOfFriedFish ,long heart) {
	super();
	this.submarine = submarine;
	this.score = score;
	this.countOfFriedFish = countOfFriedFish;
	pilotView = new PilotView(this);
}

public Submarine getSubmarine() {
	return submarine;
}
public void setSubmarine(Submarine submarine) {
	this.submarine = submarine;
}
public long getScore() {
	return score;
}
public void setScore(long score) {
	this.score = score;
}
public long getCountOfFriedFish() {
	return countOfFriedFish;
}
public void setCountOfFriedFish(long countOfFriedFish) {
	this.countOfFriedFish = countOfFriedFish;
}
public long getHeart() {
	return heart;
}
public void setHeart(long heart) {
	this.heart = heart;
}

public PilotView getPilotView() {
	return pilotView;
}

public void setPilotView(PilotView pilotView) {
	this.pilotView = pilotView;
}

}
