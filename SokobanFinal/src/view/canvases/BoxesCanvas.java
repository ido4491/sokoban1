package view.canvases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class BoxesCanvas extends Canvas{
	private StringProperty boxPathProperty = new SimpleStringProperty("");;
	private StringProperty boxOnDestPathProperty = new SimpleStringProperty("");;
	private Image boxIMG;
	private Image boxOnDestIMG;
	


	public void clearCanvas() {
		getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
	}

	public void drawBox(double d, double e, double wCellSize, double hCellSize) {
		if(boxIMG==null)
			setImages();
		getGraphicsContext2D().drawImage(boxIMG, d, e,wCellSize,hCellSize);
	}

	public void drawBoxOnDestination(double d, double e, double wCellSize, double hCellSize) {
		if(boxOnDestIMG==null)
			setImages();
		getGraphicsContext2D().drawImage(boxOnDestIMG, d, e,wCellSize,hCellSize);
	}

	public String getBoxPathProperty() {
		return boxPathProperty.get();
	}

	public void setBoxPathProperty(String boxPathProperty) {
		this.boxPathProperty.set(boxPathProperty);
	}

	public String getBoxOnDestPathProperty() {
		return boxOnDestPathProperty.get();
	}

	public void setBoxOnDestPathProperty(String boxOnDestPathProperty) {
		this.boxOnDestPathProperty.set(boxOnDestPathProperty);
	}
	
	public Image getBoxIMG() {
	return boxIMG;
	}

	public Image getBoxOnDestIMG() {
		return boxOnDestIMG;
	}
	
	private void setImages() {
		try {
			boxIMG = new Image(new FileInputStream(boxPathProperty.get()));
			boxOnDestIMG = new Image(new FileInputStream(boxOnDestPathProperty.get()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
