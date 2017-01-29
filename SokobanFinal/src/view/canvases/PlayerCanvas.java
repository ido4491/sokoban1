package view.canvases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class PlayerCanvas extends Canvas{
	private StringProperty playerPathProperty = new SimpleStringProperty("");;
	private StringProperty playerOnDestPathProperty = new SimpleStringProperty("");;
	private Image playerIMG;
	private Image playerOnDestIMG;
	
	
	
	
	public void clearCanvas() {
		getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
	}

	public void drawPlayer(double d, double e, double wCellSize, double hCellSize) {
		if(playerIMG==null)
			setImages();
		getGraphicsContext2D().drawImage(playerIMG, d, e,wCellSize,hCellSize);
	}



	public void drawPlayerOnDestination(double d, double e, double wCellSize, double hCellSize) {
		if(playerOnDestIMG==null)
			setImages();
		getGraphicsContext2D().drawImage(playerOnDestIMG, d, e,wCellSize,hCellSize);
	}

	public String getPlayerPathProperty() {
		return playerPathProperty.get();
	}

	public void setPlayerPathProperty(String playerPathProperty) {
		this.playerPathProperty.set(playerPathProperty);
	}

	public String getPlayerOnDestPathProperty() {
		return playerOnDestPathProperty.get();
	}

	public void setPlayerOnDestPathProperty(String playerOnDestPathProperty) {
		this.playerOnDestPathProperty.set(playerOnDestPathProperty);
	}
	
	public Image getPlayerIMG() {
		return playerIMG;
	}

	public Image getPlayerOnDestIMG() {
		return playerOnDestIMG;
	}
	private void setImages() {
		try {
			playerIMG = new Image(new FileInputStream(playerPathProperty.get()));
			playerOnDestIMG = new Image(new FileInputStream(playerOnDestPathProperty.get()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
