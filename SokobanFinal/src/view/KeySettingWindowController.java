package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class KeySettingWindowController {
@FXML
private Label upLbl;
@FXML
private Label downLbl;
@FXML
private Label leftLbl;
@FXML
private Label rightLbl;
@FXML
private Button upBtn;
@FXML
private Button downBtn;
@FXML
private Button leftBtn;
@FXML
private Button rightBtn;

private StringProperty[] stringP = new SimpleStringProperty[4];

private KeyObject[] key = new KeyObject[4];


public void setUpKey(KeyObject key){
	this.key[0] = key;
	stringP[0] = new SimpleStringProperty(key.toString());
	upLbl.textProperty().bind(stringP[0]);
}

public void setDownKey(KeyObject key){
	this.key[1] = key;
	stringP[1] = new SimpleStringProperty(key.toString());
	downLbl.textProperty().bind(stringP[1]);
}

public void setLeftKey(KeyObject key){
	this.key[2] = key;
	stringP[2] = new SimpleStringProperty(key.toString());
	leftLbl.textProperty().bind(stringP[2]);
}

public void setRightKey(KeyObject key){
	this.key[3] = key;
	stringP[3] = new SimpleStringProperty(key.toString());
	rightLbl.textProperty().bind(stringP[3]);
}

public void setKey(final int index){
	upBtn.setDisable(true);
	downBtn.setDisable(true);
	leftBtn.setDisable(true);
	rightBtn.setDisable(true);
	
	downLbl.requestFocus();
	downLbl.setOnKeyPressed(new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent event) {
			key[index].setKey(event.getCode());
			stringP[index].set(key[index].toString());
			
			upBtn.setDisable(false);
			downBtn.setDisable(false);
			leftBtn.setDisable(false);
			rightBtn.setDisable(false);
			downLbl.setOnKeyPressed(null);
		}
	});
	
}

public void onUpClick(){
	setKey(0);
	
}

public void onDownClick(){
	setKey(1);
}

public void onLeftClick(){
	setKey(2);
}

public void onRightClick(){
	setKey(3);
}


}
