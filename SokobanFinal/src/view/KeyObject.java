package view;

import javafx.scene.input.KeyCode;

public class KeyObject {
private KeyCode key;
public KeyObject(KeyCode key){
	setKey(key);
}
public KeyCode getKey() {
	return key;
}

public void setKey(KeyCode key) {
	this.key = key;
}

@Override
public String toString(){
	return this.key.toString();
}

}
