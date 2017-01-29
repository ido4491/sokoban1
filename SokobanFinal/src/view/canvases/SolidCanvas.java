package view.canvases;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class SolidCanvas extends Canvas{
private StringProperty floorPathPropery = new SimpleStringProperty("");
private StringProperty destPathPropery = new SimpleStringProperty("");;
private StringProperty wallPathPropery = new SimpleStringProperty("");;
private Image floorIMG;
private Image destIMG;
private Image wallIMG;




	public void clearCanvas() {
		getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
	}

	public void drawFloor(double d, double e, double wCellSize, double hCellSize) {
		if(floorIMG==null)
			setImages();
		getGraphicsContext2D().drawImage(floorIMG, d, e,wCellSize,hCellSize);
	}

	public void drawWall(double d, double e, double wCellSize, double hCellSize) {
		if(wallIMG==null)
			setImages();
		getGraphicsContext2D().drawImage(wallIMG, d, e,wCellSize,hCellSize);
	}

	public void drawDestination(double d, double e, double wCellSize, double hCellSize) {
		if(destIMG==null)
			setImages();
		getGraphicsContext2D().drawImage(destIMG, d, e,wCellSize,hCellSize);
	}

	public String getFloorPathPropery() {
		return floorPathPropery.get();
	}

	public void setFloorPathPropery(String floorPathPropery) {
		this.floorPathPropery.set(floorPathPropery);
	}

	public String getDestPathPropery() {
		return destPathPropery.get();
	}

	public void setDestPathPropery(String destPathPropery) {
		this.destPathPropery.set(destPathPropery);
	}

	public String getWallPathPropery() {
		return wallPathPropery.get();
	}

	public void setWallPathPropery(String wallPathPropery) {
		this.wallPathPropery.set(wallPathPropery);
	}

	public Image getFloorIMG() {
		return floorIMG;
	}

	public Image getDestIMG() {
		return destIMG;
	}

	public Image getWallIMG() {
		return wallIMG;
	}
	private void setImages() {
		try {
			wallIMG = new Image(new FileInputStream(wallPathPropery.get()));
			destIMG = new Image(new FileInputStream(destPathPropery.get()));
			floorIMG = new Image(new FileInputStream(floorPathPropery.get()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
