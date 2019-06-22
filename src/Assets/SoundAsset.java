package Assets;

import java.io.File;

public class SoundAsset {
	private static SoundAsset soundAsset;
	private File clickSound;
	private File backGroundSound;
	private File explosionSound;
	private File shootingSound;
	private File readySound;
	private File alarmSound;
	private SoundAsset(){
		setClickSound(new File ("src\\Assets\\sounds\\clickSound.wav"));
		setBackGroundSound(new File ("src\\Assets\\sounds\\backGroundSound.wav"));
		setExplosionSound(new File ("src\\Assets\\sounds\\explosionSound.wav"));
		setShootingSound(new File ("src\\Assets\\sounds\\shootingSound.wav"));
		setReadySound(new File ("src\\Assets\\sounds\\readySound.wav"));
		setAlarmSound(new File("src\\Assets\\Sounds\\alarmSound.wav"));
	}
	public static SoundAsset create(){
		if (soundAsset==null){
			soundAsset = new SoundAsset();}
		return soundAsset;
	}
	public File getClickSound() {
		return clickSound;
	}
	private void setClickSound(File clickSound) {
		this.clickSound = clickSound;
	}
	public File getBackGroundSound() {
		return backGroundSound;
	}
	private void setBackGroundSound(File backGround) {
		this.backGroundSound = backGround;
	}
	public File getExplosionSound() {
		return explosionSound;
	}
	private void setExplosionSound(File explosionSound) {
		this.explosionSound = explosionSound;
	}
	public File getShootingSound() {
		return shootingSound;
	}
	private void setShootingSound(File shootingSound) {
		this.shootingSound = shootingSound;
	}
	public File getReadySound() {
		return readySound;
	}
	private void setReadySound(File ready) {
		this.readySound = ready;
	}
	public File getAlarmSound() {
		return alarmSound;
	}
	private void setAlarmSound(File alarm) {
		this.alarmSound = alarm;
	}
}
