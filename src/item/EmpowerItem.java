package item;

public abstract class EmpowerItem {
	private	double X;
	private	double Y;
	public abstract void influence();

	public void move(){
		Y+=10;
	}
	public void isContacted(){

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
