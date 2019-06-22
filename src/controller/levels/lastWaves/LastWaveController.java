package controller.levels.lastWaves;
import java.util.ArrayList;
public abstract class LastWaveController {
	int life;
	private double X;
	private double Y;
	ArrayList<Double> angelOfDamages = new ArrayList<Double>();
	public abstract void move();
	public  void damage(){
		int i = Math.round(16);
		angelOfDamages.add(Math.PI*(i/16.0));
	}
	public abstract void contact();
	public boolean isFinished(){
		if(life<=0){
			return true;
		}
		return false;
	}
	public void maveDamage(){
		for(int i = 0 ; i < angelOfDamages.size();i++){
			
		}
	}
	public double getX() {
		return X;
	}
	public void setX(double x) {
		X = x;
	}
	public double getY() {
		return Y;
	}
	public void setY(double y) {
		Y = y;
	}
}
