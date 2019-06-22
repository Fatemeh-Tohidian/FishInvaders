package models.levels.items;

public enum FishType {
	//felan image code ha bashe in jori ta badan aks jadid peyda konim
	TYPE1(11,13,10,1,0.1),TYPE2(11,13,10,2,0.05),TYPE3(11,13,15,3,0.06),TYPE4(11,13,20,4,0.07);
	private int life;
	private int urchinSpeed;
	private int imageCode;
	private int countOfImages;
	private double urchinProbility;
	private FishType(int imageCode ,int countOfImages ,int urchinSpeed ,int life,double urchinProbility){
		this.setImageCode(imageCode);
		this.setCountOfImages(countOfImages);
		this.urchinSpeed = urchinSpeed;
		this.life = life;
		this.urchinProbility = urchinProbility;
				
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getUrchinSpeed() {
		return urchinSpeed;
	}
	public void setUrchinSpeed(int urchinSpeed) {
		this.urchinSpeed = urchinSpeed;
	}
	public double getUrchinProbility() {
		return urchinProbility;
	}
	public void setUrchinProbility(double urchinProbility) {
		this.urchinProbility = urchinProbility;
	}
	public int getImageCode() {
		return imageCode;
	}
	public void setImageCode(int imageCode) {
		this.imageCode = imageCode;
	}
	public int getCountOfImages() {
		return countOfImages;
	}
	public void setCountOfImages(int countOfImages) {
		this.countOfImages = countOfImages;
	}
}
