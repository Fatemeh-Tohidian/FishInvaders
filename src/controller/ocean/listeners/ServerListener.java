package controller.ocean.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import controller.pilot.submarine.firingSystem.bullet.BulletController;
import models.MainModel;

public class ServerListener implements MouseMotionListener,MouseListener {
	private boolean move;
	private boolean shootBullet = false;
	private boolean shootBomb = false;
	
	private double submarineX;
	private double submarineY;
	private double bulletFirsLocationX;
	private double bulletFirsLocationY;
	private double bombFirsLocationX;
	private double bombFirsLocationY;

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)){

			if(!MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().isOverHeated()){	
						BulletController.addBullet(e);
			}
		}
		if(SwingUtilities.isRightMouseButton(e)){

			if(!MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().getFiringSystem().isOverHeated()){	
				//BombController.addBomb(e);
			//	shootBomb = true;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().setX(e.getX());
		MainModel.getModel().getOceanModel().getCurrentPilot().getSubmarine().setY(e.getY());
		//move = true;

	}
	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public boolean isShootBullet() {
		return shootBullet;
	}

	public void setShootBullet(boolean shootBullet) {
		this.shootBullet = shootBullet;
	}

	public boolean isShootBomb() {
		return shootBomb;
	}

	public void setShootBomb(boolean shootBomb) {
		this.shootBomb = shootBomb;
	}

	public double getSubmarineX() {
		return submarineX;
	}

	public void setSubmarineX(double submarineX) {
		this.submarineX = submarineX;
	}

	public double getSubmarineY() {
		return submarineY;
	}

	public void setSubmarineY(double submarineY) {
		this.submarineY = submarineY;
	}

	public double getBulletFirsLocationX() {
		return bulletFirsLocationX;
	}

	public void setBulletFirsLocationX(double bulletFirsLocationX) {
		this.bulletFirsLocationX = bulletFirsLocationX;
	}

	public double getBulletFirsLocationY() {
		return bulletFirsLocationY;
	}

	public void setBulletFirsLocationY(double bulletFirsLocationY) {
		this.bulletFirsLocationY = bulletFirsLocationY;
	}

	public double getBombFirsLocationX() {
		return bombFirsLocationX;
	}

	public void setBombFirsLocationX(double bombFirsLocationX) {
		this.bombFirsLocationX = bombFirsLocationX;
	}

	public double getBombFirsLocationY() {
		return bombFirsLocationY;
	}

	public void setBombFirsLocationY(double bombFirsLocationY) {
		this.bombFirsLocationY = bombFirsLocationY;
	}


}
